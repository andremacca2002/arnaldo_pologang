package it.unibs.fp.codiceFiscale;
import javax.xml.stream.*;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		
		String path = null;
		path = new File("inputPersone.xml").getPath();
		
		Utility_Xml.Inizializzazione(path);

		String pathComuni = null;
		pathComuni = new File("comuni.xml").getPath();
		
		Utility_Xml.Inizializzazione(pathComuni);
		
		for(int i = 0; i < Utility_Xml.persona.size(); i++) {
			String codiceFiscale = null;
			String cognome = Utility_Xml.persona.get(i).getCognome();
			String nome = Utility_Xml.persona.get(i).getNome();
			String data = Utility_Xml.persona.get(i).getData();
			String sesso = Utility_Xml.persona.get(i).getSesso();
			String comune = Utility_Xml.persona.get(i).getLuogoNascita();
			int sommaDisp = 0;
			int sommaPari = 0;
			
			char [] codiceCognome = new char[3];
			char [] codiceNome = new char[3];
			char [] codiceData = new char[3];
			int numCons;
			
			if(cognome.length() < 3) {
				for(int j = 0; j < cognome.length(); j++) {
					codiceCognome[j] = cognome.charAt(j);
				}
				codiceCognome[2] = 'X';
			}
			else {
				numCons = 0;
				for(int j = 0; j < cognome.length(); j++) {
					if((cognome.charAt(j) != '\u0041') && (cognome.charAt(j) != '\u0045') && (cognome.charAt(j) != '\u0049') && (cognome.charAt(j) != '\u004F') && (cognome.charAt(j) != '\u0055')) {
						numCons++;
					}
				}
				if(numCons >= 3) {
					int k = 0;
					
					for(int j = 0; j < cognome.length(); j++) {
						if(k < 3) {
							if((cognome.charAt(j) != '\u0041') && (cognome.charAt(j) != '\u0045') && (cognome.charAt(j) != '\u0049') && (cognome.charAt(j) != '\u004F') && (cognome.charAt(j) != '\u0055')) {
								codiceCognome[k] = cognome.charAt(j);
								k++;
							}
						}
					}
				}
				else if(numCons < 3) {
					int z = numCons;
					int k = 0;
					
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
			}
			
			codiceFiscale = Arrays.toString(codiceCognome);
			codiceFiscale = codiceFiscale.replace("[", "").replace("]", "").replace(", ", "");
			
			if(nome.length() < 3) {
				for(int j = 0; j < nome.length(); j++) {
					codiceNome[j] = nome.charAt(j);
				}
				codiceNome[2] = 'X';
			}
			else {
				numCons = 0;
				for(int j = 0; j < nome.length(); j++) {
					if((nome.charAt(j) != '\u0041') && (nome.charAt(j) != '\u0045') && (nome.charAt(j) != '\u0049') && (nome.charAt(j) != '\u004F') && (nome.charAt(j) != '\u0055')) {
						numCons++;
					}
				}
				
				if(numCons > 3) {
					int k = 0;
					int z = 0;
					
					for(int j = 0; j < nome.length(); j++) {
						if(k < 3) {
							if((nome.charAt(j) != '\u0041') && (nome.charAt(j) != '\u0045') && (nome.charAt(j) != '\u0049') && (nome.charAt(j) != '\u004F') && (nome.charAt(j) != '\u0055')) {
								if(z != 1) {
									codiceNome[k] = nome.charAt(j);
									k++;
								}
								z++;
							}
						}
					}
				}
				
				else if(numCons == 3) {
					int k = 0;
					
					for(int j = 0; j < nome.length(); j++) {
						if(k < 3) {
							if((nome.charAt(j) != '\u0041') && (nome.charAt(j) != '\u0045') && (nome.charAt(j) != '\u0049') && (nome.charAt(j) != '\u004F') && (nome.charAt(j) != '\u0055')) {
								codiceNome[k] = nome.charAt(j);
								k++;
							}
						}
					}
				}
				
				else if(numCons < 3) {
					int z = numCons;
					int k = 0;
					
					for(int j = 0; j < nome.length(); j++) {
						if((nome.charAt(j) != '\u0041') && (nome.charAt(j) != '\u0045') && (nome.charAt(j) != '\u0049') && (nome.charAt(j) != '\u004F') && (nome.charAt(j) != '\u0055')) {
							codiceNome[k] = nome.charAt(j);
							k++;
						}
						else{
							if(z < 3) {
								codiceNome[z] = nome.charAt(j);
								z++;
							}
						}
					}	
				}
			}
			codiceFiscale = codiceFiscale + Arrays.toString(codiceNome).replace("[", "").replace("]", "").replace(", ", "");
			
			for(int j = 0; j < 3; j++) {
				codiceData[j] = data.charAt(j+2);
				if(j == 2) {
					String mese = data.substring(5, 7);

					switch (mese) {
						case "01": codiceData[j] = 'A';
							break;
						case "02": codiceData[j] = 'B';
							break;
						case "03": codiceData[j] = 'C';
							break;
						case "04": codiceData[j] = 'D';
							break;
						case "05": codiceData[j] = 'E';
							break;
						case "06": codiceData[j] = 'H';
							break;
						case "07": codiceData[j] = 'L';
							break;
						case "08": codiceData[j] = 'M';
							break;
						case "09": codiceData[j] = 'P';
							break;
						case "10": codiceData[j] = 'R';
							break;
						case "11": codiceData[j] = 'S';
							break;
						case "12": codiceData[j] = 'T';
							break;
					}
				}
			}
			codiceFiscale = codiceFiscale + Arrays.toString(codiceData).replace("[", "").replace("]", "").replace(", ", "");
			
			if(sesso.equals("F")) {
				String giorno = data.substring(8, 10);
				int codSesso = Integer.parseInt(giorno) + 40;
				codiceFiscale = codiceFiscale + String.valueOf(codSesso);
			}
			else {
				String giorno = data.substring(8, 10);
				codiceFiscale = codiceFiscale + giorno;
			}
			
			for(int j = 0; j < Utility_Xml.comune.size(); j++) {
				if (comune.equals(Utility_Xml.comune.get(j).getNome())) {
					codiceFiscale = codiceFiscale + Utility_Xml.comune.get(j).getCodice();
				}
			}
			
			for(int d = 0; d < codiceFiscale.length(); d = d +2) {
				switch (codiceFiscale.charAt(d)) {
				case '0': codiceData[j] = 'A';
					break;
				case '1': codiceData[j] = 'B';
					break;
				case '2': codiceData[j] = 'C';
					break;
				case '3': codiceData[j] = 'D';
					break;
				case '4': codiceData[j] = 'E';
					break;
				case '5': codiceData[j] = 'H';
					break;
				case '6': codiceData[j] = 'L';
					break;
				case '7': codiceData[j] = 'M';
					break;
				case '8': codiceData[j] = 'P';
					break;
				case '9': codiceData[j] = 'R';
					break;
				case 'A': codiceData[j] = 'S';
					break;
				case 'B': codiceData[j] = 'T';
					break;
				case 'C': codiceData[j] = 'S';
					break;
				case 'D': codiceData[j] = 'T';
					break;
				case 'E': codiceData[j] = 'S';
					break;
				case 'F': codiceData[j] = 'T';
					break;
				case 'G': codiceData[j] = 'S';
					break;
				case 'H': codiceData[j] = 'T';
					break;
				case 'I': codiceData[j] = 'S';
					break;
				case 'j': codiceData[j] = 'T';
					break;
				case 'I': codiceData[j] = 'S';
					break;
				case 'j': codiceData[j] = 'T';
					break;
				case 'I': codiceData[j] = 'S';
					break;
				case 'j': codiceData[j] = 'T';
					break;
			}
			
			
			}
				sommaDisp = sommaDisp + codiceFiscale.charAt(d);
			
			
			
			System.out.println(codiceFiscale);
		}	
	}
}
