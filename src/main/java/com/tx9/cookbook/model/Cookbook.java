package com.tx9.cookbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // creates a class constructor with all arguments (properties)
@NoArgsConstructor // creates an empty class constructor with all arguments (properties)
@Data //creates toString, equals, hashCode, getters and setters
@Entity
public class Cookbook {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
}
