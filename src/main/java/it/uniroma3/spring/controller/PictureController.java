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
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.ArtistService;
import it.uniroma3.spring.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService; 

	@Autowired
	private ArtistService artistService; 
	
	

	@GetMapping("/admin/picture")
	public String showPictureInsert(Picture picture,Model model){
		List<Artist> artists = artistService.getAll();
		model.addAttribute("artists",artists);
		return "admin/pictureInsert";
	}

	


	@PostMapping("/admin/picture")
	public String checkPictureInfo(@Valid @ModelAttribute Picture picture,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "admin/pictureInsert";
		}
		else 
			picture.setUrl("../img/picture/"+picture.getUrl());
		

			
			
			model.addAttribute(picture);
			pictureService.add(picture); 
			
			System.out.println("----id-artista----"+picture.getArtist().getId());
			Artist a = artistService.find(picture.getArtist().getId());
			a.getPictures().add(picture);
			artistService.add(a);
			
			System.out.println("----pictures----"+a.getPictures());
			

		return "admin/pictureInfo";
	}
	
	@GetMapping("/showPicture")
	public String showPicture(Model model,WebRequest request){
		
		/*setting picture to show*/
		Long id = Long.parseLong(request.getParameter("id"));
		Picture pic = pictureService.find(id);
		model.addAttribute(pic);
		
		return "admin/pictureInfo";

	}
	
	@GetMapping("/showPictureGag")
	public String showPictureGag(Model model,WebRequest request){
		
		/*setting picture to show*/
		Long id = Long.parseLong(request.getParameter("id"));
		Picture picture = pictureService.find(id);
		model.addAttribute(picture);
		
		return "pictureInfoGag";

	}

	@GetMapping("/admin/picturesList")
	public String showPicturesList(Model model){
		
		List<Picture> pictures = pictureService.getAll();
		model.addAttribute("pictures", pictures);
		
		return "admin/picturesList";

	}

}
