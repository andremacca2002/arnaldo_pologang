package it.unibs.fp.codiceFiscale;

public class Persona {
	String nome;
	String cognome;
	String sesso;
	String luogoNascita;
	String data;
	
	public Persona(String nome, String cognome, String sesso, String comune, String data) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.luogoNascita = comune;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getSesso() {
		return sesso;
	}
	
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	public String getLuogoNascita() {
		return luogoNascita;
	}
	
	public void setLuogoNascita(String comune) {
		this.luogoNascita = comune;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

		
}
