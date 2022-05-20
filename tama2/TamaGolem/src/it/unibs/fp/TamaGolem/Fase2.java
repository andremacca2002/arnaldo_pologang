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
		
		static ScortaPietre scortaPietre = new ScortaPietre();
		
		int numTama1 = 2;
		int numTama2 = 2;
		
		
		final static int vita=10;
		final static int pietraAttuale=0;
	
		public static Giocatore registraGiocatore() {
		
			String nome =InputDati.leggiStringaNonVuota(" Come ti chiami? ");
			System.out.println("\nTocca ai tuoi tamagolem, come si chiamano?");
			
			TamaGolem tamaSquad[] = new TamaGolem[2];
			
			for(int i = 0; i < 2; i++) {
				String nomeTama = InputDati.leggiStringaNonVuota("->");
				
				Pietra pietreTama[] = new Pietra[3];
			
				TamaGolem tama = new TamaGolem(vita, pietreTama,nomeTama, pietraAttuale);

				tamaSquad[i] = tama;
			}
			
			Giocatore giocatore = new Giocatore(nome, tamaSquad);
			
			return giocatore;
			
		}

		public static TamaGolem evocazione(Giocatore giocatore, TamaGolem[] tamaGang) {
			
			
			TamaGolem tamaEvocato = null;	
			
			if(tamaGang.length==0)
		    	System.out.println("Hai esaurito i tuoi TamaGolem!");
		    else {
		    	
				for(int i = 0; i < tamaGang.length; i++) {
					if(tamaGang[i].getVita() <= 0) {
						voci1[i] = tamaGang[i].getNome() + " - ESAUSTO";
					}
					else {
						voci1[i] = tamaGang[i].getNome();
					}
				}
				
			    System.out.println("\n" + giocatore.getNome() + " quale tamagolem vuoi evocare?");
			    int scelta2 = 0;
			    boolean valido = false;
			    
			    do {
					scelta2 = menu1.scegli();
					switch(scelta2) {
						case 0:
							System.out.println("Non puoi abbandonare la battaglia finché hai TamaGolem a disposizione!");
							break;
						case 1: 
							if(tamaGang[0].getVita() <= 0) {
								System.out.println("\nTamaGolem esausto!");
							}
							else {
								tamaEvocato = tamaGang[0];
								valido = true;
							}
							
							break;
						case 2:
							if(tamaGang[1].getVita() <= 0) {
								System.out.println("TamaGolem esausto!");
							}
							else {
								tamaEvocato = tamaGang[1];
								valido = true;
							}
							
							break;
					}
			    }while((scelta2 != 1 && scelta2 != 2) || !valido);
		    }
			return tamaEvocato;
		}
		
		public static  void assegnaPietra(TamaGolem tama, boolean[][] scorta) {
				int scelta3;
				
				
				Pietra[] pietre = new Pietra[3];
			
				int i=0;
				
				do {									//do while che gestisce le scelte dell'utente	
					scelta3 = menu.scegli();
					int numPietre = 0;
					switch(scelta3) {
						case 0:
							System.out.println("Non puoi evocare un TamaGolem senza averlo prima sfamato!");
							break;
							
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
				
				System.out.println("\nHai scelto: ");
				
				for(i=0; i<3; i++) System.out.println("-> " + pietre[i].toString() + " ");
				
				tama.setPietre(pietre);
			}
		
		public static int battaglia(TamaGolem tama1, TamaGolem tama2) {
			int [][] balance = Fase1.creaEquilibrio();
			Pietra[] pietre1 = tama1.getPietre();
			Pietra[] pietre2 = tama2.getPietre();
			int tamaInGioco = 0;
			
				for(int j=tama1.getPietraAttuale(), i=tama2.getPietraAttuale()%3; tama1.getVita() > 0 && tama2.getVita() > 0; i++, j++) {	
					System.out.print("\n" + tama1.getNome());
					System.out.println(" scaglia una pietra " + pietre1[j%3].getElemento().name() + ".");
					System.out.print(tama2.getNome());
					System.out.println(" risponde con una pietra " + pietre2[i%3].getElemento().name() + ".");
					
					int potenza = balance[pietre1[j%3].getElemento().getId()-1][pietre2[i%3].getElemento().getId()-1];
					
					
					if(potenza == 0) {
						System.out.println("->Nessun danno arrecato.");
					}
					else if(potenza > 0) {
						System.out.println("->" + tama1.getNome() + " infligge un danno vitale di "+ Math.abs(potenza) +" a " +tama2.getNome());
						tama2.setVita(tama2.getVita() - Math.abs(potenza));
						if(tama2.getVita() <= 0) {
							System.out.println(tama2.getNome()+" ha esaurito la vita, deve lasciare il combattimento");
							tamaInGioco = 1;
							tama1.setPietraAttuale((j+1)%3);
							break;
						}
					}
					else {
						System.out.println("->" + tama2.getNome()+" infligge un danno vitale di "+ Math.abs(potenza) +" a " +tama1.getNome());
						tama1.setVita(tama1.getVita() - Math.abs(potenza));
						if(tama1.getVita() <= 0) {
							System.out.println("\n" + tama1.getNome() + " ha esaurito la vita, deve lasciare il combattimento.");
							tamaInGioco = 2;
							tama2.setPietraAttuale((i+1)%3);
							break;
						}
					}
				}
		return tamaInGioco;
	}
}