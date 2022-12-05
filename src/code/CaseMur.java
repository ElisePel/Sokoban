package code;

/**
 * permet d'instancier un personnage
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */


public class CaseMur{
	private int abscisseCaseM = 300;
	private int ordonneeCaseM = 300;
	private int hauteurCaseM;
	private int largeurCaseM;
	
	public CaseMur()
	{
	}

	/**
	 * Constructeur de la classe Personnage
	 * @param aP abscisse du personnage
	 * @param oP ordonnÃ©e du personnage
	 * @param h hauteur du personnage
	 * @param l largeur du personnage
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