package it.unibs.fp.TamaGolem;

public class Fase3 {

	
	public static void finepartita(int tamaEsausti1, Giocatore giocatore1, Giocatore giocatore2) {
		if(tamaEsausti1<2) {
			System.out.println("comlimenti "+ giocatore1.getNome()+"sei il vincitore!");
		}else System.out.println("comlimenti "+ giocatore2.getNome()+"sei il vincitore!");	
	}
	
	public static void visualizzaEquilibrio() {
	
	}
}
	

