package com.gfg.jbdl52.service;

import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {

    Logger logger= LoggerFactory.getLogger(MovieService.class);


    MovieRepository repository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository){
        this.repository=movieRepository;
    }


    RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }



    private final String homepageMovieKey="HOMEPAGE_MOVIES";



    public Movie addMovie(Movie movie){
        if(movie.getReleaseDate().isAfter(LocalDate.now().minusDays(30)))
            redisTemplate.opsForList().rightPush(homepageMovieKey,movie);
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

    public List<Movie> getMoviesForHomePage(){
        /**
         * 1. List of all movies, sorted by Desc date.
         * 2. Map of movies with Genre as key and value as list of movie sorted with date.
         *
         * Redis structure: Key : "HOMEPAGE_MOVIES"
         *                  value : List<Movies>
         *
         * */
        Long start = System.currentTimeMillis();
        List<Movie> movieList=redisTemplate.opsForList().range(homepageMovieKey,0,-1);
        if(CollectionUtils.isEmpty(movieList)){
            movieList=repository.findAllByOrderByReleaseDate();
            if(!CollectionUtils.isEmpty(movieList))
                movieList.stream().forEach(movie -> redisTemplate.opsForList().rightPush(homepageMovieKey,movie));
        }
        Long end=System.currentTimeMillis();
        logger.info("time : {}", end-start);
        return movieList;


    }

    public List<Movie> getAllMovie(){
        return repository.findAll();
    }

    public List<Movie> getMovieByTitle(String title) {
        List<Movie> movieList=repository.findByTitle(title);
        logger.info("{}",movieList.size());
        return movieList;
    }
}
