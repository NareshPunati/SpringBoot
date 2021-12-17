package com.practice.employee.repository;

import com.practice.employee.entity.PublicHolidays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicRepository extends JpaRepository<PublicHolidays, Integer> {
}
