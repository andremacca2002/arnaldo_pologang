package it.unibs.fp.TamaGolem;
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
						
						System.out.println("Bene, prima di combattere dovete Registrare voi e la vostra squadra di tamagolem: \n");
						
						System.out.println("Tocca al giocatore 1: ");
						Giocatore giocatore1;
						giocatore1 = Fase2.registragiocatore();
						
						System.out.println("Tocca al giocatore 2: ");
						Giocatore giocatore2;
						giocatore2 = Fase2.registragiocatore();
						//giocatore2.toString();
						System.out.println("Potete iniziare lo scontro evocando i vostri Tamagolem uno alla volta: ");
						
						TamaGolem tamaE1=Fase2.evocazione(giocatore1, giocatore1.getTamagolems());
						Fase2.assegnaPietra(tamaE1);
						
						
						System.out.println("Potete iniziare lo scontro evocando i vostri Tamagolem uno alla volta: ");
						
						TamaGolem tamaE2=Fase2.evocazione(giocatore2, giocatore2.getTamagolems());
						Fase2.assegnaPietra(tamaE2);
						
						System.out.println("Diamo inizio alla battaglia!");
						
						break;
						
					case 3:
						
						break;

				}
				
			} while(scelta!=0);
	}	

}


