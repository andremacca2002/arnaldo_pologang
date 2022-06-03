package it.unibs.fp.rovinePerdute;

import java.util.*;

public abstract class Percorso {
	private ArrayList<Citta> ottimale = new ArrayList<Citta>();
	//utilizzo di A* f=g(n)+z(n)
	private double f; //distanza tot 
	private double g;  //distanza start nodo n
	private double z; //distanza nodo n al target
	static double distanza;
	
	abstract double calcolaDistanza(Citta citta1, Citta citta2);
	
	ArrayList<Citta> calcolaPercorso(ArrayList<Citta> mappa) {
		distanza = 0;
		int i = 0;  //contatore che tiene conto della città da cui parto in ogni iterazione (inizializzata a 0 per partire da campo base )
		int id = 0; 
		boolean arrivato=false; //funzione booleana per verificare se sono arrivato alla fine dell'arrey mappa (quindi alle rovine)

		ottimale.add(mappa.get(0)); //aggiungo campo base all'arreylist che sarà riempito con le città sul percorso migliore 
		
		while(!arrivato) {
			double min = 0;
			for(int j = 0; j < mappa.get(i).link.size(); j++) { //j serve per ciclare nell'arreylist link k di ogni città (che contiene gli id delle città a essa collegata) 
				if(!(ottimale.contains(mappa.get(mappa.get(i).link.get(j))))) {
					g = calcolaDistanza(mappa.get(i), mappa.get(mappa.get(i).link.get(j))) + distanza; //vengono passati al metodo la città in cui mi trovo e la città a cui è collegata
					z = calcolaDistanza(mappa.get(mappa.size()-1), mappa.get(mappa.get(i).link.get(j))); //passo la città in cui intendo andare e l'ultima città (le rovine perdute )
					f = g + z;
					
					if(min == 0) { //la variabile min viene innizzializzta al nuovo valore attimale trovato
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
			ottimale.add(mappa.get(id)); //aggiungo la città che si trova sul percorso ottimale 
			i = id;
			
			if(i == mappa.get(mappa.size()-1).getID()) { //arrivo a fine arreylist
				arrivato = true;
			}
		}
		
		return ottimale;
		}

	public static double getDistanza() { //per accedere alla variabile distanza dal main
		return distanza;
	}
}




