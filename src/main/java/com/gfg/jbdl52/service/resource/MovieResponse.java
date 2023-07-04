package com.gfg.jbdl52.service.resource;

import com.gfg.jbdl52.domain.Genre;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private String title;
    private Genre genre;
    private Double rating;
    private String releaseDate;

}
