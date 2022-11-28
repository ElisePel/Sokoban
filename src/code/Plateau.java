package code;

import java.util.Scanner; //lire un fichier
import java.awt.Graphics; 
import javax.swing.ImageIcon; //afficher une image

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
	protected int NombreCaisses;
	protected int NombreElements;
	protected int NombreMurs;
    protected Personnage perso;
    protected boolean gagne = false;
    protected Caisse [] listeCaisse;
	protected CaseArrivee [] listeCaseArrivee; 	
	protected CaseMur [] listeMur;
	
	
	/**
	 * Constructeur par dÃ©fault de la classe Plateau
	 */
	public Plateau() {
		
		Caisse[] listeCaisse = new Caisse[NombreCaisses];
		CaseArrivee[] listeCaseArrivee = new CaseArrivee[NombreCaisses];
		CaseMur[] listeMur = new CaseMur[NombreElements-1-2*NombreCaisses];
	}
	
	public Plateau(String nomfichier) {
		int type,a,o,i=0,k=0,m=0;
		
		Scanner sc = new Scanner(nomfichier);
	   
		while (sc.hasNextInt()){
			NombreCaisses = sc.nextInt();
            NombreElements = sc.nextInt();
            NombreMurs = sc.nextInt();
            listeCaisse = new Caisse[NombreCaisses];
            listeCaseArrivee = new CaseArrivee[NombreCaisses];
            listeMur = new CaseMur[NombreMurs];

	            for (int j=0;j<NombreElements;j++){
	                type = sc.nextInt();
	                if (type==0){
	                    a = sc.nextInt();
	                    o = sc.nextInt();
	                    perso.setCoordonneesPerso(a,o);
	                }
	                else if (type==1){
	                    a = sc.nextInt();
	                    o = sc.nextInt();
	                    listeCaisse[i].setCoordonnees(a,o);
	                    i++;
	                }
	                else if (type==2)
	                {
	                    a = sc.nextInt();
	                    o = sc.nextInt();
	                    listeCaseArrivee[k].setCoordonnees(a,o);
	                    k++;
	                }
	                else if (type==3)
	                {
	                    a = sc.nextInt();
	                    o = sc.nextInt();
	                    listeMur[m].setCoordonnees(a,o);
	                    m++;
	                }
	            }
	         }
			sc.close();
	     /*else {
	    	 System.out.println("Impossible d'ouvrir le fichier !");
		}*/
	}

	
	
	
	
	
	/**
	 * Constructeur par dÃ©fault de la classe Plateau
	 */
	public boolean testerSiGagner() {
		boolean b = true;
	    int i=0;
	    while (b==true && i<NombreCaisses)
	    {
	        if (listeCaisse[i].getArrivee()==false)
	            b=false;
	        i++;
	    }
	    return b;
	 }
	
	

	/**
	 * @brief Plateau::VoisinPersoGauche
	 * @return le type du voisin gauche du personnage
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */
	public int VoisinPersoGauche()
	{
	    int x=perso.getAbcisse()-perso.getLargeur();
	    int y=perso.getOrdonnee();

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee[i].getAbcisse()==x && listeCaseArrivee[i].getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur[i].getAbcisse()==x && listeMur[i].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;
	}

	/**
	 * @brief Plateau::VoisinPersoDroite
	 * @return le type du voisin droite du personnage
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */

	public int VoisinPersoDroite()
	{
	    int x=perso.getAbcisse()+perso.getLargeur();
	    int y=perso.getOrdonnee();

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee[i].getAbcisse()==x && listeCaseArrivee[i].getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur[i].getAbcisse()==x && listeMur[i].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;

	}

	/**
	 * @brief Plateau::VoisinPersoHaut
	 * @return le type du voisin haut du personnage
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */
	public int VoisinPersoHaut()
	{
	    int x=perso.getAbcisse();
	    int y=perso.getOrdonnee()-perso.getHauteur();

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee[i].getAbcisse()==x && listeCaseArrivee[i].getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur[i].getAbcisse()==x && listeMur[i].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;

	}

	/**
	 * @brief Plateau::VoisinPersoBas
	 * @return le type du voisin bas du personnage
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */
	public int VoisinPersoBas()
	{
	    int x=perso.getAbcisse();
	    int y=perso.getOrdonnee()+perso.getHauteur();

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee[i].getAbcisse()==x && listeCaseArrivee[i].getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur[i].getAbcisse()==x && listeMur[i].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;

	}

	/**
	 * @brief Plateau::VoisinCaisseGauche
	 * @param i le numéro de la caisse dont on cherche le voisin
	 * @return le type du voisin gauche de la caisse
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */

	public int VoisinCaisseGauche(int i)
	{
	    int x=listeCaisse[i].getAbcisse()-listeCaisse[i].getLargeur();
	    int y=listeCaisse[i].getOrdonnee();

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse[j].getAbcisse()==x && listeCaisse[j].getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee[j].getAbcisse()==x && listeCaseArrivee[j].getOrdonnee()==y)
	            return 2;
	    }

	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur[j].getAbcisse()==x && listeMur[j].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;

	}

	/**
	 * @brief Plateau::VoisinCaisseDroite
	 * @param i le numéro de la caisse dont on cherche le voisin
	 * @return le type du voisin gauche de la caisse
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */
	public int VoisinCaisseDroite(int i)
	{
	    int x=listeCaisse[i].getAbcisse()+listeCaisse[i].getLargeur();
	    int y=listeCaisse[i].getOrdonnee();

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse[j].getAbcisse()==x && listeCaisse[j].getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee[j].getAbcisse()==x && listeCaseArrivee[j].getOrdonnee()==y)
	            return 2;
	    }


	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur[j].getAbcisse()==x && listeMur[j].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;

	}

	/**
	 * @brief Plateau::VoisinCaisseHaut
	 * @param i le numéro de la caisse dont on cherche le voisin
	 * @return le type du voisin haut de la caisse
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */
	public int VoisinCaisseHaut(int i)
	{
	    int x=listeCaisse[i].getAbcisse();
	    int y=listeCaisse[i].getOrdonnee()-listeCaisse[i].getHauteur();

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse[j].getAbcisse()==x && listeCaisse[j].getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee[j].getAbcisse()==x && listeCaseArrivee[j].getOrdonnee()==y)
	            return 2;
	    }


	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur[j].getAbcisse()==x && listeMur[j].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;

	}

	/**
	 * @brief Plateau::VoisinCaisseBas
	 * @param i le numéro de la caisse dont on cherche le voisin
	 * @return le type du voisin bas de la caisse
	 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
	 */
	public int VoisinCaisseBas(int i)
	{
	    int x=listeCaisse[i].getAbcisse();
	    int y=listeCaisse[i].getOrdonnee()+listeCaisse[i].getHauteur();


	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse[j].getAbcisse()==x && listeCaisse[j].getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee[j].getAbcisse()==x && listeCaseArrivee[j].getOrdonnee()==y)
	            return 2;
	    }


	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur[j].getAbcisse()==x && listeMur[j].getOrdonnee()==y)
	            return 3;
	    }

	    return 4;

	}

	/**
	 * @brief Plateau::getNumCaisse
	 * @param d : entier qui correspond à la direction souhaitée
	 * @return le numéro de la caisse recherchée
	 * @details 5 correspond à la direction gauche, 6 à la direction droite, 7 à la direction haut et 8 à la direction bas
	 */
	public int getNumCaisse(int d)
	{
	    int x,y;
	    switch(d)
	    {
	        case 5: x=perso.getAbcisse()-perso.getLargeur();
	                y=perso.getOrdonnee();

	                for (int i=0;i<NombreCaisses;i++)
	                {
	                    if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	                        return i;
	                }
	                break;

	        case 6: x=perso.getAbcisse()+perso.getLargeur();
	                y=perso.getOrdonnee();

	                for (int i=0;i<NombreCaisses;i++)
	                {
	                    if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	                        return i;
	                }
	                break;
	        case 7: x=perso.getAbcisse();
	                y=perso.getOrdonnee()-perso.getHauteur();

	                for (int i=0;i<NombreCaisses;i++)
	                {
	                    if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	                        return i;
	                }
	                break;
	         case 8:x=perso.getAbcisse();
	                y=perso.getOrdonnee()+perso.getHauteur();

	                for (int i=0;i<NombreCaisses;i++)
	                {
	                    if (listeCaisse[i].getAbcisse()==x && listeCaisse[i].getOrdonnee()==y)
	                        return i;
	                }
	                break;
	    }
	    return 0;
	}


	/**
	 * @brief Plateau::DeplacementGauche
	 * @details permet de gérer un déplacement à gauche
	 */
	public void DeplacementGauche()
	{
	    int v=VoisinPersoGauche();
	    int vc;

	    if (v==4)
	        perso.deplacer(-perso.getLargeur(),0);
	    else if (v==2)
	        perso.deplacer(-perso.getLargeur(),0);
	    else if (v==1)
	    {
	        vc=getNumCaisse(5);
	        if (VoisinCaisseGauche(vc)==4)
	        {
	            listeCaisse[vc].deplacer(-listeCaisse[vc].getLargeur(),0);
	            listeCaisse[vc].setArrivee(false);
	            perso.deplacer(-perso.getLargeur(),0);
	        }
	        else if (VoisinCaisseGauche(vc)==2)
	        {
	            listeCaisse[vc].deplacer(-listeCaisse[vc].getLargeur(),0);
	            listeCaisse[vc].setArrivee(true);
	            perso.deplacer(-perso.getLargeur(),0);
	            gagne=testerSiGagner();
	        }
	    }
	}

	/**
	 * @brief Plateau::DeplacementDroite
	 * @details permet de gérer un déplacement à droite
	 */
	public void DeplacementDroite()
	{
	    int v=VoisinPersoDroite();
	    int vc;

	    if (v==4)
	        perso.deplacer(perso.getLargeur(),0);
	    else if (v==2)
	        perso.deplacer(perso.getLargeur(),0);
	    else if (v==1)
	    {
	        vc=getNumCaisse(6);
	        if (VoisinCaisseDroite(vc)==4)
	        {
	            listeCaisse[vc].deplacer(listeCaisse[vc].getLargeur(),0);
	            listeCaisse[vc].setArrivee(false);
	            perso.deplacer(perso.getLargeur(),0);
	        }
	        else if (VoisinCaisseDroite(vc)==2)
	        {
	            listeCaisse[vc].deplacer(listeCaisse[vc].getLargeur(),0);
	            listeCaisse[vc].setArrivee(true);
	            perso.deplacer(perso.getLargeur(),0);
	            gagne=testerSiGagner();
	        }
	    }
	}

	/**
	 * @brief Plateau::DeplacementHaut
	 * @details permet de gérer un déplaceemnt en haut
	 */
	public void DeplacementHaut()
	{
	    int v=VoisinPersoHaut();
	    int vc;

	    if (v==4)
	        perso.deplacer(0,-perso.getHauteur());
	    else if (v==2)
	        perso.deplacer(0,-perso.getHauteur());
	    else if (v==1)
	    {
	        vc=getNumCaisse(7);
	        if (VoisinCaisseHaut(vc)==4)
	        {
	            listeCaisse[vc].deplacer(0,-listeCaisse[vc].getHauteur());
	            listeCaisse[vc].setArrivee(false);
	            perso.deplacer(0,-perso.getHauteur());
	        }
	        else if (VoisinCaisseHaut(vc)==2)
	        {
	            listeCaisse[vc].deplacer(0,-listeCaisse[vc].getHauteur());
	            listeCaisse[vc].setArrivee(true);
	            perso.deplacer(0,-perso.getHauteur());
	            gagne=testerSiGagner();
	        }
	    }
	}

	/**
	 * @brief Plateau::DeplacementBas
	 * @details permet de gérer un déplacement en bas
	 */
	public void DeplacementBas()
	{
	    int v=VoisinPersoBas();
	    int vc;

	    if (v==4)
	        perso.deplacer(0,perso.getHauteur());
	    else if (v==2)
	        perso.deplacer(0,perso.getHauteur());
	    else if (v==1)
	    {
	        vc=getNumCaisse(8);
	        if (VoisinCaisseBas(vc)==4)
	        {
	            listeCaisse[vc].deplacer(0,listeCaisse[vc].getHauteur());
	            listeCaisse[vc].setArrivee(false);
	            perso.deplacer(0,perso.getHauteur());
	        }
	        else if (VoisinCaisseBas(vc)==2)
	        {
	            listeCaisse[vc].deplacer(0,listeCaisse[vc].getHauteur());
	            listeCaisse[vc].setArrivee(true);
	            perso.deplacer(0,perso.getHauteur());
	            gagne=testerSiGagner();
	        }
	    }
	}
	
	
	public void afficher(Graphics g){
		ImageIcon personnage = new ImageIcon("../policier.png");
		ImageIcon caisse = new ImageIcon("../prisonnier.png");
		ImageIcon mur = new ImageIcon("../mur.jpeg");
		ImageIcon arrivee = new ImageIcon("../prison.jpeg");
        
		//personnage = new ImageIcon("C:\\Users\\moi\\Desktop\\5A\\java\\prison.jpeg");
		personnage = new ImageIcon("../prisonnier.png");
		g.drawImage(personnage.getImage(), 200,100,50,50,null);

        //g.drawImage(personnage.getImage(), perso.getAbcisse(),perso.getOrdonnee(),perso.getHauteur(),perso.getLargeur(),null);
/*		
	    for (int i=0;i<NombreCaisses;i++){
	       g.drawImage(caisse.getImage(), listeCaisse[i].getAbcisse(),listeCaisse[i].getOrdonnee(),listeCaisse[i].getHauteur(),listeCaisse[i].getLargeur(),null);
	       g.drawImage(arrivee.getImage(), listeCaseArrivee[i].getAbcisse(),listeCaseArrivee[i].getOrdonnee(),listeCaseArrivee[i].getHauteur(),listeCaseArrivee[i].getLargeur(), null);
	    }
	    for (int l=0;l<NombreMurs;l++){
	    	g.drawImage(mur.getImage(), listeMur[l].getAbcisse(),listeMur[l].getOrdonnee(),listeMur[l].getHauteur(),listeMur[l].getLargeur(),null);
	    }*/
	}
	
	
	public void afficherGagner(Graphics g){
		ImageIcon fin = new ImageIcon(":/fin.png");
	    g.drawImage(fin.getImage(), 225,125,200,200,null);
	}
	
	public boolean getGagne(){
	    return gagne;
	}
	
	

	
}
