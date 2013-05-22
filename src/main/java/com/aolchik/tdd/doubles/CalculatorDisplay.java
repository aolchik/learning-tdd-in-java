package com.aolchik.tdd.doubles;

import com.aolchik.tdd.simple.Calculator;

public class CalculatorDisplay {
	
	public CalculatorDisplay (Calculator calc) {
		this.calculator = calc;
	}
	
	public void setSeparators(String thousands, String decimals) {
		this.thousandSeparator = thousands;
		this.decimalSeparator = decimals;
	}
	
	public String show() { 
		return String.valueOf(calculator.result());
	}

	private Calculator calculator;
	private String thousandSeparator;
	private String decimalSeparator;
	
}
