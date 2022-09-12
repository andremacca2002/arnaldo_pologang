package it.unibs.fp.AziendaSanitaria;

public class Medico {
	private String codice;
	private String nome;
	private String cognome;
	private GiorniSettimana giornoLibero;
	
	public Medico(String codice, String nome, String cognome, GiorniSettimana giornoLibero) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.giornoLibero = giornoLibero;
	}

	public String getCodice() {
		return codice;
	}
	/**
	 * 
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	/**
	 * 
	 * @return nome del medico 
	 */
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public GiorniSettimana getGiornoLibero() {
		return giornoLibero;
	}

	public void setGiornoLibero(GiorniSettimana giornoLibero) {
		this.giornoLibero = giornoLibero;
	}

	public String toString() {
		return "Medico: " + nome + " " + cognome + ", codice: " + codice + ", giorno libero: " + giornoLibero;
	}
	
	
	
}
