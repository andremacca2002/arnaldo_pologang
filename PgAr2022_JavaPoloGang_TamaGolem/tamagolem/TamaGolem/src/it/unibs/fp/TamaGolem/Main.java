package it.unibs.fp.TamaGolem;
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
						int [][] balance = Fase1.creaEquilibrio();
						
						boolean[][] scortaPietre = ScortaPietre.inizializzazioneScorta(); //scorta di pietre reinizzializzata all'inizio di ogni battaglia 
						
						System.out.println(STR_Utili.INTRO);
						
						System.out.println("Tocca al giocatore 1: ");
						Giocatore giocatore1;
						giocatore1 = Fase2.registraGiocatore(); //giocatare inserisce il suo nome e quello dei suoi tamagolem
						
						System.out.println("\nTocca al giocatore 2: ");
						Giocatore giocatore2;
						giocatore2 = Fase2.registraGiocatore();
						
						int tamaInGioco = 0; 
						
						System.out.println(STR_Utili.INIZIO_BATT);
						
						TamaGolem tamaE1=null;
						TamaGolem tamaE2=null;
						
						int tamaEsausti1 = 0; //numero tamagolem perdenti di ogni giocatore
						int tamaEsausti2 = 0;
						
						do {
							if(tamaInGioco == 0){
								System.out.println(STR_Utili.EVOCAZIONE);
								
								tamaE1=Fase2.evocazione(giocatore1, giocatore1.getTamagolems()); //evocozione iniziale tamagolem giocatore 1
								System.out.println();
								Fase2.assegnaPietra(tamaE1, scortaPietre); //assegno le pietre al tamagolem1
								
								tamaE2=Fase2.evocazione(giocatore2, giocatore2.getTamagolems());//evocozione iniziale tamagolem giocatore 2
								System.out.println();
								Fase2.assegnaPietra(tamaE2, scortaPietre);//assegno le pietre al tamagolem2
							}
							else if(tamaInGioco == 1) {
								tamaE2=Fase2.evocazione(giocatore2, giocatore2.getTamagolems()); //evocazione nel caso sia morto un tamagolem di giocatore 2
								System.out.println();
								Fase2.assegnaPietra(tamaE2, scortaPietre);
							}
							else if(tamaInGioco == 2) {								
								tamaE1=Fase2.evocazione(giocatore1, giocatore1.getTamagolems()); //evocazione nel caso sia morto un tamagolem di giocatore 1 
								System.out.println();
								Fase2.assegnaPietra(tamaE1, scortaPietre); 
							}	
							
							tamaInGioco = Fase2.battaglia(tamaE1, tamaE2, balance); //battaglia restituisce un valore di 1 se il tamagolem di giocatore 2 è morto e viceversa 
							
							if(tamaInGioco == 1) {
								tamaEsausti2++;
							}
							else {
								tamaEsausti1++;
							}
							
						}while((tamaEsausti1 < 2) && (tamaEsausti2 < 2));
						
						System.out.println(STR_Utili.FINE_BATT);
						
						Fase3.finePartita(tamaEsausti1,giocatore1,giocatore2);
						
						Fase3.visualizzaEquilibrio(balance);
						break;
				}
				
			} while(scelta!=0);
	}	

}


