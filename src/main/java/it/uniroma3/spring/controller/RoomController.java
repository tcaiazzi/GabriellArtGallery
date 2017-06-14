package it.uniroma3.spring.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import it.uniroma3.spring.model.Room;
import it.uniroma3.spring.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;



	@GetMapping("/room")
	public String showRoomInsert(Room room){

		return "roomInsert";
	}

	@PostMapping("/room")
	public String checkRoomInfo(@Valid @ModelAttribute Room room,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "roomInsert";
		}
		else 
			model.addAttribute(room);
		roomService.add(room);

		return "roomInsert";



	}


}
