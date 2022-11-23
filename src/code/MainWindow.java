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


public class MainWindow extends JFrame {

	private MyPanel myPanel;
	private JButton btnJouer;
	private JButton btnNiveaux;
	private JButton btnAide;
	private Plateau plateau;
	private Personnage perso;

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
		setBounds(100, 100, 450, 300);

		// On modifie le ContentPane
		myPanel = new MyPanel(this) ;
		myPanel.setLayout(null);
		myPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		//...
		setTitle("Sokoban");

		
		JButton btnJouer = new JButton("Jouer");
		btnJouer.setBounds(30, 200, 70, 21);
		myPanel.add(btnJouer);
		
		JButton btnNiveaux = new JButton("Niveaux");
		btnNiveaux.setBounds(120, 200, 80, 21);
		myPanel.add(btnNiveaux);
		
		JButton btnAide = new JButton("Aide");
		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					 // Création de la boite en mémoire
					 FenetreAide AideFenetre = new FenetreAide();
	
					 // Affichage de la boite
					 AideFenetre.setVisible(true);
			}
		});

		btnAide.setBounds(220, 200, 70, 21);
		myPanel.add(btnAide);
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
	 bufferGraphics.setColor(Color.GRAY);
	 bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),this.getContentPane().getHeight());

	 // On dessine les objets graphiques de la liste dans l'image en mémoire pour éviter les
	 // problèmes de scintillements
	 
	 //if (listeObjets != null)
	 //for (CObjetGraphique o : listeObjets)
	 //o.dessiner(bufferGraphics);
	 bufferGraphics.setColor(Color.RED);
	 bufferGraphics.fillRect(0,0,50,50);
	 
	 //if (plateau!=null & plateau.getGagne()==false) {
		 plateau.afficher(bufferGraphics);
	 /*}
	 else if (plateau.getGagne()==true){
		 plateau.afficherGagner(bufferGraphics);
	}*/
	 
	// plateau.afficher(bufferGraphics);
	 
	 // On afficher l'image mémoire à l'écran
	 g.drawImage(offscreen,0,0,null);
	 
	 
	}

	    
	
	private void keyPressEvent(java.awt.event.KeyEvent e) {
		switch(e.getKeyCode()) {
			case (KeyEvent.VK_RIGHT ) :
				plateau.DeplacementDroite();
			case (KeyEvent.VK_LEFT):
				plateau.DeplacementGauche();
			case (KeyEvent.VK_UP ) :
				plateau.DeplacementHaut();
			case (KeyEvent.VK_DOWN):
				plateau.DeplacementBas();
		}
		dessiner(this.getContentPane().getGraphics());
	}
	
	
	
}
