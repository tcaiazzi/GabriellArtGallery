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

import it.uniroma3.spring.model.Room;
import it.uniroma3.spring.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;




	@GetMapping("/admin/room")
	public String showRoomInsert(Room room){

		return "admin/roomInsert";
	}
	
	@GetMapping("/admin/roomInfo")
	public String showRoomInfo(Model model, WebRequest request){
		Long id = Long.parseLong(request.getParameter("id"));
		Room room = this.roomService.findRoom(id);
		model.addAttribute("room", room);
		return "admin/roomInfo";
	}
	
	
	@GetMapping("/admin/roomsList")
	public String showRoomsList(Model model){
		List<Room> rooms = this.roomService.findAll();
		model.addAttribute("rooms", rooms);
		return "admin/roomsList";
	}
	
	
	@GetMapping("/admin/deleteRoom")
	public String deleteRoom(WebRequest request){
		Long id = Long.parseLong(request.getParameter("id"));
		this.roomService.delete(id);
		return "admin/roomsList";
	}
	
	
	

	@PostMapping("/admin/room")
	public String checkRoomInfo(@Valid @ModelAttribute Room room,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "admin/roomInsert";
		}
		else 
			model.addAttribute(room);
		roomService.add(room);

		return "admin/roomInsert";
	}


}
