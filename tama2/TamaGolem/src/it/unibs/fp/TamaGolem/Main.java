package it.unibs.fp.TamaGolem;
import java.util.*;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


public class Main {


	//N                                      =        5
	//G = (N - 1)(N - 2) / (2 * P)          =        2
	//P = (N + 1) / 3 + 1                   =        3
	// S = (2 * G * P) / N * N              =        15
	//S / N = (2 * G * P) / N pietre.
	
	
	public static void main(String[] args) {
	
		
		String sceltamain = STR_Utili.BENVENUTO;
		
		String [] vocimain = STR_Utili.ELENCO_SCELTAINIZIALE;
		
		MyMenu mainmenu = new MyMenu(sceltamain, vocimain);
		
		boolean[][] scortaPietre = ScortaPietre.inizializzazioneScorta();
		
		int scelta;
	
			do {									//do while che gestisce le scelte dell'utente	
				scelta = mainmenu.scegli();
				
				switch(scelta) {
					
					case 1: 
							System.out.println(STR_Utili.SPIEGAZIONE_GIOCO);
							System.out.println(STR_Utili.REGOLAMENTO_PARTE1);
							System.out.println(STR_Utili.REGOLAMENTO_PARTE2);
							System.out.println(STR_Utili.REGOLE_BATTAGLIA);
						
					
						break;
					
					case 2:
						
						System.out.println("Bene, prima di combattere dovete registrare voi e la vostra squadra di TamaGolem.\n");
						
						System.out.println("Tocca al giocatore 1: ");
						Giocatore giocatore1;
						giocatore1 = Fase2.registraGiocatore();
						
						System.out.println("\nTocca al giocatore 2: ");
						Giocatore giocatore2;
						giocatore2 = Fase2.registraGiocatore();
						
						//ArrayList<TamaGolem> TamaList1 = new ArrayList<TamaGolem>(Arrays.asList(giocatore1.getTamagolems()));
						//ArrayList<TamaGolem> TamaList2 = new ArrayList<TamaGolem>(Arrays.asList(giocatore2.getTamagolems()));
						
						int tamaInGioco = 0;
						System.out.println("\nDiamo inizio alla battaglia!");
						
						TamaGolem tamaE1=null;
						TamaGolem tamaE2=null;
						int tamaEsausti1 = 0;
						int tamaEsausti2 = 0;
						
						do {
							if(tamaInGioco == 0){
								System.out.println("Potete iniziare lo scontro evocando i vostri Tamagolem uno alla volta.");
								
								tamaE1=Fase2.evocazione(giocatore1, giocatore1.getTamagolems()); //evoco tamagolem giocatore 1
								System.out.println();
								Fase2.assegnaPietra(tamaE1, scortaPietre); //assegno le pietre al tamagolem
								
								tamaE2=Fase2.evocazione(giocatore2, giocatore2.getTamagolems());
								System.out.println();
								Fase2.assegnaPietra(tamaE2, scortaPietre);
							}
							else if(tamaInGioco == 1) {
								tamaE2=Fase2.evocazione(giocatore2, giocatore2.getTamagolems());
								System.out.println();
								Fase2.assegnaPietra(tamaE2, scortaPietre);
							}
							else if(tamaInGioco == 2) {								
								tamaE1=Fase2.evocazione(giocatore1, giocatore1.getTamagolems()); //evoco tamagolem giocatore 1 
								System.out.println();
								Fase2.assegnaPietra(tamaE1, scortaPietre); //assegno le pietre al tamagolem	
							}	
							
							tamaInGioco = Fase2.battaglia(tamaE1, tamaE2);
							
							if(tamaInGioco == 1) {
								tamaEsausti2++;
							}
							else {
								tamaEsausti1++;
							}
							
						}while((tamaEsausti1 < 2) && (tamaEsausti2 < 2));
						
						break;
					case 3:
						
						break;

				}
				
			} while(scelta!=0);
	}	

}


