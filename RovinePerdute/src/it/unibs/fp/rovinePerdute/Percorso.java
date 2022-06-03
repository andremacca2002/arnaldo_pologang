package it.unibs.fp.rovinePerdute;

import java.util.*;

public interface Percorso {
 
	
	double calcolaDistanza(Citta citta1, Citta citta2);
	
	ArrayList<Citta> calcolaPercorso(ArrayList<Citta> mappa);

}

