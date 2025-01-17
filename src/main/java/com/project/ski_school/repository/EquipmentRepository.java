package com.project.ski_school.repository;

import com.project.ski_school.model.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {

    Equipment save(Equipment entity);

    List<Equipment> findAll();

    Optional<Equipment> findById(Integer id);

    List<Equipment> findByEquipmentType(String type);

    List<Equipment> findByBrand(String brand);

    List<Equipment> findByLength(String length);


    void deleteById(Integer id);

    boolean existsById(Integer id);
}
