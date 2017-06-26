package com.code_monkee.psolib;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PsoParticle {
	@Autowired PsoContext psoCtx;
	@Autowired PsoParticle gBest;
	PsoParticle pBest;

	double[] values;
	double[] velocities;
	PsoSwarm swarm;
	SwarmAttributes attributes;
	Random random = new Random();

	public PsoParticle() { 
		// just default to a 2-n array
	}

	public PsoParticle(SwarmAttributes attributes) {
		this.attributes=attributes;
		setSize(attributes.getUpperBounds().length);
		pBest = new PsoParticle();
		pBest.setValues(values);

	}

	public void setSize(int size) {
		values = new double[size];
		velocities = new double[size];
		for(int i=0; i < size; i++) {
			if(attributes.getLowerBounds() == null) {
				values[i] = 0;
				velocities[i] = 0;
			} else {
				values[i] = values[i] < attributes.getLowerBounds()[i] ? attributes.getLowerBounds()[i] : values[i];
				velocities[i] = velocities[i] < attributes.getLowerBounds()[i] ? attributes.getLowerBounds()[i] : velocities[i];
			}
			
			if(attributes.getUpperBounds() == null) {
				values[i] = 0;
				velocities[i] = 0;
			} else {
				values[i] = values[i] < attributes.getUpperBounds()[i] ? attributes.getUpperBounds()[i] : values[i];
				velocities[i] = velocities[i] < attributes.getUpperBounds()[i] ? attributes.getUpperBounds()[i] : velocities[i];
			}
		}
	}

	public void run() {

		for(int i=0; i < values.length; i++) {
			double x = values[i];
			double v = velocities[i];
			double[] weights = psoCtx.getWeights();
			double w = weights[0];
			double c1 = weights[1];
			double c2 = weights[2];
			double[] pBestValues = pBest.getValues();
			double[] gBestValues = gBest.getValues(); 

			v = v*w + c1*random.nextDouble()*(pBestValues[i] - x)
					+ c2*random.nextDouble()*(gBestValues[i] - x);
			x += v;
			if(x > attributes.getUpperBounds()[i]) {
				x = attributes.getUpperBounds()[i];
			}
			if(x < attributes.getLowerBounds()[i]) {
				x = attributes.getLowerBounds()[i];
			}
		}
	}

	public void setValues(double[] values) {
		this.values = values;
	}

	public double[] getValues() {
		return this.values;
	}
}
