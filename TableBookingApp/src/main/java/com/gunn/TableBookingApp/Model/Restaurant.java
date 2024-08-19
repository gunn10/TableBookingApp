package com.gunn.TableBookingApp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    @NotNull
    @Size(min = 1, max = 100)
    private String restaurantName;

    @NotNull
    private String restaurantLocation;

    @NotNull
    private Integer restaurantTotalTableCount;

    private String restaurantDescription;

    @NotNull
    private String restaurantCity;

   // @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<RestaurantTable> tables;

    // Getters and Setters
    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public Integer getRestaurantTotalTableCount() {
        return restaurantTotalTableCount;
    }

    public void setRestaurantTotalTableCount(Integer restaurantTotalTableCount) {
        this.restaurantTotalTableCount = restaurantTotalTableCount;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    public String getRestaurantCity() {
        return restaurantCity;
    }

    public void setRestaurantCity(String restaurantCity) {
        this.restaurantCity = restaurantCity;
    }

//    public List<RestaurantTable> getTables() {
//        return tables;
//    }

//    public void setTables(List<RestaurantTable> tables) {
//        this.tables = tables;
//    }
}
