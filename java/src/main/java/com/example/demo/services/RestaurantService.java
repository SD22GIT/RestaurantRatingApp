package com.example.demo.services;

import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class RestaurantService {

    private final IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant registerRestaurant(String name)
    {
        Restaurant restaurant = new Restaurant(name);
        restaurantRepository.saveRestaurant(restaurant);
        return restaurant;
    }

    
    public List<String> describeRestaurant(int restaurantId)
    {
      Restaurant restaurant = restaurantRepository.getRestaurant(restaurantId).get();

      List<String> descriptions = new LinkedList<>();

      int id = restaurant.getId();
      String name = restaurant.getName();
      double avgRating = restaurant.getAverageRating();

      descriptions.add(Integer.toString(id));
      descriptions.add(name);
      descriptions.add(Double.toString(avgRating));

      return descriptions;
    }

    public List<Restaurant> listRestaurant()
    {
        List<Restaurant> restaurants = restaurantRepository.getAllRestaurants();
        Collections.sort(restaurants,Collections.reverseOrder());

        return restaurants;
    }

}
