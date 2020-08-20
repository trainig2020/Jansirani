package com.jansi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jansi.model.CatalogItem;
import com.jansi.model.Movie;
import com.jansi.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		
		
		return new CatalogItem(movie.getName(), "Test Name", rating.getRating());
	}
	
	public CatalogItem getFallbackCatalogItem(Rating rating) {
		
		return new CatalogItem("Movie not found", "", rating.getRating());
		
	}

}
