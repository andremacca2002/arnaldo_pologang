package rovinePerdute;

import java.util.*;

public class Citta {
	String nome;
	int ID;
	int x;
	int y;
	int h;
	ArrayList<Integer> link = new ArrayList<Integer>();
	public Citta(String nome, int iD, int x, int y, int h, ArrayList<Integer> link) {
		super();
		this.nome = nome;
		ID = iD;
		this.x = x;
		this.y = y;
		this.h = h;
		this.link = link;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getH() {
		return h;
	}
	
	public ArrayList<Integer> getLink() {
		return link;
	}
}
