package com.gfg.jbdl52.domain;

import com.gfg.jbdl52.service.resource.MovieResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movies")
@ToString
@Builder
public class Movie {

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String title;

   private Double rating;

   @Enumerated(EnumType.STRING)
   private Genre genre;

   private String director;
   /**
    * one movie can have multiple reivews
    * */
   @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
   List<Review> reviewList;

   public MovieResponse toMovieResponse(){
      return MovieResponse.builder().title(this.title).rating(this.rating).genre(this.genre).build();
   }


   /**
    * Types of ID generation strategy
    *
    *     TABLE -> a separate the table for ID management.
    *     SEQUENCE -> uses the sequence logic for id generation
    *     IDENTITY -> uses underlying of the database to handle.
    *     UUID -> using Java's UUID
    *     AUTO; -> if the database supports the identity it uses identity else if sequence is supported go for sequence
    * */


   /****
    * JOINS
    * A & B
    * INNER  - On join return the columns which are part of both A and B
    * OUTER
    *    LEFT OUTER A joins B -> return all in A and B plus the A with null values where B is not present
    *    RIGHT OUTER A joins B -> return all in A and B plus the B with null values where A is not present
    *
    * */

   /***
    * CASCADE type:
    *      ALL, -> all of the below
    *     PERSIST -> along with parent entity, persist child entity 2.
    *     MERGE, -> along with update of parent entity, update the child entity too
    *     REMOVE, -> if parent entity is removed, force remove the child entity
    *     REFRESH, -> if parent is referred, refer the child too
    *     DETACH; -> if parent is removed, remove the relation from child.
    *
    *
    * orphanRemoval -> remove the child if not referred by any of then entities
    *
    *
    * Difference between -> cascade.REMOVE and orphanRemoval
    * Example:
         Movie1-> cast1, cast2, cast3
         Movie2-> cast1,cast2
    Cascade.REMOVE will exclude cast1,2,3 from table irrespective of other references

    orphanRemoval=true, it will remove the cast-x if it is not part of any movie.


    *
    * */
}

