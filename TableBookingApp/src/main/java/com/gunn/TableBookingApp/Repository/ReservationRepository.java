package com.gunn.TableBookingApp.Repository;

import com.gunn.TableBookingApp.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
