package com.aolchik.tdd.doubles;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.aolchik.tdd.simple.Calculator;

public class CalculatorDisplay {
	
	public CalculatorDisplay (Calculator calc) {
		this.calculator = calc;
		
		setSeparators(DEFAULT_THOUSAND_SEPARATOR, DEFAULT_DECIMAL_SEPARATOR);
	}
	
	public void setSeparators(String thousands, String decimals) {
		setFormatter(DEFAULT_FORMATTING_PATTERN, thousands, decimals);
	}
	
	public String show() { 
		return formatter.format(calculator.result());
	}

	private static final String DEFAULT_FORMATTING_PATTERN = "#,###.00";
	private static final String DEFAULT_DECIMAL_SEPARATOR = ".";
	private static final String DEFAULT_THOUSAND_SEPARATOR = ",";
	
	private Calculator calculator;
	private DecimalFormat formatter;

	private void setFormatter(String formattingPattern, String thousands, String decimalSeparator) {
		this.formatter = new DecimalFormat(formattingPattern);

		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(decimalSeparator.charAt(0));
		assert(decimalSeparator.length() == 1) : "Decimal separator has more than one character!";

		if(thousands != null && thousands.length() > 0) {
			dfs.setGroupingSeparator(thousands.charAt(0));
			assert(thousands.length() == 1) : "Thousand separator has more than one character!";
		}

		this.formatter.setDecimalFormatSymbols(dfs);
	}

	
}
