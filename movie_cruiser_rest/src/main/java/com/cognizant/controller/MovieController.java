package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;
import com.cognizant.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	MovieService movieService;
	
	@GetMapping()
	public List<Movie> getAllMovies(){
		LOGGER.info("Start MovieController getAllMovies");
		LOGGER.info("End MovieController getAllMovies");
		return movieService.getMovieListCustomer();
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable long id)throws MovieNotFoundException{
		LOGGER.info("Start MovieController getMovie");
		LOGGER.info("End MovieController getMovie");
		return movieService.getMovie(id);
	}
	
	@PutMapping
	public void modifyMovie(@RequestBody Movie movie) {
		LOGGER.info("Start MovieController modifyMovie");
		movieService.modifyMovie(movie);
		LOGGER.info("End MovieController modifyMovie");
	}
}
