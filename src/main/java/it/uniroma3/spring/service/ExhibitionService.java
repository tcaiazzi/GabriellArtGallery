package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Exhibition;
import it.uniroma3.spring.repository.ArtistRepository;
import it.uniroma3.spring.repository.ExhibitionRepository;

@Service
public class ExhibitionService {
	
	@Autowired
	private ExhibitionRepository exhibitionRepository;

	@Transactional
	public void add(Exhibition exhibition) {
		
		this.exhibitionRepository.save(exhibition);
		
	}

	public List<Exhibition> getAll() {
		return (List<Exhibition>) this.exhibitionRepository.findAll();
	}

	public Exhibition find(Long id) {
		return this.exhibitionRepository.findOne(id);
	}

}
