package com.practice.employee.repository;

import com.practice.employee.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidaysRepository extends JpaRepository<Holiday, Integer> {
}
