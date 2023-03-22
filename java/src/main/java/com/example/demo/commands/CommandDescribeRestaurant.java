package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;


public class CommandDescribeRestaurant implements ICommand
{
    private final RestaurantService restaurantService;

    public CommandDescribeRestaurant(RestaurantService restaurantService)
    {
       this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        int restaurantId=Integer.parseInt(tokens.get(1));

       List<String> desc = restaurantService.describeRestaurant(restaurantId);

       System.out.println("Restaurant [id="+desc.get(0)+", name="+desc.get(1)+", rating="+desc.get(2)+"]");

    }
}


