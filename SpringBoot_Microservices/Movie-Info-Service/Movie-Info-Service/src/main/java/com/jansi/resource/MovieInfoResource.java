package com.jansi.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jansi.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie("1", "Mr.Perfect");
	}

}
