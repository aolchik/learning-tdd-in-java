package com.aolchik.tdd.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class BageTemperatureTest {

	@Test
	public void day21ShouldBe11() {
		BageTemperature bageTemp = new BageTemperature();
		
		assertEquals(11, bageTemp.get(21));
	}

	@Test
	public void shouldDecrease2DegreesEachDayAfter() {
		BageTemperature bageTemp = new BageTemperature();
		
		assertEquals("day 22", 9, bageTemp.get(22));
		assertEquals("day 23", 7, bageTemp.get(23));
		assertEquals("day 24", 5, bageTemp.get(24));
	}

	// @TODO: This test could be moved to CityTemperatureTest
	@Test
	public void shouldHave5AsMinimum() {
		BageTemperature bageTemp = new BageTemperature();
		
		assertEquals(5, bageTemp.minimum());
	}

}
