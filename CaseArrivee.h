#ifndef CASEARRIVEE_H
#define CASEARRIVEE_H


/**
 * @brief CaseArrivee
 * @details classe dérivée de la classe Case
 */

#include "Case.h"



class CaseArrivee : public Case
{
public:
    CaseArrivee(int aC=0, int oC=0,int h=50, int l=50);
    int getAbcisse();
    int getOrdonnee();
    int getHauteur();
    int getLargeur();
    void setCoordonneesCase(int x, int y);
    ~CaseArrivee();




};

#endif // CASEARRIVEE_H
