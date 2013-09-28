package com.aolchik.tdd.simple;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class LivramentoTemperatureTest {

	@Test
	public void day21ShouldBe8() {
		LivramentoTemperature livraTemp = new LivramentoTemperature();
		
		assertEquals(8, livraTemp.get(21));
	}

	@Test
	public void shouldIncrease1DegreeEachDayAfter() {
		LivramentoTemperature livraTemp = new LivramentoTemperature();
		
		assertEquals("day 22", 9, livraTemp.get(22));
		assertEquals("day 23", 10, livraTemp.get(23));
		assertEquals("day 24", 11, livraTemp.get(24));
	}

	@Test
	public void shouldHave8AsMinimum() {
		LivramentoTemperature livraTemp = new LivramentoTemperature();
		
		assertEquals(8, livraTemp.minimum());
	}

}
