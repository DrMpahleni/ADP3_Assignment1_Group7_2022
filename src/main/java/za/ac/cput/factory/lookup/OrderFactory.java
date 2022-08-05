package za.ac.cput.factory.lookup;
/* Order.java
   This is Order factory class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.lookup.Order;
import za.ac.cput.util.genericHelper;

public class OrderFactory {

    public static Order createOrder(String orderItem, String date, int amount) {
        if(genericHelper.isNullOrEmpty(orderItem) || genericHelper.isNullOrEmpty(date))
            return null;

        int orderId = genericHelper.generateIntId();
        Order order = new Order.Builder().setOrderId(orderId).
                setOrderItem(orderItem).
                setDate(date).
                setAmount(amount).
                build();

        return order;

    }
}
