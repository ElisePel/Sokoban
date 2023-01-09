package code;
/**
 * permet d'instancier la fenêtre aide
 * @author Claire Mezieres et Elise Pellegry
 */
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class FenetreJouer extends JFrame {


	private MyPanelJouer myPanel;
	private Plateau plateau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreJouer frame = new FenetreJouer(0);
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
	public FenetreJouer(int niv) {
		myPanel = new MyPanelJouer(this) ;
		myPanel.setLayout(null);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				myKeyPressEvent(e);
			}
		});
		
		//on crée le plateau en fonction d'une niveau demandé
		plateau = new Plateau(niv);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);

		// On modifie le ContentPane
		myPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		myPanel.setVisible(true);

		setTitle("Sokoban");
		
		//creation d'un bouton pour revenir on menu principal
		JButton btnMenu = new JButton("Menu Principal");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Création de la boite en mémoire
				MainWindow main = new MainWindow();
	
					 // Affichage de la boite
				main.setVisible(true);
			}
		});
		btnMenu.setBounds(500, 20, 130, 21);
		btnMenu.setFocusable(false);
		myPanel.add(btnMenu);
		
		this.setContentPane(myPanel);
	}
	
	/**
	 * fonction qui affiche qui une fenetre 
	 * @param g
	 */
	public void dessiner(Graphics g){
	 Graphics bufferGraphics;
	 Image offscreen;
	 // On crée une image en mémoire de la taille du ContentPane
	 offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
	 // On récupère l'objet de type Graphics permettant de dessiner dans cette image
	 bufferGraphics = offscreen.getGraphics();

	 //on a plusieurs cas, si l'utilisateur ne gagne pas encore
	 if (plateau.getGagne()==false) {
		 plateau.afficher(bufferGraphics);
		 //l'utilisateur peut recommencer s'il est bloqué
		 JButton btnReco = new JButton("Recommencer");
			btnReco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//ça remet le plateau
					plateau = new Plateau(plateau.getniveau());
					btnReco.setVisible(true);
				}
			});
			btnReco.setBounds(30, 430, 150, 21);
			btnReco.setFocusable(false);
			myPanel.add(btnReco);
			this.setContentPane(myPanel);
	 }

	 //si l'utilisateur termine le niveau 1, il peut passer au niveau suivant ou rejouer 
	 else if (plateau.getGagne()==true & plateau.getniveau() == 1){
		 plateau.afficherGagner(bufferGraphics);
		 JButton btnsuivant = new JButton("Niveau suivant");
		 btnsuivant.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 // Création de la boite en mémoire
				 FenetreJouer niveau2 = new FenetreJouer(2);
				 // Affichage de la boite
				 niveau2.setVisible(true);
			 }
			});
		
		btnsuivant.setBounds(510, 430, 200, 21);
		btnsuivant.setFocusable(false);
		myPanel.add(btnsuivant);
		this.setContentPane(myPanel);
	}
	 
	 //s'il termine le niveau 2, alors la dernière fenetre s'affiche : fenetre de fin du jeu
	 else if(plateau.getGagne()==true && plateau.getniveau() == 2){
		 Fenetre fin = new Fenetre();
		 // Affichage de la boite
		 fin.setVisible(true);
	 }
	 
	 // On afficher l'image mémoire à l'écran
	 g.drawImage(offscreen,0,0,null);
	 
	}
	
	/**
	 * fonction qui permet de recuperer les informations des touches du clavier pour le déplacement des objets
	 * @param e
	 */
	private void myKeyPressEvent(KeyEvent e) {
	switch(e.getKeyCode()) {
		case (KeyEvent.VK_RIGHT ) :
			plateau.DeplacementDroite();
		break;
		case (KeyEvent.VK_LEFT):
			plateau.DeplacementGauche();
		break;
		case (KeyEvent.VK_UP ) :
			plateau.DeplacementHaut();
		break;
		case (KeyEvent.VK_DOWN):
			plateau.DeplacementBas();
		break;
	}
	dessiner(this.getContentPane().getGraphics());

	}
	

}
