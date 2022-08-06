/*
    IPaymentRepository.java
    IRepository for payment
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.restaurant.Payment;

import java.util.Set;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    public Set<Payment> getAll();
}
