package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.model.User;

@Controller
public class LoginController {

	 // Login form
	  @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }

	  // Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }
	  
	  @PostMapping("/login")
	  public String frusc(@Valid @ModelAttribute User user, 
				BindingResult bindingResult, Model model) {
		  System.out.println("fruscio");
		  return null;
	  }
	  

}
