package com.aolchik.tdd.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {

	@Before
	public void setUp() {
		this.calc = new Calculator();	
	}
	
	@Test
	public void acceptsNewNumber() {		
		double num = 25.35;

		assertEquals("throught enter", calc.enter(num), num, deltaForDoubleComparison);		
		assertEquals("throught result", calc.result(), num, deltaForDoubleComparison);		
	}
	
	@Test
	public void adds() {
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
	public void divides() { }

	private static final double deltaForDoubleComparison = 0;
	private Calculator calc;
	
}
