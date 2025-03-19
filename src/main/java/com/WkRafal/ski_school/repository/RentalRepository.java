package com.WkRafal.ski_school.repository;

import com.WkRafal.ski_school.model.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {

    Rental save(Rental entity);

    List<Rental> findAll();

    Optional<Rental> findById(Integer id);

    List<Rental> findByStatus(String status);

    void deleteById(Integer id);

    boolean existsById(Integer id);
}
