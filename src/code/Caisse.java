package code;

/**
 * permet d'instancier une caisse
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */


public class Caisse {
	/**
	 * attributs
	 * abcisseCaisse : abscisse de la caisse
	 * ordonneeCaisse : ordonnee de la caisse
	 * hauteurCaisse : hauteur de la caisse
	 * largeurCaisse : largeur de la caisse
	 */
	
	private int abcisseCaisse = 300;
	private int ordonneeCaisse = 300;
	private int hauteurCaisse;
	private int largeurCaisse;
	private boolean arrivee;
	
	public Caisse() {
		
	}

	/**
	 * Constructeur de la classe Caisse
	 * @param aP abscisse de la caisse
	 * @param oP ordonnÃ©e de la caisse
	 * @param h hauteur de la caisse
	 * @param l largeur de la caisse
	 */
	public Caisse(int aC, int oC,int h, int l)
	{
	    abcisseCaisse=aC;
	    ordonneeCaisse=oC;
	    hauteurCaisse=h;
	    largeurCaisse=l;
	    arrivee=false;
	}


	
	/**
	 * @return l'abscisse 
	 */
	public int getAbcisse() {
		return abcisseCaisse;
	}


	/**
	 * @return l'ordonne 
	 */
	public int getOrdonnee() {
		return ordonneeCaisse;
	}

	/**
	 * @return la hauteur 
	 */
	public int getHauteur() {
		return hauteurCaisse;
	}

	/**
	 * @return la largeur 
	 */
	public int getLargeur() {
		return largeurCaisse;
	}

	/**
	 * permet de se dÃ©placer
	 * x : correspond Ã  l'abssice
	 * y : correspond Ã  l'ordonnee
	 */
	public void deplacer(int x, int y) {
		abcisseCaisse+=x;
    	ordonneeCaisse+=y;
	}

	
	/**
	 * met Ã  jour les coordonnÃ©es
	 * x : correspond Ã  l'abssice
	 * y : correspond Ã  l'ordonnee
	 */
	public void setCoordonnees(int x, int y) {
    	abcisseCaisse=x;
    	ordonneeCaisse=y;
	}
	
	/**
	 * @brief Caisse::setArrivee
	 * @param a
	 */
	public void setArrivee(boolean a)
	{
	    arrivee=a;
	}

	/**
	 * @brief Caisse::getArrivee
	 * @return true si la caisse est sur une case arrivée, false sinon
	 */
	public boolean getArrivee()
	{
	    return arrivee;
	}
}
