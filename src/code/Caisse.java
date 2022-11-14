package code;

/**
 * permet d'instancier un personnage
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */


public class Caisse {
	/**
	 * attributs
	 * i : correspond Ã  l'abscisse
	 * j : correspond Ã  l'ordonnÃ©e
	 */
	
	private int abcisseCaisse;
	private int ordonneeCaisse;
	private int hauteurCaisse;
	private int largeurCaisse;
	private boolean arrivee;

	/**
	 * Constructeur de la classe Personnage
	 * @param aP abscisse du personnage
	 * @param oP ordonnÃ©e du personnage
	 * @param h hauteur du personnage
	 * @param l largeur du personnage
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
	public void setCoordonneesCaisse(int x, int y) {
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