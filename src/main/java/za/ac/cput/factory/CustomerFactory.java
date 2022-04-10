package za.ac.cput.factory;

import za.ac.cput.entity.Customer;
import za.ac.cput.util.genericHelper;

public class CustomerFactory {
    public static Customer createCustomer(int customerId, String customerName){
        String customerID = genericHelper.generateId();
        Customer customer = new Customer.Builder().setCustomerId(customerId).setCustomerName(customerName).build();
        return customer;
    }
}
