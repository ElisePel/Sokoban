package code;

import java.awt.EventQueue;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;



public class MainWindow extends JFrame {

	private MyPanel MyPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);

		// On modifie le ContentPane
		MyPanel = new MyPanel(this) ;
		MyPanel.setLayout(null);
		MyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setTitle("Sokoban");

		
		JButton btnJouer = new JButton("Jouer");
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					 // Création de la boite en mémoire
				FenetreJouer FenetreJ = new FenetreJouer(1);
	
					 // Affichage de la boite
				FenetreJ.setVisible(true);
			}
		});
		
		btnJouer.setBounds(30, 430, 70, 21);
		MyPanel.add(btnJouer);
		
		//ajout d'un bouton aide
		JButton btnAide = new JButton("Aide");
		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					 // Création de la boite en mémoire
					 FenetreAide AideFenetre = new FenetreAide();
	
					 // Affichage de la boite
					 AideFenetre.setVisible(true);
			}
		});

		btnAide.setBounds(610, 430, 70, 21);
		MyPanel.add(btnAide);
		this.setContentPane(MyPanel);

	}
	
/**
 * fonction dessiner qui permet l'affichage de notre jeu
 * @param g
 */
	
	public void dessiner(Graphics g){
	 Graphics bufferGraphics;
	 Image offscreen;
	 ImageIcon debut = new ImageIcon("../SOKO-BAGNE.jpg");
	 // On crée une image en mémoire de la taille du ContentPane
	 offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
	 bufferGraphics = offscreen.getGraphics();
	 
	 bufferGraphics.drawImage(debut.getImage(), 0,0,750,550,null);

	 // On afficher l'image mémoire à l'écran
	 g.drawImage(offscreen,0,0,null);
	 
	}	
	
}
