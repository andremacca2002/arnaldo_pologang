package it.unibs.fp.rovinePerdute;

import java.util.*;

public abstract class Percorso {
	private ArrayList<Citta> ottimale = new ArrayList<Citta>();
	private double f; //distanza tot
	private double g;  //distanza start nodo n
	private double z; //distanza nodo n al target
	static double distanza;
	
	abstract double calcolaDistanza(Citta citta1, Citta citta2);
	
	ArrayList<Citta> calcolaPercorso(ArrayList<Citta> mappa) {
		distanza = 0;
		int i = 0;
		int id = 0;
		boolean arrivato=false;

		ottimale.add(mappa.get(0));
		
		while(!arrivato) {
			double min = 0;
			for(int j = 0; j < mappa.get(i).link.size(); j++) {
				if(!(ottimale.contains(mappa.get(mappa.get(i).link.get(j))))) {
					
					g = calcolaDistanza(mappa.get(i), mappa.get(mappa.get(i).link.get(j))) + distanza;
					z = calcolaDistanza(mappa.get(mappa.size()-1), mappa.get(mappa.get(i).link.get(j)));
					f = g + z;
					
					if(min == 0) {
						min = f;
						id = mappa.get(i).link.get(j);
						
					}
					else if(f < min) {
						min = f;
						id = mappa.get(i).link.get(j);
					}
					else if(f == min) {
						min = f;
						id = mappa.get(i).link.get(j);
					}
				}
			}
			distanza=g;
			//cittaControllate.add(mappa.get(mappa.get(i).link.get(j)));
			ottimale.add(mappa.get(id));
			i = id;
			
			if(i == mappa.get(mappa.size()-1).getID()) {
				arrivato = true;
			}
		}
		
		return ottimale;
		}

	public static double getDistanza() {
		return distanza;
	}
}




