package it.unibs.fp.CD;

import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<CD> dischi = new ArrayList<CD>();
		ArchivioCD archivio = new ArchivioCD(dischi);
		MyMenu menu = new MyMenu(Menu.titolo, Menu.voci);
		int scelta;
		
		do {
			scelta = menu.scegli();
			switch(scelta) {
				case 1:
					
					inserimentoDisco(archivio);
	
					break;
				
				case 2:
					
					eliminazioneDisco(archivio);
					
					break;
				
				case 3:
					
					visualizzazioneDischi(archivio);
					
					break;
	
				case 4:
					
					riproduzioneCasuale(archivio);
					
					break;
			}
		}while(scelta!=0);
	}

	public static void riproduzioneCasuale(ArchivioCD archivio) {
		System.out.println();
		CD discoRandom = archivio.randomCD();
		
		if(discoRandom == null) {
			System.out.println("Non sono presenti CD all'interno dell'archivio.");
		}
		else {
			Brano branoRandom = discoRandom.randomBrano();
			System.out.println("Riproduzione casuale: ");
			System.out.println(branoRandom.toString());
		}
	}

	public static void visualizzazioneDischi(ArchivioCD archivio) {
		System.out.println();
		
		if(archivio.getDischi().size() == 0) {
			System.out.println("Non sono presenti CD all'interno dell'archivio.");
		}
		else {
			for(int i = 0; i < archivio.getDischi().size(); i++) {
				System.out.println((i+1) + " - " + archivio.getDischi().get(i).toString()); 
			}
		}
	}

	public static void eliminazioneDisco(ArchivioCD archivio) {
		System.out.println();
		
		int numCD;
		
		if(archivio.getDischi().size() == 0) {
			System.out.println("Non sono presenti CD all'interno dell'archivio.");
		}
		else {
			for(int i = 0; i < archivio.getDischi().size(); i++) {
				System.out.println((i+1) + " - " + archivio.getDischi().get(i).toString()); 
			}
			
			System.out.println();
			
			numCD = InputDati.leggiIntero("Inserisci numero CD da eliminare dall'archivio: ", 1, archivio.getDischi().size());
			archivio.deleteCD(archivio.getDischi().get(numCD-1).getNome());
		}
	}

	public static void inserimentoDisco(ArchivioCD archivio) {
		System.out.println();
		
		boolean valido = true;
		String titoloCD;
		String autore;
		int numBrani;
		String titoloB;
		int durata;
		ArrayList<Brano> brani = new ArrayList<Brano>();
		
		do {
			titoloCD = InputDati.leggiStringaNonVuota("Inserisci titolo CD: ");
			
			
			for(int i = 0; i < archivio.getDischi().size(); i++) {
				if(archivio.getDischi().get(i).getNome().equalsIgnoreCase(titoloCD)) {
					valido = false;
				}
				else valido = true;
			}
		}while(!valido);
		
		autore = InputDati.leggiStringaNonVuota("Inserisci autore CD: ");
		
		numBrani = InputDati.leggiIntero("Inserisci il numero di brani che vuoi salvare: ", 1, 21);
		
		for(int i = 0; i < numBrani; i++) {
			titoloB = InputDati.leggiStringaNonVuota("Inserisci titolo brano: ");
			durata = InputDati.leggiIntero("Inserisci durata in secondi del brano: ", 1, 999);
			Brano branoN = new Brano(titoloB, durata);
			brani.add(branoN);
		}
		
		CD disco = new CD(titoloCD, autore, brani);
		archivio.insertCD(disco);
	}
}
