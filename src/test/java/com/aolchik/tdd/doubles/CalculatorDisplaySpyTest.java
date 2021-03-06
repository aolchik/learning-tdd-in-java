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
		assertEquals("standard decimal separator:", expected, actual);

		// Code above was extracted to a method
		verifyStandardDisplayBehaviour("standard thousand separator:", 1000, "1,000.00");
	}
	
	@Test
	public void showsAlternateSeparators() {
		// Arrange
		CalculatorEngine mockedCalculator = mock(CalculatorEngine.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);		
		String thousandSeparator = ".";
		String decimalSeparator = ",";
		display.setSeparators(thousandSeparator, decimalSeparator);
		double resultToInject = 100.0;
		String expected = "100,00";
		when(mockedCalculator.result()).thenReturn(resultToInject);
			
		//Act
		String actual = display.show();		
			
		//Assert
		verify(mockedCalculator).result();
		assertEquals("decimal separator change", expected, actual);
		
		// Code above was extracted to a single method
		verifyNonStandardDisplayBehaviour("single thousand separator", 
				1000, ".", ",", "1.000,00");

		verifyNonStandardDisplayBehaviour("multiple thousand separators", 
				1000000000, ".", ",", "1.000.000.000,00");

		verifyNonStandardDisplayBehaviour("thousand separator on negative numbers", 
				-45000, ".", ",", "-45.000,00");
	}

	@Ignore
	@Test
	public void showSpecificNumberOfDecimals() {
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

	private void verifyNonStandardDisplayBehaviour(String behaviour, double resultToInject, 
			String thousandSeparator, String decimalSeparator, String expectedResult) {
		CalculatorEngine mockedCalculator = mock(CalculatorEngine.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);

		display.setSeparators(thousandSeparator, decimalSeparator);
		
		verifyDisplayBehaviourUsingMockedCalculator(display, mockedCalculator, behaviour, resultToInject, expectedResult);
	}
	
	private void verifyStandardDisplayBehaviour(String behaviour, double resultToInject, 
			String expectedResult) {
		CalculatorEngine mockedCalculator = mock(CalculatorEngine.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);
		
		verifyDisplayBehaviourUsingMockedCalculator(display, mockedCalculator, behaviour, resultToInject, expectedResult);
	}
	
	private void verifyDisplayBehaviourUsingMockedCalculator(CalculatorDisplay display, 
			CalculatorEngine mockedCalculator, String behaviour, 
			double resultToInject, String expectedResult) {	
		when(mockedCalculator.result()).thenReturn(resultToInject);
		
		String actual = display.show();		
		
		verify(mockedCalculator).result();
		assertEquals(behaviour, expectedResult, actual);
	}

}
