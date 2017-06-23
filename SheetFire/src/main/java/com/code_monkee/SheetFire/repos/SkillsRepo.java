package com.code_monkee.SheetFire.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.code_monkee.SheetFire.entities.Skill;

public interface SkillsRepo extends CrudRepository<Skill, Long> {
	List<Skill> findByName(String name);
	
}
