package za.ac.cput.factory;
/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import org.junit.jupiter.api.Test;

import za.ac.cput.entity.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {
    @Test
    public void createSupplier() {
        Supplier supplier = (Supplier) SupplierFactory.createSupplier("CHICKEN", "@GMAIL.COM", "0781837656", "6826");

        System.out.println(supplier);

        assertTrue(supplier instanceof Supplier);
    }
}