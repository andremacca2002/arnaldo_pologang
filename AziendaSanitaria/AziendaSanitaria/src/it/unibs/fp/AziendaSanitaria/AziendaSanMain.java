package it.unibs.fp.AziendaSanitaria;
import it.unibs.fp.mylib.*;
import java.util.ArrayList;

public class AziendaSanMain {
	public static final String TITOLO = "Scegli tra le seguenti opzioni:";
	public static final String[] VOCI = {"Inserimento medico.", "Inserimento paziente.", 
										"Ricerca medico.", "Ricerca paziente.", 
										"Riassegnamento medico-paziente."};
	
	public static void main(String[] args) {
		ArrayList<Medico> medici = new ArrayList<Medico>();
		ArrayList<Paziente> pazienti = new ArrayList<Paziente>();
		
		String nomeAzienda = InputDati.leggiStringaNonVuota("Inserisci nome azienda: ");
		String descrizione = InputDati.leggiStringaNonVuota("Inserisci breve descrizione dell'azienda: ");
		
		AziendaSanitaria azienda = new AziendaSanitaria(nomeAzienda, descrizione, medici, pazienti);
		
		MyMenu menu = new MyMenu(TITOLO, VOCI);
		
		int scelta;
		do {
			scelta = menu.scegli();
			switch (scelta) {
			case 1:
				medici.add(azienda.inserimentoMedico());
				break;
			case 2:
				if(medici.size() == 0) {
					System.out.println("E' necessario aggiungere dei medici.");
				}
				else {
					pazienti.add(azienda.inserimentoPaziente(medici));
				}
				break;
			case 3:
					azienda.ricercaMedico(medici);
				break;
			case 4:
				String codiceSanitario = InputDati.leggiStringaNonVuota("Inserisci codice sanitario del paziente: ");
				azienda.ricercaPaziente(pazienti, medici, codiceSanitario);
				break;
			case 5:
				azienda.riassegnamentoPazienteMedico(pazienti, medici);
				break;
			}
		}while(scelta!=0);
	}
}