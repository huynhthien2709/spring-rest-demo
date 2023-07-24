package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

//Lab 15.4
@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// define @PostContruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));
	}

	// define endpoint for "/student" - return list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
//		List<Student> students = new ArrayList<>();
//		students.add(new Student("Poornima", "Patel"));
//		students.add(new Student("Mario", "Rossi"));
//		students.add(new Student("Mary", "Smith"));
		return students;
	}

	// Lab 16.1
	// define endpoint for "/student/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// just index into the list ... keeep it simple now

		// check studentId against list size
		if ((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return students.get(studentId);
	}

//	// Add an exception handler using @ExceptionHandler
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//
//		// create a StudentErrorResponse
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		// return ResponseEntity
//
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//
//	// add another exception handler ... to catch any exception (catch all)
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//
//		// create a StudentErrorResponse
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		// return ResponseEntity
//
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}

}
