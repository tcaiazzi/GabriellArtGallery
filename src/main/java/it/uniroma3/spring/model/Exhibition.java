package it.uniroma3.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Exhibition implements Comparable<Exhibition>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "exhibition_id")
	private Long id;
	@NotNull
	@Size(min=1)
	private String name;
	@NotNull
	@Size(min=1)
	@Column(length=1024)
	private String description;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "exhibition_room", joinColumns = @JoinColumn(name = "exhibition_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
	private List<Room> rooms;
	@NotNull
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@NotNull
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int compareTo(Exhibition that) {
		return this.getStartDate().compareTo(that.getStartDate());
	}
	

	
}
