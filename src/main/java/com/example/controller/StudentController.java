
package com.example.controller;

import com.example.entity.StudentEntity;
import com.example.exception.ErrorResponse;
import com.example.model.StudentDTO;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;
	private final Logger log = LoggerFactory.getLogger(StudentController.class);

	public StudentController(StudentService studentService){
		this.studentService = studentService;
	}


	@GetMapping(value="/getAllStudents", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentEntity>> getAllStudents()
	{
log.debug("inside getAllStudents");
		List<StudentEntity> list = studentService.getAllStudents();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value="/studentById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<StudentEntity>> getEmployee(@PathVariable("id") int id) {
		Optional<StudentEntity> employee = studentService.getStudent(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping(value="/studentByName/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentEntity>> findStudentEntityByName(@PathVariable("name") String name) {
		List<StudentEntity> employee = studentService.findStudentByName(name);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping(value="/studentByName/{firstName}/{lastName}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentEntity> findStudentByFirstAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		StudentEntity employee = studentService.findStudentByFirstAndLastName(firstName,lastName);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping(value = "/createStudent")
	public ResponseEntity<ErrorResponse> createEmployee(@Valid @RequestBody StudentDTO student, BindingResult bindingResult, UriComponentsBuilder builder) {
		if(bindingResult.hasErrors()){
			List<String> details = new ArrayList<>();
			details.add(String.valueOf(bindingResult.getFieldError()));
			ErrorResponse error = new ErrorResponse("Validation fails", details);
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		StudentEntity result = studentService.createStudent(student);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(result.getStudentId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping(value="/delete/{id}")
	public void deleteEmployee(@PathVariable("id")int id){
		studentService.deleteStudent(id);
	}
}
