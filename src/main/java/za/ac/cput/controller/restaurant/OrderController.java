package za.ac.cput.controller.restaurant;

/*OrderController.java
this is order controller class
@Author:Lihle Njobe(218193882)
Due Date: 21 August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.service.restaurant.IOrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restuarant/order")
@Slf4j


public class OrderController {

    private IOrderService IorderService;

    @Autowired
    public OrderController(IOrderService IorderService) {
        this.IorderService = IorderService;
    }
    @PostMapping("Save")
    public ResponseEntity<Order> save(@Valid @RequestBody Order order) {
        log.info("Save request: {}", order);
        Order save = IorderService.create(order);
        return ResponseEntity.ok(save);
    }

    private Optional<Order> getById(Integer orderId) {
        return this.IorderService.read(orderId);
    }

    @GetMapping("/read{orderId}")
    public ResponseEntity<Order> read(@PathVariable Integer orderId) {
        log.info("Read request: {} raceId");
        Order order = getById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(order);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@Valid @RequestBody Order order) {
        log.info("Update request: {} ", order);
        Order updated = IorderService.update(order);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("delete/{orderId}")
    public ResponseEntity<Void> delete (@PathVariable Integer orderId){
        log.info("Delete Request: {} ", orderId);
        this.IorderService.deleteById(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(Integer orderId) {
        List<Order> orders = this.IorderService.getAll(orderId);
        return ResponseEntity.ok(orders);
    }

}


