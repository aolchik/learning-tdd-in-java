package com.aolchik.tdd.doubles;

import static org.junit.Assert.*;
import com.aolchik.tdd.simple.Calculator;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorDisplayTest {

	@Test
	public void showsThousandsSeparatorUsingStubs() {

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

		display.setThousandSeparator('.');
		calc.enter(100);
		assertEquals("no thousand separator", display.show(), "100");

		calc.enter(1000);
		assertEquals("single thousand separator", display.show(), "1.000");

		calc.enter(1000000000);
		assertEquals("multiple thousand separators", display.show(),
				"1.000.000.000");

		calc.enter(-45000);
		assertEquals("thousand separator on negative numbers", display.show(),
				"-45.000");
	}

	@Ignore
	@Test
	public void showsDecimalSeparator() {
		fail("Not yet implemented");
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
	public void showsDecimalRepresentation() {
		fail("Not yet implemented");
	}
}
