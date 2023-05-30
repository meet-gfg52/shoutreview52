package com.gfg.jbdl52.contorller;

import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    ApplicationContext context;

    @Autowired
    MovieService service;


    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody @Valid Movie movie){
        return new ResponseEntity<>(service.addMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Movie> getMovies(){
      return service.getAllMovies();
    }

//    @GetMapping(value="/{title}")
//    public Movie getMovieByTitle(@PathVariable("title") String title){
//        return service.getMovieByTitle(title);
//    }
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



















