package com.code_monkee.SheetFire;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import com.code_monkee.psolib.PsoContext;
import com.code_monkee.psolib.PsoSwarm;
import com.code_monkee.psolib.SwarmAttributes;

public class ApplicationTest {

	@Autowired PsoContext psoCtx;

	@Before
	public void init() {
		if(psoCtx == null) {
			psoCtx = new PsoContext();
			SwarmAttributes attrib =
					new SwarmAttributes( 1, //int swarmCount, 
							15, //int particleCount, 
							2, //int particleLength,
							new double[]{10, 10}, //double[] upperBounds, 
							new double[]{-10, -10}); // double[] lowerBounds);
			psoCtx.addSwarm(new PsoSwarm(attrib));
		}
	}

	@Test public void TestInit() {
		assertTrue(psoCtx != null);
	}

	@Test public void makeSwarm_test() {
		SwarmAttributes attrib =
				new SwarmAttributes( 1, //int swarmCount, 
						15, //int particleCount, 
						2, //int particleLength,
						new double[]{10, 10}, //double[] upperBounds, 
						new double[]{-10, -10}); // double[] lowerBounds);
		psoCtx.addSwarm(new PsoSwarm(attrib));


	}
}
