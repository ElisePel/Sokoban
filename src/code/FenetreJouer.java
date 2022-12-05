package code;

import java.awt.EventQueue;


import javax.swing.JButton;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Color;
//import java.awt.Point;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FenetreJouer extends JFrame {


	private MyPanelJouer myPanel;
	private Plateau plateau;
	private Personnage perso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreJouer frame = new FenetreJouer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreJouer() {
		plateau = new Plateau("../nv1.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// On modifie le ContentPane
		myPanel = new MyPanelJouer(this) ;
		myPanel.setLayout(null);
		myPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		myPanel.setVisible(true);

		//...
		setTitle("Sokoban");
		
		this.setContentPane(myPanel);
	}
	
	public void dessiner(Graphics g)
	{
	 Graphics bufferGraphics;
	 Image offscreen;
	 // On crée une image en mémoire de la taille du ContentPane
	 offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
	 bufferGraphics = offscreen.getGraphics();
	 // On colore le fond de l'image en blanc
	// bufferGraphics.setColor(Color.GRAY);
	 //bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight());

	 // On dessine les objets graphiques de la liste dans l'image en mémoire pour éviter les
	 // problèmes de scintillements
	 
	 //if (listeObjets != null)
	 //for (CObjetGraphique o : listeObjets)
	 //o.dessiner(bufferGraphics);
	// bufferGraphics.setColor(Color.RED);
	// bufferGraphics.fillRect(0,0,50,50);
	 
	 //if (plateau!=null & plateau.getGagne()==false) {


	 
	 plateau.afficher(bufferGraphics);

		 /*plateau.afficher(bufferGraphics);
	//	 plateau.afficher(bufferGraphics);
	 /*}
	 else if (plateau.getGagne()==true){
		 plateau.afficherGagner(bufferGraphics);
	}*/
	 
	// plateau.afficher(bufferGraphics);
	 
	 // On afficher l'image mémoire à l'écran
	 g.drawImage(offscreen,0,0,null);
	 
	}

}
