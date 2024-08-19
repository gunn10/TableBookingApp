package com.gunn.TableBookingApp.Controller;

import com.gunn.TableBookingApp.Model.Restaurant;
import com.gunn.TableBookingApp.Model.RestaurantTable;
import com.gunn.TableBookingApp.Service.RestaurantService;
import com.gunn.TableBookingApp.Service.RestaurantTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantTableController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final RestaurantTableService restaurantTableService;
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantTableController(RestaurantTableService restaurantTableService, RestaurantService restaurantService) {
        this.restaurantTableService = restaurantTableService;
        this.restaurantService =  restaurantService;
    }

    @PostMapping("tablebooking/{id}")
    public RestaurantTable tableBooking(@RequestBody RestaurantTable restaurantTable, @PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if(restaurant==null){
           throw new RuntimeException("Restaurant Not found!");
       }
       restaurantTable.setRestaurant(restaurant);

        return restaurantTableService.tableBooking(restaurantTable);

    }
}
