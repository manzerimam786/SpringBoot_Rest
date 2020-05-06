package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PersonDao;
import com.example.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonDao personDao;
	public List<Person> getAllPerson()
	{
		return personDao.getAllPerson();
	}
	
	public Person getPerson(int id){
		return personDao.getPerson(id);
	}
	
	public void createPerson(Person person){
		personDao.createPerson(person);
	}
	
	public void deletePerson(int id)
	{
		personDao.deletePerson(id);
	}
	
	public boolean updatePerson(Person person, int id)
	{
		return personDao.updatePerson(person,id);
	}
	
}
