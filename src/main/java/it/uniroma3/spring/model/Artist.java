package it.uniroma3.spring.model;

import java.util.Date;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String surname;
	private String nationality; 
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Temporal(TemporalType.DATE)
	private Date deathDate;
	
	@OneToMany(mappedBy = "artist" )
	private Map<String,Picture> pictures;
	
	public Artist() {
		// TODO Auto-generated constructor stub
	}


	
	

}
