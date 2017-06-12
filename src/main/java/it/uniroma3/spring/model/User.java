package it.uniroma3.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String name;
	
	public String surname;
	
	public String username;
	
	public String email;
	
	public String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

}
