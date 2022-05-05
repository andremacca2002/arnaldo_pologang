package it.unibs.fp.tamabase;
public class Tamagotchi {
	
	private String nome;
	private int sazieta;
	private int soddisfazione;
	
	public Tamagotchi(String nome, int sazieta, int soddisfazione) {
		this.nome = nome; 
		this.sazieta = sazieta;
		this.soddisfazione = soddisfazione;
	}

	public void daiBiscotti(int numBiscotti) {
		sazieta=Math.min(100, sazieta+numBiscotti);
		soddisfazione=Math.max(0, soddisfazione-5);
	}

	public void daiCarezze(int numCarezze) {
		sazieta=Math.max(0, sazieta-5);
		soddisfazione=Math.min(100, soddisfazione+numCarezze);
	}
	public boolean isTriste() {
		return (sazieta<30 || soddisfazione<30);
	}
    public boolean isFelice() {
    	return (sazieta>=80 && soddisfazione>=80);
    }
	public String toString() {
		
		StringBuffer descrizione= new StringBuffer();
		descrizione.append("nome:"+nome); //append classe string buffer per creare super stringa 
		descrizione.append("\nsazietà:"+sazieta);
		descrizione.append("\nsoddisfazione:"+soddisfazione);
		
		if(isTriste()) descrizione.append("\nSono Triste!");
		if(isFelice()) descrizione.append("\nSono Felice!");
		return descrizione.toString();
	}
}