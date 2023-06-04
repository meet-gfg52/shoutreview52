package com.gfg.jbdl52.domain;

import com.gfg.jbdl52.service.resource.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;


/**
 * Assossciation:
 *
 * 1. Unidirectional
 * -> if table B's can be fetched from A, but not true to fetch A's data from B.
 * 2. BiDirectional
 * -> From A, B's data can be fetched and From B, A's data can be fetched.
 *
 * Relationships:
 *
 * 1. One to One: for one entry in A, there is exactly one entry in B
 * 2. One to Many: for one entry in A, there are multiple entries in B
 * 3. Many to one: for multiple entries in A, there is single entry in B
 * 4. Many to Many: for multiple entries in A,there are multiple entries in B
 * */

@Data
@AllArgsConstructor
@Entity
@Table(name="reviews")
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double rating;

    private String comment;

    /**
     * multiple reviews can be there for one movie
     * */
    @ManyToOne
    @JoinColumn(name = "movie_id",nullable = false)
    private Movie movie;

    public ReviewResponse toReviewResponse(){
        return ReviewResponse.builder().comment(this.comment).rating(this.rating).build();
    }

}
