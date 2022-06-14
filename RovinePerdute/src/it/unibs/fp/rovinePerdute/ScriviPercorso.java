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
	}
}
		
		
	
	
