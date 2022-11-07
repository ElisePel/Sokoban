#include "debut.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    Debut w;
    w.show();
    return a.exec();
}
