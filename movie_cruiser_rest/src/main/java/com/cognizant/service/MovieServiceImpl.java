package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.MovieDao;
import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;

@Service
public class MovieServiceImpl implements MovieService{

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Autowired
	MovieDao movieDao;

	@Override
	public List<Movie> getMovieListCustomer() {
		LOGGER.info("Start MovieServiceImpl getMovieListCustomer");
		LOGGER.info("End MovieServiceImpl getMovieListCustomer");
		return movieDao.getMovieListCustomer();
	}

	@Override
	public void modifyMovie(Movie movie) {
		LOGGER.info("Start MovieServiceImpl modifyMovie");
		movieDao.modifyMovie(movie);
		LOGGER.info("End MovieServiceImpl modifyMovie");
	}

	@Override
	public Movie getMovie(long movieId) throws MovieNotFoundException {
		LOGGER.info("Start MovieServiceImpl getMovie");
		LOGGER.info("End MovieServiceImpl getMovie");
		return movieDao.getMovie(movieId);
	}
}
