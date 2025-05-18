
package com.example.controller;

import com.example.entity.StudentEntity;
import com.example.exception.ErrorResponse;
import com.example.model.StudentDTO;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
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

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Added pagination page =0 size 2, and sortBy firstName and sortDir = ascending
    @GetMapping(value = "/getAllStudents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> getAllStudents(@RequestParam(required=false, defaultValue = "0") int page,@RequestParam(required = false, defaultValue = "2") int size,@RequestParam(required = false, defaultValue = "firstName") String sortBy,@RequestParam(required = false, defaultValue = "ascending") String sortDir) {
        log.debug("inside getAllStudents");
        List<StudentEntity> list = studentService.getAllStudents(page,size,sortBy,sortDir);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/studentById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<StudentEntity>> getEmployee(@PathVariable("id") int id) {
        Optional<StudentEntity> employee = studentService.getStudent(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/studentByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> findStudentEntityByName(@PathVariable("name") String name) {
        List<StudentEntity> employee = studentService.findStudentByName(name);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/studentByName/{firstName}/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentEntity> findStudentByFirstAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        StudentEntity employee = studentService.findStudentByFirstAndLastName(firstName, lastName);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping(value = "/createStudent")
    public ResponseEntity<ErrorResponse> createEmployee(@Valid @RequestBody StudentDTO student,
                                                        //BindingResult bindingResult, required when do programmatic validation
                                                        UriComponentsBuilder builder) {
        // when we want to handle validation then need to enable below code
        /*if (bindingResult.hasErrors()) {
            List<String> details = new ArrayList<>();
            details.add(bindingResult.getFieldError().getDefaultMessage());
            ErrorResponse error = new ErrorResponse(bindingResult.getFieldError().getField(), details);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }*/
        StudentEntity result = studentService.createStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/create/{id}").buildAndExpand(result.getStudentId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }

    // calling procedure which is in MySQL database
    @GetMapping(value = "/testProcedure/{a}/{b}")
    public ResponseEntity<Integer> testProcedure(@PathVariable("a") int a, @PathVariable("b") int b) {
        System.out.println("here started");
        int result = studentService.callProcedure(a, b);
        System.out.println("result =" + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
