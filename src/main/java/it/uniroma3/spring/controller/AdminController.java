package it.uniroma3.spring.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Permission;
import it.uniroma3.spring.model.User;
import it.uniroma3.spring.service.PermissionService;
import it.uniroma3.spring.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService permissionService;
	
	
	@GetMapping("/admin")
	public String showAdminPanel(User user){

		return "admin/adminPanel";

	}

	
	@GetMapping("/admin/registration")
	public String showAdminRegistartion(User user){
		return "admin/adminRegistration";
	}
	
	
	@PostMapping("/admin/registration")
	public String checkUserInfo(@Valid @ModelAttribute User user, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "admin/adminRegistration";
		}
		else {
			model.addAttribute(user);
			userService.addAdmin(user); 
			
			
		}
		return "userInfo";
	}
	
	@GetMapping("/admin/users")
	public String showUsersList(Model model){
		List<Permission> permissions = this.permissionService.findAllUsers();
		model.addAttribute("permissions", permissions);
		return "admin/usersList";
		
	}

	
	

}
