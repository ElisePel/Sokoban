package code;


/**
 * permet d'instancier un plateau
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 *
 */
public class Plateau {
	/**
	 * attributs :
	 * largeur : entier contenant la largeur de la grille
	 * hauteur : entier contenant la hauteur de la grille
	 * cases : HashMap qui a pour valeur case et pour clÃ© coordonnÃ©es
	 */
	private int largeur = 6;
	private int hauteur = 7; 	
	
	/**
	 * Constructeur par dÃ©fault de la classe Plateau
	 */
	public Plateau() {
		cases = new HashMap<Coordonnee, Case>();	
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				Coordonnee cor = new Coordonnee(i,j);
				Case c = new CaseVide(cor);
				cases.put(cor, c);
			}
		}
	}
	
	/**
	 * Constructeur
	 * @param l : entier qui correspond Ãƒ  la largeur de la grille
	 * @param h : entier qui correspond Ãƒ  la hauteur de la grille
	 */
	public Grille(int l, int h) {
		largeur = l;
		hauteur = h;
		cases = new HashMap<Coordonnee, Case>();
		
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				Coordonnee cor = new Coordonnee(i,j);
				Case c = new CaseVide(cor);
				cases.put(cor, c);
			}
		}
	}
	
	/**
	 * @return String : affiche la grille
	 */
	public String afficher() {
		String s="     ";
		for(int i=0 ; i<largeur ; i++) {
			s += "--" + i + "-- ";
		}
		s += "\n";
		for(int i=0 ; i<hauteur ; i++) {
			s += "--" + i + "-- ";
			for(int j=0 ; j<largeur ; j++) {
				Case c = getCase(i,j);
				s += c.afficher();
			}
			s += "\n";
		}
		return s;
	}

	/**
	 * @param i : abscisse
	 * @param j : ordonnÃ©e
	 * @param c : case
	 * met Ã  jour le type de cases
	 */
	public void setCase(int i, int j, Case c) {
		Coordonnee cor = new Coordonnee(i,j);
		cases.put(cor, c);
	}
	
	/**
	 * @param i : abscisse
	 * @param j : ordonnÃ©e
	 * @return case
	 */
	public Case getCase(int i, int j) {
		Coordonnee cor = new Coordonnee(i,j);
		return cases.get(cor);
	}
	
	/**
	 * @return boolean : true si la grille est pleine, false sinon
	 */
	public boolean pleine() {
		int n=0;
		while(n<largeur) {
			for(int j=0 ; j<largeur ; j++) {
				Case c = getCase(0,j);
				if(c instanceof CaseVide) {
					return false;
				}
			}
			n++;
		}
		return true;
	}
	
}
