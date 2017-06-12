package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import it.uniroma3.spring.model.Artist;
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.ArtistService;

@Controller
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@GetMapping("/artist")
	public String showArtistInsert(Artist artist){
		return "artistInsert";
	}
	
	@PostMapping("/artist")
	public String checkArtistInfo(@Valid @ModelAttribute Artist artist, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "artistInsert";
		}
		else {
			model.addAttribute(artist);
			artistService.add(artist); 
		}
		return "artistInfo";
	}
	
	@GetMapping("/artistsList")
	public String showArtistsList( Model model){
		List<Artist> artists = artistService.getAll();
		model.addAttribute("artists", artists);
		return "artistsList";
	}
	

}
