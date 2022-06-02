package rovinePerdute;
import java.util.*;

import javax.xml.stream.*;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		ArrayList<Citta> mappa = LeggiCittaXml.inizializzazione("PgAr_Map_5.xml");
		
		for(int i = 0; i < mappa.size(); i++) {
			System.out.println(mappa.get(i).toString());
		}
	}
	
	
}
