package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"nationality"})
public class Person {

	private long id;
	@NonNull
	private String first_name;
	@NonNull
	private String last_name;
	@NonNull
	private String age;
	@NonNull
	private String favourite_colour;

	 private String nationality;

}
