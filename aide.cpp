#include "aide.h"
#include "ui_aide.h"

/**
 * @brief Aide::Aide
 * @param parent
 */
Aide::Aide(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Aide)
{
    ui->setupUi(this);
    setWindowTitle("Aide");
}

/**
 * @brief Aide::~Aide
 */
Aide::~Aide()
{
    delete ui;
}

/**
 * @brief Aide::on_Quitter_clicked
 */
void Aide::on_Quitter_clicked()
{
    close();
}
