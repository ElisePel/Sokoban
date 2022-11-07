#include "CaseMur.h"

/**
 * @brief CaseMur::CaseMur
 * @param aC
 * @param oC
 * @param h
 * @param l
 * @details constructeur par défaut
 */
CaseMur::CaseMur(int aC, int oC, int h, int l): Case(aC,oC,h,l)
{

}

/**
 * @brief CaseMur::~CaseMur
 */
CaseMur::~CaseMur()
{

}

/**
 * @brief CaseMur::getAbcisse
 * @return l(abscisse de la case mur
 */
int CaseMur::getAbcisse()
{
    return abcisseCase;
}

/**
 * @brief CaseMur::getOrdonnee
 * @return l'ordonnée de la case mur
 */
int CaseMur::getOrdonnee()
{
    return ordonneeCase;
}

/**
 * @brief CaseMur::getHauteur
 * @return la hauteur de la case mur
 */
int CaseMur::getHauteur()
{
    return hauteurCase;
}

/**
 * @brief CaseMur::getLargeur
 * @return la largeur de la case mur
 */
int CaseMur::getLargeur()
{
    return largeurCase;
}

/**
 * @brief CaseMur::setCoordonneesCase
 * @param x
 * @param y
 */
void CaseMur::setCoordonneesCase(int x, int y)
{
    abcisseCase=x;
    ordonneeCase=y;

}


