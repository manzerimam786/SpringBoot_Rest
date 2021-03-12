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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/emp")
@Api(value = "Swagger Documentation of Employee Controller", description = "REST APIs related to Employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@ApiOperation(value = "Get list of All Employees from the Map", response = Iterable.class, tags = "getAllEmployees")
	@ApiResponses(value= {
			@ApiResponse(code = 404, message = "Employee Not Found"),
			@ApiResponse(code = 200, message = "Employee Found"),
			@ApiResponse(code = 401, message = "Unauthorized, check credentials"),
			@ApiResponse(code = 403, message = "Forbidden, check your authorization")
		})
	@RequestMapping(value="/employees", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}

	@ApiOperation(httpMethod = "GET", value = "d and return employee details")
	@ApiResponses(value= {
		@ApiResponse(code = 404, message = "Specific Employee Not Found"),
		@ApiResponse(code = 200, message = "Employee ID Found"),
		@ApiResponse(code = 401, message = "Unauthorized, check credentials"),
		@ApiResponse(code = 403, message = "Forbidden, check your authorization")
	})
	@RequestMapping(value="/employee/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(
			@ApiParam( name =  "id",value = "Employee ID",required = true)
			@PathVariable("id") int id) 
	{
		Employee employee = employeeService.getEmployee(id);
		if(employee==null)
			 throw new RecordNotFoundException("Invalid employee id : " + id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	
	}
	@ApiOperation(produces = "Specific Employee Deatil", consumes = "Employee ID", httpMethod = "GET", value = "takes employee id and return employee details")
	@ApiResponses(value= {
		@ApiResponse(code = 201, message = "Employee Not Created"),
		@ApiResponse(code = 401, message = "Unauthorized, check credentials"),
		@ApiResponse(code = 403, message = "Forbidden, check your authorization")
	})
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
