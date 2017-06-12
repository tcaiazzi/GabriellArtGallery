package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService; 



	@GetMapping("/picture")
	public String showPictureInsert(Picture picture){
		return "user/pictureInsert";
	}


	@PostMapping("/picture")
	public String checkPictureInfo(@Valid @ModelAttribute Picture picture, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "user/pictureInsert";
		}
		else {
			model.addAttribute(picture);
			pictureService.add(picture); 
		}
		return "pictureInfo";
	}
}
