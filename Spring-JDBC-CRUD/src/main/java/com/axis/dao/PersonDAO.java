package com.axis.dao;

import java.util.List;

import com.axis.model.Person;

public interface PersonDAO {
	Person getPersonId(int id);
	List<Person> getAllPersons();
	boolean createPerson(Person person);
	boolean updatePerson(Person person);
	boolean deletePerson(Person person);
	

}
