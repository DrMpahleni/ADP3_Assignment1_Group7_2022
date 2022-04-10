/*
    paymentFactory.java
    Factory for payment
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Payment;
import za.ac.cput.util.genericHelper;

public class paymentFactory {

    public static Payment createPayment(String paymentId, String customerId, String orderId, String paymentType, int amount) {

        if (genericHelper.isNullOrEmpty(orderId) || genericHelper.isNullOrEmpty(paymentId))
            return null;

        String paymentID = genericHelper.generateId();

        Payment payment = new Payment.Builder().setPaymentId(paymentID).
                                                setCustomerId(customerId).
                                                setOrderId(orderId).
                                                setPaymentType(paymentType).
                                                setAmount(amount).
                                                build();

        return payment;
    }
}
