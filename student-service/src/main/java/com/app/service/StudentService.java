package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.controller.ResourceNotFoundException;
import com.app.model.Student;
import com.app.repository.StudentRepository;

@Service
public class StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	public Student getStudentByStudentId(int studentId) {
		return studentRepository.findByStudentId(studentId);
		// TODO Auto-generated method stub
		
	}
	public ResponseEntity<Student> getStudentDetailsUpdate(int studentId,Student studentDetails) {
		Student updateStudent = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with studentId: "+ studentId));
		
		
		updateStudent.setName(studentDetails.getName());
		updateStudent.setEmail(studentDetails.getEmail());
		updateStudent.setage(studentDetails.getage());
		
		studentRepository.save(updateStudent);
		
		return ResponseEntity.ok(updateStudent);
	}
	
	
	

}
