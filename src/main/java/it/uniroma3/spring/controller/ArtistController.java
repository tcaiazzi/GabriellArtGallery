package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import it.uniroma3.spring.model.Artist;
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.ArtistService;
import it.uniroma3.spring.service.PictureService;

@Controller
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private PictureService pictureService;

	
	@GetMapping("/showArtist")
	public String showArtistProfile(Model model,WebRequest request){
		/*setting artist to show*/
		Long id = Long.parseLong(request.getParameter("id"));
		Artist art = artistService.find(id);
		model.addAttribute(art);
		/*setting artist's picture list if exist*/
		if(pictureService.findPicsByArtist(art)!=null){
		List<Picture> pictures = pictureService.findPicsByArtist(art);
		model.addAttribute("pictures", pictures);
		}
		return "artistInfo";
	}
	
	@PostMapping("/admin/artist")
	public String checkArtistInfo(@Valid @ModelAttribute Artist artist, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "artistInsert";
		}
		else {
			artist.setUrl("../img/artist/"+artist.getUrl());
			model.addAttribute(artist);
			artistService.add(artist); 
		}
		return "artistInfo";
	}
	@GetMapping("/admin/artistsList")
	public String showArtistsListAdmin( Model model){
		List<Artist> artists = artistService.getAll();
		model.addAttribute("artists", artists);
		return "artistsList";
	}
	
	@GetMapping("/artistsList")
	public String showArtistsList( Model model){
		List<Artist> artists = artistService.getAll();
		model.addAttribute("artists", artists);
		return "artistsListGag";
	}
	
	
	

}
