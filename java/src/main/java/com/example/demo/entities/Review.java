package com.example.demo.entities;

import java.util.List;

public class Review implements Comparable<Review>{

    private int id;
    private List<String> dishes;
    private Rating rating;
    private String description;
    private static int autoIncrement=1;

    public Review(int rating)
    {
        this.id = autoIncrement;
        ++autoIncrement;
        this.rating = new Rating(rating);
    }

    public Review(int rating,List<String> dishNames,String description)
    {
        this.rating = new Rating(rating);
        this.dishes.addAll(dishNames);
        this.description = description;
    }

    public int getId()
    {
        return this.id;
    }

    public void addDish(String dishName)
    {
        dishes.add(dishName);
    }

    public List<String> getDishes()
    {
        return this.dishes;
    }

    public int getRating()
    {
        return this.rating.getRatingValue();
    }

    public String getDescription()
    {
        return this.description;
    }

    @Override
    public int compareTo(Review object)
    {
       return Integer.compare(this.rating.getRatingValue(), object.getRating());
    }
}
