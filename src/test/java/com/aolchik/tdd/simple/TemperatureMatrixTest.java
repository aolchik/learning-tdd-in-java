package com.aolchik.tdd.simple;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;


public class TemperatureMatrixTest {

	@Test
	public void averageMinimumReturnsMinimumTemperatureOfASingleCity() {
		int[] expectedMinimums = { 9 };
		CityTemperature[] array = createCityTemperatureMockArray( expectedMinimums );

		TemperatureMatrix tMatrix = new TemperatureMatrix(array);
		
		assertEquals(expectedMinimums[0], tMatrix.averageMinimum());
	}

	@Test
	public void averageMinimumReturnsAverageMinimumTemperatureOfMultipleCities() {
		int[] expectedMinimums = { 9, 2, 0};
		CityTemperature[] array = createCityTemperatureMockArray( expectedMinimums );

		TemperatureMatrix tMatrix = new TemperatureMatrix(array);
		
		assertEquals((expectedMinimums[0]+expectedMinimums[1]+expectedMinimums[2])/3, 
				tMatrix.averageMinimum());
	}
	
	@Test
	public void averageMinimumCityTest() {
		CityTemperature[] array = { new BageTemperature(), 
				new LivramentoTemperature() };
		TemperatureMatrix tMatrix = new TemperatureMatrix(array);
		
		assertEquals((5+8)/2, tMatrix.averageMinimum());
	}
	
	private CityTemperature[] createCityTemperatureMockArray(int[] expectedMinimuns) {
		CityTemperature array[] = new CityTemperature[expectedMinimuns.length];

		for(int i = 0; i < expectedMinimuns.length; i++) {
			CityTemperature mockedCity = mock(CityTemperature.class);
			when(mockedCity.minimum()).thenReturn(expectedMinimuns[i]);
					
			array[i] = mockedCity;
		}

		return array;
		
		
	}


}
