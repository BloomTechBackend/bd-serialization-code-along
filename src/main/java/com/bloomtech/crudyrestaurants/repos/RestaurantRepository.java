package com.bloomtech.crudyrestaurants.repos;

import com.bloomtech.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();
    Restaurant save(Restaurant restaurant);
}
