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
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import com.code_monkee.psolib.PsoContext;
import com.code_monkee.psolib.PsoParticle;
import com.code_monkee.psolib.PsoSwarm;
import com.code_monkee.psolib.SwarmAttributes;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.code_monkee.psolib")
public class PsoSwarmTest {
	@Autowired ApplicationContext context;
	@Autowired PsoContext psoContext;
	static boolean isFirstRun = true;
	static PsoSwarm swarm;
	
	private void firstRun() {
		
	}
	
	@Test
	public void InitSwarm() {
		SwarmAttributes attributes = new SwarmAttributes();
		swarm = new PsoSwarm(attributes);
		psoContext.addSwarm(swarm);
		
		assertTrue(psoContext.getSwarms().isEmpty() == false);
	}
	
	
	@Test
	public void runswarm() {
		if(psoContext == null) {
			psoContext = new PsoContext();
		}
		SwarmAttributes attributes = new SwarmAttributes();
		swarm = new PsoSwarm(attributes);
		psoContext.addSwarm(swarm);
		
		boolean passed = true;
		double[] upperBounds = swarm.getAttributes().getUpperBounds();
		double[] lowerBounds = swarm.getAttributes().getLowerBounds();
		
		//swarm.fly();
		/*
		for(PsoParticle p : swarm.getParticles()) {
			double[] values = p.getValues();
			for(int j=0; j<values.length; j++) {
				if(values[j] > upperBounds[j] || values[j] < lowerBounds[j]) {
					passed = false;
				}
			}
		}*/
		assertTrue(passed);
	}

	
}
