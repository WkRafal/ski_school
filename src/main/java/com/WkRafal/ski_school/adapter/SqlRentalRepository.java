package com.WkRafal.ski_school.adapter;

import com.WkRafal.ski_school.model.Rental;
import com.WkRafal.ski_school.repository.RentalRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlRentalRepository extends RentalRepository, JpaRepository<Rental, Integer> {

    @Override
    List<Rental> findByStatus(String status);

    @Override
    boolean existsById(Integer id);
}
