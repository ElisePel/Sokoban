package code;

public class Case {
	/**
	 * attributs
	 * i : correspond Ã  l'abscisse
	 * j : correspond Ã  l'ordonnÃ©e
	 */
	
	private int abcisseCase;
	private int ordonneeCase;
	private int hauteurCase;
	private int largeurCase;

	/**
	 * Constructeur de la classe Personnage
	 * @param aP abscisse du personnage
	 * @param oP ordonnÃ©e du personnage
	 * @param h hauteur du personnage
	 * @param l largeur du personnage
	 */
	public Case()
	{

	}
	
	public Case(int aC, int oC,int h, int l)
	{
	    abcisseCase=aC;
	    ordonneeCase=oC;
	    hauteurCase=h;
	    largeurCase=l;

	}
	
	/**
	 * a : entier qui correspond à l'abscisse
	 */
	public void setabcisseCase(int a) {
		abcisseCase = a; 
	}

	/**
	 * @return j : l'ordonnée 
	 */
	public int getabcisseCase() {
		return abcisseCase;
	}

	/**
	 * a : entier qui correspond à l'abscisse
	 */
	public void setordonneeCase(int a) {
		ordonneeCase = a; 
	}

	/**
	 * @return j : l'ordonnée 
	 */
	public int getordonneeCase() {
		return ordonneeCase;
	}
	
	/**
	 * a : entier qui correspond à l'abscisse
	 */
	public void sethauteurCase(int a) {
		hauteurCase = a; 
	}

	/**
	 * @return j : l'ordonnée 
	 */
	public int gethauteurCase() {
		return hauteurCase;
	}
	
	/**
	 * a : entier qui correspond à l'abscisse
	 */
	public void setlargeurCase(int a) {
		largeurCase = a; 
	}

	/**
	 * @return j : l'ordonnée 
	 */
	public int getlargeurCase() {
		return largeurCase;
	}

}
