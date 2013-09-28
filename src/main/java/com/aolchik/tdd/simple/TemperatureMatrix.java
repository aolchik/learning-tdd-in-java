package com.aolchik.tdd.simple;

/**
 *	No m�s de Agosto foram registradas as menores temperaturas 
 *	do ano de 2013 no Rio Grande do Sul. A m�nima registrada 
 *	nessas cidades seguiu as seguintes regras:
 *
 *	- Em Bag�, a temperatura no dia 21 era 11�C e  diminuiu 2�C 
 *	a cada dia seguinte.
 *	- Em Livramento, a m�nima registrada em 21/08 foi  8�C, com 
 *	acr�scimo de 1� C nos dias seguintes.
 *	- Em Porto Alegre, o dia 23/08 foi o dia mais frio da semana, 
 *	fazendo a mesma temperatura m�nima de Bag� no dia 21/08.  Nos 
 *	demais dias a temperatura sofreu uma altera��o de 2�C por dia 
 *	em rela��o ao dia 23/08, sendo descrecente antes e crescente ap�s..
 *	- Em Caxias, a temperatura m�nima se manteve a 6�C nos tr�s 
 *	primeiros dias (21/22/23/08) e aumentou em 2�C no �ltimo.
 *
 *	Qual � a m�dia da  temperatura m�nima das cidades consideradas?
 *	
 *	Desenvolva um programa que calcule a m�dia das temperaturas m�nimas em
 *	Bag�, Livramento, Porto Alegre e Caxias.
 **/

public class TemperatureMatrix {
	
	public TemperatureMatrix(CityTemperature[] cityTemp) {
		cityTempArray = cityTemp;
	}
	
	public int averageMinimum() {
		double average = 0;
		for(CityTemperature cityTemp : cityTempArray) {
			average += (cityTemp.minimum()/cityTempArray.length);
		}
		return (int)average;
	}
	
	private CityTemperature[] cityTempArray;
}
