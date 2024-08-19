
package com.gunn.TableBookingApp.Repository;

import com.gunn.TableBookingApp.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}


