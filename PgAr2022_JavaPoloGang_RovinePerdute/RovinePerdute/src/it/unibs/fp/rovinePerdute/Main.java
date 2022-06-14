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
					ArrayList<Citta> mappa2 = LeggiCittaXml.inizializzazione("PgAr_Map_50.xml");
					metztli = new Metztli();
					tonatiuh = new Tonatiuh();
					percOttimoT = tonatiuh.calcolaPercorso(mappa2);
					distanzaT = String.valueOf(Percorso.getDistanza());
					percOttimoM = metztli.calcolaPercorso(mappa2); //percorso ottimale team matzli
					distanzaM = String.valueOf(Percorso.getDistanza()); //distanza percorsa dal team matzli
					ScriviPercorso.scrittura(percOttimoT, percOttimoM, distanzaT, distanzaM); //scrittura su xml
					break;

				case 4:
					ArrayList<Citta> mappa3 = LeggiCittaXml.inizializzazione("PgAr_Map_200.xml");
					metztli = new Metztli();
					tonatiuh = new Tonatiuh();
					percOttimoT = tonatiuh.calcolaPercorso(mappa3);
					distanzaT = String.valueOf(Percorso.getDistanza());
					percOttimoM = metztli.calcolaPercorso(mappa3); //percorso ottimale team matzli
					distanzaM = String.valueOf(Percorso.getDistanza()); //distanza percorsa dal team matzli
					ScriviPercorso.scrittura(percOttimoT, percOttimoM, distanzaT, distanzaM); //scrittura su xml
					break;
				
				case 5:
					ArrayList<Citta> mappa4 = LeggiCittaXml.inizializzazione("PgAr_Map_2000.xml");
					metztli = new Metztli();
					tonatiuh = new Tonatiuh();
					percOttimoT = tonatiuh.calcolaPercorso(mappa4);
					distanzaT = String.valueOf(Percorso.getDistanza());
					percOttimoM = metztli.calcolaPercorso(mappa4); //percorso ottimale team matzli
					distanzaM = String.valueOf(Percorso.getDistanza()); //distanza percorsa dal team matzli
					ScriviPercorso.scrittura(percOttimoT, percOttimoM, distanzaT, distanzaM); //scrittura su xml
					break;
					
				case 6:
					ArrayList<Citta> mappa5 = LeggiCittaXml.inizializzazione("PgAr_Map_10000.xml");
					metztli = new Metztli();
					tonatiuh = new Tonatiuh();
					percOttimoT = tonatiuh.calcolaPercorso(mappa5);
					distanzaT = String.valueOf(Percorso.getDistanza());
					percOttimoM = metztli.calcolaPercorso(mappa5); //percorso ottimale team matzli
					distanzaM = String.valueOf(Percorso.getDistanza()); //distanza percorsa dal team matzli
					ScriviPercorso.scrittura(percOttimoT, percOttimoM, distanzaT, distanzaM); //scrittura su xml
					break;
				
				case 7:
					
					break;
					
				
			}
		} while(scelta!=0);
	}
	
}
	
	

