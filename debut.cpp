#include "debut.h"
#include "ui_debut.h"
#include <QScreen>

/**
 * @brief Debut::Debut
 * @param parent
 */
Debut::Debut(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::Debut)
{
    ui->setupUi(this);
    setFixedSize(750,500);
    setWindowTitle("Soko-bagne");
    move(QGuiApplication::screens().at(0)->geometry().center()-frameGeometry().center());
}

/**
 * @brief Debut::~Debut
 */
Debut::~Debut()
{
    delete ui;
}

/**
 * @brief Debut::paintEvent
 * @param e
 */
void Debut::paintEvent(QPaintEvent* e)
{
    QWidget::paintEvent(e);
    QPainter painter(this);

    painter.drawPixmap(0,0,750,500,QPixmap(":/images/deb"));
}

/**
 * @brief Debut::on_Jouer_clicked
 */
void Debut::on_Jouer_clicked()
{
    Niveau f(this);
    f.exec();
}

/**
 * @brief Debut::on_Quitter_clicked
 */
void Debut::on_Quitter_clicked()
{
    close();
}

/**
 * @brief Debut::on_Aide_clicked
 */
void Debut::on_Aide_clicked()
{
    Aide f(this);
    f.exec();
}

