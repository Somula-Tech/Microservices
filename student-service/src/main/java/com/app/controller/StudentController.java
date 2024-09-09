package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Configuration;
import com.app.model.LimitConfiguration;
import com.app.model.Student;
import com.app.repository.StudentRepository;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
@RefreshScope
public class StudentController {

	@Autowired
	private Configuration configuration;

	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello World";
	}
	
	@GetMapping("/studentconfig")
	public LimitConfiguration retrievelLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	
	@PostMapping("/")
	public Student saveStudentDate(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/{id}")
	public Student getStudentDataById(@PathVariable("id") int studentId) {
		return studentService.getStudentByStudentId(studentId);
	}
	
	@PutMapping("{studentId}")
	public ResponseEntity<Student> getStudentDetailsUpdate(@PathVariable int studentId,@RequestBody Student studentDetails) {
		
		
		return studentService.getStudentDetailsUpdate(studentId, studentDetails);
	}
	
	
	
	
	
}
