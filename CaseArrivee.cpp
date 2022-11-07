#include "CaseArrivee.h"

/**
 * @brief CaseArrivee::CaseArrivee
 * @param aC
 * @param oC
 * @param h
 * @param l
 * @details constructeur par défaut
 */
CaseArrivee::CaseArrivee(int aC, int oC,int h, int l): Case(aC,oC,h,l)
{

}

/**
 * @brief CaseArrivee::~CaseArrivee
 */
CaseArrivee::~CaseArrivee()
{

}

/**
 * @brief CaseArrivee::getAbcisse
 * @return l'abscisse de la case arrivée
 */
int CaseArrivee::getAbcisse()
{
    return abcisseCase;
}

/**
 * @brief CaseArrivee::getOrdonnee
 * @return l'ordonnée de la case arrivée
 */
int CaseArrivee::getOrdonnee()
{
    return ordonneeCase;
}

/**
 * @brief CaseArrivee::getHauteur
 * @return la hauteur de la case arrivée
 */
int CaseArrivee::getHauteur()
{
    return hauteurCase;
}

/**
 * @brief CaseArrivee::getLargeur
 * @return la largeur de la case largeur
 */
int CaseArrivee::getLargeur()
{
    return largeurCase;
}

/**
 * @brief CaseArrivee::setCoordonneesCase
 * @param x
 * @param y
 */
void CaseArrivee::setCoordonneesCase(int x, int y)
{
    abcisseCase=x;
    ordonneeCase=y;

}
