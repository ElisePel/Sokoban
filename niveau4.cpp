#include "niveau4.h"
#include "ui_niveau4.h"

/**
 * @brief Niveau4::Niveau4
 * @param parent
 */
Niveau4::Niveau4(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Niveau4)
{
    ui->setupUi(this);

    setFixedSize(750,550);
    setWindowTitle("Niveau 4");
    move(QGuiApplication::screens().at(0)->geometry().center()-frameGeometry().center());

    pl=new Plateau(":/niveaux/n4");
}

/**
 * @brief Niveau4::~Niveau4
 */
Niveau4::~Niveau4()
{
    delete ui;
}

/**
 * @brief Niveau4::paintEvent
 * @param e
 */
void Niveau4::paintEvent(QPaintEvent* e)
{
    QWidget::paintEvent(e);
    QPainter painter(this);

    if (pl!=NULL and pl->getGagne()==false)
        pl->afficher(&painter);
    else if (pl->getGagne()==true)
        pl->afficherGagner(&painter);


}

/**
 * @brief Niveau4::keyPressEvent
 * @param event
 */
void Niveau4::keyPressEvent ( QKeyEvent * event ) {
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
 * @brief Niveau4::on_Recommencer_clicked
 */
void Niveau4::on_Recommencer_clicked()
{
    pl=new Plateau(":/niveaux/n4");
    this->repaint();
}

/**
 * @brief Niveau4::on_Menu_clicked
 */
void Niveau4::on_Menu_clicked()
{
    this->close();
}

/**
 * @brief Niveau4::on_aide_clicked
 */
void Niveau4::on_aide_clicked()
{
    Aide f(this);
    f.exec();
}
