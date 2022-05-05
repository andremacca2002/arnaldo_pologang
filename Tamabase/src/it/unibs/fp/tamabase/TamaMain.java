package it.unibs.fp.tamabase;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class TamaMain {

	private static final int MAX_SAZIETA = 100;
	private static final String SCELTA = "scegli l'opzione";
	private static final String SALUTO = "benvenuto nel mondo dei tamagotvhi";

	public static void main(String[] args) {
		
		System.out.println(SALUTO);
		String[] voci= {"dai i biscotti","dai carezze"};
		int scelta=0, numBiscotti, numCarezze;
		Tamagotchi tamagotchi = creatamagotchi();
		MyMenu menu=new MyMenu(SCELTA, voci);
		
		do {
			scelta=menu.scegli();
			switch(scelta) {
			case 1: numBiscotti=InputDati.leggiIntero("inserire numero biscotti",0,20);
				    tamagotchi.daiBiscotti(numBiscotti);
				break;
			case 2: numCarezze=InputDati.leggiIntero("inserire numero carezze",0,20);
					tamagotchi.daiCarezze(numCarezze);
				break;
			default: 
				break;
			}
			System.out.println(tamagotchi.toString());
		}while(scelta!=0);
	}

	private static Tamagotchi creatamagotchi() {
		String nome = InputDati.leggiStringaNonVuota("come si chiama il tuo tamagotchi?");
		int sazieta=InputDati.leggiIntero("inserisci il valore iniziale di sazietà",0,MAX_SAZIETA);
		int soddisfazione=InputDati.leggiIntero("inserire il valore iniziale di soddisfazione",0,100);
		
		Tamagotchi tamagotchi=new Tamagotchi(nome, sazieta, soddisfazione);
		return tamagotchi;
	}
}
