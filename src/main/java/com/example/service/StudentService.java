package com.example.service;

import com.atish.model.Book;
import com.example.StudentUtil;
import com.example.entity.StudentEntity;
import com.example.model.StudentDTO;
import com.example.respository.ProcedureRepository;
import com.example.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final ProcedureRepository procedureRepository;
    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public StudentService(StudentRepository studentRepository, ProcedureRepository procedureRepository) {
        this.studentRepository = studentRepository;
        this.procedureRepository = procedureRepository;
        this.restTemplate = new RestTemplate();
    }

    @Cacheable(value = "students", key = "#id")
    public List<StudentEntity> getAllStudents(int page, int size, String sortBy, String sortDir) {
        String url = "http://localhost:8082/books/getAllBooks";
        // we have restriction to call List<Book>.class while using getForEntity, so we need to use exchange here
        ResponseEntity<List> listOfBook = restTemplate.getForEntity(url, List.class);
        List<Book> listOfBooks = (List<Book>)listOfBook.getBody();
        System.out.println("listOfBook1="+listOfBook.getBody());
        
        // by using exchange
        ResponseEntity<List<Book>> lisofBooks = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
        });
        System.out.println("listOfBook="+lisofBooks.getBody().get(1));

        Sort sort = sortDir.equals("ascending") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return studentRepository.findAll(pageable).getContent();
    }

    @Cacheable(key = "#studentId", value = "students")
    public Optional<StudentEntity> getStudent(int id) {
		return Optional.of(studentRepository.findById(id).get());
    }

    public StudentEntity createStudent(StudentDTO student) {
        StudentEntity studentEntity = new StudentUtil().mapStudentDTOToStduentEntity(student);
        return studentRepository.save(studentEntity);
    }

    @CachePut(key = "students", value = "#id")
    public StudentEntity updateStudent(int id, String updateFirstName) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        StudentEntity updatedStudent = null;
        if(studentEntity.isPresent()){
            studentEntity.get().setFirstName(updateFirstName);
            updatedStudent = studentRepository.save(studentEntity.get());
        }
        return updatedStudent;
    }

    @CacheEvict(value = "students", key = "#studentId")
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
        return procedureRepository.callProcedure(a, b);
    }
}
