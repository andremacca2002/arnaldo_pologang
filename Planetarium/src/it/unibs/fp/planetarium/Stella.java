package it.unibs.fp.planetarium;


public class Stella extends CorpoCeleste {
	
	public Stella(String nome, double massa, Punto posizione) {
		super(nome, massa, posizione);
	}
	
	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("\nNome: "+ this.getNome());
		descrizione.append("\nMassa: "+ this.getMassa());
		descrizione.append("\nPosizione: "+ this.getPosizione());
		
		return descrizione.toString();
	}
}
