package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.bean.Person;
import com.example.demo.entity.PersonEntity;

@Component
public class PersonMapper {
	
	public Person mapFromEntity(PersonEntity entity) {
		Person person = new Person();
		person.setId(entity.getId());
		person.setAge(entity.getAge());
		person.setFavourite_colour(entity.getFavourite_colour());
		person.setFirst_name(entity.getFirst_name());
		person.setLast_name(entity.getLast_name());

		return person;
		
	}

	public PersonEntity mapToEntity(Person person ,PersonEntity personEntity) {

		personEntity.setAge(person.getAge());
		personEntity.setFavourite_colour(person.getFavourite_colour());
		personEntity.setFirst_name(person.getFirst_name());
		personEntity.setLast_name(person.getLast_name());

		return personEntity;

	}


}
