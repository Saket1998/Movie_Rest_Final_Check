package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.FavoritesDao;
import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;

@Service
public class FavoritesServiceImpl implements FavoritesService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FavoritesServiceImpl.class);
	
	@Autowired
	FavoritesDao favoritesDao;

	@Override
	public void addFavorites(String userId, long movieId) throws MovieNotFoundException {
		LOGGER.info("Start FavoritesServiceImp addFavorites");
		favoritesDao.addFavorites(userId,movieId);
		LOGGER.info("End FavoritesServiceImp addFavorites");
	}

	@Override
	public List<Movie> getAll(String userId) {
		LOGGER.info("Start FavoritesServiceImp getAll");
		LOGGER.info("End FavoritesServiceImp getAll");
		return favoritesDao.getAll(userId);
	}

	@Override
	public void deleteFavorites(String userId, long movieId) throws MovieNotFoundException {
		LOGGER.info("Start FavoritesServiceImp deleteFavorites");
		favoritesDao.deleteFavorites(userId,movieId);
		LOGGER.info("End FavoritesServiceImp deleteFavorites");
	}

	@Override
	public long getTotalFav(String userId) {
		LOGGER.info("Start FavoritesServiceImp getTotalFav");
		LOGGER.info("End FavoritesServiceImp getTotalFav");
		return favoritesDao.getTotalFav(userId);
	}

}
