package it.unibs.fp.rovinePerdute;
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
import it.unibs.fp.mylib.*;



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
		
	
