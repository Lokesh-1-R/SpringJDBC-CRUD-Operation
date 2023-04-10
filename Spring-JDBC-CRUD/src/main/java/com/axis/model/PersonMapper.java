package com.axis.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonMapper implements RowMapper<Person> {

	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	Person person = new Person();
	person.setId(rs.getInt("Id"));
	person.setFirstName(rs.getString("firstName"));
	person.setLastName(rs.getString("lastName"));
	person.setAge(rs.getInt("age"));
	
	return person;
	}

}
