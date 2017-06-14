package it.uniroma3.spring.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Artist;
import it.uniroma3.spring.model.Picture;

public interface PictureRepository extends CrudRepository<Picture, Long>{
	
	List<Picture> findByArtist(Artist artist);
}
