#include "mainwindow.h"
#include "ui_mainwindow.h"

/**
 * @brief MainWindow::MainWindow
 * @param parent
 */
MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    setFixedSize(750,550);
    setWindowTitle("Niveau 1");
    move(QGuiApplication::screens().at(0)->geometry().center()-frameGeometry().center());

    pl=new Plateau(":/niveaux/n1");

}

/**
 * @brief MainWindow::~MainWindow
 */
MainWindow::~MainWindow()
{
    delete ui;
    delete pl;
}

/**
 * @brief MainWindow::paintEvent
 * @param e
 */
void MainWindow::paintEvent(QPaintEvent* e)
{
    QWidget::paintEvent(e);
    QPainter painter(this);

    if (pl!=NULL and pl->getGagne()==false)
        pl->afficher(&painter);
    else if (pl->getGagne()==true)
        pl->afficherGagner(&painter);
}

/**
 * @brief MainWindow::keyPressEvent
 * @param event
 */
void MainWindow::keyPressEvent ( QKeyEvent * event ) {
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
 * @brief MainWindow::on_Recommencer_clicked
 */
void MainWindow::on_Recommencer_clicked()
{
    pl=new Plateau(":/niveaux/n1");
    this->repaint();
}

/**
 * @brief MainWindow::on_Aide_clicked
 */
void MainWindow::on_Aide_clicked()
{
    Aide f(this);
    f.exec();
}

/**
 * @brief MainWindow::on_Menu_clicked
 */
void MainWindow::on_Menu_clicked()
{
    this->close();
}
