package za.ac.cput.controller.supplier;

/*IngredientsControllerJava
  This is Ingredients controller
  @Author: Lihle Njobe(218193883)
  Due date: 21 August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.service.Supplier.IIngredientsService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restuarant/ingredients")
@Slf4j

public class IngredientsController {

    private IIngredientsService IingredientsService;

    @Autowired
    public IngredientsController(IIngredientsService IingredientsService) {
        this.IingredientsService = IingredientsService;
    }
    @PostMapping("Save")
    public ResponseEntity<Ingredients> save(@Valid @RequestBody Ingredients ingredients) {
        log.info("Save request: {}", ingredients);
        Ingredients save = IingredientsService.create(ingredients);
        return ResponseEntity.ok(save);
    }

    private Optional<Ingredients> getById(String ingredientName) {
        return this.IingredientsService.read(ingredientName);
    }

    @GetMapping("/read{orderId}")
    public ResponseEntity<Ingredients> read(@PathVariable String ingredientName) {
        log.info("Read request: {} ingredientName");
        Ingredients ingredients = getById(ingredientName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(ingredients);
    }

    @PutMapping("/update")
    public ResponseEntity<Ingredients> update(@Valid @RequestBody Ingredients ingredients) {
        log.info("Update request: {} ", ingredients);
        Ingredients updated = IingredientsService.update(ingredients);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("delete/{orderId}")
    public ResponseEntity<Void> delete (@PathVariable String ingredientName){
        log.info("Delete Request: {} ", ingredientName);
        this.IingredientsService.deleteById(ingredientName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ingredients>> getAll(String ingredientName) {
        List<Ingredients> orders = this.IingredientsService.getAll(ingredientName);
        return ResponseEntity.ok(orders);
    }

}


