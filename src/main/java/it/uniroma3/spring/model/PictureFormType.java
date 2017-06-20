package it.uniroma3.spring.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PictureFormType {
	
	@NotNull
	@Size(min=1)
	private String title;
	@NotNull
	private int year;
	@NotNull
	@Size(min=1)
	private String medium;
	@NotNull
	@Size(min=1)
	private String dimension;
	@NotNull
	@Size(min=1)
	@Column(length=1024)
	private String description;
	
	@NotNull
	@Size(min=1)
	private String url;

	

	@ManyToOne
	private Artist artist;
	

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
