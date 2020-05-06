package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
public class PersonDao {

	public TreeMap<Integer, Person> map = new TreeMap<>();
	public AtomicInteger randomNumber = new AtomicInteger(0);

	public PersonDao() {
		Person person = new Person("manzer", "patna");
		addPerson(person);
	}

	private void addPerson(Person person2) {
		int id = randomNumber.getAndIncrement();
		person2.setId(id);
		map.put(id, person2);

	}

	public List<Person> getAllPerson() {
		List<Person> list = new ArrayList<>();
		list.addAll(map.values());
		return list;
	}

	public Person getPerson(int id) {
		return map.get(id);
	}

	public void createPerson(Person person) {
		addPerson(person);
	}

	public void deletePerson(int id) {
		map.remove(id);
	}

	public boolean updatePerson(Person person, int id) {
		Person currentPerson = map.get(id);
		if (currentPerson != null) {
			currentPerson.setAddress(person.getAddress());
			currentPerson.setName(person.getName());
			map.put(id, currentPerson);
			return true;
		} else
			return false;
	}
}
