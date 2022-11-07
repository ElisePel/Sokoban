#include "Personnage.h"

/**
 * @brief Personnage::Personnage
 * @param aP abscisse du personnage
 * @param oP ordonnée du personnage
 * @param h hauteur du personnage
 * @param l largeur du personnage
 * @details constructeur par défaut
 */
Personnage::Personnage(int aP, int oP,int h, int l)
{
    abcissePersonnage=aP;
    ordonneePersonnage=oP;
    hauteurPersonnage=h;
    largeurPersonnage=l;
}

/**
 * @brief Personnage::~Personnage
 * @details destructeur
 */
Personnage::~Personnage()
{

}

/**
 * @brief Personnage::getAbcisse
 * @return l'abscisse du personnage
 */
int Personnage::getAbcisse()
{
    return abcissePersonnage;
}

/**
 * @brief Personnage::getOrdonnee
 * @return l'ordonnée du personnage
 */
int Personnage::getOrdonnee()
{
    return ordonneePersonnage;
}

/**
 * @brief Personnage::deplacer
 * @param x
 * @param y
 */
void Personnage::deplacer(int x, int y)
{
    abcissePersonnage+=x;
    ordonneePersonnage+=y;
}

/**
 * @brief Personnage::getHauteur
 * @return la hauteur du personnage
 */
int Personnage::getHauteur()
{
    return hauteurPersonnage;
}

/**
 * @brief Personnage::getLargeur
 * @return la largeur du personnage
 */
int Personnage::getLargeur()
{
    return largeurPersonnage;
}

/**
 * @brief Personnage::setCoordonneesPerso
 * @param x
 * @param y
 * @details met à jour les coordonnées du personnage
 */
void Personnage::setCoordonneesPerso(int x, int y)
{
    abcissePersonnage=x;
    ordonneePersonnage=y;

}
