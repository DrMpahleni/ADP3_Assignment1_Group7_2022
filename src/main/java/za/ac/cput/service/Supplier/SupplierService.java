package za.ac.cput.service.Supplier;


import za.ac.cput.domain.supplier.Supplier;
import za.ac.cput.service.IService;

import java.util.List;

public interface SupplierService extends IService<Supplier, Integer> {

    List<Supplier> getAll(Integer SupplierId );
    void deleteById(Integer SupplierId);
}
