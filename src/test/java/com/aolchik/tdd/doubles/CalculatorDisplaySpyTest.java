package com.aolchik.tdd.doubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Ignore;
import org.junit.Test;

import com.aolchik.tdd.simple.CalculatorEngine;

public class CalculatorDisplaySpyTest {

	@Test
	public void showsDefaultSeparator() {
		// How to write a test when we still don't know the underlying technology enough?
		// spike! (i.e. using a separate folder or using a new branch)
		
		// Arrange
		CalculatorEngine mockedCalculator = mock(CalculatorEngine.class);
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
		verifyDisplayBehaviour("standard thousand separator", 1000, "1,000.00");
	}
	
	@Test
	public void showsAlternateSeparators() {
		CalculatorEngine mockedCalculator = mock(CalculatorEngine.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);		
		String thousandSeparator = ".";
		String decimalSeparator = ",";
		display.setSeparators(thousandSeparator, decimalSeparator);

		verifyDisplayBehaviour(display, mockedCalculator, "decimal separator change", 100, "100,00");
		
		
		// Code above was extracted to a method
		verifyDisplayBehaviour("single thousand separator", 1000, ".", ",", "1.000,00");

		verifyDisplayBehaviour("multiple thousand separators", 1000000000, ".", ",", "1.000.000.000,00");

		verifyDisplayBehaviour("thousand separator on negativa numbers", -45000, ".", ",", "-45.000,00");
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

	private void verifyDisplayBehaviour(String behaviour, double resultToInject, String thousandSeparator, 
			String decimalSeparator, String expectedResult) {
		CalculatorEngine mockedCalculator = mock(CalculatorEngine.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);

		display.setSeparators(thousandSeparator, decimalSeparator);
		
		verifyDisplayBehaviour(display, mockedCalculator, behaviour, resultToInject, expectedResult);
	}
	
	
	private void verifyDisplayBehaviour(String behaviour, double resultToInject, String expectedResult) {
		CalculatorEngine mockedCalculator = mock(CalculatorEngine.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);
		
		verifyDisplayBehaviour(display, mockedCalculator, behaviour, resultToInject, expectedResult);
	}
	
	private void verifyDisplayBehaviour(CalculatorDisplay display, CalculatorEngine mockedCalculator, String behaviour, double resultToInject, String expectedResult) {	
		when(mockedCalculator.result()).thenReturn(resultToInject);
		
		String actual = display.show();		
		
		verify(mockedCalculator).result();
		assertEquals(behaviour, expectedResult, actual);
	}

}
