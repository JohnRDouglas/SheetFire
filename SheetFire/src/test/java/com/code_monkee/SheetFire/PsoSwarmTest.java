package com.code_monkee.SheetFire;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import com.code_monkee.psolib.PsoContext;
import com.code_monkee.psolib.PsoParticle;
import com.code_monkee.psolib.PsoSwarm;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.code_monkee.psolib")
@Configuration
@EnableAutoConfiguration
public class PsoSwarmTest {

	@Autowired
	PsoContext psoctx;
	
	@Before
	public void setup() {
		List<PsoSwarm> swarms = new ArrayList<PsoSwarm>();
		PsoSwarm swarm =  new PsoSwarm();
		
		psoctx.setSwarms(swarms);
	}
	
	@Test
	public void InitSwarm() {
		PsoSwarm swarm = new PsoSwarm();
		Random rnd = new Random();
		List<PsoParticle> particles = new ArrayList<PsoParticle>();
		PsoParticle p;
		for(int i=0; i < 12; i++) {
			p = new PsoParticle();
			List<Object> x = new ArrayList<Object>();
			x.add(rnd.nextDouble());
			x.add(rnd.nextDouble());
			p.setValues(x);
			particles.add(p);
		}
		
		p = particles.get(0);
		assertTrue(p.getValues().size() == 2);
	}

}
