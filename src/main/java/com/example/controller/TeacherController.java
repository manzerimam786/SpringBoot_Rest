package com.example.controller;

import com.example.entity.Teacher;
import com.example.model.TeacherDTO;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable("teacherId") Long teacherId){
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping("/createTeacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody @Valid TeacherDTO teacher){
        Teacher teacherResponse = teacherService.createTeacher(teacher);
        return new ResponseEntity<>(teacherResponse, HttpStatus.OK);
    }
}
