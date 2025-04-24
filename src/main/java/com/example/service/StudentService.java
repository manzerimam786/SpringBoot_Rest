package com.example.service;

import com.example.entity.StudentEntity;
import com.example.model.StudentDTO;
import com.example.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<StudentEntity> getStudent(int id) {
		return Optional.of(studentRepository.findById(id).get());
	}

	public StudentEntity createStudent(StudentDTO student) {
		StudentEntity studentEntity = mapStudentDTOToStduentEntity(student);
		return studentRepository.save(studentEntity);
	}

	private static StudentEntity mapStudentDTOToStduentEntity(StudentDTO student) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(student.getStudentId());
		studentEntity.setFirstName(student.getFirstName());
		studentEntity.setLastName(student.getLastName());
		studentEntity.setCity(student.getCity());
		studentEntity.setCourse(student.getCourse());
		return studentEntity;
	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public List<StudentEntity> findStudentByName(String name) {
		return studentRepository.getLastName(name);
	}

	public StudentEntity findStudentByFirstAndLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
	}
}
