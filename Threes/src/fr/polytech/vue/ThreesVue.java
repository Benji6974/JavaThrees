package fr.polytech.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.SwingConstants;

import fr.polytech.model.Grille;
import fr.polytech.model.Tuile;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ThreesVue extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel p_tuilesuiv;
	private JPanel p_jeu;
	private JMenu mnNewMenu;
	private JMenuItem mntmNouveauJeu;
	private JMenuBar menuBar;
	private ArrayList<TuileGraphique> array_tuile;


	public JPanel getP_jeu() {
		return p_jeu;
	}


	public void setP_jeu(JPanel p_jeu) {
		this.p_jeu = p_jeu;
	}


	/**
	 * Create the frame.
	 */
	public ThreesVue(Grille g) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 488);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		mntmNouveauJeu = new JMenuItem("Nouveau Jeu");
		mnNewMenu.add(mntmNouveauJeu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		/* ajout des tuilles dans l'arraylist*/
	
		array_tuile = new ArrayList<TuileGraphique>();
		for(Tuile t : g.getGrille()){
				array_tuile.add(new TuileGraphique(t));
				System.out.println("coucou");
			}
		
		
		
		
		p_jeu = new JPanel();
		contentPane.add(p_jeu, BorderLayout.CENTER);
		p_jeu.setLayout(new GridLayout(4, 4, 5, 5));
		int x = 1;
		int y = g.getTaille_y();
		for (TuileGraphique tg: array_tuile){
			if(x == g.getTaille_x()){
				y--;
			}
			p_jeu.add(tg);
		}
		
		
		
		p_tuilesuiv = new JPanel();
		contentPane.add(p_tuilesuiv, BorderLayout.NORTH);
	}


	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof Tuile)
		{
			Tuile c1 = (Tuile) arg0;
			
			for (TuileGraphique tg :array_tuile){
				if (tg.getT().getPos_x() == c1.getPos_x() && tg.getT().getPos_y() == c1.getPos_y()){
					tg.maj_tuile(c1);
				}
			}
			
		}
		
	}

}
