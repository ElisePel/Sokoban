#ifndef PERSONNAGE_H
#define PERSONNAGE_H

/**
 * @brief la classe Personnage
 */

class Personnage
{
public:
    Personnage(int aP=0, int oP=0, int h=50, int l=50);
    ~Personnage();
    int getAbcisse();
    int getOrdonnee();
    int getHauteur();
    int getLargeur();
    void deplacer(int x, int y);
    void setCoordonneesPerso(int x, int y);



private:
    int abcissePersonnage;
    int ordonneePersonnage;
    int hauteurPersonnage;
    int largeurPersonnage;

};


#endif // PERSONNAGE_H
