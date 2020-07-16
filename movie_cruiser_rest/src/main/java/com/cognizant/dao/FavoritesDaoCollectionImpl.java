package com.cognizant.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Favorites;
import com.cognizant.model.Movie;
import com.cognizant.service.MovieService;

@Repository
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoritesDaoCollectionImpl.class);
	
	private static Map<String, Favorites> favItems = new HashMap<>();

	@Autowired
	MovieService movieService;

	@Override
	public void addFavorites(String userId, long movieId) throws MovieNotFoundException {
		LOGGER.info("Start FavoritesDaoCollectionImpl addFavorites");
		Movie movie = movieService.getMovie(movieId);
		if (favItems.containsKey(userId)) {
			Favorites userFav = favItems.get(userId);
			List<Movie> list = userFav.getMovieList();
			list.add(movie);
			userFav.setMovieList(list);
			userFav.setNoOfFavorites(userFav.getNoOfFavorites() + 1);
			favItems.put(userId, userFav);
		} else {
			Favorites newFav = new Favorites();
			List<Movie> list = new ArrayList<>();
			list.add(movie);
			newFav.setMovieList(list);
			newFav.setNoOfFavorites(1);
			favItems.put(userId, newFav);
		}
		LOGGER.info("End FavoritesDaoCollectionImpl addFavorites");
	}

	@Override
	public List<Movie> getAll(String userId) {
		LOGGER.info("Start FavoritesDaoCollectionImpl getAll");
		Favorites fav = favItems.get(userId);
		LOGGER.info("End FavoritesDaoCollectionImpl getAll");
		return fav.getMovieList();
	}

	@Override
	public void deleteFavorites(String userId, long movieId) throws MovieNotFoundException {
		LOGGER.info("Start FavoritesDaoCollectionImpl deleteFavorites");
		Movie movie = movieService.getMovie(movieId);
		Favorites fav = favItems.get(userId);
		List<Movie> movieList = fav.getMovieList();
		movieList.remove(movie);
		fav.setNoOfFavorites(fav.getNoOfFavorites() - 1);
		favItems.put(userId, fav);
		LOGGER.info("End FavoritesDaoCollectionImpl deleteFavorites");
	}

	@Override
	public long getTotalFav(String userId) {
		LOGGER.info("Start FavoritesDaoCollectionImpl getTotalFav");
		Favorites fav = favItems.get(userId);
		LOGGER.info("End FavoritesDaoCollectionImpl getTotalFav");
		return fav.getNoOfFavorites();
	}

}
