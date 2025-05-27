package com.example;

import com.example.entity.StudentEntity;
import com.example.model.StudentDTO;

public class StudentUtil {
    public StudentEntity mapStudentDTOToStduentEntity(StudentDTO student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(student.getStudentId());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setCity(student.getCity());
        studentEntity.setCourse(student.getCourse());
        return studentEntity;
    }
}
