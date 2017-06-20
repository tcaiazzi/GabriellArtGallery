package it.uniroma3.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(		
		   name = "reservations",
		   uniqueConstraints = {@UniqueConstraint(columnNames = {"exhibition_id", "username"})}
		)
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "reservation_id")
	private Long id;

	private Long exhibition_id;
	
	private String exhibition;

	
	private String username;
	
	public Reservation(Long exhibition_id, String exhibition_name, String username){
		this.exhibition_id = exhibition_id;
		this.exhibition = exhibition_name; 
		this.username = username;
	}
	
	
	public Reservation(){};
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getExhibition_id() {
		return exhibition_id;
	}
	public void setExhibition_id(Long exhibition_id) {
		this.exhibition_id = exhibition_id;
	}
	public String getExhibition_name() {
		return exhibition;
	}
	public void setExhibition_name(String exhibition_name) {
		this.exhibition = exhibition_name;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	} 
	
	

}
