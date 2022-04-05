/*
    RestaurantFactory.java
    Factory for Restaurant
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Restaurant;

public class RestaurantFactory {

    public static Restaurant createRestaurant(String name, String address, int phone) {

        Restaurant restaurant = new Restaurant.Builder().setName(name).
                                setAddress(address).
                                setPhone(phone).
                                build();

                                return restaurant;
    }
}
