package fr.polytech.model;

import java.util.ArrayList;
import java.util.Random;



public class Grille {
	private ArrayList<Tuile> grille;
	private int taille_x = 4;
	private int taille_y = 4;
	
	
	/**
	 * @return the grille
	 */
	public ArrayList<Tuile> getGrille() {
		return grille;
	}

	/**
	 * @param grille the grille to set
	 */
	public void setGrille(ArrayList<Tuile> grille) {
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
		grille = new ArrayList<Tuile>();
	}
	
	public void ajout_val(){
		Random rand = new Random();
		int nb_spawn = taille_x*taille_y - (taille_x+ taille_y);
		for (int i =0; i<nb_spawn; i++){
			int nombreAleatoire = rand.nextInt(3 - 1 + 1) + 1;
			boolean verif = true;
			while(verif){
				int positionAleatoirex = rand.nextInt(this.getTaille_x() - 1 + 1) + 1;
				int positionAleatoirey = rand.nextInt(this.getTaille_y() - 1 + 1) + 1;
				for (Tuile t: getGrille()){
					
					if (positionAleatoirex == t.getPos_x() && positionAleatoirey == t.getPos_y()){
						if (t.getValeur() ==0){
							t.setValeur(nombreAleatoire);
							verif = false;
							break;
						}
							
					}
				}
			}		
		}
	}
	
	public void generation(){
		
		int x = 1;
		int y = 1;
		for (int i = 0; i<taille_x*taille_y; i++){
			if (x > this.getTaille_x()){
				x =1;
			}
			if (y > this.getTaille_y()){
				y =1;
			}
			grille.add(new Tuile(x,y));
			x++;
			y++;
		}
		ajout_val();
	}
	
	public boolean deplacement(Deplacement direction) {
		int x;
		int y;
		boolean res = false;
		if (direction == Deplacement.GAUCHE){
			x = 1;
			
			while(x<= getTaille_x()){
				for (Tuile t: getGrille()){
					if (t.getPos_x()== x){
						res = t.deplacer(this, t.getPos_x()-1, t.getPos_y());
						//System.out.println(res);
					}
				}
				x++;
			}
		}
		if (direction == Deplacement.DROIT){
			x = getTaille_x();
			while(x>= 1){
				for (Tuile t: getGrille()){
					if (t.getPos_x()== x){
						res = t.deplacer(this, t.getPos_x()+1, t.getPos_y());
					}
				}
				x--;
			}
		}
		if (direction == Deplacement.HAUT){
			y = getTaille_y();
			while(y>= 1){
				for (Tuile t: getGrille()){
					if (t.getPos_y()== y){
						res = t.deplacer(this, t.getPos_x(), t.getPos_y()+1);
					}
				}
				y--;
			}
		}
		if (direction == Deplacement.BAS){
			y = 1;
			while(y<= getTaille_y()){
				for (Tuile t: getGrille()){
					if (t.getPos_y()== y){
						res = t.deplacer(this, t.getPos_x(), t.getPos_y()-1);
					}
				}
				y++;
			}
		}
		return res;
	}
	
	private boolean ajouteval(Deplacement direction) {
		return false;
		
	}
	
	void deplacement_gauche(){
		boolean res = deplacement(Deplacement.GAUCHE);
		if (res){
			boolean res2 = ajouteval(Deplacement.GAUCHE);
			
		}
	}
	void deplacement_droit(){
		boolean res = deplacement(Deplacement.DROIT);
		if (res){
			boolean res2 = ajouteval(Deplacement.DROIT);
			
		}
	}
	void deplacement_haut(){
		boolean res = deplacement(Deplacement.HAUT);
		if (res){
			boolean res2 = ajouteval(Deplacement.HAUT);
			
		}
	}
	void deplacement_bas(){
		boolean res = deplacement(Deplacement.BAS);
		if (res){
			boolean res2 = ajouteval(Deplacement.BAS);
			
		}
	}
	
	public void affichagetemporaire(){
		int i = 0;
		System.out.println(this.getGrille());
		int x =1, y=this.getTaille_y();
		for(int z = 1 ; z<= this.getTaille_y();z++){
			for(Tuile t : grille){
				if (x > this.getTaille_x()){
					x = 1;	
				}
				if (x == t.getPos_x() && y == t.getPos_y()){
					System.out.print(t.getValeur()+" ");
				}
				x++;
				
			}
			System.out.println("");
			y--;
		}
		
	}
	
}
