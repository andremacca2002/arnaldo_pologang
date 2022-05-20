package it.unibs.fp.TamaGolem;

public class Fase3 {
	public static void finePartita(int tamaEsausti1, Giocatore giocatore1, Giocatore giocatore2) {
		if(tamaEsausti1<2) {
			System.out.println("Complimenti "+ giocatore1.getNome()+", sei il vincitore!");
		}else System.out.println("Complimenti "+ giocatore2.getNome()+", sei il vincitore!");	
	}
	
	public static void visualizzaEquilibrio(int [][] balance) {
		String[] elementi = {Elemento.BARBECUE.name(), Elemento.KETCHUP.name(), Elemento.MAIONESE.name(), Elemento.TERIYAKI.name(), Elemento.YOGURT.name()};
		
		System.out.println("\nL'Equilibrio del mondo è rappresentato di seguito.\nGli elementi di sinistra prevalgono su quelli di destra e causano un danno riportato sulla freccia.\n");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(j > i) {
					if(balance[i][j] > 0) {
						System.out.printf("%-10s---%d--->  %s\n", elementi[i], balance[i][j], elementi[j]);
					}
					else {
						System.out.printf("%-10s---%d--->  %s\n", elementi[j], Math.abs(balance[i][j]), elementi[i]);
					}
				}
			}
		}
	}
}
	

