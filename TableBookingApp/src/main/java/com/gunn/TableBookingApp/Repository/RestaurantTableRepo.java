package com.gunn.TableBookingApp.Repository;

import com.gunn.TableBookingApp.Model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepo extends JpaRepository<RestaurantTable,Long> {
}
