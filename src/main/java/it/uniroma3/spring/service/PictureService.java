package it.uniroma3.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Artist;
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.repository.PictureRepository;

@Service
public class PictureService{

	@Autowired
	private PictureRepository pictureRepository;


	@Transactional
	public void add(final Picture painting){
		this.pictureRepository.save(painting);
	}

	@Transactional
	public Picture find(Long id) {
		return this.pictureRepository.findOne(id);
	}

	@Transactional
	public List<Picture> findPicsByArtist(Artist a){
		return this.pictureRepository.findByArtist(a);

	}
	
	@Transactional
	public void deletePicsByArtist(Artist a){
		this.pictureRepository.delete(this.pictureRepository.findByArtist(a));

	}
	@Transactional
	public List<Picture> getAll() {

		return (List<Picture>) this.pictureRepository.findAll();
	}
	@Transactional
	public void deletePicture(Long id){
		this.pictureRepository.delete(id);
	}
	@Transactional
	public void deletePictures(List<Picture> pictures){
		this.pictureRepository.delete(pictures);
	}


}