package com.gfg.jbdl52.repository;

import com.gfg.jbdl52.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    public Review save(Review review);

}
