package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Review;
import java.util.Optional;

public interface IReviewRepository {

    public void saveReview(Review review);
    public Optional<Review> getReviewById(int id);
    public void removeReview(int id);
    public List<Review> getAllReviews();
    
}
