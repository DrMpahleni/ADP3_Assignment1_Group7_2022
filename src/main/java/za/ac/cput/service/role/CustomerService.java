package za.ac.cput.service.role;

import za.ac.cput.domain.role.Customer;
import za.ac.cput.service.IService;

import java.util.List;

public interface CustomerService extends IService<Customer, String> {

    List<Customer> getAll(String customerName);
    void deleteById(String customerName);

    Customer save(Customer customer);
}
