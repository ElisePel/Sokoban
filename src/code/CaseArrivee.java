package code;

/**
 * permet d'instancier une case d'arrivee
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */


public class CaseArrivee{
	/**
	 * attributs
	 * abcisseCaisse : abscisse de la case arrivee
	 * ordonneeCaisse : ordonnee de la case arrivee
	 * hauteurCaisse : hauteur de la case arrivee
	 * largeurCaisse : largeur de la case arrivee
	 * arrivee : boolean pour savoir si la case arrivee est rempli ou pas
	 */
	private int abscisseCaseA = 300;
	private int ordonneeCaseA = 300;
	private int hauteurCaseA;
	private int largeurCaseA;
	private boolean arrivee;
	
	/**
	 * constructeur vide
	 */
	public CaseArrivee()
	{

	}

	/**
	 * Constructeur de la classe CaseArrivee
	 * @param aP abscisse de la case arrivee
	 * @param oP ordonnÃ©e de la case arrivee
	 * @param h hauteur de la case arrivee
	 * @param l largeur de la case arrivee
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
