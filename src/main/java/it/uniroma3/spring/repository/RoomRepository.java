package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.spring.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	
}
