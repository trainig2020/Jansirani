package com.jansi.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.jansi.model.CatalogItem;
import com.jansi.model.Movie;
import com.jansi.model.UserRating;
import com.jansi.service.MovieInfo;
import com.jansi.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRatings;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating ratings = userRatings.getUserRating(userId);
		return ratings.getUserRating().stream().map(rating -> 
			movieInfo.getCatalogItem(rating))
		.collect(Collectors.toList());

	}

}
