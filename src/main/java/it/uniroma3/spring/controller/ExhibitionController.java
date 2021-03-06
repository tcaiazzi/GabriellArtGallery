
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

import it.uniroma3.spring.mail.HtmlEmailSender;
import it.uniroma3.spring.mail.HtmlMessagePreparator;
import it.uniroma3.spring.model.Exhibition;
import it.uniroma3.spring.model.Reservation;
import it.uniroma3.spring.model.Room;
import it.uniroma3.spring.model.User;
import it.uniroma3.spring.service.ExhibitionService;
import it.uniroma3.spring.service.ReservationService;
import it.uniroma3.spring.service.RoomService;
import it.uniroma3.spring.service.UserService;

@Controller
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HtmlEmailSender emailSender;
	
	@Autowired
	private HtmlMessagePreparator messagePreparator;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/admin/exhibition")
	public String showExhibitionInsert(Exhibition exhibition,Model model){
		
		
		List<Room> rooms = roomService.findAll();
		model.addAttribute("rooms", rooms);
		
		
		return "admin/exhibitionInsert";
	}
	
	@PostMapping("/admin/exhibition")
	public String checkExhibitionInfo(@Valid @ModelAttribute Exhibition exhibition,
			BindingResult bindingResult, Model model,WebRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "admin/exhibitionInsert";
		}
		else 
		exhibition.setUrl("../img/exhibition/"+exhibition.getUrl());
		model.addAttribute(exhibition);
		exhibitionService.add(exhibition); 
		List<User> users = userService.findAll();
		emailSender.prepareEmailforAllUsers(users, "New exhibition: " +exhibition.getName(), messagePreparator.newExhibitionMessage(exhibition.getId(), exhibition.getName()));
		request.getParameter("rooms");
		
		
	return "admin/exhibitionInfo";
			

		
	}
	
	@GetMapping("/admin/showExhibition")
	public String showExhibitionInfo(Model model,WebRequest request){
		
		Long id = Long.parseLong(request.getParameter("id"));
		Exhibition exhibition = exhibitionService.find(id);
		model.addAttribute("exhibition", exhibition);
		String name = request.getParameter("name");
		List<Reservation> reservations = reservationService.findReservationByExhibitionName(name);
		model.addAttribute("reservations", reservations);
		
		
		return "admin/exhibitionInfo";
	}
	
	
	
	@GetMapping("/showExhibition")
	public String showExhibitionInfoGag(Exhibition exhibition,Model model,WebRequest request){
		
		Long id = Long.parseLong(request.getParameter("id"));
	 exhibition = exhibitionService.find(id);
		model.addAttribute(exhibition);
		
		return "exhibitionInfoGag";
	}
	
	@GetMapping("/admin/exhibitionsList")
	public String showExhibitionsListAdmin( Model model){
		List<Exhibition> exhibitions = exhibitionService.getAll();
		model.addAttribute("exhibitions", exhibitions);
		return "admin/exhibitionsList";
	}
	
	@GetMapping("/exhibitionsList")
	public String showExhibiotnsList( Model model){
		List<Exhibition> exhibitions = exhibitionService.getAll();
		model.addAttribute("exhibitions", exhibitions);
		return "exhibitionsListGag";
	}
	
	
	@GetMapping("/reservation/confirm")
	public String showReservationConfirm(Principal principal, WebRequest request, Model model){
		if(principal!=null){
			Long ex_id = Long.parseLong(request.getParameter("id"));
			String ex_name = request.getParameter("name");
			Exhibition ex = exhibitionService.find(ex_id);
			
			model.addAttribute("exhibition", ex);
			String username = principal.getName();
			model.addAttribute("principal", principal);
			try{
			Reservation reservation = new Reservation(ex_id, ex_name, username);
			this.reservationService.add(reservation);
			}catch(Exception e){
				return "reservationConfirmError";
				
			}
		}
		
		return "reservationConfirm";
		
	}
	
	
	@GetMapping("admin/reservationDelete")
	public String reservationDelete( WebRequest request, Model model){
		
			Long resId = Long.parseLong(request.getParameter("res_id"));
			this.reservationService.delete(resId);
			Long id = Long.parseLong(request.getParameter("ex_id"));
			Exhibition exhibition = exhibitionService.find(id);
			model.addAttribute("exhibition", exhibition);
			List<Reservation> reservations = reservationService.findReservationByExhibitionName(exhibition.getName());
			System.out.println("-------------------------------------------"+reservations);
			model.addAttribute("reservations", reservations);
			
		return "admin/exhibitionInfo";
		
	}
	
	
	
	
}
