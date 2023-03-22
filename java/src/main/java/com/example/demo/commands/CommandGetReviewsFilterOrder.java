package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;
import com.example.demo.entities.Review;


public class CommandGetReviewsFilterOrder implements ICommand
{
    private final ReviewService reviewService;

    public CommandGetReviewsFilterOrder(ReviewService reviewService)
    {
       this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        int restaurantId=Integer.parseInt(tokens.get(1));
        int low = Integer.parseInt(tokens.get(2));
        int high = Integer.parseInt(tokens.get(3));
        String order = tokens.get(4);

       List<Review> reviews = reviewService.getFilteredReviews(restaurantId, low, high, order);

       System.out.print("[");
       int i=0;
       for(i=0;i<reviews.size()-1;++i)
       {
        System.out.print("Review [id="+reviews.get(i).getId()+"], ");
       }
       System.out.println("Review [id="+reviews.get(i).getId()+"]]");

    }
}

