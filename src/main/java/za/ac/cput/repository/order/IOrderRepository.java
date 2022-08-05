package za.ac.cput.repository.order;

import za.ac.cput.entity.Order;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IOrderRepository extends IRepository<Order, String> {
    public Set<Order> getAll();
}
