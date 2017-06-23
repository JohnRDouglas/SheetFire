package com.code_monkee.SheetFire.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weapon {
	@Id
	String name;
	Integer Damage;
	
	public Weapon() { }
	
	public Integer getDamage() {
		return Damage;
	}

	public void setDamage(Integer damage) {
		Damage = damage;
	}

	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
}
