package it.unibs.fp.massaia;

import it.unibs.fp.mylib.InputDati;

public class Ingrediente {
	
	private String nome;
	private double cal;
	private int quantit�;
	
	public Ingrediente(String nome, double cal) {
		this.nome = nome;
		this.cal = cal;
	}
	
	
	public Ingrediente(String nome, double cal, int quantit�) {
		this.nome = nome;
		this.cal = cal;
		this.quantit� = quantit�;
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

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	@Override
	public String toString() {
		return " nome=" + nome + ", cal=" + cal;
	}
	public static Ingrediente creaIngrediente() {
	String nomeIngrediente;
	boolean valido1;
	do {
		valido1=true;
		nomeIngrediente = InputDati.leggiStringaNonVuota(STR.MSG_INSERISCI_NOME_INGREDIENTE);
		for (int i = 0; i < nomeIngrediente.length(); i++)
          {
            char c = nomeIngrediente.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) valido1=false;
            }
		}while(!valido1);
    int calorie = InputDati.leggiIntero(STR.MSG_QUANTE_CALORIE_PER_ETT);
    return new Ingrediente(nomeIngrediente, calorie);
	}
}
