#ifndef NIVEAU4_H
#define NIVEAU4_H

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
class Niveau4;
}

class Niveau4 : public QMainWindow
{
    Q_OBJECT

public:
    explicit Niveau4(QWidget *parent = nullptr);
    ~Niveau4();

private slots:
    void on_Recommencer_clicked();

    void on_Menu_clicked();

    void on_aide_clicked();

private:
    Ui::Niveau4 *ui;
    Plateau *pl;
    void paintEvent(QPaintEvent* e);
    void keyPressEvent ( QKeyEvent * event );
};

#endif // NIVEAU4_H
