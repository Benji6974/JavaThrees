package fr.polytech.model;


public class ThreesModel {
	private Grille g1;
	
	public void mise_a_jour(){
		
	}
	
	public ThreesModel(){
		g1 = new Grille();
		g1.generation();
		g1.affichagetemporaire();
		g1.deplacement_gauche();
		g1.affichagetemporaire();
	}
	
	public static void main (String[] args){
		ThreesModel tm = new ThreesModel();
		
		
	}
}
