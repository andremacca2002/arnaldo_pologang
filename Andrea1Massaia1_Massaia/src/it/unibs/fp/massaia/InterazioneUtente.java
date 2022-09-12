package it.unibs.fp.massaia;

import java.util.ArrayList;

import it.unibs.fp.mylib.MyMenu;

public class InterazioneUtente {
	
	public void menuPrincipale() {
		
	String[] voci= {STR.OPZIONE_1_MENU_PRINC,STR.OPZIONE_2_MENU_PRINC,STR.OPZIONE_3_MENU_PRINC,STR.OPZIONE_4_MENU_PRINC,STR.OPZIONE_5_MENU_PRINC};
	MyMenu menu = new MyMenu(STR.SCELTA, voci);
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
