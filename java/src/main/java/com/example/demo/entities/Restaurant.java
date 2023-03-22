package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Comparable<Restaurant> {

    private int id;
    private List<Review> reviews;
    private String name;
    private double avgRating;
    private static int autoIncrement = 1;

    public Restaurant(String name)
    {
        this.id = autoIncrement;
        ++autoIncrement;
        this.name= name;
        this.reviews = new ArrayList<>();
        this.avgRating = 0;
    }

    public int getId()
    {
        return this.id;
    }

    public List<Review> getReviews()
    {
        return this.reviews;
    }

    public String getName()
    {
        return this.name;
    }

    public void addReview(Review review)
    {
        this.reviews.add(review);
    }

    public double getAverageRating()
    {
        double sum=0;
        for(Review review:reviews)
        {
            sum = sum + review.getRating();
        }

        this.avgRating = sum/this.reviews.size();
        return this.avgRating;
    }

    @Override
    public int compareTo(Restaurant restaurant)
    {
      return Double.compare(this.avgRating, restaurant.avgRating);
    }

}
