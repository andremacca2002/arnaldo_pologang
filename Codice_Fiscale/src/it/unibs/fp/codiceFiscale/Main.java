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
			int num = 0;
			for(int j = 0; j < cognome.length(); j++) {
				if((cognome.charAt(j) != '\u0041') && (cognome.charAt(j) != '\u0045') && (cognome.charAt(j) != '\u0049') && (cognome.charAt(j) != '\u004F') && (cognome.charAt(j) != '\u0055')) {
					num++;
				}
				if(num == 3) {
					
				}
			}
			
			/*if(Utility_Xml.persona.get(i).getCognome().replaceAll("(?i) [^ BCDFGHJKLMNPQRSTVWXYZ]", "").length() == 3) {
				codiceFiscale = Utility_Xml.persona.get(i).getCognome().replaceAll("(?i) [^ bcdfghjklmnpqrstvwxyz]", "");
				System.out.println(codiceFiscale);
				System.out.println(i);
			}*/
		}

	}

}
