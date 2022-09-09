package it.unibs.fp.massaia;

import java.util.*;
import it.unibs.fp.mylib.*;


public class Main {
	private static final String SCELTA = "scegli una opzione: ";
	
	public static void main(String[] args) {
		System.out.println("ciao sono la massaia");
		String[] voci= {"aggiungi ingrediente","visualizza elenco ingradienti","aggiungi ricetta","visualizza elenco ricette","trova menù"};
		MyMenu menu = new MyMenu(SCELTA, voci);
		int scelta=0;
		ArrayList<Ingrediente> ingredienti= new ArrayList<Ingrediente>();
		ArrayList<Ricetta> ricette= new ArrayList<Ricetta>();
		do {
			scelta=menu.scegli();
			
			switch(scelta) {
			
			case 1: 
				ingredienti.add(Ingrediente.creaIngrediente());
				break;
				
			case 2: 
				for(Ingrediente ingredienteN : ingredienti) {
					System.out.println(ingredienteN.toString());
				}
				break;
				
			case 3: 
				Ricetta ricettaNuova= Ricetta.creaRicetta(ingredienti);
				ricette.add(ricettaNuova);
				break;	
				
			case 4: 
				for(Ricetta ricetta : ricette) {
					System.out.println(ricetta.toString());
				}
				break;
				
			case 5: 
				Menu.creaMenu(ricette);
				break;
			}
		}while(scelta!=0);
	}
}




