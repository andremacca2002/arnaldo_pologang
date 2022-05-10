package it.unibs.fp.codiceFiscale;

import java.util.ArrayList;
import java.util.Arrays;

public class CreazioneCodici {

	public static ArrayList<String> creazioneCF(ArrayList<String> codiciPersone,ArrayList<Comune> listaComuni) {
		for(int i = 0; i < Utility_Xml.persone.size(); i++) {
			String codiceFiscale = null;
			String cognome = Utility_Xml.persone.get(i).getCognome();
			String nome = Utility_Xml.persone.get(i).getNome();
			String data = Utility_Xml.persone.get(i).getData();
			String sesso = Utility_Xml.persone.get(i).getSesso();
			String comune = Utility_Xml.persone.get(i).getLuogoNascita();

			
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
					
					UltimoCarattereCF(codiceFiscale);
				
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
			
			for(int j = 0; j < listaComuni.size(); j++) {
				if (comune.equalsIgnoreCase(listaComuni.get(j).getNome())) {
					codiceFiscale = codiceFiscale + listaComuni.get(j).getCodice();
				}
			}
			
			codiciPersone.add(codiceFiscale);
		}
		return codiciPersone;
	}
	
	
	public static String UltimoCarattereCF(String codiceFiscale) {
		int sommaDisp = 0;
		int sommaPari = 0;
		for(int d = 0; d < codiceFiscale.length(); d = d + 2) {
			int valore = 0;
			switch (codiceFiscale.charAt(d)) {
				case '0': valore = 1;
					break;
				case '1': valore = 0;
					break;
				case '2': valore = 5;
					break;
				case '3': valore = 7;
					break;
				case '4': valore = 9;
					break;
				case '5': valore = 13;
					break;
				case '6': valore = 15;
					break;
				case '7': valore = 17;
					break;
				case '8': valore = 19;
					break;
				case '9': valore = 21;
					break;
				case 'A': valore = 1;
					break;
				case 'B': valore = 0;
					break;
				case 'C': valore = 5;
					break;
				case 'D': valore = 7;
					break;
				case 'E': valore = 9;
					break;
				case 'F': valore = 13;
					break;
				case 'G': valore = 15;
					break;
				case 'H': valore = 17;
					break;
				case 'I': valore = 19;
					break;
				case 'J': valore = 21;
					break;
				case 'K': valore = 2;
					break;
				case 'L': valore = 4;
					break;
				case 'M': valore = 18;
					break;
				case 'N': valore = 20;
					break;
				case 'O': valore = 11;
					break;
				case 'P': valore = 3;
					break;
				case 'Q': valore = 6;
					break;
				case 'R': valore = 8;
					break;
				case 'S': valore = 12;
					break;
				case 'T': valore = 14;
					break;
				case 'U': valore = 16;
					break;
				case 'V': valore = 10;
					break;
				case 'W': valore = 22;
					break;
				case 'X': valore = 25;
					break;
				case 'Y': valore = 24;
					break;
				case 'Z': valore = 23;
					break;
			}
			sommaDisp = sommaDisp + valore;
		}
		
		for(int p = 1; p < codiceFiscale.length(); p = p + 2) {
			int valore = 0;
			switch (codiceFiscale.charAt(p)) {
				case '0': valore = 0;
					break;
				case '1': valore = 1;
					break;
				case '2': valore = 2;
					break;
				case '3': valore = 3;
					break;
				case '4': valore = 4;
					break;
				case '5': valore = 5;
					break;
				case '6': valore = 6;
					break;
				case '7': valore = 7;
					break;
				case '8': valore = 8;
					break;
				case '9': valore = 9;
					break;
				case 'A': valore = 0;
					break;
				case 'B': valore = 1;
					break;
				case 'C': valore = 2;
					break;
				case 'D': valore = 3;
					break;
				case 'E': valore = 4;
					break;
				case 'F': valore = 5;
					break;
				case 'G': valore = 6;
					break;
				case 'H': valore = 7;
					break;
				case 'I': valore = 8;
					break;
				case 'J': valore = 9;
					break;
				case 'K': valore = 10;
					break;
				case 'L': valore = 11;
					break;
				case 'M': valore = 12;
					break;
				case 'N': valore = 13;
					break;
				case 'O': valore = 14;
					break;
				case 'P': valore = 15;
					break;
				case 'Q': valore = 16;
					break;
				case 'R': valore = 17;
					break;
				case 'S': valore = 18;
					break;
				case 'T': valore = 19;
					break;
				case 'U': valore = 20;
					break;
				case 'V': valore = 21;
					break;
				case 'W': valore = 22;
					break;
				case 'X': valore = 23;
					break;
				case 'Y': valore = 24;
					break;
				case 'Z': valore = 25;
					break;
			}
			sommaPari = sommaPari + valore;
		}
		
		int codiceControllo = (sommaPari + sommaDisp) % 26;
		
		String valore = null;
		switch (codiceControllo) {
			case 0: valore = "A";
				break;
			case 1: valore = "B";
				break;
			case 2: valore = "C";
				break;
			case 3: valore = "D";
				break;
			case 4: valore = "E";
				break;
			case 5: valore = "F";
				break;
			case 6: valore = "G";
				break;
			case 7: valore = "H";
				break;
			case 8: valore = "I";
				break;
			case 9: valore = "J";
				break;
			case 10: valore = "K";
				break;
			case 11: valore = "L";
				break;
			case 12: valore = "M";
				break;
			case 13: valore = "N";
				break;
			case 14: valore = "O";
				break;
			case 15: valore = "P";
				break;
			case 16: valore = "Q";
				break;
			case 17: valore = "R";
				break;
			case 18: valore = "S";
				break;
			case 19: valore = "T";
				break;
			case 20: valore = "U";
				break;
			case 21: valore = "V";
				break;
			case 22: valore = "W";
				break;
			case 23: valore = "X";
				break;
			case 24: valore = "Y";
				break;
			case 25: valore = "Z";
				break;
		}
		return codiceFiscale = codiceFiscale + valore;
	}

}
