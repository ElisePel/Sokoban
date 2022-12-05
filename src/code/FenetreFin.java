package code;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyEvent;

public class FenetreFin extends JFrame {


	private MyPanelFin myPanel;
	private Plateau plateau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreFin frame = new FenetreFin();
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
	public FenetreFin() {
		myPanel = new MyPanelFin(this) ;
		myPanel.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);

		// On modifie le ContentPane
		
		myPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		myPanel.setVisible(true);

		setTitle("Sokoban");
		
		this.setContentPane(myPanel);
	}
	
	public void dessiner(Graphics g){
		Graphics bufferGraphics;
		Image offscreen;
		
		ImageIcon fin = new ImageIcon("../end.png");
	    g.drawImage(fin.getImage(), 225,125,250,250,null);
	    
	 // On crée une image en mémoire de la taille du ContentPane
		 offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
		 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
		 bufferGraphics = offscreen.getGraphics();
		 
		 bufferGraphics.drawImage(fin.getImage(), 0,0,750,550,null);

		 JButton btnRecoJ = new JButton("Recommencer le jeu");
			btnRecoJ.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 FenetreJouer niveau1 = new FenetreJouer(1);
					//plateau = new Plateau(1);
					niveau1.setVisible(true);
				}
			});
			btnRecoJ.setBounds(10, 10, 200, 21);
			btnRecoJ.setFocusable(false);
			myPanel.add(btnRecoJ);
			this.setContentPane(myPanel);
			
		 // On afficher l'image mémoire à l'écran
		 g.drawImage(offscreen,0,0,null);
	 
	}
		

}




