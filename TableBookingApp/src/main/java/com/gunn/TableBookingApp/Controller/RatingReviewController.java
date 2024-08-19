package com.gunn.TableBookingApp.Controller;

import com.gunn.TableBookingApp.Model.RatingReview;
import com.gunn.TableBookingApp.Model.Restaurant;
import com.gunn.TableBookingApp.Model.User;
import com.gunn.TableBookingApp.Repository.RestaurantRepository;
import com.gunn.TableBookingApp.Repository.UserRepository;
import com.gunn.TableBookingApp.Service.RatingReviewService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingReviewController {

    private final RatingReviewService ratingReviewService;

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public RatingReviewController(RatingReviewService ratingReviewService, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.ratingReviewService = ratingReviewService;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    // Endpoint to add a new rating and review
    @PostMapping("/add")
    public RatingReview addRatingReview(@RequestBody RatingReview ratingReview) {
        User user = ratingReview.getUser();
        Restaurant restaurant = ratingReview.getRestaurant();

        user = userRepository.findById(user.getId()).orElse(null);
        restaurant = restaurantRepository.findById(restaurant.getRestaurantId().longValue()).orElse(null);

        if (user == null){
            throw new RuntimeException("User not available");
        }
        if (restaurant == null){
            throw new RuntimeException("Restaraunt not available");
        }

        ratingReview.setUser(user);
        ratingReview.setRestaurant(restaurant);

        return ratingReviewService.addRatingReview(ratingReview);
    }

    // Endpoint to get all ratings and reviews for a specific restaurant
    @GetMapping("/restaurant/{restaurantId}")
    public List<RatingReview> getRatingsForRestaurant(@PathVariable Long restaurantId) {
        return ratingReviewService.getRatingsForRestaurant(restaurantId);
    }

    // Endpoint to get all ratings and reviews given by a specific user
    @GetMapping("/user/{userId}")
    public List<RatingReview> getRatingsByUser(@PathVariable Long userId) {
        return ratingReviewService.getRatingsByUser(userId.intValue());
    }
}
