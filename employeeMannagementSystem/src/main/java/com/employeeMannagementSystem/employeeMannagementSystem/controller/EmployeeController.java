package com.employeeMannagementSystem.employeeMannagementSystem.controller;

import com.employeeMannagementSystem.employeeMannagementSystem.dto.EmployeeDTO;
import com.employeeMannagementSystem.employeeMannagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	ApplicationContext applicationContext;

	Logger log =  LoggerFactory.getLogger(this.getClass());
	//Build ADD Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//Build Get Employee By ID REST API
	@GetMapping("/get_by_id")
	public ResponseEntity<EmployeeDTO> getEmployeeByIdWithRequestParam(@RequestParam(value = "id", defaultValue = "1") Long id){
		//Show all Beans
		String[] allBeans = applicationContext.getBeanDefinitionNames();

		Arrays.sort(allBeans);
		for(String beanName:allBeans){
			log.info("beanName: "+beanName);
		}

		EmployeeDTO employeeDTO = employeeService.getElementById(id);
		return ResponseEntity.ok(employeeDTO);
	}

	//Build Get Employee By ID REST API
	@GetMapping("/get_by_id/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeByIdWithParam(@PathVariable("id") Long id){
		EmployeeDTO employeeDTO = employeeService.getElementById(id);
		return ResponseEntity.ok(employeeDTO);
	}
	
	//Build Get All Employee REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployess(){
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Build Updated Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO>  updatedEmployee(
			@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDTO updatedEmployee) {
		EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDTO);
	}
	
	@PutMapping()
	public ResponseEntity<EmployeeDTO>  updatedEmployee(
			@RequestBody EmployeeDTO updatedEmployee) {
		EmployeeDTO employeeDTO = employeeService.updateEmployee2(updatedEmployee);
		return ResponseEntity.ok(employeeDTO);
	}
	
	//Build Delete By Id From Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee Deleted Successfully!.");
	}
	
}
