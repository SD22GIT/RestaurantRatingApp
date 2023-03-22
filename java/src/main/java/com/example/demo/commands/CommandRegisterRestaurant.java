package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;
import com.example.demo.entities.Restaurant;


public class CommandRegisterRestaurant implements ICommand
{
    private final RestaurantService restaurantService;

    public CommandRegisterRestaurant(RestaurantService restaurantService)
    {
       this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        Restaurant restaurant  = restaurantService.registerRestaurant(tokens.get(1));

       System.out.println("Restaurant [id="+restaurant.getId()+"]");
    }
}