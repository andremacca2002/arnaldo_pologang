package it.unibs.fp.codiceFiscale;
import javax.xml.stream.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws XMLStreamException {
		ArrayList<String> codiciInvalidi = new ArrayList<String>();
		ArrayList<String> codiciValidi = new ArrayList<String>();
		ArrayList<String> codiciFiscali = new ArrayList<String>();
		ArrayList<String> codiciSpaiati = new ArrayList<String>();
		ArrayList<String> codiciPersone = new ArrayList<String>();
	
		
		Utility_Xml.inizializzazione("inputPersone.xml");

		Utility_Xml.inizializzazione("comuni.xml");
		
		ControlloCodici.inizializzazione("codiciFiscali.xml");
		
		codiciPersone.addAll(CreazioneCodici.creazioneCF(codiciFiscali, Utility_Xml.comuni));
		
		for(int i = 0; i < ControlloCodici.codiciFiscali.size(); i++) {
			if(ControlloCodici.codiciFiscali.get(i).length() != 16) {
				codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
			}
			else {
				boolean valido = true;
				char car;
				
				for(int j = 0; j < 6 && valido; j++) {
					car = ControlloCodici.codiciFiscali.get(i).charAt(j);
					if(!(Character.isAlphabetic(car))) {
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					}
				}
				
				for(int j = 6; j < 8 && valido; j++) {
					car = ControlloCodici.codiciFiscali.get(i).charAt(j);
					if(!(Character.isDigit(car))) {
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					}
				}
				
				car = ControlloCodici.codiciFiscali.get(i).charAt(8);
				
				if((car != 'A') || (car != 'B') || (car != 'C') || (car != 'D') || (car != 'E') || (car != 'H') || (car != 'L') || (car != 'M') || (car != 'P') || (car != 'R') || (car != 'S') || (car != 'T')) {
					codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
					valido = false;
				}
				
				String giorno = ControlloCodici.codiciFiscali.get(i).substring(9, 11);
				int gg = Integer.parseInt(giorno);
				
				if((gg < 1 || gg > 31) && (gg < 41 || gg > 71)) {
					codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
					valido = false;
				}
				
				String mese = ControlloCodici.codiciFiscali.get(i).substring(8, 9);
				
				switch (mese) {
				case "A": 
					if(gg != 31)
					codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
					valido = false;
					break;
				case "B": 
					if(gg != 28)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "C": 
					if(gg != 31)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "D": 
					if(gg != 30)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "E": 
					if(gg != 31)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "H": 
					if(gg != 30)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "L": 
					if(gg != 31)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "M": 
					if(gg != 31)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "P": 
					if(gg != 30)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "R": 
					if(gg != 31)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "S": 
					if(gg != 30)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
				case "T": 
					if(gg != 31)
						codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
						valido = false;
					break;
			}
				
				 String codice1 = ControlloCodici.codiciFiscali.get(i).substring(0, 15);

				if(!(CreazioneCodici.UltimoCarattereCF(codice1).equals(ControlloCodici.codiciFiscali.get(i)))) {
					codiciInvalidi.add(ControlloCodici.codiciFiscali.get(i));
					valido = false;
				}
				
				if(valido) {
					codiciValidi.add(ControlloCodici.codiciFiscali.get(i));
				}
			}
			
		}
		
		for(int i = 0 ; i < codiciValidi.size(); i++) {
			Boolean spaiati = false;
			for(int j = 0; i < codiciPersone.size(); j++) {
				if(codiciValidi.get(i).equals(codiciPersone.get(j))) {
					spaiati = true;
				}
				if(!spaiati) codiciSpaiati.add(codiciValidi.get(i));
			}	
		}
		Utility_Xml.scrittura(Utility_Xml.persone,codiciPersone,codiciInvalidi,codiciSpaiati);		
	}
}
