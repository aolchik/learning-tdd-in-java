package com.aolchik.tdd.simple;

public class LivramentoTemperature extends CityTemperature {

	@Override
	public int get(int day) {
		switch(day) {
			case 21:
				return 8;
			case 22:
				return 9;
			case 23:
				return 10;
			case 24:
				return 11;
		}
		throw new IllegalArgumentException();
	}
	

}
