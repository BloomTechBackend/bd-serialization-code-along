package com.bloomtech.crudyrestaurants.repos;

import com.bloomtech.crudyrestaurants.models.Payment;
import com.bloomtech.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    List<Payment> findAll();
    Payment save(Payment payment);
}
