package it.unibs.fp.TamaGolem;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


public class Fase2 {
	

		private Giocatore giocatore;
		
		Pietra [] scortaComune = new Pietra[15];
		
		int numTama1 = 2;
		int numTama2 = 2;
		
		static String scelta = STR_Utili.scelta;
		
		static String [] voci = STR_Utili.ELENCO_ELEMENTI;
		
		static MyMenu menu = new MyMenu(scelta, voci);

		public static void assegnaPietre(TamaGolem tama) {
			
			int scelta;
			
			Pietra[] pietre = new Pietra[3];
			
			do {	                                                //do while che gestisce le scelte dell'utente	
				scelta = menu.scegli();
				switch(scelta) {
					case 1:
						
						System.out.println("hai scelto 1");
						
						break;
					
					case 2:
						
						System.out.println("hai scelto 2");
						
						break;
					
					case 3:
						
						break;

					case 4:
						
						break;
					
					case 5:
						
						break;
				}
			} while(scelta!=0);
			
			tama.setPietre(pietre);
			
			for(int i = 0 ; i < tama.getPietre().length; i++) {
				
				System.out.println("Elemento pietra " + i + ":");
				
					
				}
			}
			
		}
	

