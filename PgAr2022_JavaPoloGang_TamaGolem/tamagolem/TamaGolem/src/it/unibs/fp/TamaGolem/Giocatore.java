package it.unibs.fp.TamaGolem;

public class Giocatore {
	
	private String nome;
	private TamaGolem [] tamagolems = new TamaGolem[2];
	
	public Giocatore(String nome, TamaGolem[] tamagolems) {
		this.nome = nome;
		this.tamagolems = tamagolems;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TamaGolem[] getTamagolems() {
		return tamagolems;
	}

	public void setTamagolems(TamaGolem[] tamagolems) {
		this.tamagolems = tamagolems;
	}

	public String toString() {
		return "Giocatore [nome=" + nome + ", tamagolems=" + tamagolems.toString() + "]";
	}
	
	
	
	
}