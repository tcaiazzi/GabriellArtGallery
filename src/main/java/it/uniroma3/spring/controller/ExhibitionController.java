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
import org.springframework.web.context.request.WebRequest;

import it.uniroma3.spring.model.Artist;
import it.uniroma3.spring.model.Exhibition;
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.model.Room;
import it.uniroma3.spring.service.ExhibitionService;
import it.uniroma3.spring.service.RoomService;

@Controller
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;
	
	@Autowired
	private RoomService roomService;
	
	
	
	@GetMapping("/exhibition")
	public String showExhibitionInsert(Exhibition exhibition,Model model){
		
		
		List<Room> rooms = roomService.findAll();
		model.addAttribute("rooms", rooms);
		
		
		return "exhibitionInsert";
	}
	
	@PostMapping("/exhibition")
	public String checkExhibitionInfo(@Valid @ModelAttribute Exhibition exhibition,
			BindingResult bindingResult, Model model,WebRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "exhibitionInsert";
		}
		else 
		model.addAttribute(exhibition);
		exhibitionService.add(exhibition); 
		

		
		
	return "exhibitionInfo";
			

		
	}
	
	@GetMapping("/showExhibition")
	public String showExhibitionInfo(Exhibition exhibition,Model model,WebRequest request){
		
		Long id = Long.parseLong(request.getParameter("id"));
		Exhibition ex = exhibitionService.find(id);
		model.addAttribute(ex);
		
		/*
		List<Room> rooms = roomService.findAll();
		model.addAttribute("rooms", rooms);*/
		
		
		return "exhibitionInfo";
	}
	
	@GetMapping("/exhibitionList")
	public String showArtistsList( Model model){
		List<Exhibition> exhibitions = exhibitionService.getAll();
		model.addAttribute("exhibitions", exhibitions);
		return "exhibitionList";
	}
	
}
