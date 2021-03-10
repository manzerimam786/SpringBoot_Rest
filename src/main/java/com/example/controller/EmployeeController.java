package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.RecordNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}

	@RequestMapping(value="/employee/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployee(id);
		if(employee==null)
			 throw new RecordNotFoundException("Invalid employee id : " + id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	
	}

	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {
		boolean result = employeeService.createEmployee(employee);
		if(result)
		{
		HttpHeaders headers =  new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(employee.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		boolean result = employeeService.updateEmployee(id, employee);
		if(result)
		   return new ResponseEntity<Void>(HttpStatus.OK);
		else
		{
		   return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id")int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllEmployees(){
		employeeService.deleteAllEmployees();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
