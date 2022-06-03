package it.unibs.fp.rovinePerdute;

import java.util.ArrayList;

public class Tonatiuh implements Percorso {
	private int x; //cordinate del punto
	private int y;
	
	private int f; //distanza tot
	private int g; //distanza start nodo n
	private int z; //distanza nodo n al target
	
	private ArrayList<Citta> ottimale;
	private ArrayList<Citta> citt‡Aperte; //= new ArrayList<Citta>();
	private ArrayList<Citta> citt‡Chiuse; //= new ArrayList<Citta>();
	
	
	@Override
	public double calcolaDistanza(Citta citta1, Citta citta2) {
		double distanza=0;
		distanza=Math.sqrt(Math.pow(citta1.getX()+citta2.getX(), 2)+Math.pow(citta1.getY()+citta2.getY(), 2));
		
		return distanza;
		
	}


	@Override
	public ArrayList<Citta> calcolaPercorso(ArrayList<Citta> mappa){
		int distanza;
		boolean arrivato=false;
		while(!arrivato) {
			for(int i=0; !arrivato; i++){
				for(int j=0; j<mappa.get(i).link.size(); j++){	
			}
		}
	}
	return ottimale;
	}
}
