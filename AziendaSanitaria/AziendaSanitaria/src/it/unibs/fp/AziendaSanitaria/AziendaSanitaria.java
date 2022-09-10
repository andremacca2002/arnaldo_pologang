package it.unibs.fp.AziendaSanitaria;
import it.unibs.fp.mylib.*;
import java.util.*;

public class AziendaSanitaria {
	private static final String SCEGLIERE_GIORNO = "Scegliere giorno libero medico:";
	private static final String[] GIORNI_SETT= {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
	private String nome;
	private String descrizione;
	private ArrayList<Medico> listaMedici = new ArrayList<Medico>();
	private ArrayList<Paziente> listaPaziente = new ArrayList<Paziente>();
	
	public AziendaSanitaria(String nome, String descrizione, ArrayList<Medico> listaMedici, ArrayList<Paziente> listaPazienti) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.listaMedici = listaMedici;
		this.listaPaziente = listaPazienti;
	}

	public ArrayList<Medico> getListaMedici() {
		return listaMedici;
	}

	public void setListaMedici(ArrayList<Medico> listaMedici) {
		this.listaMedici = listaMedici;
	}

	public ArrayList<Paziente> getListaPaziente() {
		return listaPaziente;
	}

	public void setListaPaziente(ArrayList<Paziente> listaPaziente) {
		this.listaPaziente = listaPaziente;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public Medico inserimentoMedico() {
		String nomeMedico = InputDati.leggiStringaNonVuota("Inserisci nome medico: ");
		String cognomeMedico = InputDati.leggiStringaNonVuota("Inserisci cognome medico: ");
		boolean valido = false;
		
		String codice;
		do {
			codice = InputDati.leggiStringaNonVuota("Inserisci codice medico: ");
			
			for(int i = 0; i < listaMedici.size(); i++) {
				if(listaMedici.get(i).getCodice().equals(codice)) {
					System.out.println("Il codice è già stato inserito.");
					valido = true;
				}
				else {
					valido = false;
				}
			}
		}while(valido);
		GiorniSettimana giorno = null;
		int scelta;
		MyMenu menu = new MyMenu(SCEGLIERE_GIORNO, GIORNI_SETT);
		scelta = menu.scegli();
		
		switch (scelta) {
		case 1:
			giorno = GiorniSettimana.valueOf("LUNEDI");
			break;
		case 2:
			giorno = GiorniSettimana.valueOf("MARTEDI");
			break;
		case 3:
			giorno = GiorniSettimana.valueOf("MERCOLEDI");
			break;
		case 4:
			giorno = GiorniSettimana.valueOf("GIOVEDI");
			break;
		case 5:
			giorno = GiorniSettimana.valueOf("VENERDI");
			break;
		case 6:
			giorno = GiorniSettimana.valueOf("SABATO");
			break;
		case 7:
			giorno = GiorniSettimana.valueOf("DOMENICA");
			break;
		}
		
		return new Medico(codice, nomeMedico, cognomeMedico, giorno);
	}
	
	public Paziente inserimentoPaziente(ArrayList<Medico> medici) {

		Random random = new Random();
		boolean valido = false;
		String tesseraSanitaria;
		do {
			tesseraSanitaria = InputDati.leggiStringaNonVuota("Inserisci codice tessera sanitaria: ");
			
			for(int i = 0; i < listaPaziente.size(); i++) {
				if(listaPaziente.size() == 0);
				else if(listaPaziente.get(i).getTesseraSanitaria().equals(tesseraSanitaria)) {
					System.out.println("Il codice è già stato inserito.");
					valido = true;
				}
				else {
					valido = false;
				}
			}
		}while(valido);
		
		String nomePaziente = InputDati.leggiStringaNonVuota("Inserire nome paziente: ");
		String cognomePaziente = InputDati.leggiStringaNonVuota("Inserire cognome paziente: ");
		
		int num = random.nextInt(1000) % medici.size();
		
		String codiceMedico = medici.get(num).getCodice();
		
		return new Paziente(tesseraSanitaria, nomePaziente, cognomePaziente, codiceMedico);
	}
	
	public void ricercaMedico(ArrayList<Medico> mediciAzienda) {
		final String TITOLO = "Scegli tra le seguenti opzioni:";
		final String[] VOCI = {"per giorno di riposo","per codice"};
		MyMenu menu = new MyMenu(TITOLO, VOCI);
		int scelta;
		do {
			scelta = menu.scegli();
			switch(scelta) {
				case 1:
					System.out.println("Qual è il giorno?");
					
					GiorniSettimana giornoMedico = null;
					int scelta1;
					MyMenu menu1 = new MyMenu(SCEGLIERE_GIORNO, GIORNI_SETT);
					scelta1 = menu1.scegli();
					
					switch (scelta1) {
						case 1:
							giornoMedico = GiorniSettimana.valueOf("LUNEDI");
							break;
						case 2:
							giornoMedico = GiorniSettimana.valueOf("MARTEDI");
							break;
						case 3:
							giornoMedico = GiorniSettimana.valueOf("MERCOLEDI");
							break;
						case 4:
							giornoMedico = GiorniSettimana.valueOf("GIOVEDI");
							break;
						case 5:
							giornoMedico = GiorniSettimana.valueOf("VENERDI");
							break;
						case 6:
							giornoMedico = GiorniSettimana.valueOf("SABATO");
							break;
						case 7:
							giornoMedico = GiorniSettimana.valueOf("DOMENICA");
							break;
					}
					
					System.out.println("medici non a riposo: ");
					for(int i=0; i< mediciAzienda.size(); i++) {
						if(mediciAzienda.get(i).getGiornoLibero().equals(giornoMedico)) {
							System.out.println(mediciAzienda.get(i).getNome() + " " + mediciAzienda.get(i).getCognome() + "\n");
						  }
	                }
	                break;
	            
	            case 2:
	                String codiceUniv = InputDati.leggiStringaNonVuota("qual'è il codice del medico che sta cercando?");
	                for(int i=0; i< mediciAzienda.size(); i++) {
	                    if(mediciAzienda.get(i).getCodice().equals(codiceUniv)) System.out.println(mediciAzienda.get(i).toString());
	                }
	                break;
	        }
	    }while(scelta!=0);
	}

	public void ricercaPaziente(ArrayList<Paziente> pazienti, ArrayList<Medico> medici, String codiceSanitario) {
		for(int i = 0; i < pazienti.size(); i++) {
			if(pazienti.get(i).getTesseraSanitaria().equals(codiceSanitario)) {
				for(int j = 0; j < medici.size(); j++) {
					if(medici.get(j).getCodice().equals(pazienti.get(i).getMedico())) {
						System.out.println("Il paziente ricercato è " + pazienti.get(i).getNome() + " " + 
											pazienti.get(i).getCognome() + ", il suo medico associato è " + 
											medici.get(j).getNome() + " " + medici.get(j).getCognome());
					}
					else {
						System.out.println("Non è stato trovato nessun paziente.");
					}
				}
			}
			
		}
	}
	
	public void riassegnamentoPazienteMedico(ArrayList<Paziente> pazienti, ArrayList<Medico> medici) {
		for(int j = 0; j < pazienti.size(); j++) {
			System.out.println((j+1) + ". " + pazienti.get(j).toString());
		}
		
		int paziente = InputDati.leggiIntero("Inserire numero paziente desiderato: ", 1, pazienti.size());
		
		System.out.println("Seleziona il medico disponibile: ");
		int x = 0;
		for(int i = 0; i < medici.size(); i++) {
			if(!(pazienti.get(paziente).getMedico().equals(medici.get(i).getCodice()))) {
				System.out.println((i+1) + ". " + medici.get(i).toString());
			}
			else {
				x = i;
			}
		}	
		
		boolean valido = false;
		int medico;
		
		do {
			medico = InputDati.leggiIntero("-> ", 1, medici.size());
			
			if(medico == x) {
				System.out.println("Selezione errata.");
				valido = true;
			}
			else {
				valido = false;
			}
		}while(valido);
		
		pazienti.get(paziente).setMedico(medici.get(medico-1).getCodice());
		
		System.out.println(pazienti.get(paziente).toString());
	}
}