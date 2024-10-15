package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.respository.StudentRepository;
import com.example.entity.StudentEntity;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	public StudentEntity getStudent(int id) {
		return studentRepository.findById(id).get();
	}

	public StudentEntity createStudent(StudentEntity student) {
		return studentRepository.save(student);
	}
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public StudentEntity findStudentEntityByName(String name) {
		return studentRepository.findStudentEntityByName(name);
	}

//	public boolean updateEmployee(int id, Student student) {
//		return studentRepository.updateStudentBy(id);
//	}
}
