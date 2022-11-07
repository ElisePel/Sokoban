#include "niveau3.h"
#include "ui_niveau3.h"

/**
 * @brief Niveau3::Niveau3
 * @param parent
 */
Niveau3::Niveau3(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Niveau3)
{
    ui->setupUi(this);

    setFixedSize(750,600);
    setWindowTitle("Niveau 3");
    move(QGuiApplication::screens().at(0)->geometry().center()-frameGeometry().center());

    pl=new Plateau(":/niveaux/n3");
}

/**
 * @brief Niveau3::~Niveau3
 */
Niveau3::~Niveau3()
{
    delete ui;
}

/**
 * @brief Niveau3::paintEvent
 * @param e
 */
void Niveau3::paintEvent(QPaintEvent* e)
{
    QWidget::paintEvent(e);
    QPainter painter(this);

    if (pl!=NULL and pl->getGagne()==false)
        pl->afficher(&painter);
    else if (pl->getGagne()==true)
        pl->afficherGagner(&painter);


}

/**
 * @brief Niveau3::keyPressEvent
 * @param event
 */
void Niveau3::keyPressEvent ( QKeyEvent * event ) {
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
 * @brief Niveau3::on_Recommencer_clicked
 */
void Niveau3::on_Recommencer_clicked()
{
    pl=new Plateau(":/niveaux/n3");
    this->repaint();
}

/**
 * @brief Niveau3::on_aide_clicked
 */
void Niveau3::on_aide_clicked()
{
    Aide f(this);
    f.exec();
}

/**
 * @brief Niveau3::on_Menu_clicked
 */
void Niveau3::on_Menu_clicked()
{
    this->close();
}
