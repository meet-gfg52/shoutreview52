package com.gfg.jbdl52.service.resource;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private String comment;
    private Double rating;
}
