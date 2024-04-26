package com.app.QR_Code_Generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.QR_Code_Generator.Repository.StudentRepository;
import com.app.QR_Code_Generator.model.Student;

@Service
public class StudentService {

	private StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Autowired
	private final StudentRepository studentRepository;
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudent(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found"));
	}
	
	
}
