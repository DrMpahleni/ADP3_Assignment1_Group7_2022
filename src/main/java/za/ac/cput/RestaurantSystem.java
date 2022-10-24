package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestaurantSystem {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantSystem.class,args);
    }
}
