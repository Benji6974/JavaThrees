package fr.polytech.model;

import java.util.Random;


public class ThreesModel {
	private Grille g1;
	
	public void mise_a_jour(){
		
	}
	
	public ThreesModel(){
		g1 = new Grille();
		g1.generation();
		g1.affichagetemporaire();
		/*System.out.println("gauche");
		g1.deplacement_gauche();
		g1.affichagetemporaire();
		System.out.println(g1.test_possible_mouvement());
		System.out.println("bas");
		g1.deplacement_bas();
		g1.affichagetemporaire();
		System.out.println(g1.test_possible_mouvement());
		System.out.println("haut");
		g1.deplacement_haut();
		g1.affichagetemporaire();
		System.out.println(g1.test_possible_mouvement());
		System.out.println("droit");
		g1.deplacement_droit();
		g1.affichagetemporaire();
		System.out.println(g1.test_possible_mouvement());*/
		Random rand = new Random();
		while (g1.test_possible_mouvement()){
			
			int num = rand.nextInt(4 - 1 + 1) + 1;
			if (num == 1){
				System.out.println("droit");
				g1.deplacement_droit();
			}
			if (num == 2){
				System.out.println("haut");
				g1.deplacement_haut();	
			}
			if (num == 3){
				System.out.println("bas");
				g1.deplacement_bas();
			}
			if (num == 4){
				System.out.println("gauche");
				g1.deplacement_gauche();
			}
			g1.affichagetemporaire();
		}
		System.out.println("perdu");
		
	}
	
	public static void main (String[] args){
		ThreesModel tm = new ThreesModel();
		
		
	}
}
