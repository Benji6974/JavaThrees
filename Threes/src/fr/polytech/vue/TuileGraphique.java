package fr.polytech.vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import fr.polytech.model.Tuile;

public class TuileGraphique extends JLabel{
	private Color c;
	private Tuile t;
	
	public Color getC() {
		return c;
	}
	public void setC() {
		if (t.getValeur() == 1){
			this.c = new Color(108,197,211);
			this.setBackground(c);
			this.setForeground(Color.WHITE);
		}else if (t.getValeur() == 2){
			this.c = new Color(232,43,70);
			this.setBackground(c);
			this.setForeground(Color.WHITE);
		}else if (t.getValeur() == 0){
			this.c = Color.LIGHT_GRAY;
			this.setBackground(c);
			
		}else{
			this.c = new Color(244,239,193);
			this.setBackground(c);
			this.setForeground(Color.BLACK);
		}
		
	}
	public Tuile getT() {
		return t;
	}
	public void setT(Tuile t) {
		this.t = t;
	}
	
	public void maj_tuile(){
		ajout_val(t.getValeur());
		setC();
	}
	
	
	public void ajout_val(int i){
		if(i>0){
			this.setText(Integer.toString(i));
		}else{
			this.setText("");
		}
	}
	
	public TuileGraphique(Tuile t){
		this.t = t;
		this.setFont(new Font("Tahoma", Font.BOLD, 22));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		BevelBorder b = new BevelBorder(javax.swing.border.BevelBorder.RAISED);

		this.setBorder(b);
	
		this.ajout_val(t.getValeur());
		this.setC();
		
	}
	

}
