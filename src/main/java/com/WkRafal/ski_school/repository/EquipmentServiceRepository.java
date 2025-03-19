package com.WkRafal.ski_school.repository;

import com.WkRafal.ski_school.model.Equipment;
import com.WkRafal.ski_school.model.EquipmentService;

import java.util.List;

public interface EquipmentServiceRepository {

    EquipmentService save(EquipmentService entity);

    List<EquipmentService> findAll();

    void deleteById(Integer id);

    boolean existsById(Integer id);
}
