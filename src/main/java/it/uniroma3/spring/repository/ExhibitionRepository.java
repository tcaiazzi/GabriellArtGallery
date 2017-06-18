package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Exhibition;
import it.uniroma3.spring.model.Room;

public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {
	
}
