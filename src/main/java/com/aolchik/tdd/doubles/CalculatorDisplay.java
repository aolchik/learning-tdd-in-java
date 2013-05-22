package com.aolchik.tdd.doubles;

import com.aolchik.tdd.simple.Calculator;

public class CalculatorDisplay {
	
	public CalculatorDisplay (Calculator calc) {
		this.calculator = calc;
	}
	
	public void setThousandSeparator(char separator) {}
	
	public String show() { return "Error"; }

	private Calculator calculator;
	
}
