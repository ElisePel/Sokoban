package code;

import java.awt.Graphics;
import javax.swing.JPanel;
@SuppressWarnings("serial")

class MyPanelFin extends JPanel {
 // Réference sur la fenêtre principale
 
 private FenetreFin fin;
 
 public MyPanelFin(FenetreFin f) {
	 fin = f;
 }

 /**
 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
 */
 @Override
 public void paintComponent(Graphics g) {
 super.paintComponent(g);
 // On appel la méthode dessiner de la fenêtre principale...
 fin.dessiner(g);
 }
}