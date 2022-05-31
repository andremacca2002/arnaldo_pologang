package it.unibs.fp.TamaGolem;

public class STR_Utili {
	
	public static final String SCELTAPIETRE = "Assegna al tamagolem 3 pietre di un elemento a piacere tra i cinque di seguito:";
	public static final String SCELTATAMAGOLEM = "TamaGolem disponibili nella tua squadra:";
	public static final String [] ELENCO_ELEMENTI = {Elemento.BARBECUE.getNome(), Elemento.KETCHUP.getNome(),Elemento.MAIONESE.getNome(),Elemento.TERIYAKI.getNome(),Elemento.YOGURT.getNome()};
	public static final String [] ELENCO_SCELTAINIZIALE = {"Esponi regolamento", "Incomincia una battaglia"};
	public static final String BENVENUTO = "Benvenuto nel magico mondo dei TamaGolem, dove solo il più forte può rimanere, cosa volete fare?";
	public static final String REGOLE_BATTAGLIA = "\nREGOLE DELLA BATTAGLIA:	\nDue pietre scagliate l’una contro l’altra scatenano il potere dei relativi elementi, che interagiscono secondo l'Equilibrio generato all'inizio della partita.\nL’elemento debole causa dei danni al TamaGolem che l’ha scagliato. \nQuando un TamaGolem subisce un certo numero massimo di danni, denominato Vita del TamaGolem, viene eliminato dallo scontro. Il rispettivo giocatore deve quindi evocarne un altro. \nChi perde tutti i suoi TamaGolem è considerato sconfitto. L’altro giocatore è il vincitore\n";
	public static final String REGOLAMENTO_PARTE2 = "\nREGOLE DELL'EVOCAZIONE: \nOgni giocatore ha a disposizione 2 TamaGolem, che può evocare nel corso dello Scontro.\nOgni TamaGolem può ingurgitare fino a 3 pietre degli elementi \nDurante la fase di evocazione, il giocatore attivo seleziona un set di pietre fra quelle disponibili\n";
	public static final String REGOLAMENTO_PARTE1 = "\nREGOLE SULL'EQUILIBRIO: \nAll’inizio di ogni nuova partita l’Universo stabilisce casualmente le regole che governano le interazioni fra le forze naturali.\nL’insieme di queste interazioni è detto Equilibrio del Mondo.\\nLEquilibrio è fondamentale per definire l’esito degli scontri durante la fase di combattimento\n";
	public static final String SPIEGAZIONE_GIOCO = "\nIl GIOCO: siete qui per dare inizio a epici scontri tra squadre di tamagolem, l'esito di questi scontri sarà decisa dall'equilibrio del mondo\n";
}
