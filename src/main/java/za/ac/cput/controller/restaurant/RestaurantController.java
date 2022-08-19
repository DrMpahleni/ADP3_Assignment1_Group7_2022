package za.ac.cput.controller.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.service.restaurant.RestaurantService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/")
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired public RestaurantController (RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("save")
    public ResponseEntity<Restaurant> save (@Valid @RequestBody Restaurant restaurant) {
        log.info("Save request: {}", restaurant);
        Restaurant save = restaurantService.create(restaurant);
        return ResponseEntity.ok(save);
    }

    private Optional<Restaurant> getById(String name) {
        return this.restaurantService.read(name);
    }

    @GetMapping("read/{name}")
    public ResponseEntity<Restaurant> read (@PathVariable String name) {
        log.info("Read request: {}", name);
        Restaurant employee = getById(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("update")
    public ResponseEntity<Restaurant> update (@Valid @RequestBody Restaurant restaurant) {
        log.info("Update request: {}", restaurant);
        Restaurant updated = restaurantService.update(restaurant);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        log.info("Read request: {}", name);
        this.restaurantService.deleteById(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Restaurant>> getAll(String name) {
        List<Restaurant> employees = this.restaurantService.getAll(name);
        return ResponseEntity.ok(employees);
    }
}
