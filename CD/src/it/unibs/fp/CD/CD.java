package it.unibs.fp.CD;
import java.util.*;

public class CD {
	private String titolo;
	private String autore;
	private ArrayList<Brano> brani = new ArrayList<Brano>();
	
	public CD(String nome, String autore, ArrayList<Brano> brani) {
		this.titolo = nome;
		this.autore = autore;
		this.setBrani(brani);
	}
	
	public ArrayList<Brano> getBrani() {
		return brani;
	}
	public void setBrani(ArrayList<Brano> brani) {
		this.brani = brani;
	}

	public String getNome() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public Brano randomBrano() {
		return brani.get((int) (Math.random() % brani.size()));
	}
	
	public Brano selectBrano(String nome) {
		for(int i = 0; i < brani.size(); i++) {
			if(brani.get(i).getTitolo().equals(nome)) return brani.get(i);
		}
		
		return null;
	}

	public String toString() {
		return "titolo: " + titolo + ", autore: " + autore;
	}
	
}
