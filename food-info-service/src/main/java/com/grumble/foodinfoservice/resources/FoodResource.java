package com.grumble.foodinfoservice.resources;

import com.grumble.foodinfoservice.models.Food;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodResource {

    @RequestMapping("/{foodId}")
    public Food getFoodInfo(@PathVariable("foodId") String foodId) {
        return new Food(foodId, "Name for ID " + foodId);

    }

}