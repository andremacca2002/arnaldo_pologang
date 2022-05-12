package it.unibs.fp.TamaGolem;

public class TamaGolem {
	
	int vita = 10;
	Pietra [] pietre = new Pietra[3];
	
	public TamaGolem(int vita, Pietra [] pietre) {
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
}
