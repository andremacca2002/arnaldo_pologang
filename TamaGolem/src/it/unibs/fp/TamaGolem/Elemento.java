package it.unibs.fp.TamaGolem;

public class Elemento {
	double a, b;
	static String [] elementi = {"Ketchup", "Maionese", "Barbeque", "Teriyaki", "Yoghurt"};
	int [][] matrice = new int[5][5];
	int potenza; 

	public void creaEquilibrio() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.printf("%d %d", i, j);
			}
		}
		
	}
}