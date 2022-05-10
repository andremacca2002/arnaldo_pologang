package it.unibs.fp.codiceFiscale;

import java.io.FileInputStream;
import java.util.ArrayList;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ControlloCodici {
	
	static ArrayList<String> codiciFiscali = new ArrayList<String>();
	
	public static void inizializzazione(String path) throws FactoryConfigurationError, XMLStreamException {
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		String codice = null;
		
		try {
			xmlif = XMLInputFactory.newInstance();
			
			xmlr = xmlif.createXMLStreamReader(path, new FileInputStream(path));
		} catch (Exception e) {
			//System.out.println("Errore nell'inizializzazione del reader:");
			//System.out.println(e.getMessage());
		}
		
		while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
			switch (xmlr.getEventType()) { // switch sul tipo di evento
				case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
					break;
				case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
					if(xmlr.getLocalName().equals("codice")) {
						xmlr.next();
						codice = xmlr.getText();
						codiciFiscali.add(codice);
					}
					break;
				case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
					break;
				case XMLStreamConstants.COMMENT:
					break; // commento: ne stampa il contenuto
				case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
				break;
			}
			xmlr.next();
			}
		
		
		
}
}
