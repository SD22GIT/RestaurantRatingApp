package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;
import com.example.demo.entities.Review;


public class CommandAddRating implements ICommand
{
    private final ReviewService reviewService;

    public CommandAddRating(ReviewService reviewService)
    {
       this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        int rating=Integer.parseInt(tokens.get(1));
        int userId=Integer.parseInt(tokens.get(2));
        int restaurantId=Integer.parseInt(tokens.get(3));
       Review review  = reviewService.addRating(rating,userId,restaurantId );
       System.out.println("Review [id="+review.getId()+"] added successfully for Restaurant [id="+restaurantId+"] by User [id="+userId+"]!");
    }
}
