package com.aolchik.tdd.doubles;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.aolchik.tdd.simple.Calculator;

public class CalculatorDisplay {
	
	public CalculatorDisplay (Calculator calc) {
		this.calculator = calc;
		this.formatter = new DecimalFormat(DEFAULT_FORMATTING_PATTERN);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		decimalSeparator = DEFAULT_DECIMAL_SEPARATOR;
		dfs.setDecimalSeparator(decimalSeparator.charAt(0));
		//@TODO: throw exception when decimal separator is larger than one
		this.formatter.setDecimalFormatSymbols(dfs);
	}
	
	public void setSeparators(String thousands, String decimals) {
		this.thousandSeparator = thousands;
		this.decimalSeparator = decimals;
	}
	
	public String show() { 
		return formatter.format(calculator.result());
	}

	private static final String DEFAULT_FORMATTING_PATTERN = "#.00";
	private static final String DEFAULT_DECIMAL_SEPARATOR = ".";
	
	private Calculator calculator;
	private String thousandSeparator;
	private String decimalSeparator;
	private DecimalFormat formatter;
	
}
