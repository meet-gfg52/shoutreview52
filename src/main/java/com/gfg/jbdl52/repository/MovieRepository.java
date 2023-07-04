package com.gfg.jbdl52.repository;

import com.gfg.jbdl52.domain.Genre;
import com.gfg.jbdl52.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAll();

   /** select * from movie where title=?*/

   List<Movie> findByTitle(String title);

   List<Movie> findByRating(Double rating);

   List<Movie> findByGenre(Genre genre);

   //@Query("select m from Movie where genre=?2 and rating=?1")
   List<Movie> findByRatingAndGenre(Double rating,Genre genre);

   /**
    * JPQL -> Jave persistence query language
    * */
   @Query("select m from Movie m where m.genre=?1")
   //@Query("select m from Movie m where m.genre=:genre")
   List<Movie> promotionMovies(Genre genre);


   /***
    * To run the query with database platform dependent language
    * */
   @Query(value = "select * from movies where genre=?",nativeQuery = true)
   List<Movie> movieView(String genre);

   List<Movie> findAllByOrderByReleaseDate();





}
