package it.unibs.fp.codiceFiscale;
import javax.xml.stream.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		
		String path = null;
		path = new File("inputPersone.xml").getPath();
		
		Utility_Xml.Inizializzazione(path);

		for(int i = 0; i < Utility_Xml.persona.size(); i++) {
			String codiceFiscale = null;
			String cognome = Utility_Xml.persona.get(i).getCognome();
			char [] codiceCognome = new char[3];
			int numCons = 0;
			
			if(cognome.length() < 3) {
				for(int j = 0; j < cognome.length(); j++) {
					codiceCognome[j] = cognome.charAt(j);
				}
				codiceCognome[2] = 'X';
			}
			else {
				for(int j = 0; j < cognome.length(); j++) {
					if((cognome.charAt(j) != '\u0041') && (cognome.charAt(j) != '\u0045') && (cognome.charAt(j) != '\u0049') && (cognome.charAt(j) != '\u004F') && (cognome.charAt(j) != '\u0055')) {
						numCons++;
					}
				}
				if(numCons == 3) {
					int k = 0;
					System.out.println(cognome);
					for(int j = 0; j < cognome.length(); j++) {
						if((cognome.charAt(j) != '\u0041') && (cognome.charAt(j) != '\u0045') && (cognome.charAt(j) != '\u0049') && (cognome.charAt(j) != '\u004F') && (cognome.charAt(j) != '\u0055')) {
							codiceCognome[k] = cognome.charAt(j);
							
							k++;
						}    
					}                             
				}
				else if(numCons < 3) {
					int z = numCons;
					int k = 0;
					System.out.println(cognome);
					for(int j = 0; j < cognome.length(); j++) {
						if((cognome.charAt(j) != '\u0041') && (cognome.charAt(j) != '\u0045') && (cognome.charAt(j) != '\u0049') && (cognome.charAt(j) != '\u004F') && (cognome.charAt(j) != '\u0055')) {
							codiceCognome[k] = cognome.charAt(j);
							
							k++;
						}
						else{
							if(z < 3) {
								codiceCognome[z] = cognome.charAt(j);
								z++;
							}
						}
					}
				
				}
			}System.out.println(codiceCognome);
		}
		
	}

}
