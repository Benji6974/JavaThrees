package fr.polytech.model;

import java.util.ArrayList;
import java.util.Random;



public class Grille {
	private ArrayList<Tuile> grille;
	private int taille_x = 4;
	private int taille_y = 4;
	private int score;
	
	
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
		this.generation();
		this.setScore(0);
	}
	
	/* ajoute une nouvelle tuile pendant le jeu*/
	public void ajout_val(){
		Random rand = new Random();
		int nb_spawn = taille_x*taille_y - (taille_x+ taille_y);
		for (int i =0; i<nb_spawn; i++){
			int nombreAleatoire = rand.nextInt(3 - 1 + 1) + 1; // nombre aleatoire entre faire spawn 1 2 ou 3
			boolean verif = true;
			while(verif){ // tant que l'on a pas reussi a positionner la nouvelle tuile
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
	
	
	/*Calculer le score sur tout le plateau*/
    public void score_total(){
        for(Tuile t : grille){
            setScore(getScore() + t.getValeur());
        }
    }
    
    /* generation du jeu au d�but*/
	public void generation(){
		
		int x = 1;
		int y = 1;
		for (int i = 0; i<taille_x*taille_y; i++){
			if (x > this.getTaille_x()){
				x =1;
				y++;
			}
			if (y > this.getTaille_y()){
				y =1;
			}
			grille.add(new Tuile(x,y)); // on ajoute les tuilles a l'arraylist
			x++;
			
		}
		ajout_val(); // on ajoute les valeurs dans l'araylist
	}
	
	/* fonction pour relancer un nouveau jeux*/
	public void relancerjeu(){
		for(Tuile t : grille){
			t.setValeur(0);
		}
		ajout_val();
		this.setScore(0);
	}
	
	
	/* fonction de deplacement du jeu*/
	public boolean deplacement(Deplacement direction) {
		int x;
		int y;
		int untrucquimarche = 0; // test pour savoir si il y a eu un deplacement
		boolean res = false;
		// deplacement vers la gauche
		if (direction == Deplacement.GAUCHE){
			x = 1;
			
			while(x<= getTaille_x()){
				for (Tuile t: getGrille()){
					if (t.getPos_x()== x){
						res = t.deplacer(this, t.getPos_x()-1, t.getPos_y());// on deplace si c'est possible la tuille
						if (res){ // si il y a eu un changement
							untrucquimarche++;
						}
					}
				}
				x++;
			}
		}
		// deplacement vers la droite
		if (direction == Deplacement.DROIT){
			x = getTaille_x();
			while(x>= 1){
				for (Tuile t: getGrille()){
					if (t.getPos_x()== x){
						res = t.deplacer(this, t.getPos_x()+1, t.getPos_y());// on deplace si c'est possible la tuille
						if (res){// si il y a eu un changement
							untrucquimarche++;
						}
					}
				}
				x--;
			}
		}
		// deplacement vers le haut
		if (direction == Deplacement.HAUT){
			y = getTaille_y();
			while(y>= 1){
				for (Tuile t: getGrille()){
					if (t.getPos_y()== y){
						res = t.deplacer(this, t.getPos_x(), t.getPos_y()+1);// on deplace si c'est possible la tuille
						if (res){// si il y a eu un changement
							untrucquimarche++;
						}
					}
				}
				y--;
			}
		}
		// deplacement vers le bas
		if (direction == Deplacement.BAS){
			y = 1;
			while(y<= getTaille_y()){
				for (Tuile t: getGrille()){
					if (t.getPos_y()== y){
						res = t.deplacer(this, t.getPos_x(), t.getPos_y()-1); // on deplace si c'est possible la tuille
						if (res){// si il y a eu un changement
							untrucquimarche++;
						}
					}
				}
				y++;
			}
		}
		if (untrucquimarche >0){ // si il y a eu 1 ou plusieurs deplacements
			res = true;
		}
		return res;
	}
	
	
	/* on ajoute une valeur a l'opos� de la direction apuill�*/
	private boolean ajouteval(Deplacement direction) {
		Random rand = new Random();
		boolean res = false;
		int nombreAleatoirex = rand.nextInt(3 - 1 + 1) + 1;
		if (direction == Deplacement.GAUCHE){
			if(possible_ajoute(1,this.getTaille_x())){// on regarde si il est possible d'ajouter
				while(!res){ // tant que l'on a pas ajout� de valeur
					int posAleatoirey = rand.nextInt(this.getTaille_y() - 1 + 1) + 1; // on tire au sort une position
					for(Tuile t: grille){
						if (t.getPos_x() == this.getTaille_x() && t.getPos_y() == posAleatoirey){
							if(t.getValeur()== 0){
								res = true;
								t.setValeur(nombreAleatoirex);
							}
						}
					}
				}
			}
		}
		if (direction == Deplacement.DROIT){
			if(possible_ajoute(1,1)){// on regarde si il est possible d'ajouter
				while(!res){// tant que l'on a pas ajout� de valeur
					int posAleatoirey = rand.nextInt(this.getTaille_y() - 1 + 1) + 1;// on tire au sort une position
					for(Tuile t: grille){
						if (t.getPos_x() == 1 && t.getPos_y() == posAleatoirey){
							if(t.getValeur()== 0){
								res = true;
								t.setValeur(nombreAleatoirex);
							}
						}
					}
				}
			}
		}
		if (direction == Deplacement.HAUT){
			if(possible_ajoute(0,1)){// on regarde si il est possible d'ajouter
				while(!res){// tant que l'on a pas ajout� de valeur
					int posAleatoirex = rand.nextInt(this.getTaille_x() - 1 + 1) + 1;// on tire au sort une position
					for(Tuile t: grille){
						if (t.getPos_y() == 1 && t.getPos_x() == posAleatoirex){
							if(t.getValeur()== 0){
								res = true;
								t.setValeur(nombreAleatoirex);
							}
						}
					}
				}
			}
		}
		if (direction == Deplacement.BAS){
			if(possible_ajoute(0,this.getTaille_y())){ // on regarde si il est possible d'ajouter
				while(!res){// tant que l'on a pas ajout� de valeur
					int posAleatoirex = rand.nextInt(this.getTaille_x() - 1 + 1) + 1;// on tire au sort une position
					for(Tuile t: grille){
						if (t.getPos_y() == this.getTaille_y() && t.getPos_x() == posAleatoirex){
							if(t.getValeur()== 0){
								res = true;
								t.setValeur(nombreAleatoirex);
							}
						}
					}
				}
			}
			
		}
		return res;
		
	}
	
	/* fonction de test si l'on peut ajouter une tuile sur une ligne ou une collone*/
	public boolean possible_ajoute(int type, int val){
		
		for(Tuile t:grille){
			if(type == 1){
				System.out.println("je suis "+t);
				if (t.getPos_x()==val) // c'est une colonne
				{
					if(t.getValeur() == 0){
						return true;
					}
				}
				
			}else
			{
				if (t.getPos_y()==val)// c'est une ligne
				{
					if(t.getValeur() == 0){
						return true;
					}
				}
			}
			
		}
		return false;
		
		
	}
	
	
	// fonction de test pour tester si il est possible de bouger sur la grille
	public boolean test_possible_mouvement(){
		for(Tuile t: grille){
			
			if (t.is_possible_mouve(this)){
				return true;
			}else{
				System.out.println("jepeupasbouger");
			}
		}
		return false;
		
	}
	
	
	// fonction de deplacement a gauche
	public void deplacement_gauche(){
		boolean res = deplacement(Deplacement.GAUCHE);
		
		if (res){
			boolean res2 = ajouteval(Deplacement.GAUCHE);
			
			
		}
	}
	
	// fonction de deplacement a droite
	public void deplacement_droit(){
		boolean res = deplacement(Deplacement.DROIT);
		
		if (res){
			boolean res2 = ajouteval(Deplacement.DROIT);
			
		}
	}
	
	//fonction de deplacement en haut
	public void deplacement_haut(){
		boolean res = deplacement(Deplacement.HAUT);
		
		if (res){
			boolean res2 = ajouteval(Deplacement.HAUT);
			
			
		}
	}
	
	//fonction de deplacement en bas
	public void deplacement_bas(){
		boolean res = deplacement(Deplacement.BAS);
		
		if (res){
			boolean res2 = ajouteval(Deplacement.BAS);
			
			
		}
	}
	
	//fonction d'affichage temporaire pour valider le mod�le
	/*public void affichagetemporaire(){
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
		
	}*/

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
