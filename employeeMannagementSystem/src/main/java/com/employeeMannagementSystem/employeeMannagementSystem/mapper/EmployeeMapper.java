package com.employeeMannagementSystem.employeeMannagementSystem.mapper;

import com.employeeMannagementSystem.employeeMannagementSystem.dto.EmployeeDTO;
import com.employeeMannagementSystem.employeeMannagementSystem.entity.Employee;

public class EmployeeMapper {
	
	
	public static EmployeeDTO mapToEmployeeDTO(Employee employee){
//		EmployeeDTO employeeDTO = new EmployeeDTO();
//		employeeDTO.setId(employee.getId());
//		employeeDTO.setFirstName(employee.getFirstName());
//		employeeDTO.setLastName(employee.getLastName());
//		employeeDTO.setEmail(employee.getEmail());
//
//		return employeeDTO;
		
		
		return new EmployeeDTO(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
		);
	}
	
	public static Employee mapToEmployee(EmployeeDTO employeeDTO){
//		Employee employee = new Employee();
//		employee.setId(employeeDTO.getId());
//		employee.setFirstName(employeeDTO.getFirstName());
//		employee.setLastName(employeeDTO.getLastName());
//		employee.setEmail(employeeDTO.getEmail());
//
//		return employee;
		
		return new Employee(
				employeeDTO.getId(),
				employeeDTO.getFirstName(),
				employeeDTO.getLastName(),
				employeeDTO.getEmail()
		);
	}
}
