package code;

/**
 * permet d'instancier un personnage
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */


public class CaseMur extends Case{
	/**
	 * attributs
	 * i : correspond Ã  l'abscisse
	 * j : correspond Ã  l'ordonnÃ©e
	 */
	
	private Case c;
	
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
		super(aC, oC, h, l);
	}
	/**
	 * @return l'abscisse 
	 */
	public int getAbcisse() {
		return c.getabcisseCase();
	}


	/**
	 * @return l'ordonne 
	 */
	public int getOrdonnee() {
		return c.getordonneeCase();
	}

	/**
	 * @return la hauteur 
	 */
	public int getHauteur() {
		return c.gethauteurCase();
	}

	/**
	 * @return la largeur 
	 */
	public int getLargeur() {
		return c.getlargeurCase();
	}

	
	/**
	 * met Ã  jour les coordonnÃ©es
	 * x : correspond Ã  l'abssice
	 * y : correspond Ã  l'ordonnee
	 */
	public void setCoordonnees(int x, int y) {
    	c.setabcisseCase(x);
    	c.setordonneeCase(y);
	}
}