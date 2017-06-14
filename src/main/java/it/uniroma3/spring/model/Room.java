package it.uniroma3.spring.model;


import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "room_id")
	private Long id;
	private String name; 
	private String description;
	@OneToMany
	private Map<String,Picture> pictures;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Picture> getQuadri() {
		return pictures;
	}

	public void setQuadri(Map<String, Picture> paintings) {
		this.pictures = paintings;
	}

	

}
