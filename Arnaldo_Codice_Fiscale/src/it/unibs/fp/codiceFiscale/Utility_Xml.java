package it.unibs.fp.codiceFiscale;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Utility_Xml {
		static ArrayList<Persona> persona = new ArrayList<Persona>();
		static ArrayList<Comune> comune = new ArrayList<Comune>();
		
		public static void Inizializzazione(String path) throws FactoryConfigurationError, XMLStreamException {
			XMLInputFactory xmlif = null;
			XMLStreamReader xmlr = null;
			String nome = null;
			String cognome = null;
			String sesso = null;
			String luogoNascita = null;
			String data = null;
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
						//System.out.println(String.format("Start Read Doc %s", path)); 
						break;
					case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
						//System.out.println("Tag " + xmlr.getLocalName());
						/*for (int i = 0; i < xmlr.getAttributeCount(); i++) {
							System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
						}
						*/
						if(xmlr.getLocalName().equals("nome")) {
							xmlr.next();
							nome = xmlr.getText();
						}
						else if(xmlr.getLocalName().equals("cognome")) {
							xmlr.next();
							cognome = xmlr.getText();
						}
						else if(xmlr.getLocalName().equals("sesso")) {
							xmlr.next();
							sesso = xmlr.getText();
						}
						else if(xmlr.getLocalName().equals("comune_nascita")) {
							xmlr.next();
							luogoNascita = xmlr.getText();
						}
						else if(xmlr.getLocalName().equals("data_nascita")) {
							xmlr.next();
							data = xmlr.getText();
							Persona personaN = new Persona(nome, cognome, sesso, luogoNascita, data);
							persona.add(personaN);
						}
						else if(xmlr.getLocalName().equals("codice")) {
							xmlr.next();
							codice = xmlr.getText();
							Comune comuneN = new Comune(nome, codice);
							comune.add(comuneN);
						}
						
						break;
					case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
						//System.out.println("END-Tag " + xmlr.getLocalName()); 
						break;
					case XMLStreamConstants.COMMENT:
						//System.out.println("// commento " + xmlr.getText()); 
						break; // commento: ne stampa il contenuto
					case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
						
							//System.out.println(xmlr.getText());
						
						/*if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
	
							numConsonants = xmlr.getText().replaceAll("(?i) [^ bcdfghjklmnpqrstvwxyz]", "").length();
							System.out.println(numConsonants);
							System.out.println(xmlr.getText());
							//System.out.println("-> " + xmlr.getText());*/
					break;
				}
				xmlr.next();
				}
			
			
			
	}

}
						