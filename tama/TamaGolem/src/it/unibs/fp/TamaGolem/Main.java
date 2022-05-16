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
	
		
		TamaGolem tama = null;
		
		String scelta = STR_Utili.BENVENUTO;
		
		String [] voci = STR_Utili.ELENCO_SCELTAINIZIALE;
		
		MyMenu menu = new MyMenu(scelta, voci);

		int scelta1;
		
			int i=0;
			do {									//do while che gestisce le scelte dell'utente	
				scelta1 = menu.scegli();
				switch(scelta1) {
					
					case 1: 
							System.out.println(STR_Utili.SPIEGAZIONE_GIOCO);
							System.out.println(STR_Utili.REGOLAMENTO_PARTE1);
							System.out.println(STR_Utili.REGOLAMENTO_PARTE2);
							System.out.println(STR_Utili.REGOLE_BATTAGLIA);
						
					
						break;
					
					case 2:
						System.out.println("Bene, prima di combattere dovete Registrare voi e la vostra squadra di tamagolem: \n");
						String nome1 =InputDati.leggiStringaNonVuota("Tocca al giocatore 1:\n Come ti chiami? ");
						
						System.out.println("tocca ai tuoi tamagolem, come si chiamano?\n ");
						
						String nomeTam1=InputDati.leggiStringaNonVuota("->");
						String nomeTam2=InputDati.leggiStringaNonVuota("->");
						
						int vita=10;
						Pietra pietreTama1[]= new Pietra[3];
						Pietra pietreTama2[]= new Pietra[3];
						TamaGolem tama1= new TamaGolem(vita, pietreTama1,nomeTam1);
						TamaGolem tama2= new TamaGolem(vita, pietreTama2,nomeTam1);
						TamaGolem tamaSquad[]=new TamaGolem[2];
						
						tamaSquad[0]=tama1;
						tamaSquad[1]=tama2;
							
						Giocatore giocatore1 = new Giocatore(nome1, tamaSquad);
						giocatore1.toString();
						break;
						
					case 3:
						
						
						break;

				}
				
			} while(scelta1!=0);
	}	

//TamaGolem tama = null;
//Fase1.creaEquilibrio();

//Fase2.assegnaPietre(tama);
}


