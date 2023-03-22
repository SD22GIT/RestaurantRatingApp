package com.example.demo.repositories;

import com.example.demo.entities.Restaurant;
import java.util.List;
import java.util.Optional;

public interface IRestaurantRepository {

    public void saveRestaurant(Restaurant restaurant);
    public Optional<Restaurant> getRestaurant(int id);
    public void removeRestaurant(int id);
    public List<Restaurant> getAllRestaurants();
    
}
