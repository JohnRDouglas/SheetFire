package com.code_monkee.psolib;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.code_monkee.psolib.PsoParticle;

public class PsoSwarm {

	@Autowired PsoContext psoContext;
	List<PsoParticle> particles = new ArrayList<PsoParticle>();
	SwarmAttributes attributes;
	private Random random = new Random();
	@Autowired double gBestScore;
	@Autowired double[] gBestValues;
	
	public PsoSwarm(SwarmAttributes attributes) {
		this.attributes = attributes;
		double[] scores = new double[attributes.getParticleCount()];
		for(int i=0; i < attributes.getParticleCount(); i++) {
			PsoParticle p = new PsoParticle(attributes);
			addParticle(p);
			scores[i] = Double.MAX_VALUE;
		}
		
		gBestValues = particles.get(0).getValues();
		gBestScore = Double.MAX_VALUE;
		setScores(scores);
	}

	public void addParticle(PsoParticle particle) {
		PsoParticle p = particle;
		p.setPsoContext(this.psoContext);
		this.particles.add(p);
	}
	
	public List<PsoParticle> getParticles() {
		return particles;
	}
	
	public void setParticles(List<PsoParticle> particles) {
		this.particles = particles;
	}
	
	public void fly() {
		for(int i=0; i < particles.size(); i++) {
			PsoParticle p = particles.get(i);
			p.run();
		}
	}
	
	// This will calculate the scores and set the Global Best
	// Each particle will be responsible for updating its best
	// Each particle will be responsible for updating gBest
	public double[] getScores() {
		double[] scores = new double[particles.size()];
		for(int i=0; i<particles.size();i++) {
			PsoParticle p = particles.get(i);
			scores[i] = p.getScore();
		}
		return scores;
	}
	
	// SetScores responsible for updating particle scores,
	// setting gBestScore and gBestValues
	// Particles will be responsible for updating their pBestScores/Values
	public void setScores(double[] scores) {
		if (scores.length != particles.size()) {
			return;
		}
		
		for(int i=0; i<particles.size(); i++) {
			PsoParticle p = particles.get(i);
			if(scores[i] < gBestScore) {
				gBestScore = scores[i];
				gBestValues = p.getValues().clone();
				
			}
			p.setScore(scores[i]);
			p.setgBestValues(gBestValues);
			p.setgBestScore(gBestScore);
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

	
	public double getBestScore() {
		// TODO Auto-generated method stub
		return gBestScore;
	}
	
	public void setBestScore(double score) {
		gBestScore = score;
	}
	
	public double[] getBestValues() {
		return gBestValues;
	}
	
	public void setBestValues(double[] values) {
		gBestValues = values;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i=0; i < particles.size(); i++) {
			PsoParticle p = particles.get(i);
			sb.append(String.format("%03d", i) + ": " + p.toString());
			if(i < particles.size() - 1) {
				sb.append("; ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
