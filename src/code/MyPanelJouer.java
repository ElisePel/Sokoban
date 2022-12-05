package code;

import java.awt.Graphics;
import javax.swing.JPanel;
@SuppressWarnings("serial")

class MyPanelJouer extends JPanel {
 // Réference sur la fenêtre principale
 
 private FenetreJouer jouer;
 


 
 public MyPanelJouer(FenetreJouer J) {
	 jouer = J;
 }

 /**
 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
 */
 @Override
 public void paintComponent(Graphics g) {
 super.paintComponent(g);
 // On appel la méthode dessiner de la fenêtre principale...
 jouer.dessiner(g);
 }
}
