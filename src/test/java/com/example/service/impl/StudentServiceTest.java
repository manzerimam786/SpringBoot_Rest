package com.example.service.impl;

import com.example.entity.StudentEntity;
import com.example.model.StudentDTO;
import com.example.respository.StudentRepository;
import com.example.service.StudentService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;
    @Captor
    private ArgumentCaptor<StudentEntity> captorStudentEntity;

//    public StudentServiceTest() {
//        MockitoAnnotations.openMocks(StudentServiceTest.class);
//    }

    @Test
    public void testCreateStudent() {
        StudentDTO studentDTO = prepareRequest();
        StudentEntity response = studentService.createStudent(studentDTO);
        verify(studentRepository, times(1)).save(captorStudentEntity.capture());
        assertEquals("Jehanabad", captorStudentEntity.getValue().getCity());
    }

    private StudentDTO prepareRequest() {
        StudentDTO studentDTO = new StudentDTO();
        String id = RandomStringUtils.randomNumeric(3);
        String firstName = RandomStringUtils.randomAlphabetic(6);
        String lastName = RandomStringUtils.randomAlphabetic(6);
        studentDTO.setStudentId(Integer.parseInt(id));
        studentDTO.setFirstName(firstName);
        studentDTO.setLastName(lastName);
        studentDTO.setCity("Jehanabad");
        studentDTO.setEmail("manzer@gmail.com");
        studentDTO.setCourse("Java");
        studentDTO.setPhone("9876543210");
        return studentDTO;
    }
}
