#ifndef NIVEAU2_H
#define NIVEAU2_H

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
class Niveau2;
}

class Niveau2 : public QMainWindow
{
    Q_OBJECT

public:
    explicit Niveau2(QWidget *parent = nullptr);
    ~Niveau2();

private slots:
    void on_Recommencer_clicked();

    void on_Menu_clicked();

    void on_aide_clicked();

private:
    Ui::Niveau2 *ui;
    Plateau *pl;
    void paintEvent(QPaintEvent* e);
    void keyPressEvent ( QKeyEvent * event );
};

#endif // NIVEAU2_H
