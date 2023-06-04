package com.gfg.jbdl52.service;

import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public Movie addMovie(Movie movie){
        repository.save(movie);
        return movie;
    }

    public List<Movie> getByTitle(String title){
        /**
         * Fetch movies first
         * Fetch review based on movie id
         * merge the result and return single entity
         * */
        return repository.findByTitle(title);
    }

    public List<Movie> getAllMovie(){
        return repository.findAll();
    }

    public List<Movie> getMovieByTitle(String title) {
        return repository.findByTitle(title);
    }
}
