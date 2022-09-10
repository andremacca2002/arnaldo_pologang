package it.unibs.fp.AziendaSanitaria;

public class Paziente {
	private String tesseraSanitaria;
	private String nome;
	private String cognome;
	private String medico;
	
	public Paziente(String tesseraSanitaria, String nome, String cognome, String medico) {
		this.tesseraSanitaria = tesseraSanitaria;
		this.nome = nome;
		this.cognome = cognome;
		this.medico = medico;
	}

	public String getTesseraSanitaria() {
		return tesseraSanitaria;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String toString() {
		return "Paziente: " + nome + " " + cognome + ", numero tessera sanitaria: " + tesseraSanitaria + ", codice medico: " + medico;
	}
	
	
}
