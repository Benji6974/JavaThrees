package fr.polytech.model;

public class Score {
	private double total;
	
	public Score(Grille g){
		score_total(g);
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	/*Calculer le score pour une tuile*/
	public double score_tuile(Tuile t){
		double res = 0;
		res = Math.pow(3, t.getnbAdditions());
		return res;
	}
	
	/*Calculer le score sur tout le plateau*/
	public void score_total(Grille g){
		for(Tuile t : g.getGrille()){
			setTotal(getTotal() + score_tuile(t));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
