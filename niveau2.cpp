#include "niveau2.h"
#include "ui_niveau2.h"

/**
 * @brief Niveau2::Niveau2
 * @param parent
 */
Niveau2::Niveau2(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Niveau2)
{
    ui->setupUi(this);

    setFixedSize(750,600);
    setWindowTitle("Niveau 2");
    move(QGuiApplication::screens().at(0)->geometry().center()-frameGeometry().center());

    pl=new Plateau(":/niveaux/n2");
}

/**
 * @brief Niveau2::~Niveau2
 */
Niveau2::~Niveau2()
{
    delete ui;
}

/**
 * @brief Niveau2::paintEvent
 * @param e
 */
void Niveau2::paintEvent(QPaintEvent* e)
{
    QWidget::paintEvent(e);
    QPainter painter(this);

    if (pl!=NULL and pl->getGagne()==false)
        pl->afficher(&painter);
    else if (pl->getGagne()==true)
        pl->afficherGagner(&painter);


}

/**
 * @brief Niveau2::keyPressEvent
 * @param event
 */
void Niveau2::keyPressEvent ( QKeyEvent * event ) {
    switch(event->key())
    {
        case Qt::Key_Left : pl->DeplacementGauche();
                            break;
        case Qt::Key_Right :pl->DeplacementDroite();
                             break;
        case Qt::Key_Up :pl->DeplacementHaut();
                            break;
        case Qt::Key_Down :pl->DeplacementBas();
                          break;
    }
    this->repaint();
}

/**
 * @brief Niveau2::on_Recommencer_clicked
 */
void Niveau2::on_Recommencer_clicked()
{
    pl=new Plateau(":/niveaux/n2");
    this->repaint();
}

/**
 * @brief Niveau2::on_Menu_clicked
 */
void Niveau2::on_Menu_clicked()
{
    this->close();
}

/**
 * @brief Niveau2::on_aide_clicked
 */
void Niveau2::on_aide_clicked()
{
    Aide f(this);
    f.exec();
}
