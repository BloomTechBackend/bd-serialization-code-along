package com.bloomtech.crudyrestaurants;

import com.bloomtech.crudyrestaurants.models.MenuItem;
import com.bloomtech.crudyrestaurants.models.Payment;
import com.bloomtech.crudyrestaurants.models.Restaurant;
import com.bloomtech.crudyrestaurants.repos.PaymentRepository;
import com.bloomtech.crudyrestaurants.repos.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class SeedData
    implements CommandLineRunner
{
    private PaymentRepository payrepos;

    private RestaurantRepository restaurantrepos;

    public SeedData(
        PaymentRepository payrepos,
        RestaurantRepository restaurantrepos)
    {
        this.payrepos = payrepos;
        this.restaurantrepos = restaurantrepos;
    }

    @Override
    public void run(String[] args) throws
                                   Exception
    {
        Payment payType1 = new Payment("Credit Card");
        Payment payType2 = new Payment("Cash");
        Payment payType3 = new Payment("Mobile Pay");

        payrepos.save(payType1);
        payrepos.save(payType2);
        payrepos.save(payType3);

        // Restaurant String name, String address, String city, String state, String telephone
        String rest1Name = "Apple";
        Restaurant r1 = new Restaurant(rest1Name,
            "123 Main Street",
            "City", "ST", "555-555-1234", 100);
        r1.getPayments().add(payType1);
        r1.getPayments().add(payType2);
        r1.getPayments().add(payType3);
        r1.getMenuItems()
            .add(new MenuItem("Mac and Cheese", 6.95, r1));
        r1.getMenuItems()
            .add(new MenuItem("Lasagna", 8.50, r1));
        r1.getMenuItems()
            .add(new MenuItem("Meatloaf", 7.77, r1));
        r1.getMenuItems()
            .add(new MenuItem("Tacos", 8.49, r1));
        r1.getMenuItems()
            .add(new MenuItem("Chef Salad", 12.50, r1));

        restaurantrepos.save(r1);

        String rest2Name = "Eagle Cafe";
        Restaurant r2 = new Restaurant(rest2Name,
            "321 Uptown Drive",
            "Town", "ST", "555-555-5555", 50);
        r2.getPayments().add(payType2);
        r2.getMenuItems()
            .add(new MenuItem("Tacos", 10.49, r2));
        r2.getMenuItems()
            .add(new MenuItem("Barbacoa", 12.75, r2));

        restaurantrepos.save(r2);

        String rest3Name = "Number 1 Eats";
        Restaurant r3 = new Restaurant(rest3Name,
            "565 Side Avenue",
            "Village", "ST", "555-123-1555", 25);
        r3.getPayments().add(payType1);
        r3.getPayments().add(payType3);
        r3.getMenuItems()
            .add(new MenuItem("Pizza", 15.15, r3));

        restaurantrepos.save(r3);
    }
}
