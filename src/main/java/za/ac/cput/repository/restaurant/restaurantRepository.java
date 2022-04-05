/*
    RestaurantRepository.java
    Repository for Restaurant
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.repository.restaurant;

import za.ac.cput.entity.Restaurant;
import za.ac.cput.repository.restaurant.impl.IRestaurantRepository;

import java.util.HashSet;
import java.util.Set;

public class restaurantRepository implements IRestaurantRepository {

    private static restaurantRepository repository = null;
    private Set<Restaurant> restaurantDB;

    private restaurantRepository() {
        restaurantDB = new HashSet<Restaurant>();
    }

    public static restaurantRepository getRepository() {
        if (repository == null) {
            repository = new restaurantRepository();
        }
        return repository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        this.restaurantDB.add(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant read(String name) {
        Restaurant restaurant = restaurantDB.stream()
                .filter(r -> r.getName().equals(name))
                .findAny()
                .orElse(null);
        return restaurant;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        Restaurant oldRestaurant = read(restaurant.getName());
            if (oldRestaurant != null){
                restaurantDB.remove(oldRestaurant);
                restaurantDB.add(restaurant);
                return restaurant;
            }
            return null;
    }

    @Override
    public boolean delete(String name) {
        Restaurant restaurantToDelete = read(name);
            if (restaurantToDelete == null)
                return false;
            restaurantDB.remove(restaurantToDelete);
            return true;
    }

    public Set<Restaurant> getAll() {
        return restaurantDB;
    }
}
