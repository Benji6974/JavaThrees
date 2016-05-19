package fr.polytech.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.polytech.model.Grille;
import fr.polytech.vue.ThreesVue;





public class ThreesControler implements KeyListener{
	
	private ThreesVue w1;
	private Grille g1;
	public ThreesControler(Grille p_g1, ThreesVue p_w1) {
		// TODO Auto-generated constructor stub
		this.w1 = p_w1;
		this.g1 = p_g1;
		
		
	}
	

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		System.out.println("Touche rel�ch�e : " + arg0.getKeyCode() +
                " (" + arg0.getKeyChar() + ")");
		int keyCode = arg0.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	g1.deplacement_haut();
	            break;
	        case KeyEvent.VK_DOWN:
	        	g1.deplacement_bas();
	            break;
	        case KeyEvent.VK_LEFT:
	        	g1.deplacement_gauche();
	            break;
	        case KeyEvent.VK_RIGHT :
	        	g1.deplacement_droit();
	            break;
	     }
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}