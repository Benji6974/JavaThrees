package fr.polytech.controler;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.polytech.model.Grille;
import fr.polytech.vue.ThreesVue;





public class ThreesControler implements KeyListener,MouseListener,ActionListener{
	
	private ThreesVue w1;
	private Grille g1;
	private boolean clic;
	private Point position;
	public ThreesControler(Grille p_g1, ThreesVue p_w1) {
		// TODO Auto-generated constructor stub
		this.w1 = p_w1;
		this.g1 = p_g1;
		
		
	}
	

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		if (g1.test_possible_mouvement()){
			System.out.println("Touche relâchée : " + arg0.getKeyCode() +
	                " (" + arg0.getKeyChar() + ")");
			int keyCode = arg0.getKeyCode();
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP: // on regarde l'evenement flèche du haut
		        	g1.deplacement_haut();
		        	//g1.affichagetemporaire();
		        	w1.miseajour();
		            break;
		        case KeyEvent.VK_DOWN: // on regarde l'evenement flèche du bas
		        	g1.deplacement_bas();
		        	//g1.affichagetemporaire();
		        	w1.miseajour();
		            break;
		        case KeyEvent.VK_LEFT: // on regarde l'evenement flache a gauche
		        	g1.deplacement_gauche();
		        	//g1.affichagetemporaire();
		        	w1.miseajour();
		            break;
		        case KeyEvent.VK_RIGHT : // on regarde 
		        	g1.deplacement_droit();
		        	//g1.affichagetemporaire();
		        	w1.miseajour();
		            break;
		     }
		}else{
			
			w1.partie_fini();
			g1.relancerjeu();
			w1.miseajour();
		}
		
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e) {
		if (g1.test_possible_mouvement()){ // on regarde si il est possible de bouger
			position = e.getPoint(); // on sauvegarde les positions de la souris
			clic = true; // on dis que la souris a été appuyé
		}else{ // sinon on affiche la popup pour dire que l'on a perdu
			w1.partie_fini();
			g1.relancerjeu();
			w1.miseajour();
		}
			
		
		
	}


	public void mouseReleased(MouseEvent e) {
		if (clic){ // si la souris a été apuillé et donc que l'on a sauvegardé les positions
			// on compare les positions avec les anciennes
			int deplace_x = (int) (e.getPoint().getX()-position.getX());
			int deplace_y = (int) (e.getPoint().getY()-position.getY());
			if (Math.abs(deplace_x)>50 || Math.abs(deplace_y)>50){ // gerer le fait de faire un deplacement minimum pour que cela s'enclenche
			
				if (Math.abs(deplace_x) > Math.abs(deplace_y)){ // si le positionnement en x est plus grand on se deplace horisontallement
					if (deplace_x>0){ // on se deplace vers la droite
						g1.deplacement_droit();

			        	//g1.affichagetemporaire();
			        	w1.miseajour();
					}else{	
						g1.deplacement_gauche();// on se deplace vers la gauche
			        	//g1.affichagetemporaire();
			        	w1.miseajour();
					}
				}else{
					if (deplace_y>0){ // on se deplace vers le vas 
						g1.deplacement_bas();
			        	//g1.affichagetemporaire();
			        	w1.miseajour();
					}else{
						g1.deplacement_haut(); // on se deplace vers le haut
			        	//g1.affichagetemporaire();
			        	w1.miseajour();
					}
				}
				
			}
			clic = false;
		}
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == w1.getCommencer()){ // si l'on appuye sur jouer
			w1.jouer();
			g1.relancerjeu();
			w1.miseajour();
		}else if(e.getSource() == w1.getNouveaujeu()){ // si l'on appuiye sur le bouton recommencer
			g1.relancerjeu();
			w1.miseajour();
		}
		
	}

}