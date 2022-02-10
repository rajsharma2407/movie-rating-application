package com.mainPackage.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Movie {
	@Id
	@SequenceGenerator(name = "movie_sequence", sequenceName="movie_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="movie_sequence")
	private long id;
	private String movieName;
	private long rating;
	public Movie() {
		
	}
	public Movie(String movieName, long rating) {
		super();
		this.movieName = movieName;
		this.rating = rating;
	}	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", rating=" + rating + "]";
	}
}
