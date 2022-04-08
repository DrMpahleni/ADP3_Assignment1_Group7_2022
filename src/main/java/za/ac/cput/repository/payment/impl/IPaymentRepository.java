/*
    IPaymentRepository.java
    IRepository for payment
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.payment.impl;

import za.ac.cput.entity.Payment;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IPaymentRepository extends IRepository<Payment, String> {

    public Set<Payment> getAll();
}
