package rovinePerdute;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.*;

public class LeggiCittaXml {
	static ArrayList<String> codiciFiscali = new ArrayList<String>();
	
	public static void inizializzazione(String path) throws FactoryConfigurationError, XMLStreamException {
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		String nome = null;
		String id = null;
		String x = null;
		String y = null;
		String h = null;
		ArrayList<String> link = new ArrayList<String>();
		
		try {
		 xmlif = XMLInputFactory.newInstance();
		 xmlr = xmlif.createXMLStreamReader(path, new FileInputStream(path));
		} catch (Exception e) {
		 System.out.println("Errore nell'inizializzazione del reader:");
		 System.out.println(e.getMessage());
		}
		
		while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
			 switch (xmlr.getEventType()) { // switch sul tipo di evento
				 case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
					 //System.out.println("Start Read Doc " + path); 
					 break;
				 case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
					 if(xmlr.getLocalName().equals("city")) {
						 for (int i = 0; i < xmlr.getAttributeCount(); i++) {
							 if(xmlr.getAttributeLocalName(i).equals("id")) {
								 id = xmlr.getAttributeValue(i);
								 System.out.println(id);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("name")) {
								 nome = xmlr.getAttributeValue(i);
								 System.out.println(nome);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("x")) {
								 x = xmlr.getAttributeValue(i);
								 System.out.println(x);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("y")) {
								 y = xmlr.getAttributeValue(i);
								 System.out.println(y);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("h")) {
								 h = xmlr.getAttributeValue(i);
								 System.out.println(h);
							 }
						 }
					 }
					 //xmlr.next();
					 if(xmlr.getLocalName().equals("link")) {
						 for(int i = 0; i < xmlr.getAttributeCount(); i++) {
							 if(xmlr.getAttributeLocalName(i).equals("link")) {
								 link.add(xmlr.getAttributeValue(i));
								 for(int j = 0; j < link.size(); j++) {
									 System.out.println(link.get(j));
								 }
							 }
						 }
					 }
					 
					 /*System.out.println("Tag " + xmlr.getLocalName());
					 for (int i = 0; i < xmlr.getAttributeCount(); i++)
						 System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));*/
				 break;
				 	case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
				 		//System.out.println("END-Tag " + xmlr.getLocalName()); 
				 		break;
				 case XMLStreamConstants.COMMENT:
					 //System.out.println("// commento " + xmlr.getText()); 
					 break; // commento: ne stampa il contenuto
				 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
					 if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
					 System.out.println("-> " + xmlr.getText());
				 break;
			}
			 xmlr.next();
			}

	}
}