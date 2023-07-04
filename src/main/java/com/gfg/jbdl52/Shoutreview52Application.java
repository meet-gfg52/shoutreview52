package com.gfg.jbdl52;

import com.gfg.jbdl52.domain.Genre;
import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.domain.MyUser;
import com.gfg.jbdl52.domain.Review;
import com.gfg.jbdl52.repository.MovieRepository;
import com.gfg.jbdl52.repository.ReviewRepository;
import com.gfg.jbdl52.service.MyUserDetailService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Objects;

@SpringBootApplication
public class Shoutreview52Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Shoutreview52Application.class, args);
	}

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	ReviewRepository repository;

	@Autowired
	MyUserDetailService userDetailsService;

	@Autowired
	RedisTemplate template;

	@Override
	public void run(String... args) throws Exception {

		/*template.opsForValue().set("myJavaKey","myJavaValue");
		System.out.println(template.opsForValue().get("myJavaKey"));

		String movieKey="TopMovies";
		Movie movie=new Movie(1L,"MIB",3.0,Genre.ACTION,"",new ArrayList<>());
		template.opsForList().rightPush(movieKey,movie);
		Movie movie1=new Movie(2L,"MIB-2",2.0,Genre.ACTION,"",new ArrayList<>());
		template.opsForList().rightPush(movieKey,movie1);

		System.out.println(template.opsForList().range(movieKey,0,-1));

		template.opsForHash().put(movie.getTitle(), "title",movie.getTitle());
		template.opsForHash().put(movie.getTitle(), "rating",movie.getRating());
		template.opsForHash().put(movie.getTitle(), "genre",movie.getGenre());

		String hashMovie="movieHash";
		template.opsForHash().put(hashMovie,movie.getTitle(),movie);
		template.opsForHash().put(hashMovie,movie1.getTitle(),movie1);


		System.out.println(template.opsForHash().keys(movie.getTitle()));

*/



	}

}
