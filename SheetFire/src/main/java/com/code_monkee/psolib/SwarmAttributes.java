package com.code_monkee.psolib;

public class SwarmAttributes {
	private int swarmCount;
	private int particleCount;
	private int particleLength;
	private double[] upperBounds;
	private double[] lowerBounds;
	
	private static final double[] runWeights = new double[]{0.7,1.54,1.54};
	
	public SwarmAttributes(int swarmCount, int particleCount, int particleLength,
			double[] upperBounds, double[] lowerBounds) {
		this.swarmCount = swarmCount;
		this.particleCount = particleCount;
		this.particleLength = particleLength;
		this.upperBounds = upperBounds;
		this.lowerBounds = lowerBounds;

	}
	
	public SwarmAttributes() {
		this.swarmCount = 1;
		this.particleCount = 10;
		this.particleLength = 2;
		this.upperBounds = new double[]{1, 1};
		this.lowerBounds = new double[]{-1, -1};
	}
	
	public int getSwarmCount() {
		return swarmCount;
	}

	public void setSwarmCount(int swarmCount) {
		this.swarmCount = swarmCount;
	}

	public int getParticleCount() {
		return particleCount;
	}

	public void setParticleCount(int particleCount) {
		this.particleCount = particleCount;
	}

	public int getParticleLength() {
		return particleLength;
	}

	public void setParticleLength(int particleLength) {
		this.particleLength = particleLength;
	}

	public double[] getUpperBounds() {
		return upperBounds;
	}

	public void setUpperBounds(double[] upperBounds) {
		this.upperBounds = upperBounds;
	}

	public double[] getLowerBounds() {
		return lowerBounds;
	}

	public void setLowerBounds(double[] lowerBounds) {
		this.lowerBounds = lowerBounds;
	}

	
	
	public boolean goodSetup() {
		if(particleLength != upperBounds.length || particleLength != lowerBounds.length) {
			return false;
		}
		return true;

	
	}

	public static double[] getRunWeights() {
		return runWeights;
	}
}
