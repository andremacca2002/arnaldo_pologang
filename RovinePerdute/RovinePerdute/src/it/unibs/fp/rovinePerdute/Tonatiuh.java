package it.unibs.fp.rovinePerdute;

public class Tonatiuh extends Percorso {
	public double calcolaDistanza(Citta citta1, Citta citta2) {
		double distanza=0;
		distanza = Math.sqrt(Math.pow(citta1.getX()+citta2.getX(), 2)+Math.pow(citta1.getY()+citta2.getY(), 2));
		
		return distanza;
	}
}
