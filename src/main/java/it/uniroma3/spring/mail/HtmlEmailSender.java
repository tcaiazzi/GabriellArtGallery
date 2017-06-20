package it.uniroma3.spring.mail;


import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import it.uniroma3.spring.model.User;

@Service
public class HtmlEmailSender {

	public void sendHtmlEmail(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException,
	MessagingException {

		// sets SMTP server properties

		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// set plain text message
		msg.setContent(message, "text/html");

		// sends the e-mail
		Transport.send(msg);

	}


	public void prepareEmail(String mailTo, String subject, String message){
		// SMTP server information
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "inginfcondivisioneappunti@gmail.com";
		String password = "ingegneriainformatica";
		HtmlEmailSender mailer = new HtmlEmailSender();
		try {
			mailer.sendHtmlEmail(host, port, mailFrom, password, mailTo,
					subject, message);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}
	}


	public void prepareEmailforAllUsers(List<User> users, String subject, String message) {
		
		for(User u:users){
			this.prepareEmail(u.getEmail(), subject, message);
		}
		
	}


}