package it.unibs.fp.TamaGolem;

import java.util.Arrays;

public class TamaGolem {
	
	private int vita;
	private String nome;
	private Pietra [] pietre = new Pietra[3];
	
	public TamaGolem(int vita, Pietra [] pietre, String nome) {
		this.vita = vita;
		this.pietre = pietre;
	}
	 public int getVita() {
	        return vita;
	}

	  public void setVita(int vita) { 
		  	this.vita = vita; 
	}
	  

	public Pietra [] getPietre() {
	        return pietre;
	}

	public void setPietre(Pietra [] pietre) {
	        this.pietre = pietre;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return "TamaGolem [vita=" + vita + ", nome=" + nome;
	}
	
}
