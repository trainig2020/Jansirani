package com.jansi.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jansi.model.Rating;
import com.jansi.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRatings(@PathVariable("movieId") String movieId) {
		return new Rating(movieId,4);
	}

	

	@RequestMapping("/users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("Mr.perfect", 4), 
				new Rating("Abc", 3));
		
		UserRating userRating  = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

	
	
	
}
