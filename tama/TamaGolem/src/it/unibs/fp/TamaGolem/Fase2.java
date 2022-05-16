package it.unibs.fp.TamaGolem;


import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


public class Fase2 {
	

		private Giocatore giocatore;
		
		Pietra [] scortaComune = new Pietra[15];
		
		int numTama1 = 2;
		int numTama2 = 2;
		
		static String scelta = STR_Utili.SCELTAPIETRE;
		
		static String [] voci = STR_Utili.ELENCO_ELEMENTI;
		
		static MyMenu menu = new MyMenu(scelta, voci);

		public static void assegnaPietre(TamaGolem tama) {
			
			int scelta;
			
			Pietra[] pietre = new Pietra[3];
			int i=0;
			do {									//do while che gestisce le scelte dell'utente	
				scelta = menu.scegli();
				switch(scelta) {
					case 1:
						Pietra P1 = new Pietra(Elemento.BARBECUE);
						pietre[i]= P1;
						//System.out.println(pietre[i].toString());
						i++;
						break;
					
					case 2:
						Pietra P2 = new Pietra(Elemento.KETCHUP);
						pietre[i]= P2;
						//System.out.println(pietre[i].toString());
						i++;
						break;
						
					case 3:
						
						Pietra P3 = new Pietra(Elemento.MAIONESE);
						pietre[i]= P3;
						//System.out.println(pietre[i].toString());
						i++;
						break;

					case 4:
						
						Pietra P4 = new Pietra(Elemento.TERIYAKI);
						pietre[i]= P4;
						//System.out.println(pietre[i].toString());
						i++;
						break;
					
					case 5:
						
						Pietra P5 = new Pietra(Elemento.YOGURT);
						pietre[i]= P5;
						//System.out.println(pietre[i].toString());
						i++;
						break;
				}
			} while(i < 3);
			System.out.println("hai scelto: ");
			for(i=0; i<3; i++) System.out.println(pietre[i].toString()+" ");
		
				}
			}
			
	

