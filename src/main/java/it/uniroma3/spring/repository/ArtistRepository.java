package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

}
