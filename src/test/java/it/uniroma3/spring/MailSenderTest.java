package it.uniroma3.spring;



import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.uniroma3.spring.mail.EmailSender;


 
/**
 * @author Crunchify.com
 * 
 */
 
public class MailSenderTest {
 
	@SuppressWarnings("resource")
	public static void main(String args[]) {
 
		// Spring Bean file you specified in /src/main/resources folder
		String crunchifyConfFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
 
		// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
		EmailSender crunchifyEmailAPI = (EmailSender) context.getBean("crunchifyEmail");
		String toAddr = "valeriocaravani@gmail.com";
		String fromAddr = "info@casabalfroma.it";
 
		// email subject
		String subject = "FrusciataPerEmail";
 
		// email body
		String body = "There you go.. You got an Frusc.. Let's understand details on how Frusc MVC works -- By Ermete Admin";
		crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
	}
}