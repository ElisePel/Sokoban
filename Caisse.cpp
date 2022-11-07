#include "Caisse.h"

/**
 * @brief Caisse::Caisse
 * @param aC
 * @param oC
 * @param h
 * @param l
 * @details constructeur par défaut
 */
Caisse::Caisse(int aC, int oC,int h, int l)
{
    abcisseCaisse=aC;
    ordonneeCaisse=oC;
    hauteurCaisse=h;
    largeurCaisse=l;
    arrivee=false;
}

/**
 * @brief Caisse::~Caisse
 */
Caisse::~Caisse()
{

}

/**
 * @brief Caisse::getAbcisse
 * @return l'abscisse de la caisse
 */
int Caisse::getAbcisse()
{
    return abcisseCaisse;
}

/**
 * @brief Caisse::getOrdonnee
 * @return l'ordonnée de la caisse
 */
int Caisse::getOrdonnee()
{
    return ordonneeCaisse;
}

/**
 * @brief Caisse::deplacer
 * @param x
 * @param y
 */
void Caisse::deplacer(int x, int y)
{
    abcisseCaisse+=x;
    ordonneeCaisse+=y;
}

/**
 * @brief Caisse::getHauteur
 * @return la hauteur de la caisse
 */
int Caisse::getHauteur()
{
    return hauteurCaisse;
}

/**
 * @brief Caisse::getLargeur
 * @return la largeur de la caisse
 */
int Caisse::getLargeur()
{
    return largeurCaisse;
}

/**
 * @brief Caisse::setCoordonneesCaisse
 * @param x
 * @param y
 */
void Caisse::setCoordonneesCaisse(int x, int y)
{
    abcisseCaisse=x;
    ordonneeCaisse=y;

}

/**
 * @brief Caisse::setArrivee
 * @param a
 */
void Caisse::setArrivee(bool a)
{
    arrivee=a;
}

/**
 * @brief Caisse::getArrivee
 * @return true si la caisse est sur une case arrivée, false sinon
 */
bool Caisse::getArrivee()
{
    return arrivee;
}
