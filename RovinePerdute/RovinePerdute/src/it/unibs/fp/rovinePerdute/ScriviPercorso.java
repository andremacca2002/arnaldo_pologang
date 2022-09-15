package it.unibs.fp.rovinePerdute;

import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;



public class ScriviPercorso {
	public static void scrittura(ArrayList<Citta> percTonatiuh, ArrayList<Citta> percMetztli, String distanzaT, String distanzaM) throws FactoryConfigurationError {
		XMLOutputFactory xmlof = null;
		XMLStreamWriter xmlw = null;
		
		try {
		xmlof = XMLOutputFactory.newInstance();
		xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("Routes.xml"), "utf-8");
		xmlw.writeStartDocument("utf-8", "1.0");
		} catch (Exception e) {
		System.out.println("Errore nell'inizializzazione del writer:");
		System.out.println(e.getMessage());
		}
		
		
		try { // blocco try per raccogliere eccezioni
			xmlw.writeCharacters("\n");
			xmlw.writeStartElement("routes"); //inizio elemento output
			xmlw.writeCharacters("\n\t");
			xmlw.writeStartElement("route");//inizio elemento persone (con numero persone come attr.)
			xmlw.writeAttribute("team", "Tonatiuh"); //iniserisci numero persone
			xmlw.writeAttribute("cost", distanzaT);
			xmlw.writeAttribute("cities", Integer.toString(percTonatiuh.size()));
			
		for (int i = 0; i < percTonatiuh.size(); i++) {
			xmlw.writeCharacters("\n\t");
			xmlw.writeStartElement("city");
			xmlw.writeAttribute("id", Integer.toString(percTonatiuh.get(i).getID()));
			xmlw.writeAttribute("name", percTonatiuh.get(i).getNome());
			xmlw.writeCharacters("\n");
			xmlw.writeEndElement();	
			}
			
			xmlw.writeCharacters("\n");
			xmlw.writeEndElement();
			xmlw.writeCharacters("\n\t");
			xmlw.writeStartElement("route");//inizio elemento persone (con numero persone come attr.) 
			xmlw.writeAttribute("team", "Metztli"); //iniserisci numero persone
			xmlw.writeAttribute("cost", distanzaM);
			xmlw.writeAttribute("cities", Integer.toString(percMetztli.size()));
			
		for (int i = 0; i < percMetztli.size(); i++) {
			xmlw.writeCharacters("\n\t");
			xmlw.writeStartElement("city");
			xmlw.writeAttribute("id", Integer.toString(percMetztli.get(i).getID()));
			xmlw.writeAttribute("name", percMetztli.get(i).getNome());
			xmlw.writeCharacters("\n");
			xmlw.writeEndElement();
		}
		xmlw.writeCharacters("\n");
		xmlw.writeEndElement();
		xmlw.writeCharacters("\n");
		xmlw.writeEndDocument(); // scrittura della fine del documento
		xmlw.flush(); // svuota il buffer e procede alla scrittura
		xmlw.close(); // chiusura del documento e delle risorse impiegate
			 
		} catch (Exception e) { // se c’è un errore viene eseguita questa parte
		System.out.println("Errore nella scrittura");
		}
	}
}		
	
