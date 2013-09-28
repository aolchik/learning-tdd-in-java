package com.aolchik.tdd.simple;

/**
 *	No mês de Agosto foram registradas as menores temperaturas 
 *	do ano de 2013 no Rio Grande do Sul. A mínima registrada 
 *	nessas cidades seguiu as seguintes regras:
 *
 *	- Em Bagé, a temperatura no dia 21 era 11°C e  diminuiu 2°C 
 *	a cada dia seguinte.
 *	- Em Livramento, a mínima registrada em 21/08 foi  8°C, com 
 *	acréscimo de 1° C nos dias seguintes.
 *	- Em Porto Alegre, o dia 23/08 foi o dia mais frio da semana, 
 *	fazendo a mesma temperatura mínima de Bagé no dia 21/08.  Nos 
 *	demais dias a temperatura sofreu uma alteração de 2°C por dia 
 *	em relação ao dia 23/08, sendo descrecente antes e crescente após..
 *	- Em Caxias, a temperatura mínima se manteve a 6°C nos três 
 *	primeiros dias (21/22/23/08) e aumentou em 2°C no último.
 *
 *	Qual é a média da  temperatura mínima das cidades consideradas?
 *	
 *	Desenvolva um programa que calcule a média das temperaturas mínimas em
 *	Bagé, Livramento, Porto Alegre e Caxias.
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
