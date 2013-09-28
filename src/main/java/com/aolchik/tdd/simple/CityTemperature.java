package com.aolchik.tdd.simple;

public abstract class CityTemperature {

	abstract int get(int day);

	public int minimum() { 
		int day = INITIAL_DAY;
		int min = get(day);
		day++;
		while(day <= END_DAY) {
			if( min > get(day)) {
				min = get(day);
			}
			day++;
		}
		return min;
	}

	private static final int INITIAL_DAY = 21;
	private static final int END_DAY = 24;
	
}
