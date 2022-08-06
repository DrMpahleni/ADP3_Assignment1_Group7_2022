/*
    paymentFactory.java
    Factory for payment
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.util.genericHelper;

public class paymentFactory {

    public static Payment createPayment( String customerId, String orderId, String paymentType, int amount) {

        if (genericHelper.isNullOrEmpty(orderId) || genericHelper.isNullOrEmpty(customerId))
            return null;

        String paymentId = genericHelper.generateId();

        Payment payment = new Payment.Builder().setPaymentId(paymentId).
                                                setCustomerId(customerId).
                                                setOrderId(orderId).
                                                setPaymentType(paymentType).
                                                setAmount(amount).
                                                build();

        return payment;
    }
}
