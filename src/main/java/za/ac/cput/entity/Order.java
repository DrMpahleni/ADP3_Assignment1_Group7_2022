package za.ac.cput.entity;
/*Order.java
Entity for Order
@author Lihle Njobe 218193882
Due date: 10 April 2022
*/

public class Order {
   private int orderId;
   private String orderItem;
   private String date;
   private double amount;

    private Order(Builder builder) { 
        this.orderId = builder.orderId;
        this.orderItem = builder.orderItem;
        this.date = builder.date;
        this.amount = builder.amount;

    }

    public Order(Order order) {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId" + orderId +
                "orderItem" + orderItem +
                "date" + date +
                "amount" +
                '}';
    }
    public int getOrderId() {
        return orderId;
    }
        public String getOrderItem(){
            return orderItem;

}
    public String getDate(){
        return date;
    }
    public double getAmount() {
        return amount;
    }
    public static class Builder{
        private int orderId;
        private String orderItem;
        private String date;
        private double amount;
    }
    public Order setOrderId(int orderId) {
        this.orderId = orderId;

        return this;
    } 
    public Order setOrderItem(String orderItem) {
        this.orderItem = orderItem;

        return this;
    }
    public Order setDate(String date) {
        this.date = date;
        
        return this;
    }
    
    public Order setAmount(double amount) {
        this.amount = amount;
        
        return this;
    }

    public Order build() {
        return new Order(this);
    }
    public Order copy(Order order) {
        this.orderId = order.orderId;
        this.orderItem = order.orderItem;
        this.date = order.date;
        this.amount = order.amount;

        return this;

    }
}

