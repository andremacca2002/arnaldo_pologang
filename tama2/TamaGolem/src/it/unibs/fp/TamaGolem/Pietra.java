package it.unibs.fp.TamaGolem;

public class Pietra {

    private Elemento elemento;

    public Pietra(Elemento elemento) {
        this.elemento = elemento;
        
    }

    public Elemento getElemento() {
        return elemento;
    }

	
	public String toString() {
		return elemento.toString();
	}
    
    
}
