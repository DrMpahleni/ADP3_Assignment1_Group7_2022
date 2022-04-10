package za.ac.cput.repository.order;

import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Order;
import za.ac.cput.repository.employee.employeeRepository;

import java.util.HashSet;
import java.util.Set;

public class OrderRepository implements IOrderRepository {

    private static OrderRepository repository = null;
    private Set<Order> orderDB = null;

    private OrderRepository() {

        orderDB = new HashSet<Order>();
    }

    public static OrderRepository getRepository() {
        if (repository == null) {
            repository = new OrderRepository();
        }
        return repository;
    }
    @Override
    public Order create(Order order) {

        return null;
    }

    @Override

    public Order read(String s) {

        return null;
    }

    @Override
    public Order update(Order order) {


        return null;
    }

    @Override
    public boolean delete(String s) {

        return false;
    }

    @Override
    public Set<Order> getAll() {
        return null;
    }
}
