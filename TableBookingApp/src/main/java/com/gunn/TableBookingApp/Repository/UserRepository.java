package com.gunn.TableBookingApp.Repository;

import com.gunn.TableBookingApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom query to find a user by email
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email); //JSPL

    // Example method to check if an email exists (returns boolean)
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    // Example method to check if a phone number exists (returns boolean)
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.phone = :phone")
    boolean existsByPhone(@Param("phone") String phone);


}
