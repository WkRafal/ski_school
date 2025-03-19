package com.WkRafal.ski_school.adapter;

import com.WkRafal.ski_school.model.Equipment;
import com.WkRafal.ski_school.repository.EquipmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface LiSqlEquipmentRepository extends EquipmentRepository, JpaRepository<Equipment, Integer> {
    @Override
    List<Equipment> findByEquipmentType(String type);

    @Override
    List<Equipment> findByBrand(String brand);

    @Override
    List<Equipment> findByLength(String length);

    @Override
    boolean existsById(Integer id);



}
