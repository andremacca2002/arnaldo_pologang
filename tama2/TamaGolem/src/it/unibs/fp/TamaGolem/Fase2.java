package it.unibs.fp.TamaGolem;


import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


public class Fase2 {
	
		static String scelta = STR_Utili.SCELTAPIETRE; //menu scelta pietre 
		static String [] voci = STR_Utili.ELENCO_ELEMENTI;
		static MyMenu menu = new MyMenu(scelta, voci);
		
		static String scelta1 = STR_Utili.SCELTATAMAGOLEM; //menu scelta tamagolem da evocare 
		static String voci1[]= {"", ""};
		static MyMenu menu1 = new MyMenu(scelta1, voci1);
		
		private Giocatore giocatore;
		static ScortaPietre scortaPietre = new ScortaPietre();
		
		int numTama1 = 2;
		int numTama2 = 2;
		
		
		final static int vita=10;
	
		public static Giocatore registraGiocatore() {
		
			String nome =InputDati.leggiStringaNonVuota(" Come ti chiami? ");
			System.out.println("\nTocca ai tuoi tamagolem, come si chiamano?");
			
			TamaGolem tamaSquad[] = new TamaGolem[2];
			
			for(int i = 0; i < 2; i++) {
				String nomeTama = InputDati.leggiStringaNonVuota("->");
				
				Pietra pietreTama[] = new Pietra[3];
			
				TamaGolem tama = new TamaGolem(vita, pietreTama,nomeTama);

				tamaSquad[i] = tama;
			}
			
			Giocatore giocatore = new Giocatore(nome, tamaSquad);
			
			return giocatore;
			
			/*String nomeTam1 = InputDati.leggiStringaNonVuota("->");
			String nomeTam2 = InputDati.leggiStringaNonVuota("->");
			
			
			Pietra pietreTama1[]= new Pietra[3];
			Pietra pietreTama2[]= new Pietra[3];
			
			TamaGolem tama1= new TamaGolem(vita, pietreTama1,nomeTam1);
			TamaGolem tama2= new TamaGolem(vita, pietreTama2,nomeTam2);
			
			TamaGolem tamaSquad[]=new TamaGolem[2];
			
			tamaSquad[0]=tama1;
			tamaSquad[1]=tama2;
				
			Giocatore giocatore = new Giocatore(nome, tamaSquad);
			
			return giocatore;*/
		}

		public static TamaGolem evocazione(Giocatore giocatore, TamaGolem[] tamaGang) {
			
			
			TamaGolem tamaEvocato = null;	
			
			if(tamaGang.length==0)
		    	System.out.println("Hai esaurito i tuoi TamaGolem!");
		    else {
		    	
				for(int i = 0; i < tamaGang.length; i++) voci1[i]=tamaGang[i].getNome();
				
			    System.out.println(giocatore.getNome() + " quale tamagolem vuoi evocare?");
			    int scelta2 = 0;
			    do {
					scelta2 = menu1.scegli();
					switch(scelta2) {
						case 0:
							System.out.println("WARNING: non è possibile uscire!");
							break;
						case 1: 
							tamaEvocato = tamaGang[0];
							//scelta2=0;
							
							break;
						case 2:
							tamaEvocato = tamaGang[1];
							//scelta2=0;
							
							break;
					}
			    }while(scelta2 != 1 && scelta2 != 2);
		    }
			return tamaEvocato;
		}
		
		public static void assegnaPietra(TamaGolem tama, boolean[][] scorta) {
				int scelta3;
				
				
				Pietra[] pietre = new Pietra[3];
			
				int i=0;
				
				do {									//do while che gestisce le scelte dell'utente	
					scelta3 = menu.scegli();
					int numPietre = 0;
					switch(scelta3) {
						case 1:
							for(int j = 0; j < 3; j++) {
								if(scorta[Elemento.BARBECUE.getId()-1][j] == true) numPietre++;
								
							}
							
							if(numPietre == 0) {
								System.out.printf("\n%s esaurite!\n", Elemento.BARBECUE.getNome());
								break;
							}
							else {
								Pietra P = new Pietra(Elemento.BARBECUE);
								pietre[i]= P;
								scorta[Elemento.BARBECUE.getId()-1][numPietre-1] = false;
								i++;
							}
							
							break;
						
						case 2:
							for(int j = 0; j < 3; j++) {
								if(scorta[Elemento.KETCHUP.getId()-1][j] == true) numPietre++;
							}
							
							if(numPietre == 0) {
								System.out.printf("\n%s esaurite!\n", Elemento.KETCHUP.getNome());
								break;
							}
							else {
								Pietra P = new Pietra(Elemento.KETCHUP);
								pietre[i]= P;
								scorta[Elemento.KETCHUP.getId()-1][numPietre-1] = false;
								i++;
							}
							
							break;
							
						case 3:
							for(int j = 0; j < 3; j++) {
								if(scorta[Elemento.MAIONESE.getId()-1][j] == true) numPietre++;
							}
							
							if(numPietre == 0) {
								System.out.printf("\n%s esaurite!\n", Elemento.MAIONESE.getNome());
								break;
							}
							else {
								Pietra P = new Pietra(Elemento.MAIONESE);
								pietre[i]= P;
								scorta[Elemento.MAIONESE.getId()-1][numPietre-1] = false;
								i++;
							}

							break;
	
						case 4:
							for(int j = 0; j < 3; j++) {
								if(scorta[Elemento.TERIYAKI.getId()-1][j] == true) numPietre++;
							}
							
							if(numPietre == 0) {
								System.out.printf("\n%s esaurite!\n", Elemento.TERIYAKI.getNome());
								break;
							}
							else {
								Pietra P = new Pietra(Elemento.TERIYAKI);
								pietre[i]= P;
								scorta[Elemento.TERIYAKI.getId()-1][numPietre-1] = false;
								i++;
							}
							
							break;
						
						case 5:
							for(int j = 0; j < 3; j++) {
								if(scorta[Elemento.YOGURT.getId()-1][j] == true) numPietre++;
							}
							
							if(numPietre == 0) {
								System.out.printf("\n%s esaurite!\n", Elemento.YOGURT.getNome());
								break;
							}
							else {
								Pietra P = new Pietra(Elemento.YOGURT);
								pietre[i]= P;
								scorta[Elemento.YOGURT.getId()-1][numPietre-1] = false;
								i++;
							}
							
							break;
					}
					
					ScortaPietre.setScorta(scorta);
				} while(i < 3);
				
				System.out.println("\nHai scelto: \n ");
				
				for(i=0; i<3; i++) System.out.println(pietre[i].toString() + " ");
				
				tama.setPietre(pietre);
				
				for(int x = 0; x < 5; x++) {
					for(int j = 0; j < 3; j++) {
						System.out.print(scorta[x][j]);
					}
					System.out.println();
				}
			}
		}
		

			
	

