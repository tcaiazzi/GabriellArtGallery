package it.uniroma3.spring.mail;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class HtmlMessagePreparator {

	public String welcomeMessage(Long id, String username, String password){
		// message contains HTML markups
		String message = "<i>Welcome to GabriellArtGallery "+username+"</i><br>";
		message += "<b>Click here to confirm your account "+"<a href ="+"\"http://localhost:8080/signUp/confirm?id="+id+"&username="+username+"&password="+password+"\">";
		message += "Confirm account!</a>";
		message += "<b>Wish you a nice day!</b><br>";
		message += "<font color=red>Ermete</font>";
		
		return message;
	}
	
	
	public String newExhibitionMessage(Long id, String name, Date date){
		// message contains HTML markups
		String message = "<i>We are pleasure to present "+name+" our new Exhibition!</i><br>";
		message += "<b>We invite you to it! "+"<a href ="+"\"http://localhost:8080/signUp/confirm?id="+id+"&name="+name+"\">";
		message += "Click here to take a reservation!</a>";
		message += "<b>Wish you a nice day!</b><br>";
		message += "<font color=red>Ermete</font>";
		
		return message;
	}
	
	
	public String reservationConfirm(Long id, String exhibitionName, Date date, String time){
		// message contains HTML markups
		String message = "<i>This is your reservation to "+exhibitionName+" exhibition on day</i><br>";
		message += "Date: "+date+"</i><br>";
		message += "Time: "+time+"</i><br>";
		message += "<b>Wish you a nice day!</b><br>";
		message += "<font color=red>Ermete</font>";
		
		return message;
	}
}


