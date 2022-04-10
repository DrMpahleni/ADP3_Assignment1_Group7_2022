package za.ac.cput.repository.supplier;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.SupplierFactory;
import za.ac.cput.entity.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierRespositoryTest {

    private static SupplierRespository suppRepository = SupplierRespository.getSupplierRep();
    private static Supplier supp = (Supplier) SupplierFactory.createSupplier("CHICKEN", "@GMAIL.COM", "0781837656", "6826");

    @Test
    void create()
    {
        Supplier created = suppRepository.create(supp);
        assertEquals(created.getSupplierID(), supp.getSupplierID());
        System.out.println("Created Repository: "+created);
    }

    @Test
    void read()
    {
        Supplier read = suppRepository.read(supp.getSupplierID());
        assertNotNull(read);
        System.out.println("Retrieved Repository: "+read);
    }

    @Test
    void update()
    {
        Supplier update = new Supplier.Builder().copy(supp).setSupplierName("bongisa m").build();
        assertNotNull(suppRepository.update(update));
        System.out.println("Updated Repository: "+update);
    }

    @Test
    void delete()
    {
        boolean delete = suppRepository.delete(supp.getSupplierID())  ;
        assertTrue(delete);
        System.out.println("Deleted Repository: "+delete);
    }


    @Test
    void getAll()
    {
        System.out.println(" Display the equipment");
        assertEquals(1,suppRepository.getAll().size());
        System.out.println(suppRepository.getAll());

   }

}