package za.ac.cput.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.repository.IRepository;

import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    public Set<Restaurant> getAll();
}
