package it.unibs.fp.massaia;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Ingrediente {
	
	private String nome;
	private double cal;
	private int quantità;
	
	public Ingrediente(String nome, double cal) {
		this.nome = nome;
		this.cal = cal;
	}
	
	
	public Ingrediente(String nome, double cal, int quantità) {
		this.nome = nome;
		this.cal = cal;
		this.quantità = quantità;
	}


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCal() {
		return cal;
	}
	public void setCal(double cal) {
		this.cal = cal;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	@Override
	public String toString() {
		return " nome=" + nome + ", cal=" + cal;
	}
	public static Ingrediente creaIngrediente() {
	String nomeIngrediente;
	boolean valido1=false;
	do {
		nomeIngrediente = InputDati.leggiStringaNonVuota("come si chima l'ingrediente");
		if (!(nomeIngrediente.matches("-?\\d+"))) {
			valido1=true;
		}
	}while(!valido1);
    int calorie = InputDati.leggiIntero("quante calorie per ettogrammo?");
    return new Ingrediente(nomeIngrediente, calorie);
	}
	


}
