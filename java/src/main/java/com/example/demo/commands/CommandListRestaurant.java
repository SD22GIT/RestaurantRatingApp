package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;


public class CommandListRestaurant implements ICommand
{
    private final RestaurantService restaurantService;

    public CommandListRestaurant(RestaurantService restaurantService)
    {
       this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens)
    {

       List<Restaurant> restaurants = restaurantService.listRestaurant();

       System.out.print("[");
       int i=0;
       for(i=0;i<restaurants.size()-1;++i)
       {
        System.out.print("Restaurant [id="+restaurants.get(i).getId()+"], ");
       }
       System.out.println("Restaurant [id="+restaurants.get(i).getId()+"]]");

    }
}
