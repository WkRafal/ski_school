package com.WkRafal.ski_school.adapter;

import com.WkRafal.ski_school.model.EquipmentService;
import com.WkRafal.ski_school.repository.EquipmentRepository;
import com.WkRafal.ski_school.repository.EquipmentServiceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlEquipmentServiceRepository extends EquipmentServiceRepository, JpaRepository<EquipmentService, Integer> {

    @Override
    boolean existsById(Integer id);

}
