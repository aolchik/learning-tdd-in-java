package com.aolchik.tdd.doubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

import com.aolchik.tdd.doubles.CalculatorDisplayStubTest.StubCalculator;
import com.aolchik.tdd.simple.Calculator;

public class CalculatorDisplaySpyTest {

	@Before
	public void setUp() {
		this.calc = mock(Calculator.class);
		this.display = new CalculatorDisplay((Calculator) calc);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	private CalculatorDisplay display;
	private StubCalculator mockedCalc;

}
