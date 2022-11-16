package code;

import java.awt.EventQueue;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnJouer;
	private JButton btnNiveaux;
	private JButton btnAide;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Sokoban");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJouer = new JButton("Jouer");
		btnJouer.setBounds(30, 200, 70, 21);
		contentPane.add(btnJouer);
		
		JButton btnNiveaux = new JButton("Niveaux");
		btnNiveaux.setBounds(120, 200, 80, 21);
		contentPane.add(btnNiveaux);
		
		JButton btnAide = new JButton("Aide");
		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				private void menuItemAProposActionPerformed(java.awt.event.ActionEvent evt) {
	
					 // Création de la boite en mémoire
					 FenetreAide AideFenetre = new FenetreAide();
	
					 // Affichage de la boite
					 AideFenetre.setVisible(true);
				}
			}
		};
		btnAide.setBounds(220, 200, 70, 21);
		contentPane.add(btnAide);

	}

}
