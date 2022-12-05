package code;
/**
 * permet d'instancier un personnage
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 */
public class Personnage {
	/**
	 * attributs
	 * i : correspond Ã  l'abscisse
	 * j : correspond Ã  l'ordonnÃ©e
	 */
	private int abcissePersonnage = 200;
    private int ordonneePersonnage = 200;
    private int hauteurPersonnage;
    private int largeurPersonnage;
    
    public Personnage() {
    	
    }

	/**
	 * Constructeur de la classe Personnage
	 * @param aP abscisse du personnage
	 * @param oP ordonnÃ©e du personnage
	 * @param h hauteur du personnage
	 * @param l largeur du personnage
	 */
	public Personnage(int aP, int oP,int h, int l)
	{
    abcissePersonnage=aP;
    ordonneePersonnage=oP;
    hauteurPersonnage=h;
    largeurPersonnage=l;
	}


	
	/**
	 * @return l'abscisse 
	 */
	public int getAbcisse() {
		return abcissePersonnage;
	}


	/**
	 * @return l'ordonne 
	 */
	public int getOrdonnee() {
		return ordonneePersonnage;
	}

	/**
	 * @return la hauteur 
	 */
	public int getHauteur() {
		return hauteurPersonnage;
	}

	/**
	 * @return la largeur 
	 */
	public int getLargeur() {
		return largeurPersonnage;
	}

	/**
	 * permet de se dÃ©placer
	 * x : correspond Ã  l'abssice
	 * y : correspond Ã  l'ordonnee
	 */
	public void deplacer(int x, int y) {
		abcissePersonnage+=x;
    	ordonneePersonnage+=y;
	}

	
	/**
	 * met Ã  jour les coordonnÃ©es
	 * x : correspond Ã  l'abssice
	 * y : correspond Ã  l'ordonnee
	 */
	public void setCoordonneesPerso(int x, int y) {
    	abcissePersonnage=x;
    	ordonneePersonnage=y;
	}
}
