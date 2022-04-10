package za.ac.cput.repository.supplier;

/*
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/
import za.ac.cput.entity.Supplier;
import za.ac.cput.repository.supplier.impl.ISupplierRespository;

import java.util.HashSet;
import java.util.Set;

public class SupplierRespository implements ISupplierRespository {

    private static SupplierRespository supplierRep = null;
    private Set<Supplier> supplierSet;

    public SupplierRespository() {
        this.supplierSet = new HashSet<>();
    }

    public static SupplierRespository getSupplierRep(){

        if(supplierRep == null)
        {
            supplierRep = new SupplierRespository();
        }
        return supplierRep;
    }
    @Override
    public Supplier create(Supplier supplier)
    {
        boolean success = supplierSet.add(supplier);
        if(!success)
            return null;return supplier;
    }

    @Override
    public Supplier read(Integer supplierID)
    {
        for(Supplier supplier : supplierSet) {
            if (supplier.getSupplierID() == supplierID) {
                return supplier;
            }
        }
        return null;
    }

    @Override
    public Supplier update(Supplier supplier)
    {
        Supplier _supplier = read(supplier.getSupplierID());
        if(_supplier != null)
        {
            supplierSet.remove(_supplier);
            supplierSet.add(supplier);
            return supplier;
        }
        return null;
    }

    @Override
    public boolean delete(Integer menuItemID)
    {
        Supplier delete = read(menuItemID);
        if(delete == null)
            return false;
        supplierSet.remove(delete);
        return true;
    }

    @Override
    public Set<Supplier> getAll() {
        return supplierSet;
    }
}
