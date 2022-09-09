package it.unibs.fp.massaia;

import java.util.ArrayList;

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

	@Override
	public String toString() {
		return "Menu [primoPiatto=" + primoPiatto + ", secondoPiatto=" + secondoPiatto + ", calorie=" + calorie + "]";
	}
	
	public static void creaMenu(ArrayList<Ricetta> ricette) {
		double calorieMenu = InputDati.leggiIntero("inserisci le calorie massime del menu");
		ArrayList<Ricetta> ricetteprimi = new ArrayList<Ricetta>();
		ArrayList<Ricetta> ricettesecondi = new ArrayList<Ricetta>();
		
		for(int i=0; i<ricette.size(); i++) {
			if(ricette.get(i).getClassificazione()==1) {
				ricetteprimi.add(ricette.get(i));
			}
			if(ricette.get(i).getClassificazione()==2) {
				ricettesecondi.add(ricette.get(i));
			}
		}
		boolean trovato=false;
		do {
		if(ricetteprimi.size()==0) {
			System.out.println("nessuna combinazione possibile");
			trovato=true;
		}
		else {
			int n=(int)Math.random()%ricetteprimi.size();
			Ricetta piattoMenu=ricetteprimi.get(n);
			ricetteprimi.remove(n);
			for(int i=0; i<ricettesecondi.size(); i++) {
				if((piattoMenu.getCal()+ricettesecondi.get(i).getCal())<=calorieMenu) {
					System.out.println("il menù è composto da: \nprimo piatto:\n"+piattoMenu.toString()+
							"\nsecondopiatto:\n "+ ricettesecondi.get(i).toString());
					trovato=true;
					}
			if(trovato)break;
			}
		}
		}while(!trovato);
	}

}
