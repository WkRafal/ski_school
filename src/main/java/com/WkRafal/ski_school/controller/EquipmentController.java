package com.WkRafal.ski_school.controller;


import com.WkRafal.ski_school.model.Equipment;
import com.WkRafal.ski_school.repository.EquipmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    private final EquipmentRepository repository;

    public EquipmentController(EquipmentRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    ResponseEntity<?> createEquipment(@RequestBody Equipment equipment) {
        Equipment result = repository.save(equipment);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    ResponseEntity<List<Equipment>> findAllEquipment() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Equipment> readEquipment(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    ResponseEntity<List<Equipment>> readEquipmentByType(@PathVariable String type) {
        return ResponseEntity.ok(repository.findByEquipmentType(type));
    }

    @GetMapping("/brand/{brand}")
    ResponseEntity<List<Equipment>> readEquipmentByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(repository.findByBrand(brand));
    }

    @GetMapping("/length/{length}")
    ResponseEntity<List<Equipment>> readEquipmentByLength(@PathVariable String length) {
        return ResponseEntity.ok(repository.findByLength(length));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateEquipment(@PathVariable int id, @RequestBody Equipment update) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        };
        repository.findById(id)
                .ifPresent(equipment -> {
                    equipment.updateFrom(update);
                    repository.save(equipment);
                });
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEquipment(@PathVariable int id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
