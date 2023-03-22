package com.example.demo.commands;

import java.util.LinkedList;
import java.util.List;
import com.example.demo.services.ReviewService;
import com.example.demo.entities.Review;


public class CommandAddReview implements ICommand
{
    private final ReviewService reviewService;

    public CommandAddReview(ReviewService reviewService)
    {
       this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
        int rating=Integer.parseInt(tokens.get(1));
        int userId=Integer.parseInt(tokens.get(2));
        int restaurantId=Integer.parseInt(tokens.get(3));
        List<String> dishNames = new LinkedList<>();
        for(int i=4;i<tokens.size()-1;++i)
        {
            dishNames.add(tokens.get(i));
        }
        String description = tokens.get(tokens.size()-1);

       Review review = reviewService.addReview(rating, userId, restaurantId, dishNames, description);

       System.out.println("Review [id="+review.getId()+"] added successfully for Restaurant [id="+restaurantId+"] by User [id="+userId+"]!");
    }
}
