package com.gfg.jbdl52.service.resource;

import com.gfg.jbdl52.domain.Genre;
import com.gfg.jbdl52.domain.Movie;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    @NotBlank(message = "title cannot be blank")
    private String title;
    private Genre genre;
    private String releaseDate;
    public Movie getMovieFromRequest(){
        return Movie.builder().title(this.title).genre(genre).releaseDate(LocalDate.parse(releaseDate, DateTimeFormatter.ISO_DATE)).rating(0.0).build();
    }
}
/***
 * Builder pattern
 *
 *
 * class MovieBuilder{
 *
 *     MovieBuilder builder(){
 *         new Movie()
 *     }
 *
 *     MovieBuilder withOS(android){
 *         MovieBuilder.myphone.setOs(android);
 *         return myphone;
 *     }
 *
 *     Phone.withOs(android).withCamera(40MP).withScreenSize(6).withNFC(true).build();
 *
 * }
 *
 *
 * */