package com.gunn.TableBookingApp.Service;

import com.gunn.TableBookingApp.Model.RatingReview;
import com.gunn.TableBookingApp.Model.User;
import com.gunn.TableBookingApp.Repository.RatingReviewRepository;
import com.gunn.TableBookingApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingReviewService {

    private final RatingReviewRepository ratingReviewRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingReviewService(RatingReviewRepository ratingReviewRepository, UserRepository userRepository) {
        this.ratingReviewRepository = ratingReviewRepository;
        this.userRepository=userRepository;
    }

    // Method to add a new rating and review
    public RatingReview addRatingReview(RatingReview ratingReview) {
        return ratingReviewRepository.save(ratingReview);
    }

    // Method to get all ratings and reviews for a specific restaurant
    public List<RatingReview> getRatingsForRestaurant(Long restaurantId) {
        return ratingReviewRepository.findByRestaurantRestaurantId(restaurantId);
    }

    // Method to get all ratings and reviews given by a specific user
    public List<RatingReview> getRatingsByUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        return ratingReviewRepository.findByUser(user);
    }
}
