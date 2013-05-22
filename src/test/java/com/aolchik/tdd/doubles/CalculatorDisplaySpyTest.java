package com.aolchik.tdd.doubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Ignore;
import org.junit.Test;

import com.aolchik.tdd.simple.Calculator;

public class CalculatorDisplaySpyTest {

	@Test
	public void showsDefaultSeparator() {
		// Arrange
		Calculator mockedCalculator = mock(Calculator.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);
		double resultToInject = 100;
		String expected = "100.00";
		when(mockedCalculator.result()).thenReturn(resultToInject);
		
		// Act
		String actual = display.show();		
		
		// Assert
		verify(mockedCalculator).result();
		assertEquals("standard decimal separator", expected, actual);

		// Code above was extracted to a method
		verifyDisplayBehaviour("no standard thousand separator", 1000, "1000.00");
	}
	
	@Test
	public void showsAlternateSeparators() {
		Calculator mockedCalculator = mock(Calculator.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);		
		String thousandSeparator = ".";
		String decimalSeparator = ",";
		display.setSeparators(thousandSeparator, decimalSeparator);

		verifyDisplayBehaviour(display, mockedCalculator, "decimal separator change", 100, "100,0");
		
//		calc.enter(1000.0);
//		assertEquals("single thousand separator", "1.000,0", display.show());
//
//		calc.enter(1000000000.0);
//		assertEquals("multiple thousand separators", "1.000.000.000,0", 
//				display.show());
//
//		calc.enter(-45000.0);
//		assertEquals("thousand separator on negative numbers", "-45.000,0",
//				display.show());
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

	private void verifyDisplayBehaviour(String behaviour, double resultToInject, String expectedResult) {
		Calculator mockedCalculator = mock(Calculator.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);
		
		verifyDisplayBehaviour(display, mockedCalculator, behaviour, resultToInject, expectedResult);
	}
	
	private void verifyDisplayBehaviour(CalculatorDisplay display, Calculator mockedCalculator, String behaviour, double resultToInject, String expectedResult) {	
		when(mockedCalculator.result()).thenReturn(resultToInject);
		
		String actual = display.show();		
		
		verify(mockedCalculator).result();
		assertEquals("standard decimal separator", expectedResult, actual);
	}

}
