package com.code_monkee.psolib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.code_monkee.psolib.PsoParticle;

public class PsoSwarm {

	@Autowired PsoContext psoContext;
	List<PsoParticle> particles = new ArrayList<PsoParticle>();
	SwarmAttributes attributes;
	private Random random = new Random();
	
	public PsoSwarm(SwarmAttributes attributes) {
		this.attributes = attributes;
		for(int i=0; i < attributes.getParticleCount(); i++) {
			double[] values = new double[attributes.getUpperBounds().length]; 
			
			for(int j=0; j < attributes.getUpperBounds().length; j++) {
				double nd = random.nextDouble();
				values[j] = attributes.getLowerBounds()[j] + 
						(attributes.getUpperBounds()[j] - 
								attributes.getLowerBounds()[j]) * 
						nd;
			}
			
			PsoParticle p = new PsoParticle(attributes);
			p.setValues(values);
			this.particles.add(p);
		}
	}

	public List<PsoParticle> getParticles() {
		return particles;
	}
	
	public void setParticles(List<PsoParticle> particles) {
		this.particles = particles;
	}
	
	public void fly() {
		for(int i=0; i < particles.size(); i++) {
			particles.get(i).run();
		}
	}
	
	public SwarmAttributes getAttributes() {
		return this.attributes;
	}

	public PsoContext getPsoContext() {
		return psoContext;
	}

	public void setPsoContext(PsoContext psoContext) {
		this.psoContext = psoContext;
	}
}
