package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.example.dao.StudentRepository;
import com.example.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	/*@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

	    return sessionFactory;
	} */
	public List<Student> getAllStudents()
	{
		List<Student> list = new ArrayList<Student>();
		Iterable<Student> iterable = studentRepository.findAll();
		Iterator<Student> itr =  iterable.iterator();
		while(itr.hasNext())
		{
			Student student = (Student)itr.next();
			list.add(student);
		}
		return list;
	}
}
