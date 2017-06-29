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
	List<PsoSwarm> swarms = new ArrayList<PsoSwarm>();

	public PsoContext() {

	}

	public void flySwarms() {
		for(int i=0; i < swarms.size(); i++) {
			PsoSwarm s = swarms.get(i);
			s.fly();
		}
	}
	
	public PsoSwarm makeSwarm(SwarmAttributes attributes) {
		PsoSwarm s = new PsoSwarm(attributes);
		this.addSwarm(s);
		return new PsoSwarm(attributes);
	}

	// Preferred method for adding a Swarm
	public void addSwarm(PsoSwarm s) {
		s.setPsoContext(this);
		this.swarms.add(s);
	}

	public List<PsoSwarm> getSwarms() {
		return swarms;
	}

	public void setSwarms(List<PsoSwarm> swarms) {
		this.swarms = new ArrayList<PsoSwarm>();
		for(PsoSwarm s : swarms) {
			this.addSwarm(s);
		}
	}

	public void setSwarm(PsoSwarm psoSwarm) {
		this.swarms = new ArrayList<PsoSwarm>();
		this.swarms.add(psoSwarm);
	}

}