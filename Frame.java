import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import java.awt.GridLayout;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 535901415425739541L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtYy;
	private drawTree secondFrame;
	private JTextField txtDd;
	private JTextField txtMm;
	private String dateN;
	private JButton btnAjouterFils;
	private JButton btnAjouter;
	private JButton btnSupprimerPersonne;
	private drawTree frame;

	private List<String> prenomMembreFamille = new ArrayList<String>();
	public ArrayList<Personne> membreFamille = new ArrayList<Personne>();
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Frame() {
		
		setUndecorated(true);
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setTitle("ARBRE GÉNÉALOGIQUE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 625);

		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 830, 124);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		txtNom = new JTextField();
		txtNom.setFont(new Font("Arial", Font.BOLD, 12));
		txtNom.setBounds(303, 30, 153, 24);
		panel.add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Arial", Font.BOLD, 12));
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(138, 30, 153, 24);
		panel.add(txtPrenom);

		btnAjouter = new JButton("AJOUTER");
		btnAjouter.setBackground(new Color(83, 241, 51));
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBounds(687, 18, 123, 36);
		btnAjouter.setBorderPainted(false);
		panel.add(btnAjouter);

		txtYy = new JTextField();
		txtYy.setFont(new Font("Arial", Font.BOLD, 12));
		txtYy.setToolTipText("");
		txtYy.setBounds(602, 30, 57, 24);
		panel.add(txtYy);
		txtYy.setColumns(10);

		txtDd = new JTextField();
		txtDd.setToolTipText("");
		txtDd.setFont(new Font("Arial", Font.BOLD, 12));
		txtDd.setColumns(10);
		txtDd.setBounds(468, 30, 55, 24);
		panel.add(txtDd);

		txtMm = new JTextField();
		txtMm.setToolTipText("");
		txtMm.setFont(new Font("Arial", Font.BOLD, 12));
		txtMm.setColumns(10);
		txtMm.setBounds(535, 30, 55, 24);
		panel.add(txtMm);

		JTextPane txtpnPrenom = new JTextPane();
		txtpnPrenom.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnPrenom.setEditable(false);
		txtpnPrenom.setText("PRENOM");
		txtpnPrenom.setBounds(138, 3, 78, 21);
		panel.add(txtpnPrenom);

		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setEditable(false);
		txtpnNom.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnNom.setText("NOM");
		txtpnNom.setBounds(303, 3, 75, 21);
		panel.add(txtpnNom);

		JTextPane txtpnJour = new JTextPane();
		txtpnJour.setEditable(false);
		txtpnJour.setText("JOUR");
		txtpnJour.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnJour.setBounds(468, 3, 55, 21);
		panel.add(txtpnJour);

		JTextPane txtpnMois = new JTextPane();
		txtpnMois.setEditable(false);
		txtpnMois.setText("MOIS");
		txtpnMois.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnMois.setBounds(535, 3, 57, 21);
		panel.add(txtpnMois);

		JTextPane txtpnAnne = new JTextPane();
		txtpnAnne.setEditable(false);
		txtpnAnne.setText("ANNÉE");
		txtpnAnne.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnAnne.setBounds(602, 3, 57, 21);
		panel.add(txtpnAnne);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 29, 114, 24);
		panel.add(comboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "HOMME", "FEMME" }));

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(12, 88, 180, 24);
		panel.add(comboBox_1);
		comboBox_1.setBackground(Color.WHITE);

		btnSupprimerPersonne = new JButton("SUPPRIMER ");
		btnSupprimerPersonne.setBounds(687, 72, 123, 36);
		panel.add(btnSupprimerPersonne);
		btnSupprimerPersonne.setBorderPainted(false);
		btnSupprimerPersonne.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSupprimerPersonne.setForeground(Color.WHITE);
		btnSupprimerPersonne.setBackground(new Color(241, 57, 83));

		btnAjouterFils = new JButton("... LIER AVEC ...\n");
		btnAjouterFils.setBounds(204, 88, 186, 24);
		panel.add(btnAjouterFils);

		btnAjouterFils.setForeground(Color.BLACK);
		btnAjouterFils.setBorderPainted(false);
		btnAjouterFils.setBackground(Color.WHITE);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(402, 88, 180, 24);
		panel.add(comboBox_2);
		comboBox_2.setBackground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setOpaque(false);
		panel_2.setBounds(5, 129, 830, 506);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		drawTree vizu = new drawTree(membreFamille);
		vizu.setBounds(0, 0, 830, 506);
		panel_2.add(vizu);
		vizu.setLayout(new GridLayout(1, 0, 0, 0));

		btnAjouterFils.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboBox_1.getSelectedItem() != comboBox_2.getSelectedItem()) {
					if (estPlusVieux(membreFamille.get(comboBox_1.getSelectedIndex()),
							membreFamille.get(comboBox_2.getSelectedIndex()))) {
						/*
						 * si la personne1 est plus vieux alors personne1 est pere / mere de personne2
						 * on affiche les liens entre l'enfants et son père / mère
						 */
						membreFamille.get(comboBox_1.getSelectedIndex())
								.ajouterEnfant(membreFamille.get(comboBox_2.getSelectedIndex()));
						vizu.updateLiens(comboBox_2.getSelectedIndex());

					} else {
						/*
						 * sinon la personne1 est l'enfant de la personne2
						 */
						membreFamille.get(comboBox_2.getSelectedIndex())
								.ajouterEnfant(membreFamille.get(comboBox_1.getSelectedIndex()));
						vizu.updateLiens(comboBox_1.getSelectedIndex());

					}

				} else {
					/*
					 * affichage message d'erreur si un même personne est selectionné dans les
					 * comboBox
					 */
					JOptionPane.showMessageDialog(null, "meme personne selectionné");
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAjouterFils.setBackground(Color.LIGHT_GRAY);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAjouterFils.setBackground(Color.WHITE);

			}

		});

		btnSupprimerPersonne.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnSupprimerPersonne.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSupprimerPersonne.setBackground(new Color(241, 57, 83));
			}

			/*
			 * manque à retirer les enfants de la combo box et
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				if (membreFamille.get(comboBox_1.getSelectedIndex()).estRacine()) {
					
					
				} else if (membreFamille.get(comboBox_1.getSelectedIndex()).estFeuille()) {
					vizu.supprimerFeuille(membreFamille.get(comboBox_1.getSelectedIndex()));

				}

				membreFamille.remove(membreFamille.get(comboBox_1.getSelectedIndex()));
				comboBox_1.removeItem(comboBox_1.getSelectedItem());
			}
		});

		btnAjouter.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent ae) {
				btnAjouter.setBackground(Color.GREEN);
			}

			public void mouseExited(MouseEvent me) {
				btnAjouter.setBackground(new Color(83, 241, 51));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboBox.getSelectedItem() == "HOMME") {
					creeHomme();
					initTxtBox();
					vizu.updatePers();

				} else if (comboBox.getSelectedItem() == "FEMME") {
					creeFemme();
					initTxtBox();
					vizu.updatePers();
				}
				comboBox_1.setModel(new DefaultComboBoxModel(prenomMembreFamille.toArray()));
				if (membreFamille.size() > 1) {
					comboBox_2.setModel(new DefaultComboBoxModel(prenomMembreFamille.toArray()));
				}

			}
		});
		txtYy.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				txtYy.setText("");
				txtYy.setBorder(new LineBorder(Color.GREEN, 2));

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				txtYy.setBorder(new LineBorder(Color.GRAY, 1));

			}
		});

		txtMm.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				txtMm.setText("");
				txtMm.setBorder(new LineBorder(Color.GREEN, 2));

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				txtMm.setBorder(new LineBorder(Color.GRAY, 1));

			}
		});

		txtDd.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				txtDd.setText("");
				txtDd.setBorder(new LineBorder(Color.GREEN, 2));

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				txtDd.setBorder(new LineBorder(Color.GRAY, 1));

			}
		});

		txtPrenom.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				txtPrenom.setText("");
				txtPrenom.setBorder(new LineBorder(Color.GREEN, 2));

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				txtPrenom.setBorder(new LineBorder(Color.GRAY, 1));

			}
		});

		txtNom.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				txtNom.setText("");
				txtNom.setBorder(new LineBorder(Color.GREEN, 2));
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				txtNom.setBorder(new LineBorder(Color.GRAY, 1));

			}
		});

	}

	/*
	 * fonctions
	 */

	private void initTxtBox() {
		txtNom.setText("");
		txtPrenom.setText("");
		txtDd.setText("");
		txtMm.setText("");
		txtYy.setText("");
	}

	private boolean estPlusVieux(Personne pers1, Personne pers2) {
		String dateNaissPers1 = pers1.dateNaissance().substring(0, 4);
		String dateNaissPers2 = pers2.dateNaissance().substring(0, 4);
		int dateNP1 = Integer.parseInt(dateNaissPers1);
		int dateNP2 = Integer.parseInt(dateNaissPers2);
		return (dateNP1 < dateNP2);
	}

	public drawTree getSecondFrame() {
		return secondFrame;
	}

	public void setSecondFrame(drawTree secondFrame) {
		this.secondFrame = secondFrame;

	}

	private boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	private void creeHomme() {
		dateN = (txtYy.getText() + "-" + txtMm.getText() + "-" + txtDd.getText());
		if (isValidDate(dateN)) {
			membreFamille.add(new Homme(txtPrenom.getText(), txtNom.getText()));
			membreFamille.get(i).SetDateNaissance(dateN);
			prenomMembreFamille.add(txtPrenom.getText());
			i++;
		} else {
			JOptionPane.showMessageDialog(null, "DATE CHOISI INCORRECTE");
		}
	}

	private void creeFemme() {
		dateN = (txtYy.getText() + "-" + txtMm.getText() + "-" + txtDd.getText());
		if (isValidDate(dateN)) {
			membreFamille.add(new Femme(txtPrenom.getText(), txtNom.getText()));
			membreFamille.get(i).SetDateNaissance(dateN);
			prenomMembreFamille.add(txtPrenom.getText());
			i++;
		} else {
			JOptionPane.showMessageDialog(null, "DATE CHOISI INCORRECTE");
		}
	}
}
