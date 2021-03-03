package com.example.demo.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.entity.PersonEntity;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.interfaces.IPersonDetails;
import com.example.demo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Person;

import com.example.demo.repository.PersonRepo;

@Service
public class PersonDetailsImpl implements IPersonDetails {
	
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	PersonMapper personMapper;

	@Override
	public Long addPerson(Person p) {
		PersonEntity personEntity = new PersonEntity();
		personEntity = personMapper.mapToEntity(p, personEntity);
		personRepo.save(personEntity);
		return personEntity.getId();
	}

	@Override
	public Long updatePerson(Person p) {
		PersonEntity personEntity = personRepo.findById(p.getId())
				.orElseThrow(() ->new PersonNotFoundException(p.getId()));
		personEntity = personMapper.mapToEntity(p, personEntity);
		personRepo.save(personEntity);
		return personEntity.getId();
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		List<PersonEntity> entities= (List<PersonEntity>)personRepo.findAll();
		if(entities.isEmpty()){
			throw new NoDataFoundException();
		}
		entities.forEach(entity -> {
			persons.add(personMapper.mapFromEntity(entity));
		});
		return persons;
	}

	@Override
	public Long deletePerson(Long id) {
		PersonEntity personEntity = personRepo.findById(id)
				.orElseThrow(() ->new PersonNotFoundException(id));
		personRepo.delete(personEntity);
		return personEntity.getId();
	}

}
