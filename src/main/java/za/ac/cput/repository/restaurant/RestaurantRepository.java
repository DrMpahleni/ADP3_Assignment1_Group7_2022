package za.ac.cput.repository.restaurant.impl;

import za.ac.cput.entity.Restaurant;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRestaurantRepository extends IRepository<Restaurant, String> {

    public Set<Restaurant> getAll();
}
