package com.aolchik.tdd.doubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Test;

import com.aolchik.tdd.simple.Calculator;

public class CalculatorDisplaySpyTest {

	@Test
	public void showsDefaultSeparator() {
		// Arrange
		Calculator mockedCalculator = mock(Calculator.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);
		double resultToInject = 100.0;
		String expected = "100.0";
		when(mockedCalculator.result()).thenReturn(resultToInject);
		
		// Act
		String actual = display.show();		
		
		// Assert
		verify(mockedCalculator).result();
		assertEquals("standard decimal separator", expected, actual);

		// Code above was extracted to a method
		verifyDisplayBehaviour("no standard thousand separator", 1000.0, "1000.0");
	}
	
	
	private void verifyDisplayBehaviour(String behaviour, double resultToInject, String expectedResult) {
		Calculator mockedCalculator = mock(Calculator.class);
		CalculatorDisplay display = new CalculatorDisplay(mockedCalculator);
		when(mockedCalculator.result()).thenReturn(resultToInject);
		
		String actual = display.show();		
		
		verify(mockedCalculator).result();
		assertEquals("standard decimal separator", expectedResult, actual);
	}

}
