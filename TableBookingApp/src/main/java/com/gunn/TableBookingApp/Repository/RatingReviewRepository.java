package com.gunn.TableBookingApp.Repository;

import com.gunn.TableBookingApp.Model.RatingReview;
import com.gunn.TableBookingApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> {

    // Find all ratings for a specific restaurant
    List<RatingReview> findByRestaurantRestaurantId(Long restaurantId);

    // Find all ratings given by a specific user
    List<RatingReview> findByUser(User user_id);
}
