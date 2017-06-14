package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.model.Room;
import it.uniroma3.spring.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	public List<Room> findAll(){
		return (List<Room>) this.roomRepository.findAll();
	}

	public void add(Room room) {
		this.roomRepository.save(room)		;
	}

}
