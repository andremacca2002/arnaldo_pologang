package it.unibs.fp.massaia;

import java.util.*;

import it.unibs.fp.mylib.InputDati;

public class Menu {
	
	private Ricetta primoPiatto;
	private Ricetta secondoPiatto; 
	private double calorie;
	
	public Menu(Ricetta primoPiatto, Ricetta secondoPiatto, double calorie) {
		this.primoPiatto = primoPiatto;
		this.secondoPiatto = secondoPiatto;
		this.calorie = calorie;
	}
	
	public double calcolaCalorieMenu(Ricetta primoPiatto, Ricetta secondoPiatto) {
		return calorie;
	}

	
	public static void creaMenu(ArrayList<Ricetta> ricette) {
		Random random = new Random();
		double calorieMenu = InputDati.leggiIntero(STR.INSERISCI_CALORIE_MAX);
		ArrayList<Ricetta> ricetteprimi = new ArrayList<Ricetta>();
		ArrayList<Ricetta> ricettesecondi = new ArrayList<Ricetta>();
		
		for(int i=0; i<ricette.size(); i++) {
			if(ricette.get(i).getClassificazione()==1) {
				ricetteprimi.add(ricette.get(i));
			}
			else if(ricette.get(i).getClassificazione()==2) {
				ricettesecondi.add(ricette.get(i));
			}
		}
		boolean trovato=false;
		do {
			if(ricetteprimi.size()==0) {
				System.out.println(STR.MSG_NO_COMBINATION);
				trovato=true;
			}
		else {
			int n = random.nextInt(100) % ricetteprimi.size();
			Ricetta piattoMenu=ricetteprimi.get(n);
			ricetteprimi.remove(n);
			
			for(int i=0; i<ricettesecondi.size(); i++) {
				if((piattoMenu.getCal()+ricettesecondi.get(i).getCal())<=calorieMenu) {
					System.out.println(STR.MSG_COMPOSIZIONE_MENU + piattoMenu.toString()+
							STR.MSG_SECONDOPIATTO + ricettesecondi.get(i).toString());
					trovato=true;
					}
			if(trovato)break;
			}
		}
		}while(!trovato);
	}

	
	@Override
	public String toString() {
		StringBuffer descrizione1 = new StringBuffer(); 
		descrizione1.append(STR.MSG_MENU_COMPOSTO_DA);
		descrizione1.append(STR.MSG_PRIMO_PIATTO + primoPiatto);
		descrizione1.append(STR.MSG_SECONDO_PIATTO + secondoPiatto);
		descrizione1.append(STR.MSG_CAL + calorie);
		return descrizione1.toString();
	}
}

