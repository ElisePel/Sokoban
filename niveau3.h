#ifndef NIVEAU3_H
#define NIVEAU3_H

#include <QMainWindow>
#include <QDebug>
#include <QString>
#include <QScreen>
#include <QTextStream>
#include <QKeyEvent>
#include <QPainter>
#include <iostream>
#include <fstream>
#include "Plateau.h"
#include "aide.h"


namespace Ui {
class Niveau3;
}

class Niveau3 : public QMainWindow
{
    Q_OBJECT

public:
    explicit Niveau3(QWidget *parent = nullptr);
    ~Niveau3();

private slots:
    void on_Recommencer_clicked();

    void on_aide_clicked();





    void on_Menu_clicked();

private:
    Ui::Niveau3 *ui;
    Plateau *pl;
    void paintEvent(QPaintEvent* e);
    void keyPressEvent ( QKeyEvent * event );
};

#endif // NIVEAU3_H
