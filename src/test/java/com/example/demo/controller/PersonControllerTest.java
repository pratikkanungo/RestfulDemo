package com.example.demo.controller;


import com.example.demo.AbstractTest;
import com.example.demo.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class PersonControllerTest extends AbstractTest {



    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testGetAllPersons() throws Exception {
        String uri = "/v1/getAllPerson/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Person[] persons = super.mapFromJson(content, Person[].class);
        assertTrue(persons.length > 0);
    }
    @Test
    public void addPerson() throws Exception {
        String uri = "/v1/addPerson";
        Person person = new Person();
        person.setLast_name("jhonny");
        person.setFirst_name("depp");
        person.setAge("32");
        person.setFavourite_colour("Blue");
        person.setNationality("British");
        String inputJson = super.mapToJson(person);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }
    @Test
    public void updateProduct() throws Exception {
        String uri = "/v1/updatePerson";
        Person person = new Person();
        person.setId(1L);
        person.setFirst_name("Bob");
        person.setAge("23");
        person.setFavourite_colour("Pink");
        person.setLast_name("jill");
        String inputJson = super.mapToJson(person);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "1");
    }
    @Test
    public void deleteProduct() throws Exception {
        String uri = "/v1/removePerson/1";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "1");
    }
}

