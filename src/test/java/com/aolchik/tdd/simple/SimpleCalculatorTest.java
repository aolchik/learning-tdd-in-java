package com.aolchik.tdd.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SimpleCalculatorTest {

	@Before
	public void setUp() {
		this.calc = new SimpleCalculator();	
	}
	
	@Test
	public void acceptsNewNumber() {	
		// Intent revealing name
		
		// Arrange
		double num = 25.35;

		// Act, Assert
		assertEquals("throught enter", calc.enter(num), num, deltaForDoubleComparison);		
			// message  to easily find where the test break
		
		assertEquals("throught result", calc.result(), num, deltaForDoubleComparison);		
	
		// Reset
	}
	
	@Test
	public void shouldMultiply() {
		// BDD style name
		
		double numToAdd1 = 33.23;
		double numToAdd2 = 21.2134;
		
		assertEquals("initial add", calc.add(numToAdd1), numToAdd1, deltaForDoubleComparison);
		assertEquals("cumulative add", calc.add(numToAdd2), numToAdd1 + numToAdd2, deltaForDoubleComparison);
	}
		
	@Ignore
	@Test
	public void multiplies() { }
	
	@Ignore
	@Test
	public void subtracts() { }
		
	@Ignore
	@Test
	public void clears() { }

	@Ignore
	@Test
	public void divides() { }

	@Ignore
	@Test
	public void throwsExceptionOnDivisionByZero() { }
	
	private static final double deltaForDoubleComparison = 0;
	private SimpleCalculator calc;	
}
