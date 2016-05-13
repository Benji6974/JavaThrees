package fr.polytech.model;

import java.util.ArrayList;

public class Grille {
	private ArrayList<Tuille> grille;
	private int taille_x = 4;
	private int taille_y = 4;
	
	
	/**
	 * @return the grille
	 */
	public ArrayList<Tuille> getGrille() {
		return grille;
	}

	/**
	 * @param grille the grille to set
	 */
	public void setGrille(ArrayList<Tuille> grille) {
		this.grille = grille;
	}

	/**
	 * @return the taille_x
	 */
	public int getTaille_x() {
		return taille_x;
	}

	/**
	 * @param taille_x the taille_x to set
	 */
	public void setTaille_x(int taille_x) {
		this.taille_x = taille_x;
	}

	/**
	 * @return the taille_y
	 */
	public int getTaille_y() {
		return taille_y;
	}

	/**
	 * @param taille_y the taille_y to set
	 */
	public void setTaille_y(int taille_y) {
		this.taille_y = taille_y;
	}

	public Grille(){
		grille = new ArrayList<Tuille>();
	}
	
	public void generation(){
		int nb_spawn = taille_x*taille_y - (taille_x+ taille_y);
		for (int i = 0; i<taille_x*taille_y; i++){
			grille.add(new Tuille());
		}
	}
	
	public void affichagetemporaire(){
		int i = 0;
		for(Tuille t : grille){
			
			if (i%taille_x == 0){
				System.out.println(" ");
			}
			System.out.print(t.getValeur()+" ");
			i++;
	}
	}
}
