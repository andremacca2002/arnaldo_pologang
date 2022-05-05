package it.unibs.fp.planetarium;

import java.util.*;

public class Pianeta extends CorpoCeleste {
	
	private ArrayList<Luna> lune = new ArrayList<Luna>();
	
	public Pianeta(String nome, double massa, Punto posizione, ArrayList<Luna> lune) {
		super(nome, massa, posizione);
		this.setLune(lune);
	}
	
	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("\nNome: "+ this.getNome());
		descrizione.append("\nMassa: "+ this.getMassa());
		descrizione.append("\nPosizione: "+ this.getPosizione());
		
		if(this.getLune().isEmpty()) {
			descrizione.append(STR_U.PIANETA_NO_LUNE);
		}
		else {
			descrizione.append("\nLune: ");
			for(int i = 0 ; i < lune.size() ; i++) {
				Luna lunaX = lune.get(i);
				descrizione.append("\n->" + lunaX.getNome() + ";");
			}
		}
		return descrizione.toString();
	}

	public ArrayList<Luna> getLune() {
		return lune;
	}

	public void setLune(ArrayList<Luna> lune) {
		this.lune = lune;
	}

	
	
	
	
	
}
