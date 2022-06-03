package it.unibs.fp.rovinePerdute;

import java.util.ArrayList;

public class Metztli implements Percorso {
	
	private ArrayList<Citta> ottimale;
	private ArrayList<Citta> citt‡Aperte; //= new ArrayList<Citta>();
	private ArrayList<Citta> citt‡Chiuse; //= new ArrayList<Citta>();
	
	private int h; //altitudine
	
	private int f; //distanza tot
	private double g;  //distanza start nodo n
	private double z; //distanza nodo n al target 
	
	
	@Override
	public double calcolaDistanza(Citta citta1, Citta citta2) {
		double distanza=Math.abs(citta1.getH()-citta2.getH());
		return distanza;
		
	}


	@Override
	public ArrayList<Citta> calcolaPercorso(ArrayList<Citta> mappa){
		int distanza=0;
		int i=0;
		boolean arrivato=false;
		while(!arrivato) {
				for(int j=0; j<mappa.get(i).link.size(); j++){
					g=calcolaDistanza(mappa.get(i), mappa.get(j))+distanza;
					z=calcolaDistanza(mappa.get(mappa.size()-1), mappa.get(j));
			}
		}
	
	return ottimale;
	}	
}

