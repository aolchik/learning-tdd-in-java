package com.aolchik.tdd.integration;

import java.util.Properties;

import com.aolchik.tdd.doubles.CalculatorDisplay;
import com.aolchik.tdd.simple.BasicCalculatorEngine;
import com.aolchik.tdd.simple.CalculatorEngine;

public class PersistedPropertiesCalculator {
	
	public PersistedPropertiesCalculator(String filename) {
		this.calc = new BasicCalculatorEngine();
		this.display = new CalculatorDisplay(this.calc);
	}
	
	public void saveProperties() {
		// Fail fast strategy.
		// By default maven executes with assertion enabled (options -ea)
		assert false : "Not yet implemented!";
	}
	
	public Properties getProperties() {
		assert false : "Not yet implemented!";
		return null;
	}
	
	private CalculatorEngine calc;
	private CalculatorDisplay display;
}
