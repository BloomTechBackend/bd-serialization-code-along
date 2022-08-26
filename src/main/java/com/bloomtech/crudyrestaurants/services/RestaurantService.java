package com.bloomtech.crudyrestaurants.services;

import com.bloomtech.crudyrestaurants.models.Restaurant;
import com.bloomtech.crudyrestaurants.repos.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> findRestaurants() {
        return restaurantRepository.findAll();
    }
}
