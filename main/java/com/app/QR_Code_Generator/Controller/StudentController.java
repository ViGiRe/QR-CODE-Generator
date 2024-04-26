package com.app.QR_Code_Generator.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.QR_Code_Generator.model.Student;
import com.app.QR_Code_Generator.service.StudentService;
import com.app.QR_Code_Generator.utils.QRCodeGenerator;
import com.google.zxing.WriterException;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() throws WriterException, IOException{
		
		List<Student> students = studentService.getStudents();
		if (students.size() != 0) {
			for (Student student : students) {
				QRCodeGenerator.generateQRCode(student);
			}
		}
		return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
	}

	@GetMapping("/student/{id}")
	public Student getById(@PathVariable("id") Long id) {
		return studentService.getStudent(id);
	}
}
