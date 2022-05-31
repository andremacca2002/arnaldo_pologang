package it.unibs.fp.TamaGolem;

	public enum Elemento {
		
		BARBECUE("pietra barbecue", 1), //elementi scelti
	    KETCHUP("pietra ketchup", 2),
		MAIONESE("pietra maionese", 3),
	    TERIYAKI("pietra teriyaki", 4),
	    YOGURT("Pietra yogurt", 5);

	    private String nome;
	    private int id;

	    private Elemento(String nome, Integer id){
	        this.nome = nome;
	        this.id = id;
	    }

	    
	    public String toString() {
	        return nome;
	    }

	    public String getNome() {
	        return nome;
	    }
	    public int getId() {
	        return id;
	    }
	}
