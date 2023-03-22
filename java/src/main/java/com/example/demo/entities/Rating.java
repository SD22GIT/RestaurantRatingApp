package com.example.demo.entities;

public class Rating
{
    private int rating;
 
    public Rating(int rating)
    {
        checkRating(rating);
        this.rating = rating;
    }

    private void checkRating(int rating)
    {
        if(rating<1 || rating>5)
        {
            throw new RuntimeException("Incorrect Rating");
        }
    }

    public int getRatingValue()
    {
        return this.rating;
    }
}
    
