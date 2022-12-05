package code;

import java.util.Scanner; //lire un fichier
import java.awt.Graphics; 
import javax.swing.ImageIcon; //afficher une image
import java.util.ArrayList; // import the ArrayList class
import java.io.File;
import java.nio.file.Paths;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.InputStream;

import java.io.FileNotFoundException;

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
	protected int NombreCaisses = 1;
	protected int NombreElements = 2;
	protected int NombreMurs = 1;
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
<<<<<<< HEAD
=======
		

>>>>>>> 6e2f0e29166bcb369e5ec829dc3611c1f56a622a
	
	public Plateau(String nomfichier) {
		int type,a,o;
		//String f = nomfichier;
		//java.io.File fichier = new java.io.File(f);
		//File fichier = new File(nomfichier);
		try {
			//System.out.println(nomfichier);
			//InputStream fichier = new FileInputStream(nomfichier);
			
			//File f = File("../") + fichier;
			System.out.println(new File(nomfichier));
			System.out.println("test");
			//Scanner sc = new Scanner(Paths.get("../nv1.txt"));
			//Scanner sc = new Scanner(new File("C:\\Users\\moi\\Desktop\\5A\\java\\nv1.txt"));
			InputStream ins = new FileInputStream("../nv1.txt");
			Scanner sc = new Scanner(ins);
			
			System.out.println(new FileInputStream("C://Users//moi//Desktop//5A//java//nv1.txt"));
			while (sc.hasNext()){
				String n = sc.nextLine();
				System.out.println(n);
				NombreCaisses = Integer.parseInt(sc.nextLine());
				System.out.println(NombreCaisses);
	            NombreElements = sc.nextInt();
	            NombreMurs = sc.nextInt();

		            for (int j=0;j<NombreElements;j++){
		                type = sc.nextInt();
		                if (type==0){
		                    a = sc.nextInt();
		                    System.out.println(a);
		                    o = sc.nextInt();
		                    perso.setCoordonneesPerso(a,o);
		                }
		                else if (type==1){
		                    a = sc.nextInt();
		                    o = sc.nextInt();
		                    caisse.setCoordonnees(a, o);
		                    listeCaisse.add(caisse);
		                }
		                else if (type==2)
		                {
		                    a = sc.nextInt();
		                    o = sc.nextInt();
		                    casearrivee.setCoordonnees(a, o);
		                    listeCaseArrivee.add(casearrivee);
		                }
		                else if (type==3)
		                {
		                    a = sc.nextInt();
		                    o = sc.nextInt();
		                    casemur.setCoordonnees(a, o);
		                    listeMur.add(casemur);
		                }
		            }
		         }
				sc.close();
		}
		
	    catch (IOException e) {
	    	 System.out.println("Impossible d'ouvrir le fichier");
		}
	}
<<<<<<< HEAD


	
	
=======
>>>>>>> 6e2f0e29166bcb369e5ec829dc3611c1f56a622a
	
	
	
	/**
	 * Constructeur par dÃ©fault de la classe Plateau
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
	
	
	public void afficher(Graphics g){
		ImageIcon personnage = new ImageIcon("../policier.png");
		ImageIcon caisse = new ImageIcon("../prisonnier.png");
		ImageIcon mur = new ImageIcon("../mur.jpeg");
		ImageIcon arrivee = new ImageIcon("../prison.jpeg");
        
		//personnage = new ImageIcon("C:\\Users\\moi\\Desktop\\5A\\java\\prison.jpeg");
		personnage = new ImageIcon("../prisonnier.png");
		//g.drawImage(personnage.getImage(), 200,100,50,50,null);
		System.out.println(perso.getAbcisse());
		System.out.println(perso.getOrdonnee());
		System.out.println(perso.getHauteur());
		System.out.println(perso.getLargeur());
        g.drawImage(personnage.getImage(), perso.getAbcisse(),perso.getOrdonnee(),perso.getHauteur(),perso.getLargeur(),null);
	/*
	    for (int i=0;i<NombreCaisses;i++){
	       g.drawImage(caisse.getImage(), listeCaisse.get(i).getAbcisse(),listeCaisse.get(i).getOrdonnee(),listeCaisse.get(i).getHauteur(),listeCaisse.get(i).getLargeur(),null);
	       g.drawImage(arrivee.getImage(), listeCaseArrivee.get(i).getAbcisse(),listeCaseArrivee.get(i).getOrdonnee(),listeCaseArrivee.get(i).getHauteur(),listeCaseArrivee.get(i).getLargeur(), null);
	    }
	    
	    for (int l=0;l<NombreMurs;l++){
	    	g.drawImage(mur.getImage(), listeMur.get(l).getAbcisse(),listeMur.get(l).getOrdonnee(),listeMur.get(l).getHauteur(),listeMur.get(l).getLargeur(),null);
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
