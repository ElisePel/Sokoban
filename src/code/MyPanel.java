package code;

import java.awt.Graphics;
import javax.swing.JPanel;
@SuppressWarnings("serial")

class MyPanel extends JPanel {
 // Réference sur la fenêtre principale
 private MainWindow mainWindow;

 public MyPanel(MainWindow mWindow) {
	 mainWindow = mWindow;
 }

 /**
 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
 */
 @Override
 public void paintComponent(Graphics g) {
 super.paintComponent(g);
 // On appel la méthode dessiner de la fenêtre principale...
 mainWindow.dessiner(g);
 }
}