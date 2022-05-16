package it.unibs.fp.TamaGolem;

public class Main {
	//N                                      =        5
	//G = (N - 1)(N - 2) / (2 * P)          =        2
	//P = (N + 1) / 3 + 1                   =        3
	// S = (2 * G * P) / N * N              =        15
	//S / N = (2 * G * P) / N pietre.
	
	
	public static void main(String[] args) {
	
		TamaGolem tama = null;
	//System.out.print(Elemento.MAIONESE.getId());
		
		Fase1.creaEquilibrio();
		
		Fase2.assegnaPietre(tama);
		
	}
}

