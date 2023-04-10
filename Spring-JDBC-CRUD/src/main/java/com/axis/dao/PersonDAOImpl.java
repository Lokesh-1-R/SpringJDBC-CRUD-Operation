package com.axis.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.axis.model.Person;
import com.axis.model.PersonMapper;

@Component
public class PersonDAOImpl implements PersonDAO {
	
	
	JdbcTemplate jdbcTemplate;
	private final String SQL_FIND_PERSON = "select * from people where id =?";
	private final String SQL_DELETE_PERSON="delete from people where id = ?";
	private final String SQL_UPDATE_PERSON ="Update people set firstname = ? , lastname = ? ,age =? where id =?";
	private final String SQL_GET_ALL_PERSON ="select * from people";
	private final String SQL_INSERT_PERSON ="insert into people (id,firstname,lastname,age) values (?,?,?,?)";
	
	
	public PersonDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Person getPersonId(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] {id},new PersonMapper());
	}

	public List<Person> getAllPersons() {
		return jdbcTemplate.query(SQL_GET_ALL_PERSON,new PersonMapper());
	}

	public boolean createPerson(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_PERSON,person.getId(),person.getFirstName(),person.getLastName(),person.getAge())>0;
	}

	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_UPDATE_PERSON,person.getFirstName(),person.getLastName(),person.getAge(),person.getId())>0;
	}	

	public boolean deletePerson(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_DELETE_PERSON,person.getId())>0;
	}

}
