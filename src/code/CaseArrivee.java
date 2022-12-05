package code;

/**
 * permet d'instancier un personnage
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */


public class CaseArrivee{
	private int abscisseCaseA = 300;
	private int ordonneeCaseA = 300;
	private int hauteurCaseA;
	private int largeurCaseA;
	private boolean arrivee;
	
	public CaseArrivee()
	{

	}

	/**
	 * Constructeur de la classe Personnage
	 * @param aP abscisse du personnage
	 * @param oP ordonnÃ©e du personnage
	 * @param h hauteur du personnage
	 * @param l largeur du personnage
	 */
	public CaseArrivee(int aC, int oC,int h, int l, boolean b)
	{
		abscisseCaseA=aC;
	    ordonneeCaseA=oC;
	    hauteurCaseA=h;
	    largeurCaseA=l;
		arrivee = b;
	}


	
	/**
	 * @return l'abscisse 
	 */
	public int getAbcisse() {
		return abscisseCaseA;
	}


	/**
	 * @return l'ordonne 
	 */
	public int getOrdonnee() {
		return ordonneeCaseA;
	}

	/**
	 * @return la hauteur 
	 */
	public int getHauteur() {
		return hauteurCaseA;
	}

	/**
	 * @return la largeur 
	 */
	public int getLargeur() {
		return largeurCaseA;
	}

	
	/**
	 * met Ã  jour les coordonnÃ©es
	 * x : correspond Ã  l'abssice
	 * y : correspond Ã  l'ordonnee
	 */
	public void setCoordonnees(int x, int y) {
		abscisseCaseA=x;
    	ordonneeCaseA=y;
	}
}
