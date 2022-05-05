package it.unibs.fp.planetarium;

public class STR_U {
	//menu
	public static final String SCELTA = "Scegli opzione";
	public static final String[] MENU_VOCI = {"Aggiungi pianeta", "Aggiungi luna", "Rimuovi pianeta", 
											  "Rimuovi luna", "Ricerca corpo celeste", "Calcolo centro di massa", 
											  "Visualizza lune", "Visualizza percorso luna"};
	public static final String ISTRUZIONI = "\n|  ISTRUZIONI: se cerchi un pianeta, inserisci il codice. Se cerchi una luna, "
			+ "inserire il codice del pianeta attorno a cui orbita,\n|  seguito da un '#' e il codice della luna. Di seguito un esempio:\n|  "
			+ "Terra: 1\n|  Seconda luna: 2\n|  Codice da inserire: 1#2.\n";
	//warning
	public static final String WARNING_NO_L = "\nWARNING: Luna mancante.\n";
	public static final String WARNING_NO_OP = "\nWARNING: Pianeta orbitato mancante.\n";
	public static final String WARNING_NO_P = "\nWARNING: pianeta mancante.\n";
	public static final String WARNING_CORPO_CELESTE = "\nWARNING: Inserire almeno un corpo celeste prima della ricerca.\n";
	public static final String WARNING_COORDINATE_STELLA = "\nWARNING: hai messo le coordinate della stella: %s.\n\n";
	public static final String WARNING_COORDINATE_PIANETA = "\nWARNING: hai messo le coordinate del pianeta: %s.\n\n";
	public static final String WARNING_COORDINATE_LUNE = "\nWARNING: hai messo le coordinate della luna: %s.\n\n";
	public static final String PIANETA_NO_LUNE = "\nIl pianeta non possiede lune.";
	public static final String CODICE_NON_VALIDO = "Codice non valido.";
	
	//add and cancel
	public static final String ADD__CODE_CL = "Inserisci codice corpo celeste: ";
	public static final String ADD_CODE_L = "Inserisci codice luna: ";
	public static final String ADD_CODE_P = "Inserisci codice del pianeta: ";
	public static final String ADD_CODE = "Immetti codice: ";
	public static final String ADD_Y = "Inserisci coordinata y: ";
	public static final String ADD_X = "Inserisci coordinata x: ";
	public static final String ADD_M = "Inserisci massa: ";
	public static final String ADD_NAME = "Inserisci nome: ";
	public static final String ADD_STAR = "AGGIUNGERE STELLA";
	public static final String CANCEL_PLANET = "Quale pianeta vuoi distruggere?\nELENCO PIANETI:\n";
	public static final String CONTROL_PLANET = "Attorno a quale pianeta orbita?\n";
	
}
