package za.ac.cput.domain;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.supplier.Supplier;

class SupplierTest {

    @Test
    public void AddMenuTest()
    {
        Supplier supplier = new Supplier.Builder()
                .setSupplierAddress("6826 harry gwala street")
                .setSupplierPhone("0781837656")
                .setSupplierEmail("216205999@mycput.ac.za")
                .setSupplierID(4)
                .setSupplierName("chicken")
                .build();

        System.out.println(supplier);

    }
}