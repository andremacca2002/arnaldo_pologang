package it.unibs.fp.rovinePerdute;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.*;

public class LeggiCittaXml {
	static ArrayList<String> codiciFiscali = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Citta> inizializzazione(String path) throws FactoryConfigurationError, XMLStreamException {
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		String nome = null;
		int id = 0;
		int x = 0;
		int y = 0;
		int h = 0;
		ArrayList<Integer> linkCitta = new ArrayList<Integer>();
		ArrayList<Integer> link = new ArrayList<Integer>();
		ArrayList<Citta> cittaperdute = new ArrayList<Citta>();
		
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
								 id = Integer.decode(xmlr.getAttributeValue(i)).intValue();
								 //cittaperdute.get(n).setNome(nome);
								 //System.out.println(id);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("name")) {
								 nome = xmlr.getAttributeValue(i);
								 //cittaperdute.get(n).setNome(nome);
								 //System.out.println(nome);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("x")) {
								 x = Integer.decode(xmlr.getAttributeValue(i)).intValue();
								 //cittaperdute.get(n).setX(Integer.decode(xmlr.getAttributeValue(i)));
								// System.out.println(x);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("y")) {
								 y = Integer.decode(xmlr.getAttributeValue(i)).intValue();
								 //cittaperdute.get(n).setY(Integer.decode(xmlr.getAttributeValue(i)));
								// System.out.println(y);
							 }
							 if(xmlr.getAttributeLocalName(i).equals("h")) {
								 h = Integer.decode(xmlr.getAttributeValue(i)).intValue();
								 //cittaperdute.get(n).setH(Integer.decode(xmlr.getAttributeValue(i)));
								// System.out.println(h);
							 }
						 }
					 }
					 
					 if(xmlr.getLocalName().equals("link")) {
						 for(int i = 0; i < xmlr.getAttributeCount(); i++) {
							 if(xmlr.getAttributeLocalName(i).equals("to")) {
								 link.add(Integer.decode(xmlr.getAttributeValue(i)));
								 }
							 }
						 }
					 
					 /*System.out.println("Tag " + xmlr.getLocalName());
					 for (int i = 0; i < xmlr.getAttributeCount(); i++)
						 System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));*/
				 break;
				 	case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
				 		if(xmlr.getLocalName().equals("city")) {
				 			linkCitta = (ArrayList<Integer>) link.clone();
				 			cittaperdute.add(new Citta(nome, id, x, y, h, linkCitta));
				 			link.clear();
				 		}
				 		//System.out.println("END-Tag " + xmlr.getLocalName()); 
				 		break;
				 case XMLStreamConstants.COMMENT:
					 //System.out.println("// commento " + xmlr.getText()); 
					 break; // commento: ne stampa il contenuto
				 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
					// if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
					 //System.out.println("-> " + xmlr.getText());
				 break;
			}
			 xmlr.next();
			}
		return cittaperdute;
	}
}