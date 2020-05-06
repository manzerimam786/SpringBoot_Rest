package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.model.Person;
import com.example.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping(value="/persons" , produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getAllPersons()
	{
		List<Person> list = personService.getAllPerson();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/person/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPerson(@PathVariable("id") int id)
	{
		Person person = personService.getPerson(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<Void> addPerson(@RequestBody Person person, UriComponentsBuilder builder)
	{
		personService.createPerson(person);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/create/{id}").buildAndExpand(person.getId()).toUri());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerson(@PathVariable("id")int id)
	{
		personService.deletePerson(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Person> updatePerson(@PathVariable("id")int id, @RequestBody Person person)
	{
		boolean result = personService.updatePerson(person,id);
		if(!result)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
		
	}
	
	
}
