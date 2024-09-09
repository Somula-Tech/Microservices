package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.controller.ResourceNotFoundException;
import com.app.model.Employee;

import com.app.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeDataById(int employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
		// TODO Auto-generated method stub
		
		
		
		
	}
	public ResponseEntity<Employee> getStudentDetailsUpdate(@PathVariable int employeeId,@RequestBody Employee employeeDetails) {
		Employee updateEmployee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with employeeId: "+ employeeId));
		
		
		updateEmployee.setName(employeeDetails.getName());
		updateEmployee.setEmail(employeeDetails.getEmail());
		updateEmployee.setAge(employeeDetails.getAge());
	
		employeeRepository.save(updateEmployee);
		
		return ResponseEntity.ok(updateEmployee);
	}
	
	

}
