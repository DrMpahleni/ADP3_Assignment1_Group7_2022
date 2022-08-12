package za.ac.cput.repository.customer;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.role.Customer;
import za.ac.cput.factory.role.CustomerFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class customerRepositoryTest {

    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static Customer customer = CustomerFactory.createCustomer(2121,  "John");

    @Test
    void create() {
        Customer created = repository.create(customer);
        assertEquals(customer.getCustomerId(),created.getCustomerId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Customer read = repository.read(customer.getCustomerId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Customer updated = new Customer.Builder().copy(customer).setCustomerName("Michael").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(customer.getCustomerId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}
