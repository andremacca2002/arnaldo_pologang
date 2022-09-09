package it.unibs.fp.CD;
import java.util.*;

public class ArchivioCD {
	private ArrayList<CD> dischi = new ArrayList<CD>();

	public ArchivioCD(ArrayList<CD> dischi) {
		this.dischi = dischi;
	}
	
	public ArrayList<CD> getDischi() {
		return dischi;
	}

	public void setDischi(ArrayList<CD> dischi) {
		this.dischi = dischi;
	}
		
	
	
	public CD searchCD(String titolo) {
		for(int i = 0; i < dischi.size(); i++) {
			if(dischi.get(i).getNome().equals(titolo)) return dischi.get(i);
		}
		return null;
	}
	
	public String visualizeCD(String titolo) {
		for(int i = 0; i < dischi.size(); i++) {
			if(dischi.get(i).getNome().equals(titolo)) return dischi.get(i).toString();
		}
		return "Disco CD non trovato.";
	}
	
	public void deleteCD(String titolo) {
		for(int i = 0; i < dischi.size(); i++) {
			if(dischi.get(i).getNome().equals(titolo)) dischi.remove(i);
		}
	}
	
	public CD randomCD() {
		if(dischi.size() == 0) {
			return null;
		}
		else {
			return dischi.get((int) (Math.random() % dischi.size()));
		}
	}

	public void insertCD(CD disco) {
		dischi.add(disco);
		
	}
	
	
	
}
