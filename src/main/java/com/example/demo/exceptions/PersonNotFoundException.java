package com.example.demo.exceptions;

public class PersonNotFoundException extends  RuntimeException {
    public PersonNotFoundException(Long id) {

        super(String.format("Person with Id %d not found", id));
    }
}
