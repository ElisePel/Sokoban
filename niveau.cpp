#include "niveau.h"
#include "ui_niveau.h"

/**
 * @brief Niveau::Niveau
 * @param parent
 */
Niveau::Niveau(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Niveau)
{
    ui->setupUi(this);
    setWindowTitle("Niveaux");
}

/**
 * @brief Niveau::~Niveau
 */
Niveau::~Niveau()
{
    delete ui;
}

/**
 * @brief Niveau::on_niv1_clicked
 */
void Niveau::on_niv1_clicked()
{
    m=new MainWindow;
    m->show();
    this->close();
}

/**
 * @brief Niveau::on_niv3_clicked
 */
void Niveau::on_niv3_clicked()
{
    n3=new Niveau3;
    n3->show();
    this->close();
}

/**
 * @brief Niveau::on_niv2_clicked
 */
void Niveau::on_niv2_clicked()
{
    n2=new Niveau2;
    n2->show();
    this->close();
}

/**
 * @brief Niveau::on_niv4_clicked
 */
void Niveau::on_niv4_clicked()
{
    n4=new Niveau4;
    n4->show();
    this->close();
}
