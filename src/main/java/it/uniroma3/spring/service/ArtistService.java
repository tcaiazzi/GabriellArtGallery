package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Artist;

import it.uniroma3.spring.repository.ArtistRepository;


@Service
public class ArtistService{
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Transactional
	public void add(final Artist artist){
		this.artistRepository.save(artist);
	}

	public List<Artist> getAll() {
		return (List<Artist>) this.artistRepository.findAll();
	}
	

}
