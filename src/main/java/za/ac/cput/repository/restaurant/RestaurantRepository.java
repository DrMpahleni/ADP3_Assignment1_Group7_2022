package za.ac.cput.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.restaurant.Restaurant;

import java.util.Set;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    public Set<Restaurant> getAll();
}
