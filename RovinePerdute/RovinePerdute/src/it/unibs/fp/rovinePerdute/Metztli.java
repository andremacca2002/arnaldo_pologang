package it.unibs.fp.rovinePerdute;

public class Metztli extends Percorso {	
	public double calcolaDistanza(Citta citta1, Citta citta2) {
		double distanza=Math.abs(citta1.getH()-citta2.getH());
		return distanza;
	}			
}

