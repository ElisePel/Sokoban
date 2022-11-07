#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QDebug>
#include <QString>
#include <QScreen>
#include <QTextStream>
#include <QMainWindow>
#include <QKeyEvent>
#include <QPainter>
#include <iostream>
#include <fstream>
#include "Plateau.h"
#include "aide.h"

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();


private slots:
    void on_Recommencer_clicked();

    void on_Aide_clicked();


    void on_Menu_clicked();

private:
    Ui::MainWindow *ui;
    Plateau *pl;
    void paintEvent(QPaintEvent* e);
    void keyPressEvent ( QKeyEvent * event );
};
#endif // MAINWINDOW_H
