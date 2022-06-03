package it.unibs.fp.rovinePerdute;

import java.util.*;

public class Citta {
	private String nome;
	private int ID;
	private int x;
	private int y;
	private int h;
	ArrayList<Integer> link = new ArrayList<Integer>();
	
	
	public Citta(String nome, int ID, int x, int y, int h, ArrayList<Integer> link) {
		super();
		this.nome = nome;
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.h = h;
		this.link = link;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public ArrayList<Integer> getLink() {
		return link;
	}
	public void setLink(ArrayList<Integer> link) {
		this.link = link;
	}

	public String toString() {
		String stringa = "Citt� [nome= " + nome + ", ID= " + ID + ", x= " + x + ", y= " + y + ", h= " + h + "]\nlink:\n";
		StringBuffer risultato = new StringBuffer();
		risultato.append(stringa);
		
		for(int i = 0; i < link.size(); i++) {
			risultato.append(link.get(i) + "\n");
		}
		
		return risultato.toString();
	}
	
	
	
}
