package com.code_monkee.SheetFire.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skill {
	@Id
	String name;
	Integer rating;
	
	public Skill() {};
	
	public Skill(String name, Integer rating) {
		this.name = name;
		this.rating = rating;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getRating() {
		return this.rating;
	}
}
