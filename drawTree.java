import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.util.ArrayList;


public class drawTree extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public drawTree(ArrayList<Personne> membreFamille) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 262);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(196, 37, 7, 21);
		panel.add(textPane);
		setVisible(true);
		
		for(int i = 0; i < membreFamille.size() ; i++) {
			System.out.print(membreFamille.get(i).prenom());

			if(membreFamille.get(i).aPere()) {
				System.out.println("a pour père : " + membreFamille.get(i).prenomPere());
			}
			if(membreFamille.get(i).aMere()) {
				System.out.println("a pour mère : " + membreFamille.get(i).prenomMere());
			}
			System.out.print("\n");
		}
	}


}
