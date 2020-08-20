package com.jansi.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jansi.model.CatalogItem;
import com.jansi.model.Movie;
import com.jansi.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieResource {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId,
				UserRating.class);
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
					Movie.class);

			return new CatalogItem(movie.getName(), "Nice Movie", rating.getRating());
		}).collect(Collectors.toList());

	}

}
