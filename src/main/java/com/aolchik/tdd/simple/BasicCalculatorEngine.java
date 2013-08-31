package com.aolchik.tdd.simple;

public class BasicCalculatorEngine implements CalculatorEngine {

	public double result() {
		return this.result;
	}

	public double enter(double num) {
		return (this.result = num);
	}

	public double add(double numToAdd) {
		return (this.result += numToAdd);
	}

	public double multiply(double numToMultiply) {
		return (this.result *= numToMultiply);
	}

	private double result;


}
