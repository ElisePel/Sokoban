#ifndef PLATEAU_H
#define PLATEAU_H

#include <iostream>
#include <fstream>
using namespace std;
#include <QPainter>
#include <QDebug>
#include "Caisse.h"
#include "Personnage.h"
#include "Case.h"
#include "CaseArrivee.h"
#include "CaseMur.h"
#include <QFile>
#include <QTextStream>
#include <QString>


/**
 * @brief la classe Plateau
 */

class Plateau
{
public:
    Plateau();
    Plateau(QString nomfich);
    Plateau(const Plateau& p);
    Plateau& operator=(const Plateau& p);
    ~Plateau();
    void afficher(QPainter * p);
    bool testerSiGagner();
    int VoisinPersoGauche();
    int VoisinPersoDroite();
    int VoisinPersoHaut();
    int VoisinPersoBas();
    int VoisinCaisseGauche(int i);
    int VoisinCaisseDroite(int i);
    int VoisinCaisseHaut(int i);
    int VoisinCaisseBas(int i);
    int getNumCaisse(int d);
    void DeplacementGauche();
    void DeplacementDroite();
    void DeplacementHaut();
    void DeplacementBas();
    void afficherGagner(QPainter *p);
    bool getGagne();


protected:

    int NombreCaisses;
    int NombreElements;
    int NombreMurs;
    Caisse *listeCaisse;
    CaseArrivee *listeCaseArrivee;
    CaseMur *listeMur;
    Personnage perso;
    bool gagne=false;



};

#endif // PLATEAU_H
