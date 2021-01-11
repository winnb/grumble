package com.grumble.mealratingservice.resources;

import com.grumble.mealratingservice.models.Rating;
import com.grumble.mealratingservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/food/{foodId}")
    public Rating getFoodRating(@PathVariable("foodId") String foodId) {
        return new Rating(foodId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;

    }

}