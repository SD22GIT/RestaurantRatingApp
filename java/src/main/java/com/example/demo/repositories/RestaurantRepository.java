package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository{

    private static HashMap<Integer,Restaurant> repository = new HashMap<>();

    @Override
    public void saveRestaurant(Restaurant restaurant)
    {
        repository.put(restaurant.getId(),restaurant);
    }

    @Override
    public Optional<Restaurant> getRestaurant(int id)
    {
      Optional<Restaurant> restaurant = Optional.ofNullable(repository.get(id));
       return restaurant;
    }

    @Override
    public void removeRestaurant(int id)
    {
        repository.remove(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants()
    {
         List<Restaurant> restaurants = new LinkedList<>();

        for(Map.Entry<Integer,Restaurant> entry:repository.entrySet())
        {
            restaurants.add(entry.getValue());
        }
         return restaurants;
    }
    
}
