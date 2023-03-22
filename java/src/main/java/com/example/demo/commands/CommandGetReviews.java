package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;
import com.example.demo.entities.Review;


public class CommandGetReviews implements ICommand
{
    private final ReviewService reviewService;

    public CommandGetReviews(ReviewService reviewService)
    {
       this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        int restaurantId=Integer.parseInt(tokens.get(1));
        String order = tokens.get(2);

       List<Review> reviews = reviewService.getReviews(restaurantId, order);

       System.out.print("[");
       int i=0;
       for(i=0;i<reviews.size()-1;++i)
       {
        System.out.print("Review [id="+reviews.get(i).getId()+"], ");
       }
       System.out.println("Review [id="+reviews.get(i).getId()+"]]");

    }
}

