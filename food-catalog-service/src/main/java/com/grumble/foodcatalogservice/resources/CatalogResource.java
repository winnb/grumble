package com.grumble.foodcatalogservice.resources;

import com.grumble.foodcatalogservice.models.CatalogItem;
import com.grumble.foodcatalogservice.models.Rating;
import com.grumble.foodcatalogservice.models.UserRating;
import com.grumble.foodcatalogservice.models.Food;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratings/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Food food = restTemplate.getForObject("http://localhost:8082/food/" + rating.getFoodId(), Food.class);
                    return new CatalogItem(food.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());

    }
}

/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/