#ifndef NIVEAU_H
#define NIVEAU_H

#include <QDialog>
#include "mainwindow.h"
#include "niveau3.h"
#include "niveau2.h"
#include "niveau4.h"

namespace Ui {
class Niveau;
}

class Niveau : public QDialog
{
    Q_OBJECT

public:
    explicit Niveau(QWidget *parent = nullptr);
    ~Niveau();

private slots:
    void on_niv1_clicked();

    void on_niv3_clicked();

    void on_niv2_clicked();

    void on_niv4_clicked();

private:
    Ui::Niveau *ui;
    MainWindow *m;
    Niveau3 *n3;
    Niveau2 *n2;
    Niveau4 *n4;
};

#endif // NIVEAU_H
