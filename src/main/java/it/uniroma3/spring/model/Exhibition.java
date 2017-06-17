package it.uniroma3.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Exhibition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "exhibition_id")
	private Long id;
	@NotNull
	@Size(min=1)
	private String name;
	private String description;
	@ManyToMany
	@JoinTable(name = "exhibition_room", joinColumns = @JoinColumn(name = "exhibition_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
	private List<Room> rooms;
	@NotNull
	@Size(min=1)
	private String url;
	

	public Exhibition() {
		this.rooms = new ArrayList<>();
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	
}
