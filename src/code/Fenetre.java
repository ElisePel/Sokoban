package code;

/**
 * permet d'instancier la fenêtre pour enregistrer son pseudo
 * @author Claire Mezieres et Elise Pellegry
 */

/**
 * bibliothèques
 */
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		
		//zone qui permet à l'utilisateur de saisir son nom
		JLabel texte = new JLabel("Entre ton pseudo ");
		texte.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		texte.setBounds(300, 17, 300, 40);
		MyPanel.add(texte);
		
		JTextField pseudo = new JTextField();
		pseudo.setBounds(280, 100, 200, 30);
		MyPanel.add(pseudo);
		
		//création d'un bouton valider 
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Création de la boite en mémoire
				java.sql.Connection connecteur = null;
		        try
		        {   
		        	//on crée le connecteur à la base de données
		        	connecteur = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sokoban","root","root");
		        	//création d'un statement 
		            Statement st = connecteur.createStatement();
		            
		            //on vérifie si le pseudo saisie est dans la base de données
		            PreparedStatement pst = connecteur.prepareStatement("select Pseudo from Table_Score where Pseudo = ? ");
		            pst.setString(1, pseudo.getText());
		            ResultSet resultSet = pst.executeQuery();
		            if(resultSet.next()){
		                 // si le pseudo existe on modifie le score
		            	st.executeUpdate("UPDATE Table_Score SET Score = Score + 2 WHERE Pseudo ='" + pseudo.getText() + "'" );
		            	
		            }
		            else{
		                // si le pseudo n'existe pas on ajoute un nouvel individu avec son pseudo et son score
		            	st.executeUpdate("INSERT INTO Table_Score (Pseudo,Score) VALUES('" + pseudo.getText() + "',2)");
		            }
		            //on ferme le connecteur
		            connecteur.close();
		        }
		        catch(SQLException e2)
		        {
			       System.out.println(e2);
			    }
				FenetreFin Fenetre = new FenetreFin();
	
					 // Affichage de la boite
				Fenetre.setVisible(true);
			}
		});
		btnValider.setBounds(300, 300, 150, 40);
		MyPanel.add(btnValider);
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




