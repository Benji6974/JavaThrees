package Main;

import fr.polytech.controler.ThreesControler;
import fr.polytech.model.Grille;
import fr.polytech.vue.ThreesVue;

public class ThreesMain {
	
	public static void main(String[] args)
	{
		//lancement du model
		Grille g1 = new Grille();
		
		
		
		//lancent de la vue
		ThreesVue f1 = new ThreesVue(g1);
		f1.setVisible(true);  
		f1.setFocusable(true);
		//lancement du controller
		ThreesControler c1 = new ThreesControler(g1, f1);
		f1.addKeyListener(c1);
		f1.addMouseListener(c1);
		f1.getCommencer().addActionListener(c1);
		f1.getNouveaujeu().addActionListener(c1);
		
	}
}
