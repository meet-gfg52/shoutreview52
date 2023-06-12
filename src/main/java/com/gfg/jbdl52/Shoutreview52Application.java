package com.gfg.jbdl52;

import com.gfg.jbdl52.domain.Genre;
import com.gfg.jbdl52.domain.MyUser;
import com.gfg.jbdl52.domain.Review;
import com.gfg.jbdl52.repository.MovieRepository;
import com.gfg.jbdl52.repository.ReviewRepository;
import com.gfg.jbdl52.service.MyUserDetailService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;

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

	@Override
	public void run(String... args) throws Exception {
	}

}
