package com.cognizant.dao;

import java.util.List;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;

public interface MovieDao {

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(Movie movie);

	public Movie getMovie(long movieId) throws MovieNotFoundException;
}