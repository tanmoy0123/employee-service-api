package com.employeeMannagementSystem.employeeMannagementSystem.service.implement;

import com.employeeMannagementSystem.employeeMannagementSystem.dto.EmployeeDTO;
import com.employeeMannagementSystem.employeeMannagementSystem.entity.Employee;
import com.employeeMannagementSystem.employeeMannagementSystem.exception.ResourceNotFoundException;
import com.employeeMannagementSystem.employeeMannagementSystem.mapper.EmployeeMapper;
import com.employeeMannagementSystem.employeeMannagementSystem.repository.EmployeeRepository;
import com.employeeMannagementSystem.employeeMannagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class   EmployeeServiceIMPLEMENT implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee transferToEmployee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee = employeeRepository.save(transferToEmployee);
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}
	@Override
	public EmployeeDTO getElementById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with this id " + employeeId
		));
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
	}
	
	@Override
	public EmployeeDTO updateEmployee(
			Long employeeId,
			EmployeeDTO updatedEmployee) {
		Employee employee = employeeRepository
				.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with this id " + employeeId
		));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObject = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObject);
	}
	
	
	@Override
	public EmployeeDTO updateEmployee2(
			EmployeeDTO updatedEmployee) {
		Employee employee = employeeRepository
				.findById(updatedEmployee.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Employee is not exist with this id " + updatedEmployee.getId()
				));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObject = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObject);
	}
	
	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with this id " + employeeId
		));
		
		employeeRepository.deleteById(employeeId);
	}
	
	
}
