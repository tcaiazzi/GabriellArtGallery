package it.uniroma3.spring.controller;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

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
		return "admin/adminInfo";
	}
	
	@GetMapping("/admin/users")
	public String showUsersList(Model model){
		List<Permission> permissions = this.permissionService.findAllUsers();
		System.out.println(permissions);
		model.addAttribute("permissions", permissions);
		return "admin/usersList";
		
	}
	
	@GetMapping("/admin/userInfoAdmin")
	public String showUserInfoAdmin(Model model, WebRequest request){
		Long id = Long.parseLong(request.getParameter("id"));
		User user = this.userService.findUserById(id);
		model.addAttribute("user", user);
		return "admin/userInfoAdmin";
		
	}
	
	
	@GetMapping("/admin/userInfoAdminByUsername")
	public String showUserInfoAdminByUsername(Model model, WebRequest request){
		String username =request.getParameter("username");
		User user = this.userService.findByUsername(username);
		System.out.println("-------------"+user.getName());
		model.addAttribute("user", user);
		return "admin/userInfoAdmin";
		
	}
	
	@GetMapping("/admin/deleteUser")
	public String deleteUser(Model model, WebRequest request){
		Long userId = Long.parseLong(request.getParameter("user_id"));
		Long permissionId = Long.parseLong(request.getParameter("permission_id"));
		this.userService.deleteUser(userId);
		this.permissionService.deletePermission(permissionId);
		return "admin/usersList";
		
	}
	
	
	@GetMapping("/admin/profile")
	public String showUserProfile(Principal principal, Model model){
		if(principal!=null){
			User user = this.userService.findByUsername(principal.getName());
			model.addAttribute("user", user);
		}
		return "admin/adminProfile";

	}

	
	

}
