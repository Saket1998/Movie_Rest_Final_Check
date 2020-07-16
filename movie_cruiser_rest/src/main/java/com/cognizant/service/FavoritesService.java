package com.cognizant.service;

import java.util.List;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;

public interface FavoritesService {

	public void addFavorites(String userId,long movieId) throws MovieNotFoundException;
	
	public List<Movie> getAll(String userId);

	public void deleteFavorites(String userId,long movieId) throws MovieNotFoundException;

	public long getTotalFav(String userId);
}
