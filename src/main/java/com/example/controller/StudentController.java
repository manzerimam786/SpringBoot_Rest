
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {


	@Autowired
	StudentService studentService;
	@RequestMapping(value="/students", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> list = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
}
