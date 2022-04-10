package za.ac.cput.factory;

/* supplierFactory.java
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import za.ac.cput.entity.Supplier;
import za.ac.cput.util.genericHelper;

public class SupplierFactory {

    public static Supplier createSupplier(String supplierName,String supplierEmail,String supplierPhone,String supplierAddress) {

        int supplierID = genericHelper.generatId();
        Supplier supplier= new Supplier.Builder()
                .setSupplierID(supplierID)
                .setSupplierName(supplierName)
                .setSupplierEmail(supplierEmail)
                .setSupplierPhone(supplierPhone)
                .setSupplierAddress(supplierAddress)
                .build();

        return supplier;
    }
}
