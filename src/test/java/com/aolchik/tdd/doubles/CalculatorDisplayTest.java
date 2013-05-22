package com.aolchik.tdd.doubles;

import static org.junit.Assert.*;
import com.aolchik.tdd.simple.Calculator;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorDisplayTest {

	@Test
	public void showsSeparatorsUsingStubs() {

		class StubCalculator implements Calculator {
			public double result() {
				return this.desiredResult;
			}

			public double enter(double result) {
				return (this.desiredResult = result);
			}

			private double desiredResult;
		}

		StubCalculator calc = new StubCalculator();
		CalculatorDisplay display = new CalculatorDisplay((Calculator) calc);

		calc.enter(100.0);
		assertEquals("standard decimal separator", "100.0", display.show());

		calc.enter(1000.0);
		assertEquals("no standard thousand separator", "1000.0", display.show());

		
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
	public void showsSeparatorsUsingMocks() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void roundsBySpecificNumberOfDigitsUsingStubs() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void roundsBySpecificNumberOfDigitsUsingMocks() {
		fail("Not yet implemented");
	}

	
	@Ignore
	@Test
	public void showsHexadecimalRepresentationUsingStubs() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void showsHexadecimalRepresentationUsingMocks() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void showsBinaryRepresentationUsingMocks() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void showsScientificRepresentationUsingStubs() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void showsScientificRepresentationUsingMocks() {
		fail("Not yet implemented");
	}


}
