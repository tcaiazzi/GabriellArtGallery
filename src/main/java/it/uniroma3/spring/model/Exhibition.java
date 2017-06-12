package it.uniroma3.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exhibition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	@OneToMany
	private List<Room> rooms;

	public Exhibition() {
		// TODO Auto-generated constructor stub
	}



	
}
