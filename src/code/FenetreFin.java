package code;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Image;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class FenetreFin extends JFrame {


	private MyPanelFin myPanel;

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
		
		ArrayList<String> listepseudo = new ArrayList<String>();
		ArrayList<String> listescore = new ArrayList<String>();
		
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
		
		
		java.sql.Connection connecteur = null;
        try
        {           
        	connecteur = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sokoban","root","root");
            Statement st = connecteur.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Table_Score ORDER BY Score DESC");
            while(rs.next())
            {
            	listepseudo.add(rs.getString("Pseudo"));
            	listescore.add(rs.getString("Score"));
            }
            connecteur.close();
        }
        catch(SQLException e)
        {
	       System.out.println(e);
	    }
	
		
		JLabel t = new JLabel("Classement des scores");
		t.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 35));
		t.setBounds(200, 250, 500, 50);
		myPanel.add(t);
		
		JLabel t1 = new JLabel(listepseudo.get(0));
		t1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		t1.setBounds(150, 320, 300, 40);
		myPanel.add(t1);
		
		JLabel ts1 = new JLabel(listescore.get(0));
		ts1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		ts1.setBounds(450, 320, 300, 40);
		myPanel.add(ts1);
		
		if( listepseudo.size() > 1) {
			JLabel t2 = new JLabel(listepseudo.get(1));
			t2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
			t2.setBounds(150, 360, 300, 40);
			myPanel.add(t2);
			
			JLabel ts2 = new JLabel(listescore.get(1));
			ts2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
			ts2.setBounds(450, 360, 300, 40);
			myPanel.add(ts2);
		}
		
		if( listepseudo.size() > 2){
			JLabel t3 = new JLabel(listepseudo.get(2));
			t3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
			t3.setBounds(150, 400, 300, 40);
			myPanel.add(t3);
			
			JLabel ts3 = new JLabel(listescore.get(2));
			ts3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
			ts3.setBounds(450, 400, 300, 40);
			myPanel.add(ts3);
		}
		
		
		
		this.setContentPane(myPanel);
		
		
			
		 // On afficher l'image mémoire à l'écran
		 g.drawImage(offscreen,0,0,null);
	 
	}
		

}




