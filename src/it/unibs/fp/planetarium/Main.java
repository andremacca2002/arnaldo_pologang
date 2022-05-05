package it.unibs.fp.planetarium;
import java.util.*;

import it.unibs.fp.mylib.*;

public class Main {

	public static void main(String[] args) {
		
		String[] voci = STR_U.MENU_VOCI;
		MyMenu menu = new MyMenu(STR_U.SCELTA, voci);
		int scelta;
		
		ArrayList<Pianeta> pianeti = new ArrayList<Pianeta>(); 	
		
		Stella stella = creaStella();                           
		
		do {	                                                //do while che gestisce le scelte dell'utente	
			scelta = menu.scegli();
			switch(scelta) {
				case 1:
					aggiungiPianeta(pianeti, stella);
					break;
				
				case 2:
					aggiungiLuna(pianeti, stella);
					break;
				
				case 3:
					rimuoviPianeta(pianeti);
					break;

				case 4:
					rimuoviLuna(pianeti);
					break;
				
				case 5:
					ricercaCorpoCeleste(pianeti);
					break;
					
				case 6:
					calcoloCentroDiMassa(pianeti, stella);					
					break;
				
				case 7:
					visualizzaLune(pianeti);
					break;
					
				case 8:
					visualizzaPercorsoLuna(pianeti, stella);
					break;
			}
		} while(scelta!=0);
	}

	private static void visualizzaPercorsoLuna(ArrayList<Pianeta> pianeti, Stella stella) {
		
		if(pianeti.size() == 0) {                                     //controllo se esiste almeno un pianeta
			System.out.println(STR_U.WARNING_CORPO_CELESTE);
		}
		
		else {
			System.out.println("\nELENCO LUNE PRESENTI: ");
			for(int i = 0; i < pianeti.size(); i++) {                                            //ciclo che visualizza le lune presenti con i rispettivi codici
				for(int j=0; j < pianeti.get(i).getLune().size(); j++) {
					Luna lunaX = pianeti.get(i).getLune().get(j);
					System.out.println(lunaX.getNome() + ", codice: " + i + "#" + j);      
				}
			}
			
			boolean valido = false;
			
			do {
				valido = false;
				
				String codex = InputDati.leggiStringa("\nInserisci codice luna: ");
			
				if(codex.indexOf('#')==-1) {                                          //controlla se il codice immesso si riferisce ad un pianeta o luna
					System.out.println(STR_U.CODICE_NON_VALIDO);
					valido = true;
				}
				else {
					String P = codex.substring(0, codex.indexOf('#'));
					String L = codex.substring(codex.indexOf('#')+1, codex.length());
					
					if (!(P.matches("-?\\d+")) || !(L.matches("-?\\d+"))) {                       //controlla che il il codice sia un numero
						System.out.println(STR_U.CODICE_NON_VALIDO);
						valido = true;
					}
					else {
						int codicePianeta = Integer.parseInt(P);
						int codiceLuna = Integer.parseInt(L);
						
						if(codicePianeta < 0 || codiceLuna < 0) {
							System.out.println(STR_U.CODICE_NON_VALIDO);
							valido = true;
						}
						else if(codicePianeta >= pianeti.size())	{                                    //controlla che il codice sia un numero all'interno dell'array
							System.out.println(STR_U.CODICE_NON_VALIDO);
							valido = true;
						}
						else if(codiceLuna >= pianeti.get(codicePianeta).getLune().size())	{           //controlla che il codice sia un numero all'interno dell'array
							System.out.println(STR_U.CODICE_NON_VALIDO);
							valido = true;
						}
						
						else {
							System.out.print("\nIl percorso per arrivare alla luna:\n-Partendo dalla stella " + stella.getNome() + 
									" in posizione (" + stella.getX() + ", " + stella.getY() + ") passando per il pianeta ");
							System.out.println(pianeti.get(codicePianeta).getNome() + " in posizione (" + pianeti.get(codicePianeta).getX() + 
									", " + pianeti.get(codicePianeta).getY() + "), arrivando a " + pianeti.get(codicePianeta).getLune().get(codiceLuna).getNome() + 
									" in posizione (" + pianeti.get(codicePianeta).getLune().get(codiceLuna).getX() + ", " + 
									pianeti.get(codicePianeta).getLune().get(codiceLuna).getY() + ").");
						}
					}
				}
			} while(valido);
		}
	}

	private static void visualizzaLune(ArrayList<Pianeta> pianeti) {
		int codicePianeta;
		boolean valido;
		
		if(pianeti.size() == 0) {
			System.out.println(STR_U.WARNING_CORPO_CELESTE);
		}
		
		else {		
			do {
				valido = false;
				codicePianeta = InputDati.leggiIntero("Inserisci codice pianeta: ");
				
				if(codicePianeta < 0) {
					System.out.println(STR_U.CODICE_NON_VALIDO);
					valido = true;
				}
				else if(codicePianeta >= pianeti.size())	{               //controlla che il codice sia un numero all'interno dell'array
					System.out.println(STR_U.WARNING_NO_OP);
					valido = true;
				}
			} while(codicePianeta >= pianeti.size() || valido);
			
			if(pianeti.get(codicePianeta).getLune().size() == 0) {
				System.out.println(STR_U.PIANETA_NO_LUNE);
			}
			else {
				System.out.println("Lune: ");
				
				for(int i = 0; i < pianeti.get(codicePianeta).getLune().size(); i++) {
					System.out.println("\n" + pianeti.get(codicePianeta).getLune().get(i).getNome() + " " + codicePianeta + "#" + i);
				}
			}
		}
	}

	private static void calcoloCentroDiMassa(ArrayList<Pianeta> pianeti, Stella stella) {

		double sommaMasse = 0,massaPerPosizioneX = 0,centroDiMassaX = 0, massaLune=0;
		double massaPerPosizioneY = 0,centroDiMassaY = 0;
		
		if(pianeti.size() > 0) {
		
			for(int i = 0 ; i < pianeti.size() ; i++ ) {
				
			if(pianeti.get(i).getLune().size() != 0) {
				
				for(int j = 0 ; j < pianeti.get(i).getLune().size() ; j++ ) {
				
					massaLune = massaLune + pianeti.get(i).getLune().get(j).getMassa();		
					massaPerPosizioneX = massaPerPosizioneX + (massaLune * pianeti.get(i).getLune().get(j).getX());
					massaPerPosizioneY = massaPerPosizioneX + (massaLune * pianeti.get(i).getLune().get(j).getY());
					}
				}
				
				sommaMasse = sommaMasse + pianeti.get(i).getMassa()  + massaLune;
				
				massaPerPosizioneX =  massaPerPosizioneX + (pianeti.get(i).getMassa() * pianeti.get(i).getX());  
				
				massaPerPosizioneY = massaPerPosizioneY + (pianeti.get(i).getMassa() * pianeti.get(i).getY());
			}
		}
		centroDiMassaX = centroDiMassaX + ((massaPerPosizioneX + stella.getMassa()*stella.getX()) / (sommaMasse + stella.getMassa())) ; //massa*x è la massa e la posizione della stella
		centroDiMassaY = centroDiMassaY + ((massaPerPosizioneY + stella.getMassa() *stella.getY()) / (sommaMasse + stella.getMassa()));
		
		System.out.printf("\nIl centro di massa del sistema è: (%.2f ; %.2f)\n" , centroDiMassaX , centroDiMassaY);
	}

	private static void ricercaCorpoCeleste(ArrayList<Pianeta> pianeti) {
		if(pianeti.size() == 0) {
			System.out.println(STR_U.WARNING_CORPO_CELESTE);
		}
		
		else {
			System.out.println(STR_U.ISTRUZIONI);
			boolean valido;
			do {
				valido = false;
				String codexRicerca = InputDati.leggiStringa(STR_U.ADD__CODE_CL);
				
				if(codexRicerca.indexOf('#')==-1) {
					
					if(!(codexRicerca.matches("-?\\d+"))) {
						System.out.println(STR_U.CODICE_NON_VALIDO);
						valido = true;
					}
					else {
						int codicePianeta = Integer.parseInt(codexRicerca);
						
						if(codicePianeta < 0) {
							System.out.println(STR_U.CODICE_NON_VALIDO);
							valido = true;
						}
						else if(codicePianeta >= pianeti.size()) {
							System.out.println(STR_U.WARNING_NO_P);
							valido = true;
						}
						else {
							System.out.println("\nPIANETA CERCATO:" + pianeti.get(codicePianeta).toString());
						}
					}
				}
				else {
					String P = codexRicerca.substring(0, codexRicerca.indexOf('#'));
					String L = codexRicerca.substring(codexRicerca.indexOf('#')+1, codexRicerca.length());
					
					if (!(P.matches("-?\\d+")) || !(L.matches("-?\\d+"))) {
						System.out.println(STR_U.CODICE_NON_VALIDO);
						valido = true;
					}
					else {
						int codicePianeta = Integer.parseInt(P);
						int codiceLuna = Integer.parseInt(L);
						
						if(codicePianeta < 0 || codiceLuna < 0) {
							System.out.println(STR_U.CODICE_NON_VALIDO);
							valido = true;
						}
						else if(codicePianeta >= pianeti.size())	{
							System.out.println(STR_U.WARNING_NO_OP);
							valido = true;
						}
						else if(codiceLuna >= pianeti.get(codicePianeta).getLune().size())	{
							System.out.println(STR_U.WARNING_NO_L);
							valido = true;
						}
						else {
							System.out.printf("\nLa luna richiesta orbita attorno: %s", pianeti.get(codicePianeta).getNome());
							System.out.println(pianeti.get(codicePianeta).getLune().get(codiceLuna).toString());
						}
					}
				}
			} while(valido);
		}
	}
	
	private static void rimuoviLuna(ArrayList<Pianeta> pianeti) {
		int codex;
		boolean valido;
		System.out.println(STR_U.CONTROL_PLANET);
		
		for(int i=0; i < pianeti.size(); i++) {
			Pianeta pianetaX = pianeti.get(i);
			System.out.println("-> " + pianetaX.getNome() + ": " + i);
		}
		
		do {
			valido = false;
			codex = InputDati.leggiIntero(STR_U.ADD_CODE);
			
			if(codex < 0 || codex >= pianeti.size()) {
				System.out.println(STR_U.CODICE_NON_VALIDO);
				valido = true;
			}
			else if(pianeti.get(codex).getLune().size() == 0) {
				System.out.println(STR_U.PIANETA_NO_LUNE);
			}
			
			else {
				for(int i=0; i < pianeti.get(codex).getLune().size(); i++) {
					Luna lunaX = pianeti.get(codex).getLune().get(i);
					System.out.println(lunaX.getNome() + " " + codex + "#" + i);
				}
				int codexLuna;
				do {
					codexLuna = InputDati.leggiIntero(STR_U.ADD_CODE_L + codex + "#");
					
					if(codexLuna < 0 || codexLuna > pianeti.get(codex).getLune().size()) {
						System.out.println(STR_U.CODICE_NON_VALIDO);
						valido = true;
					}
				} while(valido);
				
				pianeti.get(codex).getLune().remove(codexLuna);
			}
		} while(valido);
	}

	private static void rimuoviPianeta(ArrayList<Pianeta> pianeti) {
		int codex;
		boolean valido;
		System.out.println(STR_U.CANCEL_PLANET);
		if(pianeti.size() == 0) {
			System.out.println("Non ci sono pianeti.");
		}
		else {
			for(int i=0; i < pianeti.size(); i++) {
				Pianeta pianetaX = pianeti.get(i);
				System.out.println(pianetaX.getNome() + ", codice pianeta: " + i);
			}
			do {
				valido=false;
				codex = InputDati.leggiIntero(STR_U.ADD_CODE_P);
				
				if(codex < 0 || codex > pianeti.size()) {
					System.out.println("Codice non valido inserito.");
					valido=true;
				}
				else {
					pianeti.remove(codex);
					
					for(int i=0; i < pianeti.size(); i++) {
						Pianeta pianetaX = pianeti.get(i);
						System.out.println(pianetaX.getNome() + " codex: " + i);
					}
				}
			}while(valido);
		}
	}

	private static void aggiungiLuna(ArrayList<Pianeta> pianeti, Stella stella) {
		int codex;
		double massa;
		double x;
		double y;
		String nome;
		int count;
		
		nome = InputDati.leggiStringaNonVuota(STR_U.ADD_NAME);
		
		do {
			massa = InputDati.leggiDouble(STR_U.ADD_M);
		} while(massa <= 0);
		
		do {
			count = 0;
			x = InputDati.leggiDouble(STR_U.ADD_X);
			y = InputDati.leggiDouble(STR_U.ADD_Y);
		
			if((stella.getX() == x) && (stella.getY() == y)) {
				System.out.format(STR_U.WARNING_COORDINATE_STELLA, stella.getNome());
				count++;
			}
			else {
				for(int i = 0 ; i < pianeti.size() ; i++ ) {
					
					if((pianeti.get(i).getX() == x) && (pianeti.get(i).getY() == y)) {
						System.out.format(STR_U.WARNING_COORDINATE_PIANETA, pianeti.get(i).getNome());
						count++;
					}
				}
				
				if(count == 0) {
					for(int k = 0 ; k < pianeti.size() ; k++ ) {
						
						if(pianeti.get(k).getLune().size() != 0) {
							
							for(int j = 0 ; j < pianeti.get(k).getLune().size() ; j++ ) {
								
								if((pianeti.get(k).getLune().get(j).getX() == x) && (pianeti.get(k).getLune().get(j).getY() == y)) {
									System.out.format(STR_U.WARNING_COORDINATE_LUNE, pianeti.get(k).getLune().get(j).getNome());
									count++;
								}
							}
						}
					}
				}
			}
			
		}while(count != 0);
		
		Punto posizione2 = new Punto(x, y);

		Luna lunaN = new Luna(nome, massa, posizione2);

		System.out.println(STR_U.CONTROL_PLANET);
		
		for(int i=0; i < pianeti.size(); i++) {
			Pianeta pianetaX = pianeti.get(i);
			System.out.println(pianetaX.getNome() + ": " + i);
		}
		
		do {
			codex = InputDati.leggiIntero(STR_U.ADD_CODE);              // verifica che il codice identifichi pianeta all'interno dell'array "pianeta"
		} while(codex < 0 || codex >= pianeti.size());
		
		pianeti.get(codex).getLune().add(lunaN);                        //aggiunta della luna 
		
		System.out.println(pianeti.get(codex).toString());              
	}

	private static void aggiungiPianeta(ArrayList<Pianeta> pianeti,  Stella stella) {
		double massa;
		double x;
		double y;
		String nome;
		int count;
		
		nome = InputDati.leggiStringaNonVuota(STR_U.ADD_NAME);
		do {
			massa = InputDati.leggiDouble(STR_U.ADD_M);
		} while(massa <= 0);
		
		do {
			count = 0;
			x = InputDati.leggiDouble(STR_U.ADD_X);
			y = InputDati.leggiDouble(STR_U.ADD_Y);
		
			if((stella.getX() == x) && (stella.getY() == y)) {
				System.out.format(STR_U.WARNING_COORDINATE_STELLA, stella.getNome());
				count++;
			}
			else {
				for(int i = 0 ; i < pianeti.size() ; i++ ) {
					
					if((pianeti.get(i).getX() == x) && (pianeti.get(i).getY() == y)) {
						System.out.format(STR_U.WARNING_COORDINATE_PIANETA, pianeti.get(i).getNome());
						count++;
					}
				}
				
				if(count == 0) {
					for(int k = 0 ; k < pianeti.size() ; k++ ) {
						
						if(pianeti.get(k).getLune().size() != 0) {
							
							for(int j = 0 ; j < pianeti.get(k).getLune().size() ; j++ ) {
								
								if((pianeti.get(k).getLune().get(j).getX() == x) && (pianeti.get(k).getLune().get(j).getY() == y)) {
									System.out.format(STR_U.WARNING_COORDINATE_LUNE, pianeti.get(k).getLune().get(j).getNome());
									count++;
								}
							}
						}
					}
				}
			}
			
		}while(count != 0);
		

		Punto posizione1 = new Punto(x, y);

		ArrayList<Luna> lune = new ArrayList<Luna>();

		Pianeta pianetaN = new Pianeta(nome, massa, posizione1, lune);
		
		pianeti.add(pianetaN);

		System.out.println(pianetaN.toString());
	}
	
	private static Stella creaStella() {
		double massa;
		double x;
		double y;
		String nome;
		
		System.out.println(STR_U.ADD_STAR);						//creazione stella
		nome = InputDati.leggiStringaNonVuota(STR_U.ADD_NAME);

		do {
			massa = InputDati.leggiDouble(STR_U.ADD_M);
		} while(massa <= 0);
			
		x = InputDati.leggiDouble(STR_U.ADD_X);
		y = InputDati.leggiDouble(STR_U.ADD_Y);
		
		Punto posizione = new Punto(x, y);
		
		System.out.println("\n");
		Stella stella = new Stella(nome, massa, posizione);
		return stella;

	}
}