package com.gfg.jbdl52.contorller;


import com.gfg.jbdl52.domain.Review;
import com.gfg.jbdl52.service.ReviewService;
import com.gfg.jbdl52.service.resource.ReviewRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value="/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody @Valid ReviewRequest reviewRequest){
        if(reviewService.addReview(reviewRequest.toReview())){
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<?> getReviewById(@RequestParam("id") Long id){
        Review review=reviewService.getReviewById(id);
        if(Objects.nonNull(review))
            return new ResponseEntity<>(review.toReviewResponse(),HttpStatus.OK);
        else
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
