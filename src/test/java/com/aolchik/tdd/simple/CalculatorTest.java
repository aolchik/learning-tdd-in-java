package com.aolchik.tdd.simple;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void acceptsNewNumber() {
		Calculator calc = new Calculator();
		
		double num = 25.35;
		
		calc.enter(num);		
		double result = calc.result();
		
		double delta = 0.0;
		assertEquals(result, num, delta);		
	}
	
	@Ignore("WIP")
	@Test
	public void adds() {
		
	}

}
