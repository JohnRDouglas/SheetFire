package com.code_monkee.SheetFire;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.code_monkee.SheetFire.entities.Skill;
import com.code_monkee.SheetFire.entities.Character;
import com.code_monkee.SheetFire.repos.SkillsRepo;
import com.code_monkee.SheetFire.repos.WepsRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SheetFireApplicationTests {
		
	private static final Logger log = LoggerFactory.getLogger(SheetFireApplication.class);

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	SkillsRepo skillsRepo;
	
	@Autowired
	WepsRepo wepsRepo;
	
	@Before
	public void contextLoads() {
		skillsRepo.save(new Skill("Null", 0));
		skillsRepo.save(new Skill("First", 1));		
	}

	@Test
	public void runFalse() {
		assertEquals(true, true);
	}
	
	@Test
	public void MakeCustomers() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < 3; i++) {
			
			sb.append("a");
			repository.save(new Customer(sb.toString(), sb.toString()));
		}
		
		String ln = repository.findByLastName("a").toString();
		System.out.println(ln);
	}
	
	@Test
	public void GetBeans() {		
		for(Customer cs : repository.findAll()) {
			String ln = cs.toString();
			System.out.println(ln);
		}
	}
	
	@Test
	public void testSkills() {
		
		assertTrue(skillsRepo.count() > 0);
	}
	
	@Test
	public void testCharacter() {
		Character c = new Character();
		Random rnd = new Random();
		
		c.setAgi(rnd.nextInt(6)+1);
			assertTrue(c.getAgi() <= 6);
	}
	
	/*
	public void GiveCharacterSkills() {
		Character c = new Character();
		
		c.setSkillsRepo(skillsRepo);
		
		SkillsRepo newSR = c.getSkillsRepo();
		assertTrue(newSR.count() > 0);
		for(Skill s : newSR.findAll()) {
			System.out.println("Char Skills" + s.getName() + s.getRating());
		}
	}
	*/
	
	@Test
	public void Really_Give_character_skills() {
		Character c = new Character();
		List<Skill> skills = (List<Skill>) skillsRepo.findAll();
		c.setSkills(skills);
		assertTrue(!c.getSkills().isEmpty());
	}
	
	
}
