package fr.polytech.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JMenu menujeu;
	private JMenuItem nouveaujeu;
	private JMenuBar menuBar;
	

	private ArrayList<TuileGraphique> array_tuile;
	private Grille g;
	private JButton commencer;
	private JLabel lblThrees;
	private JLabel copiright;


	public JPanel getP_jeu() {
		return p_jeu;
	}


	public void setP_jeu(JPanel p_jeu) {
		this.p_jeu = p_jeu;
	}
	public JMenuItem getNouveaujeu() {
		return nouveaujeu;
	}


	public void setNouveaujeu(JMenuItem nouveaujeu) {
		this.nouveaujeu = nouveaujeu;
	}


	/**
	 * Create the frame.
	 */
	public ThreesVue(final Grille g) {
		this.g = g;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 488);
		setTitle("Threes - Marie Cheng | Daujat Benjamin");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menujeu = new JMenu("Jeu");
		menuBar.add(menujeu);
		
		nouveaujeu = new JMenuItem("Nouveau Jeu");
		menujeu.add(nouveaujeu);
		menujeu.setEnabled(false);
		getContentPane().setLayout(null);
		
		commencer = new JButton("Jouer");
		commencer.setBounds(160, 185, 208, 62);
		getContentPane().add(commencer);
		
		lblThrees = new JLabel("Threes");
		lblThrees.setHorizontalAlignment(SwingConstants.CENTER);
		lblThrees.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblThrees.setBounds(43, 24, 413, 70);
		getContentPane().add(lblThrees);
		
		copiright = new JLabel("Marie Cheng | Daujat Benjamin");
		copiright.setHorizontalAlignment(SwingConstants.CENTER);
		copiright.setBounds(323, 378, 191, 39);
		getContentPane().add(copiright);
		
	}
	
	public void jouer(){
		this.remove(lblThrees);
		this.remove(copiright);
		this.remove(commencer);
		menujeu.setEnabled(true);
		init();
	}
	
	public void init(){
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
		p_jeu.setLayout(new GridLayout(g.getTaille_x(), g.getTaille_y(), 5, 5));
		
		int x =1, y=g.getTaille_y();
		for(int z = 1 ; z<= g.getTaille_y();z++){
			for(TuileGraphique tg: array_tuile){
				if (x > g.getTaille_x()){
					x = 1;	
				}
				if (x == tg.getT().getPos_x() && y == tg.getT().getPos_y()){
					p_jeu.add(tg);
				}
				x++;
				
			}
			System.out.println("");
			y--;
		}
		
		
		p_tuilesuiv = new JPanel();
		
		contentPane.add(p_tuilesuiv, BorderLayout.NORTH);
	}

	
	public void miseajour(){
		for(TuileGraphique tg: array_tuile){
				tg.maj_tuile();
			}
	}
	
	public void partie_fini(){
		Partiefini pf = new Partiefini(g);
		pf.setVisible(true);
		pf.setModal(true);
		
	}
	
	public void update(Observable arg0, Object arg1) {
		System.out.println("test11111111111111111111");
		
		if (arg0 instanceof Tuile)
		{
			miseajour();
			Tuile c1 = (Tuile) arg0;
			System.out.println("test");
			for (TuileGraphique tg :array_tuile){
				if (tg.getT().getPos_x() == c1.getPos_x() && tg.getT().getPos_y() == c1.getPos_y()){
					tg.maj_tuile();
					
				}
			}
			
		}
		this.repaint();
		
	}


	public JButton getCommencer() {
		return commencer;
	}


	public void setCommencer(JButton commencer) {
		this.commencer = commencer;
	}
}
