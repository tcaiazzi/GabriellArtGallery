package it.uniroma3.spring.controller;



import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.mail.HtmlEmailSender;
import it.uniroma3.spring.mail.HtmlMessagePreparator;
import it.uniroma3.spring.model.User;
import it.uniroma3.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HtmlEmailSender emailSender;
	
	@Autowired
	private HtmlMessagePreparator messagePreparator;

	@GetMapping("/signUp")
	public String showUserSignUp(User user){
		return "user/userSignUp";
	}
	
	
	@PostMapping("/signUp")
	public String checkUserInfo(@Valid @ModelAttribute User user, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "user/userSignUp";
		}
		else {
			
			model.addAttribute(user);
			userService.addUser(user); 
			emailSender.prepareEmail(user.getEmail(), "Welcome to GAG", messagePreparator.welcomeMessage(user.getId(), user.getUsername(), user.getPassword()));
			
			
			
		}
		return "userInfo";
	}
	
	
	@GetMapping("/signUp/confirm")
	public String confirmRegistration(HttpServletRequest request){
		this.userService.confirmUserAccount(Long.parseLong(request.getParameter("id")));
		return "user/userAccountConfirmation";
	}
	
	
	
}
