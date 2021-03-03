package com.example.demo.controller;

import java.util.List;

import com.example.demo.impl.PersonDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.Person;

@RestController
@RequestMapping("/v1")
public class PersonController {

	@Autowired
	PersonDetailsImpl personDetails;

	@GetMapping("/getAllPerson")
	public ResponseEntity<List<Person>> fetchAllPersonDetails(){
		return new ResponseEntity(personDetails.getAllPersons(), HttpStatus.OK);
		
	}
	
	@PostMapping("/addPerson")
	public ResponseEntity<Long> addPersonDetail(@RequestBody Person p){
		return new ResponseEntity(personDetails.addPerson(p), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatePerson")
	public ResponseEntity<Long> updatePersonDetail(@RequestBody Person p){

		return new ResponseEntity(personDetails.updatePerson(p), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removePerson/{id}")
	public ResponseEntity<Long> removePersonDetail(@PathVariable Long id) {

		return new ResponseEntity(personDetails.deletePerson(id), HttpStatus.OK);
		
	}
}
