package it.unibs.fp.rovinePerdute;
import java.util.*;
import it.unibs.fp.mylib.*;
import it.unibs.fp.planetarium.Pianeta;
import it.unibs.fp.planetarium.STR_U;
import it.unibs.fp.planetarium.Stella;

import javax.xml.stream.*;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
			
		String[] voci = StringheUtili.MENU_VOCI;
		MyMenu menu = new MyMenu(StringheUtili.SCELTA, voci);
		int scelta;
		do {	                                                
			scelta = menu.scegli();
			switch(scelta) {
				case 1:
					ArrayList<Citta> mappa0 = LeggiCittaXml.inizializzazione("PgAr_Map_5.xml");
					break;
				
				case 2:
					ArrayList<Citta> mappa1 = LeggiCittaXml.inizializzazione("PgAr_Map_12.xml");
					break;
				
				case 3:
					ArrayList<Citta> mappa2 = LeggiCittaXml.inizializzazione("PgAr_Map_50.xml");
					break;

				case 4:
					ArrayList<Citta> mappa3 = LeggiCittaXml.inizializzazione("PgAr_Map_200.xml");
					break;
				
				case 5:
						ArrayList<Citta> mappa4 = LeggiCittaXml.inizializzazione("PgAr_Map_2000.xml");
					break;
					
				case 6:
					ArrayList<Citta> mappa5 = LeggiCittaXml.inizializzazione("PgAr_Map_10000.xml");					
					break;
				
				case 7:
					
					break;
					
				
			}
		} while(scelta!=0);
	}
	}
}
	
	

