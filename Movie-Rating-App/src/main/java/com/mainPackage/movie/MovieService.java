package com.mainPackage.movie;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	final MovieRepo movieRepo;
	@Autowired
	MovieService(MovieRepo movieRepo){
		this.movieRepo = movieRepo;
	}
	public List<Movie> getMovies(){	
//		return List.of(
//				new Movie("Rab ne bana di jodi", 5L),
//				new Movie("Rab ne bana di jodi", 5L)
//				);
		return movieRepo.findAll();
		
	}
	@Transactional
	public void updateMovie(Long movieId, Long rating) {
		// TODO Auto-generated method stub
		Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new IllegalStateException("movie doesn't exist"));
//		System.out.println("reached");
		movie.setRating(rating);
	}
}
