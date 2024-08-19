package com.gunn.TableBookingApp.Service;

import com.gunn.TableBookingApp.Model.RestaurantTable;
import com.gunn.TableBookingApp.Repository.RestaurantTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepo restaurantTableRepo;

    @Autowired
    public RestaurantTableService(RestaurantTableRepo restaurantTableRepo) {
        this.restaurantTableRepo = restaurantTableRepo;
    }

    public RestaurantTable tableBooking(RestaurantTable restaurantTable) {
        return restaurantTableRepo.save(restaurantTable);
    }
}
