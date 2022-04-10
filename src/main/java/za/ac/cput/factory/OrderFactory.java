package za.ac.cput.factory;

/*OrderFactory.java
Factory for Order
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/

import za.ac.cput.entity.Order;
import za.ac.cput.util.genericHelper;

public class OrderFactory {

    public static Order createOrder(String orderId, String orderItem, String date, double amount){

        String orderID = genericHelper.generateId();
        Order order = new Order.Builder().setOrderId(orderID).
                setOrderItem(orderItem).
                setDate(date).
                setAmount(amount).
                build();

        return order;
    }
}

