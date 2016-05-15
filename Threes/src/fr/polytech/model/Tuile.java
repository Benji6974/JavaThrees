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
	
	/*retourne FAUX si mouvement impossible à la position x, y
	 * sinon, déplace la tuile, met à jour la valeur.*/
	public boolean deplacer(Grille g, int x, int y){
		/*si on est sur un bord*/
		if((x < 0 || x >= g.getTaille_x()) || (y < 0 || y >= g.getTaille_y())){
			return false;
		}
		for(Tuile t : g.getGrille()){
			/*s'il y a déjà une tuile à cette position x,y*/
			if((t.pos_x == x) && (t.pos_y == y)){
				setPos_x(x);
				setPos_y(y);
				/*si les valeurs des tuiles sont identiques, on les additionne,
				 * puis on supprime l'ancienne de l'arraylist de la grille*/
				if(t.valeur == this.valeur){
					this.valeur += this.valeur;
					g.getGrille().remove(t);
				}else{
					return false;
				}
				return true;
			}
		}
		return true;		
	}	
}
