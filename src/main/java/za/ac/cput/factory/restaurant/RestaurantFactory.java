/*
    RestaurantFactory.java
    Factory for Restaurant
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.util.genericHelper;

public class RestaurantFactory {

    public static Restaurant createRestaurant(String name, String streetAddress, String suburb, String city, String province, int zipCode, int phone) {

        if (genericHelper.isNullOrEmpty(name) || genericHelper.isNullOrEmpty(streetAddress))
            return null;

        Restaurant restaurant = new Restaurant.Builder().setName(name).
                                setStreetAddress(streetAddress).
                                setSuburb(suburb).
                                setCity(city).
                                setProvince(province).
                                setZipCode(zipCode).
                                setPhone(phone).
                                build();

                                return restaurant;
    }
}
