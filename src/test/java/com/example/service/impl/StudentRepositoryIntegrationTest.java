package com.example.service.impl;

import com.example.entity.StudentEntity;
import com.example.respository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
public class StudentRepositoryIntegrationTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        studentRepository.deleteAll();
    }

    @Test
    void testSaveAndFind() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName("Atifaaa11111111111");
        studentEntity.setLastName("Naaaza");
        studentEntity.setCity("Jehanabad");
        studentEntity.setEmail("nishi@gmail.com");
        studentEntity.setCourse("English");
        studentEntity.setPhone("9876543210");
        studentRepository.save(studentEntity);
        StudentEntity found = studentRepository.findByFirstNameAndLastName("Atifaaa", "Naaaza");
        System.out.println("found=" + found);
        // assertEquals(1, found.);
    }
}
