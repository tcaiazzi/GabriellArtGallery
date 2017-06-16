package it.uniroma3.spring.mail;

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
}


