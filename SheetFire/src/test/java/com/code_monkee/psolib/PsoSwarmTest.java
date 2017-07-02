package com.code_monkee.psolib;

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
		SwarmAttributes attributes = new SwarmAttributes();
		attributes.setParticleCount(10);
		attributes.setParticleLength(2);
		attributes.setLowerBounds(new double[] {-10, -10});
		attributes.setUpperBounds(new double[] {10, 10});

		swarm = new PsoSwarm(attributes);
		if(psoContext == null) {
			psoContext = new PsoContext();

		}
		psoContext.addSwarm(swarm);
	}

	@Before
	public void startUp() {
		if(swarm == null) {
			firstRun();
		}
	}
	@Test
	public void test_Persistent_Swarm() {
		assertTrue(psoContext.getSwarms().isEmpty() == false);
	}
	@Test
	public void InitSwarm() {
		SwarmAttributes attributes = new SwarmAttributes();
		swarm = new PsoSwarm(attributes);
		psoContext.addSwarm(swarm);

		assertTrue(psoContext.getSwarms().isEmpty() == false);
	}


	/*@Test
	public void runswarm() {
		if(psoContext == null) {
			psoContext = new PsoContext();
		}
		
		SwarmAttributes attributes = new SwarmAttributes();
		swarm = new PsoSwarm(attributes);
		psoContext.addSwarm(swarm);

		outputSwarm();

		for(int i = 0; i < 100; i++) {
			System.out.println("Fliegen! " + i);
			swarm.fly();
			outputSwarm();
		}

		boolean passed = true;
		double[] upperBounds = swarm.getAttributes().getUpperBounds();
		double[] lowerBounds = swarm.getAttributes().getLowerBounds();
		for(PsoParticle p : swarm.getParticles()) {
			double[] values = p.getValues();
			for(int j=0; j<values.length; j++) {
				if(values[j] > upperBounds[j] || values[j] < lowerBounds[j]) {
					passed = false;
				}
			}
		}
		assertTrue(passed);
	}
	*/

	private void outputSwarm() {
		for(PsoParticle p : swarm.getParticles()){
			System.out.println("X, Y " + p.getValues()[0] + ", " + p.getValues()[1] +
					" Score: " + p.getScore() + " pBest: " + p.getpBestScore());
		}
	}
	/*
	//@Test
	public void TEst_Fitnesses() {
		double[] particleScores = new double[swarm.getParticles().size()];
		for(int i=0; i < swarm.getParticles().size(); i++) {
			PsoParticle p = swarm.getParticles().get(i);
			particleScores[i] = Math.sqrt(Math.pow(p.getValues()[0], 2) + Math.pow(p.getValues()[1], 2));
			System.out.println("Score " + particleScores[i]);
			System.out.println("Gbest: " + swarm.getBestScore());
		}

	}
	*/
	
	// BYOFF: The program using PsoLibrary is responsible for 
	// calculating the score of each particle. 
	// 
	@Test
	public void Fly_and_set_scores_test() {
		double[] scores = scoreSwarm(swarm);

		for(int i = 0; i < 10; i++) {
			swarm.fly();
			scores = scoreSwarm(swarm);
			swarm.setScores(scores);
		}
		System.out.println("BestScore: " + swarm.getBestScore());
		System.out.println("GBestValues: " + swarm.getBestValues()[0] + ", " +
				swarm.getBestValues()[1]);
	}

	double[] scoreSwarm(PsoSwarm swarm) {
		List<Double> scores = new ArrayList<Double>();
		for(PsoParticle p : swarm.getParticles()) {
			scores.add( Math.sqrt(Math.pow(p.getValues()[0], 2) +
					Math.pow(p.getValues()[1], 2)));
		}

		return scores.stream().mapToDouble(Double::doubleValue).toArray();
	}
	
	@Test
	public void Play_With_The_Settings() {
		SwarmAttributes attributes = new SwarmAttributes();
		attributes.setParticleCount(20);
		attributes.setParticleLength(2);
		attributes.setLowerBounds(new double[] {-10, -10});
		attributes.setUpperBounds(new double[] {10, 10});

		swarm = new PsoSwarm(attributes);
		if(psoContext == null) {
			psoContext = new PsoContext();

		}
		psoContext.addSwarm(swarm);

		double[] scores = scoreSwarm(swarm);
		for(int i = 0; i < 100; i++) {
			swarm.fly();
			scores = scoreSwarm(swarm);
			swarm.setScores(scores);
		}
		System.out.println("BestScore: " + swarm.getBestScore());
		System.out.println("GBestValues: " + swarm.getBestValues()[0] + ", " +
				swarm.getBestValues()[1]);
	}
}
