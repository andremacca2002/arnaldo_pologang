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
	
	
}
