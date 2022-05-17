package it.unibs.fp.TamaGolem;


import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


public class Fase2 {
	
		static String scelta = STR_Utili.SCELTAPIETRE; //menu scelta pietre 
		static String [] voci = STR_Utili.ELENCO_ELEMENTI;
		static MyMenu menu = new MyMenu(scelta, voci);
		
		static String scelta1 = STR_Utili.SCELTATAMAGOLEM; //menu scelta tamagolem da evocare 
		static String voci1[]= {""};
		static MyMenu menu1 = new MyMenu(scelta1, voci1);
		
		private Giocatore giocatore;
		private Pietra [] scortaComune = new Pietra[15];
		
		int numTama1 = 2;
		int numTama2 = 2;
		
		
		final static int vita=10;
	
		public static Giocatore registragiocatore() {
		
		String nome =InputDati.leggiStringaNonVuota("\n Come ti chiami? ");
		System.out.println("tocca ai tuoi tamagolem, come si chiamano?\n ");
		
		String nomeTam1 = InputDati.leggiStringaNonVuota("->");
		String nomeTam2 = InputDati.leggiStringaNonVuota("->");
		
		
		Pietra pietreTama1[]= new Pietra[3];
		Pietra pietreTama2[]= new Pietra[3];
		
		TamaGolem tama1= new TamaGolem(vita, pietreTama1,nomeTam1);
		TamaGolem tama2= new TamaGolem(vita, pietreTama2,nomeTam1);
		
		TamaGolem tamaSquad[]=new TamaGolem[2];
		
		tamaSquad[0]=tama1;
		tamaSquad[1]=tama2;
			
		Giocatore giocatore = new Giocatore(nome, tamaSquad);
		
		return giocatore;
		}

		
		
		public static TamaGolem evocazione(Giocatore giocatore, TamaGolem[] tamagang ) {
			
		TamaGolem tamaEvocato=null;	
		if(tamagang.length==0)
	    	System.out.println("hai esaurito i tuoi tamagolem");
	    else {
			for(int j=0; j< tamagang.length; j++){
					voci1[j]=tamagang[j].getNome();
					}
			
		    System.out.println(giocatore.getNome() + "quale tamagolem vuoi evocare?");
				
				int scelta2;
				do {	
					scelta2 = menu1.scegli();
					switch(scelta2) {
						
						case 1: 
							tamaEvocato = tamagang[0];
							scelta2=0;
							
						
						
						case 2:
							tamaEvocato = tamagang[1];
							scelta2=0;

		
					}
					
				} while(scelta2!=0);
	    }
		return tamaEvocato;
	    
		}
		
		
		public static void assegnaPietra(TamaGolem tama) {
				int scelta3;
				
				Pietra[] pietre = new Pietra[3];
			
				int i=0;
				
				do {									//do while che gestisce le scelte dell'utente	
					scelta3 = menu.scegli();
					
					switch(scelta3) {
						case 1:
							Pietra P1 = new Pietra(Elemento.BARBECUE);
							pietre[i]= P1;
							i++;
							break;
						
						case 2:
							Pietra P2 = new Pietra(Elemento.KETCHUP);
							pietre[i]= P2;
							i++;
							break;
							
						case 3:
							
							Pietra P3 = new Pietra(Elemento.MAIONESE);
							pietre[i]= P3;
							i++;
							break;
	
						case 4:
							
							Pietra P4 = new Pietra(Elemento.TERIYAKI);
							pietre[i]= P4;
							i++;
							break;
						
						case 5:
							
							Pietra P5 = new Pietra(Elemento.YOGURT);
							pietre[i]= P5;
							i++;
							break;
					}
				} while(i < 3);
				
				System.out.println("hai scelto: ");
				
				for(i=0; i<3; i++) System.out.println(pietre[i].toString()+ " ");
				
				tama.setPietre(pietre);   
			}
		}
		

			
	

