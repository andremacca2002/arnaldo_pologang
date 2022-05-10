package it.unibs.fp.TamaGolem;

public class Elemento {
	double k;
	static String [] elementi = {"Ketchup", "Maionese", "Barbeque", "Teriyaki", "Yoghurt"};
	int potenza;
	
	do {
		k = (Math.random() % 9) - 4;
	}while(k == 0);
}