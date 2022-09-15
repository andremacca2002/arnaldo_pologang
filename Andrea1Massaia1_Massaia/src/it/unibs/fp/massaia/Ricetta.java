
package it.unibs.fp.massaia;
import java.util.*;

import it.unibs.fp.mylib.InputDati;

public class Ricetta {
	private static final String MGS_ELENCO_INGREDIENTI = "elenco degli ingredienti disponibili: ";
	private ArrayList<Ingrediente> ingredieti;
	private String nome;
	private String descrizione;
	private int classificazione;
	private double cal;
	
	public Ricetta(ArrayList<Ingrediente> ingredienti, String nome, String descrizione, int classificazione) {
		super();
		this.ingredieti = ingredienti;
		this.nome = nome;
		this.descrizione = descrizione;
		this.classificazione = classificazione;
	}

	public double setCal() {
		cal=0;
		for(int i=0; i< this.ingredieti.size(); i++) {
			cal=cal + this.ingredieti.get(i).getCal()*this.ingredieti.get(i).getQuantità();
		}
		return cal;
		
	}
	
	public int getClassificazione() {
		return classificazione;
		
	}
	public void setClassificazione(int classificazione) {
		this.classificazione = classificazione;
	}
	
	public double getCal() {
		return cal;
	}
	
	public static Ricetta creaRicetta(ArrayList<Ingrediente> ingredienti) {
		String nomeRicetta;
		nomeRicetta = InputDati.leggiStringaNonVuotaAlfanumerica(STR.MSG_NOME_RICETTA);
		
		boolean valido2=false;
		int classificazione;
		
		do {
			classificazione = InputDati.leggiIntero(STR.MSG_PRIMO_O_SECONDO);
			if(classificazione<1 || classificazione>2)valido2=true;
			else valido2=false;
		}while(valido2);
		
		ArrayList<Ingrediente> ingredientiR= new ArrayList<Ingrediente>();
		System.out.println(MGS_ELENCO_INGREDIENTI);
		for(int i=0; i<ingredienti.size(); i++) {
			System.out.println("->" + (i+1) + ": " + ingredienti.get(i).toString());
		}
		boolean valido=false;
		do {
			int numIngrediente = InputDati.leggiIntero(STR.MSG_QUALE_INGREDIENTE);
			if((numIngrediente-1)>=ingredienti.size()) {
				System.out.println(STR.MSG_INGREDIENTE_NON_PRESENTE);
			}
			else if(!(numIngrediente==0)) {
				Ingrediente ingredienteN=ingredienti.get(numIngrediente-1);
				ingredienteN.setQuantità(InputDati.leggiIntero(STR.MSG_QUANTI_ETTOGRAMMI));
				ingredientiR.add(ingredienteN);
			}
			else if(ingredientiR.size()==0){
				System.out.println(STR.MSG_ALMENO_UN_INGREDIENTE);
			}
			else {
				valido=true;
			}
		}while(!valido);
	
		String descrizione = InputDati.leggiStringaNonVuotaAlfanumerica(STR.INSERISCI_DESCRIZIONE_RICETTA);
		Ricetta ricettaN= new Ricetta(ingredientiR, nomeRicetta, descrizione, classificazione);
		ricettaN.setCal();
		return ricettaN;	
	}
	
@Override
	public String toString() {
		StringBuffer descrizione1 = new StringBuffer(); 
		descrizione1.append(STR.MSG_NOME + nome);
		descrizione1.append(STR.MSG_DESCRIZIONE + descrizione);
		descrizione1.append(STR.MSG_CLASSIFICAZIONE + classificazione);
		descrizione1.append(STR.MSG_CAL + cal);
		descrizione1.append(STR.MSG_INGREDIENTI + ingredieti);
		return descrizione1.toString();
	}
}