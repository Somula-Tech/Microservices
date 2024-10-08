package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	Employee findByEmployeeId(int employeeId);

}
