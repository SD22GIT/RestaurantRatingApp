package com.example.demo.entities;

import java.util.List;
import java.util.ArrayList;

public class User {

    private int id;
    private List<Restaurant> restaurants;
    private String name;
    private static int autoIncrement=1;

    public User(String name)
    {
       this.id = autoIncrement;
       ++autoIncrement;
       this.name=name;
       this.restaurants = new ArrayList<>();
    }

    public int getId()
    {
        return this.id;
    }

    public List<Restaurant> getRestaurants()
    {
        return this.restaurants;
    }
    
    public String getName()
    {
        return this.name;
    }

    public void addRestaurant(Restaurant restaurant)
    {
        this.restaurants.add(restaurant);
    }

}
