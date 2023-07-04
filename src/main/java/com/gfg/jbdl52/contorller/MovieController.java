package com.gfg.jbdl52.contorller;

import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.service.MovieService;
import com.gfg.jbdl52.service.MovieServiceLegacy;
import com.gfg.jbdl52.service.resource.MovieRequest;
import com.gfg.jbdl52.service.resource.MovieResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    ApplicationContext context;

    @Autowired
    MovieService service;


    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody @Valid MovieRequest movie){
        return new ResponseEntity<>(service.addMovie(movie.getMovieFromRequest()).toMovieResponse(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getMovies(){
        List<MovieResponse> response=service.getMoviesForHomePage().stream().map(Movie::toMovieResponse).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

   @GetMapping(value="/{title}")
   public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title){
        return new ResponseEntity<>(service.getMovieByTitle(title),HttpStatus.OK);
    }
//
//    @GetMapping
//    public List<Movie> getMovies(){
//        return service.getAllMovies();
//    }
//
//    @DeleteMapping
//    public boolean deleteMovie(@RequestParam("id") Integer id){
//        return service.deleteMovie(id);
//    }

}



















