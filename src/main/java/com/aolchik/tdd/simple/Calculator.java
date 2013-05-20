package com.aolchik.tdd.simple;

public class Calculator {
	public double result() {
		return this.result;
	}

	public void enter(double num) {
		this.result = num;
	}

	private double result;
}
