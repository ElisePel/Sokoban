#ifndef DEBUT_H
#define DEBUT_H

#include <QMainWindow>
#include "aide.h"
#include "niveau.h"

QT_BEGIN_NAMESPACE
namespace Ui { class Debut; }
QT_END_NAMESPACE

class Debut : public QMainWindow
{
    Q_OBJECT

public:
    Debut(QWidget *parent = nullptr);
    ~Debut();

private slots:
    void on_Jouer_clicked();

    void on_Quitter_clicked();

    void on_Aide_clicked();


private:
    Ui::Debut *ui;
    MainWindow *m;
    void paintEvent(QPaintEvent* e);

};
#endif // DEBUT_H
