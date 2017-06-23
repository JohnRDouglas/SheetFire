package com.code_monkee.psolib;

import java.util.List;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.springframework.stereotype.Component;

@Component
public class PsoContext {
	List<PsoSwarm> swarms;
	
	public PsoContext() {
		
	}
	
	public List<PsoSwarm> getSwarms() {
		return this.swarms;
	}
	
	public void setSwarms(List<PsoSwarm> swarms) {
		this.swarms = swarms;
	}
}