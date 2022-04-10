package za.ac.cput.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void Order() {
        Order order = OrderFactory.createOrder("138", "Umngqusho", "20/21/2022",25.00);
        System.out.println(order);
    }
    @Test
    public void testEquality() {
        Order.Builder type0 = new Order.Builder().setOrderId("180").setOrderItem("Cheese Burger").setAmount(80);
        Order.Builder type1 = new Order.Builder().setOrderId("180").setOrderItem("Cheese Burger").setAmount(80);
        type0 = type1;
        assertEquals(type0, type1);
        System.out.println(" assert Equals");
    }
    @Test
    public void testIdentity() {
        Order.Builder type0 = new Order.Builder().setOrderId("179").setOrderItem("Biltong Burger").setAmount(80);
        Order.Builder type1 = new Order.Builder().setOrderId("90").setOrderItem("classic burger").setAmount(80);
        type0 = type1;
        assertSame(type0, type1);
        System.out.print("assertSame");

    }
    @Test
    public void testTimeout() {
        AssertTimeout(3);
        System.out.println("Time out");
    }

    private void AssertTimeout(int i) {
    }

    @Test
    @Disabled(" When the timeout is exceeded")
    public void testWillBeExecuted() {
    }
}

