package com.aolchik.tdd.integration;

import static org.junit.Assert.fail;

import java.util.Properties;

import com.aolchik.tdd.doubles.CalculatorDisplay;
import com.aolchik.tdd.simple.CalculatorEngine;
import com.aolchik.tdd.simple.BasicCalculatorEngine;

public class PersistedPropertiesCalculator {
	
	public PersistedPropertiesCalculator(String filename) {
		this.calc = new BasicCalculatorEngine();
		this.display = new CalculatorDisplay(this.calc);
	}
	
	public void saveProperties() {
		fail("Not yet implemented!");
	}
	
	public Properties getProperties() {
		fail("Not yet implemented!");
		return null;
	}
	
	private CalculatorEngine calc;
	private CalculatorDisplay display;
}
