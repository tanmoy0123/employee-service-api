package com.employeeMannagementSystem.employeeMannagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
}
