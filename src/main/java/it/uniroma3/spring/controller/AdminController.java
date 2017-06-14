package it.uniroma3.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import it.uniroma3.spring.model.User;

@Controller
public class AdminController {
	
	
	@GetMapping("/admin")
	public String showAdminPanel(User user){
		return "admin/adminPanel";
	}
	
	

}
