package it.uniroma3.spring.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



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
	
	  // Login form
	  @RequestMapping({"/", "/index"})
	  public String home(Principal principal, Model model) {
		if(principal!=null){
			model.addAttribute(principal);
		}
	    return "gag";
	  }

}
