package com.gfg.jbdl52.service;

import com.gfg.jbdl52.domain.Movie;
import com.gfg.jbdl52.domain.Review;
import com.gfg.jbdl52.repository.MovieRepository;
import com.gfg.jbdl52.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    Logger logger= LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    public boolean addReview(Review review){
        try {
            Movie movie=movieRepository.findById(review.getMovie().getId()).orElseThrow(() ->new RuntimeException("movie does not exists"));
            review.setMovie(movie);
            reviewRepository.save(review);
            return true;
        }catch(Exception ex){
            logger.error("Exception while saving review");
        }
        return false;
    }

    public Review getReviewById(Long id){
        return reviewRepository.findById(id).orElse(null);

    }
}
