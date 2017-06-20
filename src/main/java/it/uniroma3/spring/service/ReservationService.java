package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Reservation;
import it.uniroma3.spring.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Transactional
	public void add(Reservation reservation){
		this.reservationRepository.save(reservation);
	}
	
	@Transactional
	public List<Reservation> findReservationByExhibitionName(String name){
		return this.reservationRepository.findByExhibition(name);
	}
	
	@Transactional
	public void delete(Long id) {
		this.reservationRepository.delete(id);
		
	}

}
