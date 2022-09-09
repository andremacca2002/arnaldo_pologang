
package it.unibs.fp.massaia;
import java.util.*;

import it.unibs.fp.mylib.InputDati;

public class Ricetta {

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
	@Override
	public String toString() {
		return "\n nome=" + nome + "\n descrizione=" + descrizione
				+ "\n classificazione=" + classificazione + "\n cal=" + cal + "\n ingredieti presenti=\n" + ingredieti;
		
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
		boolean valido1=false;
		String nomeRicetta;
		do {
		nomeRicetta = InputDati.leggiStringaNonVuota("come si chima la ricetta");
			if (!(nomeRicetta.matches("-?\\d+"))) { //verifica sia un numero 
				valido1=true;
			}
		}while(!valido1);
		
		boolean valido2=false;
		
		do {
		int classificazione = InputDati.leggiIntero("primo o secondo piatto?");
		if(classificazione<1 || classificazione>2)valido2=true;
		else valido2=false;
		}while(valido2);
		
		ArrayList<Ingrediente> ingredientiR= new ArrayList<Ingrediente>();
		
		for(int i=0; i<ingredienti.size(); i++) {
			System.out.println((i+1)+ingredienti.get(i).toString());
		}
		boolean valido=false;
		do {
			int numIngrediente = InputDati.leggiIntero("quale ingrediente vuoi usare?");
			if(numIngrediente>=ingredienti.size()) {
			}
			else if(!(numIngrediente==0)) {
				Ingrediente ingredienteN=ingredienti.get(numIngrediente-1);
				ingredienteN.setQuantità(InputDati.leggiIntero("quanti ettogrammi?"));
				ingredientiR.add(ingredienteN);
			}
			else if(ingredientiR.size()>0){
				System.out.println("inserisci almeno un ingrediente");
			}
			else {
				valido=true;
			}
		}while(!valido);
		String descrizione = InputDati.leggiStringaNonVuota("inserisci una descrizione della ricetta");
		Ricetta ricettaN= new Ricetta(ingredientiR, nomeRicetta, descrizione, classificazione);
		ricettaN.setCal();
		return ricettaN;	
	}
}
