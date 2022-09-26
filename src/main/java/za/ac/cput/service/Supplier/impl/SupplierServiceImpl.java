package za.ac.cput.service.Supplier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.supplier.Supplier;
import za.ac.cput.repository.supplier.impl.ISupplierRespository;
import za.ac.cput.service.Supplier.SupplierService;


import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {


    private static SupplierServiceImpl service=null;
    private ISupplierRespository repository;

    @Autowired
    public SupplierServiceImpl(ISupplierRespository repository) {
        this.repository = repository;
    }

    @Override
    public Supplier create(Supplier supplier) {

        return this.repository.save(supplier);
    }

    public Optional<Supplier> read(Integer s) {
        return this.repository.findById(s);
    }


    @Override
    public Supplier update(Supplier supplier) {
        if(this.repository.existsById(supplier.getSupplierID()))
            return this.repository.save(supplier);
        return null;
    }

    @Override
    public void delete(Supplier supplier) {
        repository.delete(supplier);
    }


    @Override
    public List<Supplier> getAll(Integer SupplierId) {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer supplierId) {
        Optional<Supplier> supplier = read(supplierId);
        if (supplier.isPresent()) delete(supplier.get());
    }
}
