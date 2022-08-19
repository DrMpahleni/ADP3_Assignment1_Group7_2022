/*
Customer.java
This is the customer entity class
Author: Felecia Zweni(218330189)
Date: 10 April 2022
 */

package za.ac.cput.domain.role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Customer")

public class Customer implements Serializable {
    @Id
    private String customerId;
    private String customerName;

    public Customer(){

    }

    private Customer(Customer.Builder builder){

        this.customerId = builder.customerId;
        this.customerName = builder.customerName;

    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {

        return customerName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setPositionId(String customerName) {
        this.customerName = customerName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public static class Builder{

        private String customerId;
        private String customerName;

        public Customer.Builder setCustomerId(String customerId){
            this.customerId = customerId;

            return this;
        }

        public Customer.Builder setCustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }

        public Customer.Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.customerName = customer.customerName;

            return this;
        }
    }
}
