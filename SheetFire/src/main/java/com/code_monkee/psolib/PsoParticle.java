package com.code_monkee.psolib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class PsoParticle {
	@Autowired PsoContext psoContext;
	@Autowired double[] gBestValues;
	@Autowired double gBestScore;

	double[] values;
	double[] velocities;
	double[] pBestValues;
	double score = Double.MAX_VALUE;
	double pBestScore = Double.MAX_VALUE;
	SwarmAttributes attributes;
	Random random = new Random();

	public PsoParticle() { 

	}

	public PsoParticle(SwarmAttributes attributes) {
		this.attributes=attributes;
		setParticleDimension(attributes.getUpperBounds().length);
		this.pBestValues = values.clone();
	}

	public void setParticleDimension(int length) {
		values = new double[length];
		velocities = new double[length];
		for(int i=0; i < length; i++) {
			values[i] = attributes.getLowerBounds()[i] + 
					random.nextDouble() * 
					(attributes.getUpperBounds()[i] - attributes.getLowerBounds()[i]);
			velocities[i] = 0;
		}
	}

	public void run() {

		for(int i=0; i < values.length; i++) {
			double x = values[i];
			double v = velocities[i];
			double[] weights = SwarmAttributes.getRunWeights();
			double w = weights[0];
			double c1 = weights[1];
			double c2 = weights[2];
			
			v = v*(.5 + random.nextDouble()/2) + c1*random.nextDouble()*(pBestValues[i] - x)
					+ c2*random.nextDouble()*(gBestValues[i] - x);
			x += v;

			if(x > attributes.getUpperBounds()[i] ||
					x < attributes.getLowerBounds()[i]) {
				x = attributes.getLowerBounds()[i] + 
						random.nextDouble() * 
						(attributes.getUpperBounds()[i] - attributes.getLowerBounds()[i]);
			}
			values[i] = x;
			velocities[i] = v;
		}
	}

	public void setValues(double[] values) {
		this.values = values;
	}

	public double[] getValues() {
		return this.values;
	}

	public void setPsoContext(PsoContext psoContext) {
		this.psoContext = psoContext;
	}

	public double[] getgBestValues() {
		return gBestValues;
	}

	public void setgBestValues(double[] gBestValues) {
		this.gBestValues = gBestValues;
	}

	public double[] getVelocities() {
		return velocities;
	}

	public void setVelocities(double[] velocities) {
		this.velocities = velocities;
	}

	public double[] getpBestValues() {
		return pBestValues;
	}

	public void setpBestValues(double[] pBestValues) {
		this.pBestValues = pBestValues;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
		if(score < pBestScore) {
			pBestScore = score;
			pBestValues = values.clone();
		}
	}

	public double getpBestScore() {
		return pBestScore;
	}

	public SwarmAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(SwarmAttributes attributes) {
		this.attributes = attributes;
	}

	public PsoContext getPsoContext() {
		return psoContext;
	}

	public void setgBestScore(double gBestScore) {
		// TODO Auto-generated method stub
		this.gBestScore = gBestScore;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb.append("[");
		// Current Values
		for(int i=0; i< values.length; i++) {
			Double v = values[i];
			sb.append(v.toString());
			Double v2 = pBestValues[i];
			sb2.append(v2.toString());
			
			if(i < values.length) {
				sb.append(", ");
				sb2.append(", ");
			}
		}
		sb.append("|");
		sb.append(sb2.toString());
		sb.append("|" + ((Double)score).toString() );
		sb.append("|" + ((Double)pBestScore).toString() ); 
		sb.append("]");
		return sb.toString();
	}
}
