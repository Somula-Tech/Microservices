package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Configuration;
import com.app.model.Employee;
import com.app.model.LimitConfiguration;
import com.app.repository.EmployeeRepository;

import com.app.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private Configuration configuration;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/config")
	public LimitConfiguration retrievelLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
		
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello World";
	}
	
	@PostMapping("/")
	public Employee saveemployeeDate(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeDataById(@PathVariable("id") int employeeId) {
		return employeeService.getEmployeeDataById(employeeId);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> getStudentDetailsUpdate(@PathVariable int employeeId,@RequestBody Employee employeeDetails) {
		
		
		return employeeService.getStudentDetailsUpdate(employeeId, employeeDetails);
	}
	
	
	
	
	
}
