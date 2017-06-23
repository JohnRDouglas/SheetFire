package com.code_monkee.SheetFire.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.code_monkee.SheetFire.entities.Weapon;

public interface WepsRepo extends CrudRepository<Weapon, Long> {
	public List<Weapon> findByName(String name);
}
