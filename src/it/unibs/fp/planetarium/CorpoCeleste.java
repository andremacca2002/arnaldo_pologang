package it.unibs.fp.planetarium;

public class CorpoCeleste {
	
	private String nome;
	private double massa;
	private Punto posizione;
	
	public CorpoCeleste(String nome, double massa, Punto posizione) {
		this.nome = nome;
		this.massa = massa;
		this.posizione = posizione;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getMassa() {
		return this.massa;
	}
	
	public Punto getPosizione() {
		return this.posizione;
	}
	
	public double getX() {
		return this.posizione.getX();
	}
	public double getY() {
		return this.posizione.getY();

	}
	
}
