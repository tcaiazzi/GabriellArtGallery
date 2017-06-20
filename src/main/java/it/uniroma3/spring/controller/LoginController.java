package it.uniroma3.spring.controller;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.spring.model.Exhibition;
import it.uniroma3.spring.service.ExhibitionService;



@Controller
public class LoginController {
	
	private ExhibitionService exhibitionService;

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
	

	  @RequestMapping({"/", "/index", "/gag"})
	  public String home(Principal principal, Model model) {
		if(principal!=null){
			model.addAttribute(principal);
		}
				
		
	    return "gag";
	  }

}
