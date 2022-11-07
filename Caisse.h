#ifndef CAISSE_H
#define CAISSE_H

/**
 * @brief la classe Caisse
 */


class Caisse
{
public:
    Caisse(int aC=0, int oC=0, int h=50, int l=50);
    ~Caisse();
    int getAbcisse();
    int getOrdonnee();
    int getHauteur();
    int getLargeur();
    void setArrivee(bool a);
    bool getArrivee();
    void setCoordonneesCaisse(int x, int y);
    void deplacer(int x, int y);



private:
    int abcisseCaisse;
    int ordonneeCaisse;
    int hauteurCaisse;
    int largeurCaisse;
    bool arrivee;

};
#endif
