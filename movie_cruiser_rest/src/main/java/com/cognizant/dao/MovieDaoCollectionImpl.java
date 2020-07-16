package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;

@Repository
public class MovieDaoCollectionImpl implements MovieDao{
	
	private static List<Movie> movie_List = new ArrayList<>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieDaoCollectionImpl.class);
	
	public MovieDaoCollectionImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("movie.xml");
		movie_List=(List<Movie>)context.getBean("movieList");
	}
	
	@Override
	public List<Movie> getMovieListCustomer() {
		LOGGER.debug("Movies : {}",movie_List);
		return movie_List;
	}

	@Override
	public void modifyMovie(Movie movie1) {
		LOGGER.info("Start MovieDaoCollectionImpl modifyMovie");
		try {
			Movie movie = getMovie(movie1.getId());
			movie.setTitle(movie1.getTitle());
			movie.setBoxOffice(movie1.getBoxOffice());
			movie.setActive(movie1.isActive());
			movie.setDateOfLaunch(movie1.getDateOfLaunch());
			movie.setGenre(movie1.getGenre());
			movie.setHasTeaser(movie1.isHasTeaser());
		}
		catch(MovieNotFoundException e){
			e.getMessage();
		}
		LOGGER.info("End MovieDaoCollectionImpl modifyMovie");
	}

	@Override
	public Movie getMovie(long id) throws MovieNotFoundException {
		LOGGER.info("Start MovieDaoCollectionImpl getMovie");
		Movie movie=null;
		for (Movie i :movie_List) {
			if(id==i.getId())
				movie=i;
		}
		LOGGER.info("End MovieDaoCollectionImpl getMovie");
		if(movie==null)
			throw new MovieNotFoundException("Movie Not Found");
		else
			return movie;
	}

}
