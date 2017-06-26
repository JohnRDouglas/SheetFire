package com.code_monkee.psolib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PsoContext {
	private Random random = new Random();
	double[] runWeights = new double[]{.7,1.4,1.4};
	
	List<PsoSwarm> swarms = new ArrayList<PsoSwarm>();
	
	public PsoSwarm makeSwarm(SwarmAttributes attributes) {
		PsoSwarm s = new PsoSwarm(attributes);
		s.setPsoContext(this);
		this.addSwarm(s);
		return new PsoSwarm(attributes);
	}
	
	public void addSwarm(PsoSwarm s) {
		
		this.swarms.add(s);
		s.setPsoContext(this);
	}
	public List<PsoSwarm> getSwarms() {
		return swarms;
	}
	
	public void setSwarms(List<PsoSwarm> swarms) {
		this.swarms = swarms;
	}

	public double[] getWeights() {
		// TODO Auto-generated method stub
		return this.runWeights;
	}

	public void setSwarm(PsoSwarm psoSwarm) {
		this.swarms = new ArrayList<PsoSwarm>();
		this.swarms.add(psoSwarm);
	}
	
}