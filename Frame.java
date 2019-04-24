import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtYy;
	private drawTree secondFrame;
	private JTextField txtDd;
	private JTextField txtMm;
	private String dateN;
	private JButton btnAjouterFils;
	private JButton btnAjouterPre;
	private JButton btnAjouter;
	private JButton btnSupprimerPersonne;
	@SuppressWarnings("unused")
	private drawTree frame;

	private int i = 0;

	private List<String> prenomMembreFamille = new ArrayList<String>();
	public ArrayList<Personne> membreFamille = new ArrayList<Personne>();

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
		setBackground(Color.DARK_GRAY);
		setResizable(false);
		setTitle("ARBRE GÉNÉALOGIQUE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 316);

		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		  
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "HOMME", "FEMME" }));
		comboBox.setBounds(12, 12, 114, 24);
		panel.add(comboBox);

		txtNom = new JTextField();
		txtNom.setFont(new Font("Arial", Font.BOLD, 12));
		txtNom.setBounds(12, 160, 325, 34);
		panel.add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Arial", Font.BOLD, 12));
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(12, 81, 325, 34);
		panel.add(txtPrenom);

		btnAjouter = new JButton("AJOUTER");
		btnAjouter.setBackground(new Color(83, 241, 51));
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBounds(231, 258, 106, 36);
		btnAjouter.setBorderPainted(false);
		panel.add(btnAjouter);

		txtYy = new JTextField();
		txtYy.setFont(new Font("Arial", Font.BOLD, 12));
		txtYy.setToolTipText("");
		txtYy.setBounds(146, 235, 57, 34);
		panel.add(txtYy);
		txtYy.setColumns(10);

		txtDd = new JTextField();
		txtDd.setToolTipText("");
		txtDd.setFont(new Font("Arial", Font.BOLD, 12));
		txtDd.setColumns(10);
		txtDd.setBounds(12, 235, 55, 34);
		panel.add(txtDd);

		txtMm = new JTextField();
		txtMm.setToolTipText("");
		txtMm.setFont(new Font("Arial", Font.BOLD, 12));
		txtMm.setColumns(10);
		txtMm.setBounds(79, 234, 55, 35);
		panel.add(txtMm);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(349, 0, 432, 494);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnAjouterFils = new JButton("...\nÀ POUR PARENTS\n ...");
		btnAjouterFils.setBounds(12, 96, 180, 100);
		panel_1.add(btnAjouterFils);

		btnAjouterFils.setForeground(Color.BLACK);
		btnAjouterFils.setBorderPainted(false);
		btnAjouterFils.setBackground(Color.GRAY);

		btnAjouterPre = new JButton("... À POUR ENFANT ...");
		btnAjouterPre.setBounds(240, 96, 180, 100);
		btnAjouterPre.setForeground(Color.BLACK);
		btnAjouterPre.setBorderPainted(false);
		btnAjouterPre.setBackground(Color.GRAY);
		panel_1.add(btnAjouterPre);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(12, 208, 408, 24);
		comboBox_2.setBackground(Color.GRAY);
		panel_1.add(comboBox_2);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(12, 60, 408, 24);
		comboBox_1.setBackground(Color.GRAY);
		panel_1.add(comboBox_1);

		JButton button = new JButton("AFFICHER");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				drawTree t = new drawTree(membreFamille);
			}
		});
		button.setBounds(12, 258, 106, 36);
		panel_1.add(button);
		button.setForeground(Color.BLACK);
		button.setBorderPainted(false);
		button.setBackground(Color.GRAY);

		btnSupprimerPersonne = new JButton("SUPPRIMER ");
		btnSupprimerPersonne.setBounds(295, 12, 125, 36);
		panel_1.add(btnSupprimerPersonne);
		btnSupprimerPersonne.setBorderPainted(false);
		btnSupprimerPersonne.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSupprimerPersonne.setForeground(Color.WHITE);
		btnSupprimerPersonne.setBackground(new Color(241, 57, 83));

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
					membreFamille.get(comboBox_1.getSelectedIndex()).enfants.clear();
				} else if (membreFamille.get(comboBox_1.getSelectedIndex()).estFeuille()) { // retire la personne de la
																							// liste de son père
					membreFamille.get(comboBox_1.getSelectedIndex()).pere().enfants
							.remove(membreFamille.get(comboBox_1.getSelectedIndex()));
					membreFamille.get(comboBox_1.getSelectedIndex()).mere().enfants
							.remove(membreFamille.get(comboBox_1.getSelectedIndex()));
				}

				membreFamille.remove(membreFamille.get(comboBox_1.getSelectedIndex()));
				comboBox_1.removeItem(comboBox_1.getSelectedItem());

			}
		});

		JTextPane txtpnPrenom = new JTextPane();
		txtpnPrenom.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnPrenom.setEditable(false);
		txtpnPrenom.setText("PRENOM");
		txtpnPrenom.setBounds(12, 48, 114, 21);
		panel.add(txtpnPrenom);

		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setEditable(false);
		txtpnNom.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnNom.setText("NOM");
		txtpnNom.setBounds(12, 127, 75, 21);
		panel.add(txtpnNom);

		JTextPane txtpnJour = new JTextPane();
		txtpnJour.setEditable(false);
		txtpnJour.setText("JOUR");
		txtpnJour.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnJour.setBounds(12, 206, 55, 21);
		panel.add(txtpnJour);

		JTextPane txtpnMois = new JTextPane();
		txtpnMois.setEditable(false);
		txtpnMois.setText("MOIS");
		txtpnMois.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnMois.setBounds(79, 206, 57, 21);
		panel.add(txtpnMois);

		JTextPane txtpnAnne = new JTextPane();
		txtpnAnne.setEditable(false);
		txtpnAnne.setText("ANNÉE");
		txtpnAnne.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpnAnne.setBounds(146, 206, 57, 21);
		panel.add(txtpnAnne);

		btnAjouterPre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAjouterPre.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAjouterPre.setBackground(Color.GRAY);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (comboBox_1.getSelectedItem() != comboBox_2.getSelectedItem()) {
					if (membreFamille.get(comboBox_2.getSelectedIndex()) instanceof Homme) {
						((Homme) membreFamille.get(comboBox_1.getSelectedIndex()))
								.ajouterEnfant(membreFamille.get(comboBox_2.getSelectedIndex()));

					} else if (membreFamille.get(comboBox_1.getSelectedIndex()) instanceof Femme) {
						((Femme) membreFamille.get(comboBox_1.getSelectedIndex()))
								.ajouterEnfant(membreFamille.get(comboBox_2.getSelectedIndex()));
					}

				} else {
					JOptionPane.showMessageDialog(null, "meme personne selectionné");
				}
			}
		});
		//btn a pour parent
		btnAjouterFils.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboBox_1.getSelectedItem() != comboBox_2.getSelectedItem()) {

					if (membreFamille.get(comboBox_2.getSelectedIndex()) instanceof Homme) {
						((Homme) membreFamille.get(comboBox_2.getSelectedIndex()))
						.ajouterEnfant(membreFamille.get(comboBox_1.getSelectedIndex()));
					} else if (membreFamille.get(comboBox_2.getSelectedIndex()) instanceof Femme) {
						((Femme) membreFamille.get(comboBox_2.getSelectedIndex()))
								.ajouterEnfant(membreFamille.get(comboBox_1.getSelectedIndex()));
					}
				} else {
					JOptionPane.showMessageDialog(null, "meme personne selectionné");
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAjouterFils.setBackground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAjouterFils.setBackground(Color.GRAY);
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
				} else if (comboBox.getSelectedItem() == "FEMME") {
					creeFemme();
					initTxtBox();

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

	public void initTxtBox() {
		txtNom.setText(" NOM :");
		txtPrenom.setText(" PRENOM :");
		txtDd.setText("DD");
		txtMm.setText("MM");
		txtYy.setText("YY");
	}

	public drawTree getSecondFrame() {
		return secondFrame;
	}

	public void setSecondFrame(drawTree secondFrame) {
		this.secondFrame = secondFrame;

	}

	public boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public void creeHomme() {
		dateN = (txtYy.getText() + "-" + txtMm.getText() + "-" + txtDd.getText());
		if (isValidDate(dateN)) {
			membreFamille.add(new Homme(txtPrenom.getText(), txtNom.getText()));
			membreFamille.get(i).SetDateNaissance(dateN);
			prenomMembreFamille.add(txtPrenom.getText());
			repaint();
			i++;
		} else {
			JOptionPane.showMessageDialog(null, "DATE CHOISI INCORRECTE");
		}
	}

	public void creeFemme() {
		dateN = (txtYy.getText() + "-" + txtMm.getText() + "-" + txtDd.getText());
		if (isValidDate(dateN)) {
			membreFamille.add(new Femme(txtPrenom.getText(), txtNom.getText()));
			membreFamille.get(i).SetDateNaissance(dateN);
			prenomMembreFamille.add(txtPrenom.getText());
			repaint();
			i++;
		} else {
			JOptionPane.showMessageDialog(null, "DATE CHOISI INCORRECTE");
		}
	}
}
