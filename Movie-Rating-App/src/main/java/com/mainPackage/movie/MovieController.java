package com.mainPackage.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping(path = "/movie")
public class MovieController {
	final MovieService movieService;
	@Autowired
	MovieController(MovieService movieService){
		this.movieService = movieService;
	}
	@GetMapping
	public List<Movie> getMovies(){
		return movieService.getMovies();
	}
	@PutMapping(path = "{movieId}")
	public List<Movie> updateRating(
				@PathVariable("movieId") Long movieId,
				@RequestBody Movie movie
			) {
//		System.out.println(movie.getRating());
		movieService.updateMovie(movieId, movie.getRating());
		return getMovies();
	}
}
