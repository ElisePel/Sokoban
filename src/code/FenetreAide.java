package code;

import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAide extends JDialog {

	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog.
	 */
	public FenetreAide() {
		setBounds(250, 250, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 232);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String newLine = System.getProperty("line.separator");
		
		JLabel Texte1 = new JLabel("Les règles sont simples :");
		Texte1.setBounds(50, 50, 200, 15);
		getContentPane().add(Texte1);
		
		JLabel Texte2 = new JLabel("-Vous contrôlez un gardien de prison"
				);
		Texte2.setBounds(50, 80, 600, 15);
		getContentPane().add(Texte2);
		
		JLabel Texte3 = new JLabel(" et votre but est de ramener tous les prisonniers dans leur cellule."
				);
		Texte3.setBounds(50, 90, 600, 15);
		getContentPane().add(Texte3);
		
		JLabel Texte4 = new JLabel("-Pour effectuer votre mission, vous pourrez vous déplacer"
				);
		Texte4.setBounds(50, 120, 600, 15);
		getContentPane().add(Texte4);
		
		JLabel Texte5 = new JLabel("dans les 4 directions, le haut, le bas, la gauche "
				);
		Texte5.setBounds(50, 130, 600, 15);
		getContentPane().add(Texte5);
		
		JLabel Texte6 = new JLabel("et la droite grâce aux flèches directionnelles de votre clavier. "
				);
		Texte6.setBounds(50, 140, 600, 15);
		getContentPane().add(Texte6);
		
		JLabel Texte7 = new JLabel("Bon courage ! "
				);
		Texte7.setBounds(50, 170, 600, 15);
		getContentPane().add(Texte7);
		
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 436, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			

			
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
