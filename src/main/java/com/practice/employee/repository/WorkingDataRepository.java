package com.practice.employee.repository;

import com.practice.employee.entity.WorkingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingDataRepository extends JpaRepository<WorkingData,Integer> {
}
