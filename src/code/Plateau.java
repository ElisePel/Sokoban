package code;

import java.awt.Graphics; 
import javax.swing.ImageIcon; //afficher une image
import java.util.ArrayList; // import the ArrayList class


/**
 * permet d'instancier un plateau
 * @author Claire MÃ©ziÃ¨res et Elise Pellegry
 * @version 1.0 08/03/2022
 *
 */
public class Plateau {
/**
 *  NombreCaisses : entier qui enregistre le nombre de caisses du niveau
	NombreElements : entier qui enregistre le nombre d'element du niveau
	NombreMurs : entier qui enregistre le nombre de murs du niveau
	niveau : entier qui enregistre le numéro du niveau
    perso : perssonage référent de la classe Personnage
    gagne : boolean, false si le joueur n'a pas gagné
    caisse : caisse référent de la classe Caisse
    casearrivee : case arrivee référent de la classe CaseArrivee
    casemur : case mur référent de la classe CaseMur
    listeCaisse : liste de caisse
    listeCaseArrivee : liste de case arrivee
    listeMur : liste de mur
 */
	protected int NombreCaisses = 1;
	protected int NombreElements = 2;
	protected int NombreMurs = 1;
	protected int niveau;
	protected int score = 0;
    protected Personnage perso = new Personnage();
    protected boolean gagne = false;
    protected Caisse caisse = new Caisse();
    protected CaseArrivee casearrivee = new CaseArrivee();
    protected CaseMur casemur = new CaseMur();
    protected ArrayList<Caisse> listeCaisse = new ArrayList<Caisse>();
    protected ArrayList<CaseArrivee> listeCaseArrivee = new ArrayList<CaseArrivee>();
    protected ArrayList<CaseMur> listeMur = new ArrayList<CaseMur>();
	
	
	/**
	 * Constructeur par dÃ©fault de la classe Plateau
	 */
	public Plateau() {

	}

	
	/**
	 * Constructeur 
	 * @param fichier : numero du niveau à afficher
	 */
	public Plateau(int fichier) {
		niveau = fichier;
		//hauteur
		int h = 50;
		//largeur
		int l = 50;
		switch (fichier) {
			case 1 :
				NombreCaisses = 2;
				NombreElements = 33;
	            NombreMurs = 28;
	            //personnage
	            perso = new Personnage(200,300,h,l);
	            
	           //caisse
	            listeCaisse.add(new Caisse(250,150,h,l));
	            listeCaisse.add(new Caisse(350,250,h,l));
	            
	            //casearrivee
	            listeCaseArrivee.add(new CaseArrivee(400, 150,h,l, false));
	            listeCaseArrivee.add(new CaseArrivee(350, 200,h,l, false));
	            
	            //casemur
	            listeMur.add(new CaseMur(200, 50,h,l));
	            listeMur.add(new CaseMur(250, 50,h,l));
	            listeMur.add(new CaseMur(300, 50,h,l));
	            listeMur.add(new CaseMur(350, 50,h,l));
	            listeMur.add(new CaseMur(400, 50,h,l));
	            listeMur.add(new CaseMur(150, 100,h,l));
	            listeMur.add(new CaseMur(200, 100,h,l));
	            listeMur.add(new CaseMur(400, 100,h,l));
	            listeMur.add(new CaseMur(450, 100,h,l));
	            listeMur.add(new CaseMur(150, 150,h,l));
	            listeMur.add(new CaseMur(450, 150,h,l));
	            listeMur.add(new CaseMur(150, 200,h,l));
	            listeMur.add(new CaseMur(300, 200,h,l));
	            listeMur.add(new CaseMur(450, 200,h,l));
	            listeMur.add(new CaseMur(150, 250,h,l));
	            listeMur.add(new CaseMur(300, 250,h,l));
	            listeMur.add(new CaseMur(450, 250,h,l));
	            listeMur.add(new CaseMur(150, 300,h,l));
	            listeMur.add(new CaseMur(450, 300,h,l));
	            listeMur.add(new CaseMur(150, 350,h,l));
	            listeMur.add(new CaseMur(200, 350,h,l));
	            listeMur.add(new CaseMur(250, 350,h,l));
	            listeMur.add(new CaseMur(300, 350,h,l));
	            listeMur.add(new CaseMur(350, 350,h,l));
	            listeMur.add(new CaseMur(450, 350,h,l));
	            listeMur.add(new CaseMur(350, 400,h,l));
	            listeMur.add(new CaseMur(400, 400,h,l));
	            listeMur.add(new CaseMur(450, 400,h,l));
	        break;

			case 2 :
				NombreCaisses = 4;
				NombreElements = 37;
	            NombreMurs = 28;
	            //personnage
	            perso = new Personnage(300,250,h,l);
	            
	           //caisse
	            listeCaisse.add(new Caisse(250,200,h,l));
	            listeCaisse.add(new Caisse(250,250,h,l));
	            listeCaisse.add(new Caisse(350,200,h,l));
	            listeCaisse.add(new Caisse(300,300,h,l));
	            
	            //casearrivee
	            listeCaseArrivee.add(new CaseArrivee(250, 100,h,l, false));
	            listeCaseArrivee.add(new CaseArrivee(400, 200,h,l, false));
	            listeCaseArrivee.add(new CaseArrivee(150, 250,h,l, false));
	            listeCaseArrivee.add(new CaseArrivee(300, 350,h,l, false));
	            
	            //casemur
	            listeMur.add(new CaseMur(200, 50,h,l));
	            listeMur.add(new CaseMur(250, 50,h,l));
	            listeMur.add(new CaseMur(300, 50,h,l));
	            listeMur.add(new CaseMur(200, 100,h,l));
	            listeMur.add(new CaseMur(300, 100,h,l));
	            listeMur.add(new CaseMur(200, 150,h,l));
	            listeMur.add(new CaseMur(300, 150,h,l));
	            listeMur.add(new CaseMur(350, 150,h,l));
	            listeMur.add(new CaseMur(400, 150,h,l));
	            listeMur.add(new CaseMur(450, 150,h,l));
	            listeMur.add(new CaseMur(100, 200,h,l));
	            listeMur.add(new CaseMur(150, 200,h,l));
	            listeMur.add(new CaseMur(200, 200,h,l));
	            listeMur.add(new CaseMur(450, 200,h,l));
	            listeMur.add(new CaseMur(100, 250,h,l));
	            listeMur.add(new CaseMur(350, 250,h,l));
	            listeMur.add(new CaseMur(400, 250,h,l));
	            listeMur.add(new CaseMur(450, 250,h,l));
	            listeMur.add(new CaseMur(100, 300,h,l));
	            listeMur.add(new CaseMur(150, 300,h,l));
	            listeMur.add(new CaseMur(200, 300,h,l));
	            listeMur.add(new CaseMur(250, 300,h,l));
	            listeMur.add(new CaseMur(350, 300,h,l));
	            listeMur.add(new CaseMur(250, 350,h,l));
	            listeMur.add(new CaseMur(350, 350,h,l));
	            listeMur.add(new CaseMur(250, 400,h,l));
	            listeMur.add(new CaseMur(300, 400,h,l));
	            listeMur.add(new CaseMur(350, 400,h,l));
	        break;
		            
		}
		
	}

	
	
	
/**
 * fonction qui permet de savoir si le joueur à gagner ou pas
 * @return b : boolean
 */
	public boolean testerSiGagner() {
		boolean b = true;
	    int i=0;
	    while (b==true && i<NombreCaisses)
	    {
	        if (listeCaisse.get(i).getArrivee()==false)
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
	        if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee.get(i).getAbcisse()==x && listeCaseArrivee.get(i).getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur.get(i).getAbcisse()==x && listeMur.get(i).getOrdonnee()==y)
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
	        if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee.get(i).getAbcisse()==x && listeCaseArrivee.get(i).getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur.get(i).getAbcisse()==x && listeMur.get(i).getOrdonnee()==y)
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
	        if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee.get(i).getAbcisse()==x && listeCaseArrivee.get(i).getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur.get(i).getAbcisse()==x && listeMur.get(i).getOrdonnee()==y)
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
	        if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
	            return 1;
	    }

	    for (int i=0;i<NombreCaisses;i++)
	    {
	        if (listeCaseArrivee.get(i).getAbcisse()==x && listeCaseArrivee.get(i).getOrdonnee()==y)
	            return 2;
	    }

	    for (int i=0;i<NombreMurs;i++)
	    {
	        if (listeMur.get(i).getAbcisse()==x && listeMur.get(i).getOrdonnee()==y)
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
	    int x=listeCaisse.get(i).getAbcisse()-listeCaisse.get(i).getLargeur();
	    int y=listeCaisse.get(i).getOrdonnee();

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse.get(j).getAbcisse()==x && listeCaisse.get(j).getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee.get(j).getAbcisse()==x && listeCaseArrivee.get(j).getOrdonnee()==y)
	            return 2;
	    }

	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur.get(j).getAbcisse()==x && listeMur.get(j).getOrdonnee()==y)
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
	    int x=listeCaisse.get(i).getAbcisse()+listeCaisse.get(i).getLargeur();
	    int y=listeCaisse.get(i).getOrdonnee();

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse.get(j).getAbcisse()==x && listeCaisse.get(j).getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee.get(j).getAbcisse()==x && listeCaseArrivee.get(j).getOrdonnee()==y)
	            return 2;
	    }


	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur.get(j).getAbcisse()==x && listeMur.get(j).getOrdonnee()==y)
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
	    int x=listeCaisse.get(i).getAbcisse();
	    int y=listeCaisse.get(i).getOrdonnee()-listeCaisse.get(i).getHauteur();

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse.get(j).getAbcisse()==x && listeCaisse.get(j).getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee.get(j).getAbcisse()==x && listeCaseArrivee.get(j).getOrdonnee()==y)
	            return 2;
	    }


	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur.get(j).getAbcisse()==x && listeMur.get(j).getOrdonnee()==y)
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
	    int x=listeCaisse.get(i).getAbcisse();
	    int y=listeCaisse.get(i).getOrdonnee()+listeCaisse.get(i).getHauteur();


	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaisse.get(j).getAbcisse()==x && listeCaisse.get(j).getOrdonnee()==y)
	            return 1;
	    }

	    for (int j=0;j<NombreCaisses;j++)
	    {
	        if (listeCaseArrivee.get(j).getAbcisse()==x && listeCaseArrivee.get(j).getOrdonnee()==y)
	            return 2;
	    }


	    for (int j=0;j<NombreMurs;j++)
	    {
	        if (listeMur.get(j).getAbcisse()==x && listeMur.get(j).getOrdonnee()==y)
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
	                    if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
	                        return i;
	                }
	                break;

	        case 6: x=perso.getAbcisse()+perso.getLargeur();
	                y=perso.getOrdonnee();

	                for (int i=0;i<NombreCaisses;i++)
	                {
	                    if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
	                        return i;
	                }
	                break;
	        case 7: x=perso.getAbcisse();
	                y=perso.getOrdonnee()-perso.getHauteur();

	                for (int i=0;i<NombreCaisses;i++)
	                {
	                    if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
	                        return i;
	                }
	                break;
	         case 8:x=perso.getAbcisse();
	                y=perso.getOrdonnee()+perso.getHauteur();

	                for (int i=0;i<NombreCaisses;i++)
	                {
	                    if (listeCaisse.get(i).getAbcisse()==x && listeCaisse.get(i).getOrdonnee()==y)
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
	            listeCaisse.get(vc).deplacer(-listeCaisse.get(vc).getLargeur(),0);
	            listeCaisse.get(vc).setArrivee(false);
	            perso.deplacer(-perso.getLargeur(),0);
	        }
	        else if (VoisinCaisseGauche(vc)==2)
	        {
	            listeCaisse.get(vc).deplacer(-listeCaisse.get(vc).getLargeur(),0);
	            listeCaisse.get(vc).setArrivee(true);
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
	            listeCaisse.get(vc).deplacer(listeCaisse.get(vc).getLargeur(),0);
	            listeCaisse.get(vc).setArrivee(false);
	            perso.deplacer(perso.getLargeur(),0);
	        }
	        else if (VoisinCaisseDroite(vc)==2)
	        {
	            listeCaisse.get(vc).deplacer(listeCaisse.get(vc).getLargeur(),0);
	            listeCaisse.get(vc).setArrivee(true);
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
	            listeCaisse.get(vc).deplacer(0,-listeCaisse.get(vc).getHauteur());
	            listeCaisse.get(vc).setArrivee(false);
	            perso.deplacer(0,-perso.getHauteur());
	        }
	        else if (VoisinCaisseHaut(vc)==2)
	        {
	            listeCaisse.get(vc).deplacer(0,-listeCaisse.get(vc).getHauteur());
	            listeCaisse.get(vc).setArrivee(true);
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
	            listeCaisse.get(vc).deplacer(0,listeCaisse.get(vc).getHauteur());
	            listeCaisse.get(vc).setArrivee(false);
	            perso.deplacer(0,perso.getHauteur());
	        }
	        else if (VoisinCaisseBas(vc)==2)
	        {
	            listeCaisse.get(vc).deplacer(0,listeCaisse.get(vc).getHauteur());
	            listeCaisse.get(vc).setArrivee(true);
	            perso.deplacer(0,perso.getHauteur());
	            gagne=testerSiGagner();
	        }
	    }
	}

/**
 * fonction qui permet d'afficher le plateaua vec toute les cases
 * @param g
 */
	
	public void afficher(Graphics g){
		ImageIcon personnage = new ImageIcon("../policier.png");
		ImageIcon caisse = new ImageIcon("../prisonnier.png");
		ImageIcon mur = new ImageIcon("../mur.jpeg");
		ImageIcon arrivee = new ImageIcon("../cellule.png");
        
		g.drawImage(personnage.getImage(), perso.getAbcisse(),perso.getOrdonnee(),perso.getHauteur(),perso.getLargeur(),null);
        
		for (int i=0;i<NombreCaisses;i++){
			g.drawImage(caisse.getImage(), listeCaisse.get(i).getAbcisse(),listeCaisse.get(i).getOrdonnee(),listeCaisse.get(i).getHauteur(),listeCaisse.get(i).getLargeur(),null);
			g.drawImage(arrivee.getImage(), listeCaseArrivee.get(i).getAbcisse(),listeCaseArrivee.get(i).getOrdonnee(),listeCaseArrivee.get(i).getHauteur(),listeCaseArrivee.get(i).getLargeur(), null);
	    }
	    
		for (int l=0;l<NombreMurs;l++){
	    	g.drawImage(mur.getImage(), listeMur.get(l).getAbcisse(),listeMur.get(l).getOrdonnee(),listeMur.get(l).getHauteur(),listeMur.get(l).getLargeur(),null);
	    }
	}
	

	/**
	 * fonction qui permet d'afficher un message à la fin d'un niveau réussi
	 * @param g
	 */
	public void afficherGagner(Graphics g){
		ImageIcon fin = new ImageIcon("../bravo.png");
	    g.drawImage(fin.getImage(), 225,125,300,300,null);
	}
	
	
	/**
	 * fonction qui permet de savoir si le joueur a gagné ou pas
	 * @return boolean
	 */
	public boolean getGagne(){
	    return gagne;
	}
	
	
	/**
	 * fonction qui retourne le numero du niveau
	 * @return niveau
	 */
	public int getniveau() {
		return niveau;
	}
	
	public void setscore(int s) {
		score = score + s;
	}
	
	public int getscore() {
		return score;
	}
	
}
