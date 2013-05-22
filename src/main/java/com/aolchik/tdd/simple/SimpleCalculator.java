package com.aolchik.tdd.simple;

public class SimpleCalculator implements Calculator {

	public double result() {
		return this.result;
	}

	public double enter(double num) {
		return (this.result = num);
	}

	public double add(double numToAdd) {
		return (this.result += numToAdd);
	}

	private double result;

}
