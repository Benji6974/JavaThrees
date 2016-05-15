package fr.polytech.model;

public class Tuile {
	private int valeur;
	private int pos_x;
	private int pos_y;
	private int nbAdditions;
	
	/**
	 * @return the pos_x
	 */
	public int getPos_x() {
		return pos_x;
	}
	/**
	 * @param pos_x the pos_x to set
	 */
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}
	/**
	 * @return the pos_y
	 */
	public int getPos_y() {
		return pos_y;
	}
	/**
	 * @param pos_y the pos_y to set
	 */
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
	public Tuile(){
		this.setValeur(0);
	}
	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the numero to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public int getnbAdditions(){
		return nbAdditions;
	}
	
	public void setnbAdditions(int valeur){
		this.nbAdditions = valeur;
	}
	
}
