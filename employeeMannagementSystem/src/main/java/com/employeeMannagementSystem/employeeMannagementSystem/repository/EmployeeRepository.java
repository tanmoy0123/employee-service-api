package com.employeeMannagementSystem.employeeMannagementSystem.repository;

import com.employeeMannagementSystem.employeeMannagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
