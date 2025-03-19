package com.WkRafal.ski_school.controller;

import com.WkRafal.ski_school.model.Rental;
import com.WkRafal.ski_school.repository.RentalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalRepository repository;

    public RentalController(RentalRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<?> createRental(@RequestBody Rental rental) {
        Rental result = repository.save(rental);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    ResponseEntity<List<Rental>> findAllRentals() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Rental>readRental(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    ResponseEntity<List<Rental>> readRentalByStatus(@PathVariable String status) {
        return ResponseEntity.ok(repository.findByStatus(status));
    }

//    @GetMapping("/data")
//    public ResponseEntity<List<Wypozyczenie>> znajdzWypozyczeniaWedlugDat(
//            @RequestParam LocalDate start, @RequestParam LocalDate end) {
//        return ResponseEntity.ok(wypozyczenieService.znajdzWypozyczeniaWedlugDat(start, end));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable int id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
