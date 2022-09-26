package za.ac.cput.controller.supplier;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.supplier.Supplier;
import za.ac.cput.service.Supplier.SupplierService;



import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name ="restaurant/supplier/" )
@Slf4j
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create")
    public ResponseEntity<Supplier> create  (@Valid @RequestBody Supplier supplier) {
        log.info("create  request: {}", supplier);
        Supplier save = supplierService.create(supplier);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/read{id}")
    public Optional<Supplier> read(@PathVariable Integer s ) {
        return supplierService.read(s);
    }

    @PostMapping("/update")
    public Supplier update(@PathVariable("supplierID") Supplier supplier) {
        return supplierService.update(supplier);
    }
    @DeleteMapping("{supplierID}")
    public void delete(@PathVariable("supplierID") Supplier s){
        supplierService.delete(s);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Supplier>> getAll(Integer s) {
        List<Supplier> supplier = this.supplierService.getAll(s);
        return ResponseEntity.ok(supplier);
    }

}
