package com.code_monkee.psolib;

import java.util.List;

import org.springframework.stereotype.Component;
import com.code_monkee.psolib.PsoParticle;

public class PsoSwarm {

	List<PsoParticle> particles;
	
	public List<PsoParticle> getParticles() {
		return particles;
	}
	
	public void setParticles(List<PsoParticle> particles) {
		this.particles = particles;
	}
}
