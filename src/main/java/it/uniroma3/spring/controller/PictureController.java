package it.uniroma3.spring.controller;

import java.security.Principal;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService; 
	
	
	



	@GetMapping("/admin/picture")
	public String showPictureInsert(Principal pricipal, Picture picture,Model model){
	
		return "admin/pictureInsert";
	}

	@PostMapping("/admin/picture")
	public String checkPictureInfo(@Valid @ModelAttribute Picture picture,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "pictureInsert";
		}
		else 
			
			model.addAttribute(picture);
			pictureService.add(picture); 
			
		return "pictureInfo";
	}
	
	@GetMapping("/showPicture")
	public String showPicture(Model model,WebRequest request){
		
		/*setting picture to show*/
		Long id = Long.parseLong(request.getParameter("id"));
		Picture pic = pictureService.find(id);
		model.addAttribute(pic);
		
		return "pictureInfo";

	}
}
