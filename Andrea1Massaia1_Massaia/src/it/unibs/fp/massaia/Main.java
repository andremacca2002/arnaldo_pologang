package it.unibs.fp.massaia;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		System.out.println(STR.MSG_BENVENUTO);
		
		InterazioneUtente interazione = new InterazioneUtente(); 
		interazione.menuPrincipale();
		
		System.out.println(STR.MSG_SALUTI);
	}
}




