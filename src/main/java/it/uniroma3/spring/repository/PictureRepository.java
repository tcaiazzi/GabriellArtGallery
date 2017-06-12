package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Picture;

public interface PictureRepository extends CrudRepository<Picture, Long>{
	
}
