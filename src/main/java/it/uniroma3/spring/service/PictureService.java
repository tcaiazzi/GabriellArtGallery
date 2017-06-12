package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.repository.PictureRepository;

@Service
public class PictureService{
	
	@Autowired
	private PictureRepository pictureRepostory;
	
	@Transactional
	public void add(final Picture painting){
		this.pictureRepostory.save(painting);
	}
	

}
