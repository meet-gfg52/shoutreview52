package com.gfg.jbdl52.service.resource;


import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.domain.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRequest {

    private String comment;
    @Min(value=0,message = "rating should be positive")
    @Max(value=5,message="rating should not be more than 5")
    private Double rating;
    private Long movieId;

    public Review toReview(){
        return Review.builder().comment(this.comment).rating(this.rating).movie( Movie.builder().id(this.movieId).build()).build();
    }

}
