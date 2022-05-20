package it.unibs.fp.TamaGolem;

public class TamaGolem {
	
	private int vita;
	private String nome;
	private Pietra [] pietre = new Pietra[3];
	private int pietraAttuale;
	
	public TamaGolem(int vita, Pietra [] pietre, String nome,int pietraAttuale) {
		this.vita = vita;
		this.pietre = pietre;
		this.nome = nome;
		this.pietraAttuale = pietraAttuale; //necessario durante la battaglia per mantenere la ciclicità delle pietre durante più scontri 
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
	public int getPietraAttuale() {
		return pietraAttuale;
	}
	public void setPietraAttuale(int pietraAttuale) {
		this.pietraAttuale = pietraAttuale;
	}
	
}
