package code;

import java.awt.Graphics;
import javax.swing.JPanel;
@SuppressWarnings("serial")

class MyPanel extends JPanel {
 // Réference sur la fenêtre principale
 private MainWindow mainWindow;
 
<<<<<<< HEAD
 public MyPanel() {
	 
 }
=======
 
>>>>>>> 71a9eb4a70ca158b77e883388709fc0aa509a843

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