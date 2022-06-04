package it.unibs.fp.rovinePerdute;
import java.util.*;
import it.unibs.fp.mylib.*;

import javax.xml.stream.*;

public class Main {
	public static void main(String[] args) throws XMLStreamException {
		ArrayList<Citta> percOttimoT = new ArrayList<Citta>();
		ArrayList<Citta> percOttimoM = new ArrayList<Citta>();
		String[] voci = StringheUtili.MENU_VOCI;
		MyMenu menu = new MyMenu(StringheUtili.SCELTA, voci);
		Metztli metztli;
		Tonatiuh tonatiuh;
		String distanzaT;
		String distanzaM;
		int scelta;
		do {	                                                
			scelta = menu.scegli();
			switch(scelta) {
				case 1:
					ArrayList<Citta> mappa0 = LeggiCittaXml.inizializzazione("PgAr_Map_5.xml"); //lettura da xml
					metztli = new Metztli();
					tonatiuh = new Tonatiuh();
					percOttimoT = tonatiuh.calcolaPercorso(mappa0);
					distanzaT = String.valueOf(Percorso.getDistanza());
					percOttimoM = metztli.calcolaPercorso(mappa0); //percorso ottimale team matzli
					distanzaM = String.valueOf(Percorso.getDistanza()); //distanza percorsa dal team matzli
					ScriviPercorso.scrittura(percOttimoT, percOttimoM, distanzaT, distanzaM); //scrittura su xml
					break;
				
				case 2:
					ArrayList<Citta> mappa1 = LeggiCittaXml.inizializzazione("PgAr_Map_12.xml");
					metztli = new Metztli();
					tonatiuh = new Tonatiuh();
					percOttimoT = tonatiuh.calcolaPercorso(mappa1);
					distanzaT = String.valueOf(Percorso.getDistanza());
					percOttimoM = metztli.calcolaPercorso(mappa1); //percorso ottimale team matzli
					distanzaM = String.valueOf(Percorso.getDistanza()); //distanza percorsa dal team matzli
					ScriviPercorso.scrittura(percOttimoT, percOttimoM, distanzaT, distanzaM); //scrittura su xml
					break;
					
				
				case 3:
				

				case 4:
				
				
				case 5:
					
					break;
					
				case 6:
					break;
				
				case 7:
					
					break;
					
				
			}
		} while(scelta!=0);
	}
	
}
	
	

