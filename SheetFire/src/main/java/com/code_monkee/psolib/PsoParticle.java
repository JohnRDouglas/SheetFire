package com.code_monkee.psolib;

import java.util.List;

public class PsoParticle {
	List<Object> values;
	
	public PsoParticle() { }
	
	public List<Object> getValues() {
		return values;
	}
	
	public void setValues(List<Object> values) {
		this.values = values;
	}
	
	public void run() {
		for(int i=0; i< values.size(); i++) {
			
		}
	}
	
}
