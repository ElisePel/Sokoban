#include "Plateau.h"

/**
 * @brief Plateau::Plateau
 * @details constructeur par défaul de la case Plateau
 */
Plateau::Plateau()
{
    listeCaisse = new Caisse[NombreCaisses];
    listeCaseArrivee = new CaseArrivee[NombreCaisses];
    listeMur = new CaseMur[NombreElements-1-2*NombreCaisses];
}


/**
 * @brief Plateau::Plateau
 * @param nomfich : nom du fichier qui contient un niveau
 */
Plateau::Plateau(QString nomfich)
{
    int type,a,o,i=0,k=0,m=0;

    QFile fichier(nomfich);

     if(fichier.open(QIODevice::ReadOnly | QIODevice::Text))
     {
         QTextStream flux(&fichier);
         while (!flux.atEnd())
         {
            NombreCaisses = flux.readLine().toInt();
            NombreElements = flux.readLine().toInt();
            NombreMurs = flux.readLine().toInt();
            listeCaisse = new Caisse[NombreCaisses];
            listeCaseArrivee = new CaseArrivee[NombreCaisses];
            listeMur = new CaseMur[NombreMurs];
            qDebug() << NombreCaisses;

            for (int j=0;j<NombreElements;j++)
            {
                type = flux.readLine().toInt();
                if (type==0)
                {
                    a = flux.readLine().toInt();
                    o = flux.readLine().toInt();
                    perso.setCoordonneesPerso(a,o);
                }
                else if (type==1)
                {
                    qDebug() << "i = " <<i;
                    a = flux.readLine().toInt();
                    o = flux.readLine().toInt();
                    listeCaisse[i].setCoordonneesCaisse(a,o);
                    i++;
                }
                else if (type==2)
                {
                    a = flux.readLine().toInt();
                    o = flux.readLine().toInt();
                    listeCaseArrivee[k].setCoordonneesCase(a,o);
                    k++;
                }
                else if (type==3)
                {
                    a = flux.readLine().toInt();
                    o = flux.readLine().toInt();
                    listeMur[m].setCoordonneesCase(a,o);
                    m++;
                }
            }
         }
         fichier.close();
     }
     else
        cerr << "Impossible d'ouvrir le fichier !" << endl;
}

/**
 * @brief Plateau::~Plateau
 * @details destructeur de la classe Plateau
 */
Plateau::~Plateau()
{
    delete[] listeCaisse;
    delete[] listeCaseArrivee;
    delete[] listeMur;
}

/**
 * @brief Plateau::Plateau
 * @param p
 * @details constructeur de recopie de la classe Plateau
 */
Plateau::Plateau(const Plateau& p)
{
    NombreCaisses=p.NombreCaisses;
    NombreElements=p.NombreElements;
    NombreMurs=p.NombreMurs;
    listeCaisse = new Caisse();
    for (int i=0;i<NombreCaisses;i++)
    {
        listeCaisse[i]=p.listeCaisse[i];
    }
    listeMur = new CaseMur();
    for (int i=0;i<NombreMurs;i++)
    {
        listeMur[i]=p.listeMur[i];
    }
    listeCaseArrivee = new CaseArrivee();
    for (int i=0;i<NombreCaisses;i++)
    {
        listeCaseArrivee[i]=p.listeCaseArrivee[i];
    }
}

/**
 * @brief Plateau::operator =
 * @param p
 * @return une instance de la classe Plateau
 */
Plateau& Plateau::operator=(const Plateau& p)
{
    if (this != &p)
    {
        delete[] listeCaisse;
        NombreCaisses=p.NombreCaisses;
        NombreElements=p.NombreElements;
        NombreMurs=p.NombreMurs;
        listeCaisse = new Caisse();
        for (int i=0;i<NombreCaisses;i++)
        {
            listeCaisse[i]=p.listeCaisse[i];
        }
        listeMur = new CaseMur();
        for (int i=0;i<NombreMurs;i++)
        {
            listeMur[i]=p.listeMur[i];
        }
        listeCaseArrivee = new CaseArrivee();
        for (int i=0;i<NombreCaisses;i++)
        {
            listeCaseArrivee[i]=p.listeCaseArrivee[i];
        }
    }
 return *this;
}

/**
 * @brief Plateau::testerSiGagner
 * @return true si la partie est remportée, false sinon
 */

bool Plateau::testerSiGagner()
{
    bool b=true;
    int i=0;
    while (b==true and i<NombreCaisses)
    {
        if (listeCaisse[i].getArrivee()==false)
            b=false;
        i++;
    }
    return b;
}


void Plateau::afficher(QPainter * p)
{
    p->drawPixmap(perso.getAbcisse(),perso.getOrdonnee(),perso.getHauteur(),perso.getLargeur(),QPixmap(":/images/po"));
    for (int i=0;i<NombreCaisses;i++)
    {
       p->drawPixmap(listeCaisse[i].getAbcisse(),listeCaisse[i].getOrdonnee(),listeCaisse[i].getHauteur(),listeCaisse[i].getLargeur(),QPixmap(":/images/pr"));
       p->drawPixmap(listeCaseArrivee[i].getAbcisse(),listeCaseArrivee[i].getOrdonnee(),listeCaseArrivee[i].getHauteur(),listeCaseArrivee[i].getLargeur(),QPixmap(":/images/c"));
    }
    for (int l=0;l<NombreMurs;l++)
    {
       p->drawPixmap(listeMur[l].getAbcisse(),listeMur[l].getOrdonnee(),listeMur[l].getHauteur(),listeMur[l].getLargeur(),QPixmap(":/images/m"));
    }
}

void Plateau::afficherGagner(QPainter *p)
{
    p->drawPixmap(225,125,200,200,QPixmap(":/images/fin"));
}

bool Plateau::getGagne()
{
    return gagne;
}


/**
 * @brief Plateau::VoisinPersoGauche
 * @return le type du voisin gauche du personnage
 * @details le type est 1 pour une caisse, 2 pour une case d'arrivée, 3 pour un mur et 4 pour une case vide
 */
int Plateau::VoisinPersoGauche()
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

int Plateau::VoisinPersoDroite()
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
int Plateau::VoisinPersoHaut()
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
int Plateau::VoisinPersoBas()
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

int Plateau::VoisinCaisseGauche(int i)
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
int Plateau::VoisinCaisseDroite(int i)
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
int Plateau::VoisinCaisseHaut(int i)
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
int Plateau::VoisinCaisseBas(int i)
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
int Plateau::getNumCaisse(int d)
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
void Plateau::DeplacementGauche()
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
void Plateau::DeplacementDroite()
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
void Plateau::DeplacementHaut()
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
void Plateau::DeplacementBas()
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

