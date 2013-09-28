package com.aolchik.tdd.simple;

public class BageTemperature extends CityTemperature {

	@Override
	public int get(int day) {
		switch(day) {
			case 21:
				return 11;
			case 22:
				return 9;
			case 23:
				return 7;
			case 24:
				return 5;
		}
		throw new IllegalArgumentException();
	}
	

}
