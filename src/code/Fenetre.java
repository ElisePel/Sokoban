package code;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Fenetre extends JFrame {

	private MyPanelF MyPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
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
	public Fenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);

		// On modifie le ContentPane
		MyPanel = new MyPanelF(this) ;
		MyPanel.setLayout(null);
		MyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setTitle("Sokoban");

		setContentPane(MyPanel);
		MyPanel.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(280, 100, 200, 30);
		MyPanel.add(editorPane);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Création de la boite en mémoire
				FenetreJouer JouerFenetre = new FenetreJouer(1);
	
					 // Affichage de la boite
				JouerFenetre.setVisible(true);
			}
		});
		btnValider.setBounds(300, 300, 150, 40);
		MyPanel.add(btnValider);
				
		JLabel texte = new JLabel("Entre ton pseudo ");
		texte.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		texte.setBounds(300, 17, 300, 40);
		MyPanel.add(texte);
	}

/**
* fonction dessiner qui permet l'affichage de notre jeu
* @param g
*/

public void dessiner(Graphics g){
	Graphics bufferGraphics;
	Image offscreen;
	ImageIcon debut = new ImageIcon("../SOKO-BAGNE-transparent.jpg");
	// On crée une image en mémoire de la taille du ContentPane
	offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	// On récupère l'objet de type Graphics permettant de dessiner dans cette image
	bufferGraphics = offscreen.getGraphics();
	
	bufferGraphics.drawImage(debut.getImage(), 0,0,750,550,null);
	
	// On afficher l'image mémoire à l'écran
	g.drawImage(offscreen,0,0,null);
}	

}




