package com.gfg.jbdl52;

import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.repository.MovieRepository;
import com.gfg.jbdl52.service.MovieService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {

    @Autowired
    MovieRepository repository;

    Logger logger= LoggerFactory.getLogger(DemoTest.class);

    public void testListAdd(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        if(list.size() != 1)
            System.out.println("size or add is not working fine");
        if(list.get(0) != 1)
            System.out.println("add has not added proper value");

    }

    public void testMovieAdd(){
        Movie movie=new Movie();
        movie.setTitle("IronMan");
        MovieService service=new MovieService();
        service.addMovie(movie);
        List<Movie> movie1=repository.findByTitle("IronMan");

    }

}
