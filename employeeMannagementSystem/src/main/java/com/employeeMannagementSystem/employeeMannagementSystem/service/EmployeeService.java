package com.employeeMannagementSystem.employeeMannagementSystem.service;

import com.employeeMannagementSystem.employeeMannagementSystem.dto.EmployeeDTO;
import com.employeeMannagementSystem.employeeMannagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO getElementById(Long employeId);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);
	
	EmployeeDTO updateEmployee2(EmployeeDTO updatedEmployee);
	void deleteEmployee(Long employeeId);
}
