package it.unibs.fp.TamaGolem;

public class Main {
	//N                                      =        5
	//G = (N - 1)(N - 2) / (2 * P)          =        2
	//P = (N + 1) / 3 + 1                   =        3
	// S = (2 * G * P) / N * N              =        15
	//S / N = (2 * G * P) / N pietre.
	
	
	public static void main(String[] args) {
		double [][] matrice = new double[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0;j < 5; j++) {
				if(j > i) {
					matrice[i][j] = Math.random() % 2;      //IMPORTANTE: cercare un altro metodo per generare numeri casuali
					System.out.printf("%d %d   %f", i, j, matrice[i][j]);
				}
			}
		}
	}
		
}


