package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.bean.Person;

public interface IPersonDetails {
	public Long addPerson(Person p);
	public Long updatePerson(Person p);
	public List<Person> getAllPersons();
	public Long deletePerson(Long id);

}
