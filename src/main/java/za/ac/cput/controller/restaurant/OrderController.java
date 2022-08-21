package za.ac.cput.controller.restaurant;

/*OrderController.java
this is order controller class
@Author:Lihle Njobe(218193882)
Due Date: 21 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.factory.restaurant.OrderFactory;
import za.ac.cput.service.restaurant.OrderService;

import java.util.Optional;
import java.util.Set;

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
     Order newOrder = OrderFactory.createOrder(order.getOrderItem());
     return orderService.create(newOrder);


    }
    @GetMapping("/read{id}")
    public Optional<Order> read(@PathVariable Integer orderId ) {
        return orderService.read(orderId);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }
    @DeleteMapping("delete/{raceId}")
    public void delete(@PathVariable String race){
        return;
    }

    @GetMapping("/getAll")
    public Set<Order> getAll() {
        return orderService.getAll();
    }

}

