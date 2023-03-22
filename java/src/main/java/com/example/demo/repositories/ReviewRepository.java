package com.example.demo.repositories;

import java.util.HashMap;
import com.example.demo.entities.Review;
import java.util.Optional;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;


public class ReviewRepository implements IReviewRepository {

    private static HashMap<Integer,Review> repository = new HashMap<>();

    @Override
    public void saveReview(Review review)
    {
     repository.put(review.getId(), review);
    }


    public Optional<Review> getReviewById(int id)
    {
      Optional<Review> review = Optional.ofNullable(repository.get(id));
      return review;
    }


    public void removeReview(int id)
    {
         repository.remove(id);
    }

    public List<Review> getAllReviews()
    {
        List<Review> reviews= new LinkedList<>();

        for(Map.Entry<Integer,Review> entry:repository.entrySet())
        {
            reviews.add(entry.getValue());
        }
       return reviews;
    }
    
}
