package it.unibs.fp.codiceFiscale;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Utility_Xml {
		static ArrayList<Persona> persone = new ArrayList<Persona>();
		static ArrayList<Comune> comuni = new ArrayList<Comune>();
		static ArrayList<String> codiciInvalidi = new ArrayList<String>();
		static ArrayList<String> codiciValidi = new ArrayList<String>();
		static ArrayList<String> codiciFiscali = new ArrayList<String>();
		static ArrayList<String> codiciSpaiati = new ArrayList<String>();
		static ArrayList<String> codiciPersone = new ArrayList<String>();
		
		public static void inizializzazione(String path) throws FactoryConfigurationError, XMLStreamException {
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

			}
			
			while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
				switch (xmlr.getEventType()) { // switch sul tipo di evento
					case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento

						break;
					case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi

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
							persone.add(personaN);
						}
						else if(xmlr.getLocalName().equals("codice")) {
							xmlr.next();
							codice = xmlr.getText();
							Comune comuneN = new Comune(nome, codice);
							comuni.add(comuneN);
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

		public static void scrittura(ArrayList<Persona> persone, ArrayList<String> codiciPersone,ArrayList<String> codiciInvalidi,ArrayList<String> codiciSpaiati) throws FactoryConfigurationError {
			XMLOutputFactory xmlof = null;
			XMLStreamWriter xmlw = null;
			
			try {
			xmlof = XMLOutputFactory.newInstance();
			xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("codicePersone.xml"), "utf-8");
			xmlw.writeStartDocument("utf-8", "1.0");
			} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del writer:");
			System.out.println(e.getMessage());
			}
			
			
			try { // blocco try per raccogliere eccezioni
				xmlw.writeStartElement("OUTPUT"); //inizio elemento output 
				xmlw.writeComment("INIZIO LISTA PERSONE"); 
				xmlw.writeStartElement("persone");//inizio elemento persone (con numero persone come attr.) 
				xmlw.writeAttribute("numero", Integer.toString(persone.size())); //iniserisci numero persone 

			for (int i = 0; i < persone.size(); i++) {
				xmlw.writeStartElement("Persona");
				xmlw.writeAttribute("id", Integer.toString(i));
				xmlw.writeEndElement();
				xmlw.writeStartElement("Nome"); 
				xmlw.writeCharacters(persone.get(i).getNome() + "\n"); 
				xmlw.writeEndElement();
				xmlw.writeStartElement("Cognome");
				xmlw.writeCharacters(persone.get(i).getCognome());
				xmlw.writeEndElement();
				xmlw.writeStartElement("Sesso"); 
				xmlw.writeCharacters(persone.get(i).getSesso());
				xmlw.writeEndElement();
				xmlw.writeStartElement("Luogodinascita");
				xmlw.writeCharacters(persone.get(i).getLuogoNascita());
				xmlw.writeEndElement();
				xmlw.writeStartElement("Data"); 
				xmlw.writeCharacters(persone.get(i).getData());
				xmlw.writeEndElement();
				
				xmlw.writeStartElement("CF");
				xmlw.writeCharacters(codiciPersone.get(i)); 
				xmlw.writeEndElement();
				
				
				
			}
			
				//xmlw.writeEndElement(); 
					
				xmlw.writeStartElement("Codici");
				xmlw.writeComment("INIZIO LISTA CODICI"); 
	
				xmlw.writeStartElement("CFinvalidi");
				xmlw.writeAttribute("Numero", Integer.toString(codiciInvalidi.size()));
				
			for (int i = 0; i < codiciInvalidi.size(); i++) {
				xmlw.writeStartElement("Codice"); 
				xmlw.writeCharacters(codiciInvalidi.get(i)); 
				xmlw.writeEndElement(); 
				}
				xmlw.writeEndElement();
	
				xmlw.writeStartElement("Spaiati");
				xmlw.writeAttribute("Numero", Integer.toString(codiciSpaiati.size()));

			for (int i = 0; i < codiciSpaiati.size(); i++) {
				xmlw.writeStartElement("Codice"); 
				xmlw.writeCharacters(codiciSpaiati.get(i));
				xmlw.writeEndElement(); 
				}
				
				xmlw.writeEndElement();
				xmlw.writeEndElement(); 
				
				xmlw.writeEndElement(); // chiusura di </OUTPUT>
				
				xmlw.writeEndDocument(); // scrittura della fine del documento
				xmlw.flush(); // svuota il buffer e procede alla scrittura
				xmlw.close(); // chiusura del documento e delle risorse impiegate
				 
			} catch (Exception e) { // se c’è un errore viene eseguita questa parte
			System.out.println("Errore nella scrittura");
			}
		}
			
		public static void prova(Persona p) {
			
			XMLOutputFactory xmlof = null;
			XMLStreamWriter xmlw = null;
			try {
			xmlof = XMLOutputFactory.newInstance();
			xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("prova.xml"), "utf-8");
			xmlw.writeStartDocument("utf-8", "1.0");
			} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del writer:");
			System.out.println(e.getMessage());
			}
			
			try { // blocco try per raccogliere eccezioni
			xmlw.writeStartElement("programmaArnaldo"); // scrittura del tag radice <programmaArnaldo>
			xmlw.writeComment("INIZIO LISTA"); // scrittura di un commento
			xmlw.writeStartElement("persona");
			xmlw.writeStartElement("nome");
			xmlw.writeCharacters(p.getNome());
			xmlw.writeEndElement();
			xmlw.writeEndElement();
			xmlw.writeEndElement(); // chiusura di </programmaArnaldo>
			xmlw.writeEndDocument(); // scrittura della fine del documento
			xmlw.flush(); // svuota il buffer e procede alla scrittura
			xmlw.close(); // chiusura del documento e delle risorse impiegate
			} catch (Exception e) { // se c’è un errore viene eseguita questa parte
			System.out.println("Errore nella scrittura");
			}
		}
		
	}


						