package com.example.service;

import com.example.entity.StudentEntity;
import com.example.model.StudentDTO;
import com.example.respository.ProcedureRepository;
import com.example.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortArgumentResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	private final ProcedureRepository procedureRepository;
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository,ProcedureRepository procedureRepository){
        this.studentRepository = studentRepository;
		this.procedureRepository= procedureRepository;
    }

	public Page<StudentEntity> getAllStudents(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equals("ascending") ?  Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page,size,sort);
		return studentRepository.findAll(pageable);
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

	public int callProcedure(int a, int b) {
		return procedureRepository.callProcedure( a,b);

	}
}
