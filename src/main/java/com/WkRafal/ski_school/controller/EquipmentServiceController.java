package com.WkRafal.ski_school.controller;

import com.WkRafal.ski_school.model.Equipment;
import com.WkRafal.ski_school.model.EquipmentService;
import com.WkRafal.ski_school.repository.EquipmentRepository;
import com.WkRafal.ski_school.repository.EquipmentServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment_services")
public class EquipmentServiceController {

    private final EquipmentServiceRepository repository;

    public EquipmentServiceController(EquipmentServiceRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<?> createEquipmentService(@RequestBody EquipmentService service) {
        EquipmentService result = repository.save(service);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    ResponseEntity<List<EquipmentService>> findAllServices() {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteService(@PathVariable int id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
