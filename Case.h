#ifndef CASE_H
#define CASE_H

/**
 * @brief la classe Case
 */

class Case
{
public:
    Case(int aC=0, int oC=0, int h=50, int l=50);
    virtual int getAbcisse()=0;
    virtual int getOrdonnee()=0;
    virtual int getHauteur()=0;
    virtual int getLargeur()=0;
    virtual void setCoordonneesCase(int x, int y)=0;
    ~Case();


protected:
    int abcisseCase;
    int ordonneeCase;
    int largeurCase;
    int hauteurCase;

};

#endif // CASE_H
