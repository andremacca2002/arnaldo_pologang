package it.unibs.fp.massaia;

import it.unibs.fp.mylib.InputDati;
/**
 * classe gestisce i dati riguardanti un ingrediente 
 * 
 * @author macca
 *
 */
public class Ingrediente {

	private String nome;
	private double cal;
	private int quantità;
	/**
	 * @param nome
	 * @param cal
	 */
	public Ingrediente(String nome, double cal) {
		this.nome = nome;
		this.cal = cal;
	}
	/**
	 * costruttore
	 * 
	 * @param nome
	 * @param cal
	 * @param quantità
	 */
	
	public Ingrediente(String nome, double cal, int quantità) {
		this.nome = nome;
		this.cal = cal;
		this.quantità = quantità;
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * 
	 * @return cal
	 */
	public double getCal() {
		return cal;
	}
	/**
	 * 
	 * @param cal
	 */
	public void setCal(double cal) {
		this.cal = cal;
	}
	/**
	 * 
	 * @return quantità
	 */
	public int getQuantità() {
		return quantità;
	}
	/**
	 * 
	 * @param quantità
	 */
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	/**
	 * metodo per creare un ingrediente, 
	 * inserendo nome e calorie per ettogrammo
	 * @return ingrediente 
	 */
	public static Ingrediente creaIngrediente() {
	String nomeIngrediente = InputDati.leggiStringaNonVuotadilettere(STR.MSG_INSERISCI_NOME_INGREDIENTE);	
    int calorie = InputDati.leggiIntero(STR.MSG_QUANTE_CALORIE_PER_ETT);
    return new Ingrediente(nomeIngrediente, calorie);
	}
	
	@Override
	public String toString() {
		StringBuffer descrizione1 = new StringBuffer(); 
		descrizione1.append(STR.MSG_NOME + nome);
		descrizione1.append(STR.MSG_CAL + cal);
		
		return descrizione1.toString();
	  }
	}