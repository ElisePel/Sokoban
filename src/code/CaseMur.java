package code;

/**
 * permet d'instancier une case mur
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */


public class CaseMur{
	/**
	 * abcisseCaisse : abscisse de la case mur
	 * ordonneeCaisse : ordonnee de la case mur
	 * hauteurCaisse : hauteur de la case mur
	 * largeurCaisse : largeur de la case mur
	 */
	private int abscisseCaseM = 300;
	private int ordonneeCaseM = 300;
	private int hauteurCaseM;
	private int largeurCaseM;
	
	/**
	 * constructeur vide
	 */
	public CaseMur()
	{
	}

	/**
	 * Constructeur de la classe CaseMur
	 * @param aP abscisse d'une case mur
	 * @param oP ordonnÃ©e d'une case mur
	 * @param h hauteur d'une case mur
	 * @param l largeur d'une case mur
	 */
	public CaseMur(int aC, int oC,int h, int l)
	{
		abscisseCaseM=aC;
	    ordonneeCaseM=oC;
	    hauteurCaseM=h;
	    largeurCaseM=l;
	}
	/**
	 * @return l'abscisse 
	 */
	public int getAbcisse() {
		return abscisseCaseM;
	}


	/**
	 * @return l'ordonne 
	 */
	public int getOrdonnee() {
		return ordonneeCaseM;
	}

	/**
	 * @return la hauteur 
	 */
	public int getHauteur() {
		return hauteurCaseM;
	}

	/**
	 * @return la largeur 
	 */
	public int getLargeur() {
		return largeurCaseM;
	}

	
	/**
	 * met Ã  jour les coordonnÃ©es
	 * x : correspond Ã  l'abssice
	 * y : correspond Ã  l'ordonnee
	 */
	public void setCoordonnees(int x, int y) {
    	abscisseCaseM =x;
    	ordonneeCaseM=y;
	}
}