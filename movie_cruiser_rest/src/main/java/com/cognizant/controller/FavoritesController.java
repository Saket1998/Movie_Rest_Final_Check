package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;
import com.cognizant.service.FavoritesService;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

private static final Logger LOGGER = LoggerFactory.getLogger(FavoritesController.class);
	
	@Autowired
	FavoritesService favoritesService;
	
	@PostMapping("/{userId}/{movieId}")
	void addFavorites(@PathVariable String userId, @PathVariable long movieId)throws MovieNotFoundException{
		LOGGER.info("Start FavoritesController addFavorites");
		favoritesService.addFavorites(userId, movieId);
		LOGGER.info("End FavoritesController addFavorites");
	}
	
	@GetMapping("/{userId}")
	List<Movie> getAll(@PathVariable String userId){
		LOGGER.info("Start FavoritesController getAll");
		LOGGER.info("End FavoritesController getAll");
		return favoritesService.getAll(userId);
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	void deleteFavorites(@PathVariable String userId, @PathVariable long movieId)throws MovieNotFoundException{
		LOGGER.info("Start FavoritesController deleteFavorites");
		favoritesService.deleteFavorites(userId, movieId);
		LOGGER.info("End FavoritesController deleteFavorites");
	}
	
	@GetMapping("/favlist/{userId}")
	long getTotalFav(@PathVariable String userId) {
		LOGGER.info("Start FavoritesController getTotalFav");
		LOGGER.info("End FavoritesController getTotalFav");
		return favoritesService.getTotalFav(userId);
	}
	
}
