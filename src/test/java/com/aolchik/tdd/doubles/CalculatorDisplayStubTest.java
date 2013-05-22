package com.aolchik.tdd.doubles;

import static org.junit.Assert.*;
import com.aolchik.tdd.simple.Calculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorDisplayStubTest {

	@Before
	public void setUp() {
		this.calc = new StubCalculator();
		this.display = new CalculatorDisplay((Calculator) calc);
	}
	
	@Test
	public void showsDefaultSeparator() {
		calc.enter(100.0);
		assertEquals("standard decimal separator", "100.0", display.show());

		calc.enter(1000.0);
		assertEquals("no standard thousand separator", "1000.0", display.show());
	}
		
	@Ignore
	@Test
	public void showsAlternateSeparators() {
		
		String thousandSeparator = ".";
		String decimalSeparator = ",";
		display.setSeparators(thousandSeparator, decimalSeparator);

		calc.enter(100.0);
		assertEquals("decimal separator change", "100,0", display.show());
		
		calc.enter(1000.0);
		assertEquals("single thousand separator", "1.000,0", display.show());

		calc.enter(1000000000.0);
		assertEquals("multiple thousand separators", "1.000.000.000,0", 
				display.show());

		calc.enter(-45000.0);
		assertEquals("thousand separator on negative numbers", "-45.000,0",
				display.show());
	}


	@Ignore
	@Test
	public void roundsBySpecificNumberOfDigits() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void showsHexadecimalRepresentation() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void showsBinaryRepresentation() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void showsScientificRepresentation() {
		fail("Not yet implemented");
	}

	private CalculatorDisplay display;
	private StubCalculator calc;
	
	class StubCalculator implements Calculator {
		public double result() {
			return this.desiredResult;
		}
	
		public double enter(double result) {
			return (this.desiredResult = result);
		}
	
		private double desiredResult;
	}
}
