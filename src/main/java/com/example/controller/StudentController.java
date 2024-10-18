
package com.example.controller;

import com.example.entity.StudentEntity;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(value="/getAllStudents", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentEntity>> getAllStudents()
	{
		List<StudentEntity> list = studentService.getAllStudents();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value="/studentById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentEntity> getEmployee(@PathVariable("id") int id) {
		StudentEntity employee = studentService.getStudent(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping(value="/studentByName/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentEntity> findStudentEntityByName(@PathVariable("name") String name) {
		StudentEntity employee = studentService.findStudentEntityByName(name);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping(value = "/createStudent")
	public ResponseEntity<Void> createEmployee(@RequestBody StudentEntity student, UriComponentsBuilder builder) {
		StudentEntity result = studentService.createStudent(student);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(result.getStudentId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id")int id){
		studentService.deleteStudent(id);
	}
}
