package za.ac.cput.service.restaurant.impl;

/* OrderService.java
   This is Order service interface
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.repository.race.EmployeeRaceRepository;
import za.ac.cput.repository.restaurant.OrderRepository;
import za.ac.cput.service.restaurant.IOrderService;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {

        this.repository = repository;
    }

    public OrderServiceImpl() {

    }
    @Override
    public Order create(Order order) {

        return this.repository.save(order);
    }

    @Override
    public Optional<Order> read(Integer orderId) {
        return repository.findById(orderId);
    }

    @Override
    public Order update(Order order) {
        if (this.repository.existsById(order.getOrderId()))
            return this.repository.save(order);
        return null;
    }

    @Override
    public void delete(Order order) {
        this.repository.delete(order);

    }


    @Override
    public List<Order> getAll(Integer orderId) {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer orderId) {
        Optional<Order> order = read(orderId);
        if (order.isPresent()) delete(order.get());

    }
}

