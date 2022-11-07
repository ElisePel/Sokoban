#ifndef CASEMUR_H
#define CASEMUR_H



#include "Case.h"

/**
 * @brief la classe CaseMur
 * @details classe dérivée de la classe Case
 */

class CaseMur : public Case
{
public:
    CaseMur(int aC=0, int oC=0, int h=50, int l=50);
    ~CaseMur();
    int getAbcisse();
    int getOrdonnee();
    int getHauteur();
    int getLargeur();
    void setCoordonneesCase(int x, int y);


};

#endif // CASEMUR_H
