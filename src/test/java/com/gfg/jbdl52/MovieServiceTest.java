package com.gfg.jbdl52;

import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.repository.MovieRepository;
import com.gfg.jbdl52.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {


    private RedisTemplate template;

   @Mock
    private MovieRepository repository;


    @InjectMocks
    private MovieService movieService;


    @Before
    public void setup(){
        movieService=mock(MovieService.class);
        repository=mock(MovieRepository.class);
        template=mock(RedisTemplate.class);
        movieService.setMovieRepository(repository);
//        movieService.setRedisTemplate(mock(template));
    }


    @Test
    public void addMovie_success(){
        Movie actualMovie=new Movie();
        actualMovie.setTitle("MIB");

        when(repository.save(actualMovie)).thenReturn(actualMovie);

        movieService.addMovie(actualMovie);

        Movie movie=repository.save(actualMovie);

        assertEquals(actualMovie,movie);

    }

    @Test
    public void addMovie_failure(){
        Movie actualMovie=new Movie();
        actualMovie.setTitle("MIB");

        Movie wrongMovie=new Movie();
        wrongMovie.setTitle("MIB-2");

        when(repository.save(actualMovie)).thenReturn(wrongMovie);

        movieService.addMovie(actualMovie);

        Movie movie=repository.save(actualMovie);

        assertNotEquals(actualMovie,movie);

    }

    @Test
    public void testGetByTitle_success(){
        List<Movie> movieList=new ArrayList<>();
        Movie actualMovie=new Movie();
        actualMovie.setTitle("MIB");
        movieList.add(actualMovie);

        when(repository.findByTitle(anyString())).thenReturn(movieList);

        List<Movie> actualMovieList=movieService.getMovieByTitle("MIB");

        assertEquals(1,actualMovieList.size());
    }
}
