package za.ac.cput.service.restaurant.impl;
/*
    RestaurantServiceImpl.java
    Implementation for Restaurant Service
    Student: Ian Louw
    Student Number: 216250773
 */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.repository.restaurant.RestaurantRepository;
import za.ac.cput.service.restaurant.RestaurantService;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    public RestaurantServiceImpl() {}

    public Restaurant create (Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Optional<Restaurant> read (String name) {
        return repository.findById(name);
    }

    public Restaurant update (Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public void delete (Restaurant restaurant) {
        repository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAll(String name){
        return repository.findAll();
    }

    public void deleteById(String name) {
        Optional<Restaurant> restaurant = read(name);
        if (restaurant.isPresent()) delete(restaurant.get());
    }
}
