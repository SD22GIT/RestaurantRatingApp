package com.example.demo.services;

import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IUserRespository;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class ReviewService
{
    private final IReviewRepository reviewRepository;
    private final IUserRespository userRespository;
    private final IRestaurantRepository restaurantRespository;

    public ReviewService(IReviewRepository reviewRepository,IUserRespository userRespository,IRestaurantRepository restaurantRespository)
    {
        this.reviewRepository = reviewRepository;
        this.userRespository = userRespository;
        this.restaurantRespository = restaurantRespository;
    }

    public Review addRating(int rating,int userId,int restaurantId)
    {
         User user = userRespository.getUserById(userId).get();
        Restaurant restaurant = restaurantRespository.getRestaurant(restaurantId).get();
         Review review = new Review(rating);
         reviewRepository.saveReview(review);
          restaurant.addReview(review);
         user.addRestaurant(restaurant);
         return review;
    }

    public Review addReview(int rating,int userId,int restaurantId,List<String> dishNames,String description)
    {
        User user = userRespository.getUserById(userId).get();
        Restaurant restaurant = restaurantRespository.getRestaurant(restaurantId).get();
        Review review = new Review(rating, dishNames, description);
        reviewRepository.saveReview(review);
        restaurant.addReview(review);
        user.addRestaurant(restaurant);
        return review;
    }

    public List<Review> getReviews(int restaurantId,String order)
    {
      Restaurant restaurant = restaurantRespository.getRestaurant(restaurantId).get();

      List<Review> reviews = restaurant.getReviews();

      if(order.equalsIgnoreCase("RATING_ASC"))
      {
        Collections.sort(reviews);
      }
      else
      {
        Collections.sort(reviews, Collections.reverseOrder());
      }

      return reviews;
    }

    public List<Review> getFilteredReviews(int restaurantId,int low,int high,String order)
    {
        Restaurant restaurant = restaurantRespository.getRestaurant(restaurantId).get();

        List<Review> actualReviews = restaurant.getReviews();
        List<Review> cloneReviews = new LinkedList<>();

        for(Review review:actualReviews)
        {
          cloneReviews.add(review);
        }

        ListIterator<Review> iterator =  cloneReviews.listIterator();

        Review review = null;
        while(iterator.hasNext())
        {
          review = iterator.next();
          if(review.getRating()<low || review.getRating()>high)
          {
            iterator.remove();
          }
        }

    if(order.equalsIgnoreCase("RATING_ASC"))
      {
        Collections.sort(cloneReviews);
      }
      else
      {
        Collections.sort(cloneReviews, Collections.reverseOrder());
      }

    return  cloneReviews;
}


}