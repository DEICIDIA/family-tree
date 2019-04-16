import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	public Personne[] membreFamille = new Personne[100];
	private int i = 0;
	private JTextField txtYy;
	private drawTree secondFrame;
	private JTextField txtDd;
	private JTextField txtMm;
	private String dateN;
	private JButton btnAjouterPre;
	private JButton btnAjouterMre;
	private List<String> prenomMembreFamille = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setTitle("ARBRE GÉNÉALOGIQUE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 517);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HOMME", "FEMME"}));
		comboBox.setBounds(12, 12, 91, 24);
		panel.add(comboBox);
		
		txtNom = new JTextField();
		txtNom.setBorder(null);
		txtNom.setFont(new Font("Arial", Font.BOLD, 12));
		txtNom.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                txtNom.setText("");
            }

            @Override
            public void focusLost(FocusEvent arg0) {                
            }
			});
		txtNom.setText(" NOM :");
		txtNom.setBounds(12, 48, 237, 19);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBorder(null);
		txtPrenom.setFont(new Font("Arial", Font.BOLD, 12));
		txtPrenom.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                txtPrenom.setText("");
            }

            @Override
            public void focusLost(FocusEvent arg0) {                
            }
			});
		txtPrenom.setText(" PRENOM :");
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(12, 79, 237, 19);
		panel.add(txtPrenom);
		
		//ajoute une personne à la famille et verifie la validité de la date de naissance 
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.setBackground(Color.GRAY);
		btnAjouter.addMouseListener(new MouseAdapter() {
				Color oldcolor = btnAjouter.getBackground();
		         public void mouseEntered(MouseEvent me) {
		            oldcolor = Color.GRAY;
		            btnAjouter.setBackground(Color.WHITE);
		         }
		         public void mouseExited(MouseEvent me) {
		            btnAjouter.setBackground(oldcolor);
		         }
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comboBox.getSelectedItem() == "HOMME") {		
					creeHomme();	
					initTxtBox();
				} else if (comboBox.getSelectedItem() == "FEMME"){
					creeFemme();
					initTxtBox();
				}
			}
			});
		
		btnAjouter.setBorderPainted(false);
		btnAjouter.setForeground(Color.BLACK);
		btnAjouter.setBounds(12, 146, 117, 25);
		panel.add(btnAjouter);
		
		
		txtYy = new JTextField();
		txtYy.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                txtYy.setText("");
            }

            @Override
            public void focusLost(FocusEvent arg0) {                
            }
			});
		txtYy.setFont(new Font("Arial", Font.BOLD, 12));
		txtYy.setText("YY");
		txtYy.setToolTipText("");
		txtYy.setBounds(146, 110, 85, 24);
		panel.add(txtYy);
		txtYy.setColumns(10);
		
		JButton button = new JButton("AFFICHER");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setSecondFrame(new drawTree(membreFamille));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Color.GRAY);
			}
		});
		
		button.setForeground(Color.BLACK);
		button.setBorderPainted(false);
		button.setBackground(Color.GRAY);
		button.setBounds(618, 442, 117, 25);
		panel.add(button);
		
		txtDd = new JTextField();
		txtDd.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                txtDd.setText("");
            }

            @Override
            public void focusLost(FocusEvent arg0) {                
            }
			});
		txtDd.setToolTipText("");
		txtDd.setText("DD");
		txtDd.setFont(new Font("Arial", Font.BOLD, 12));
		txtDd.setColumns(10);
		txtDd.setBounds(12, 110, 55, 24);
		panel.add(txtDd);
		
		txtMm = new JTextField();
		txtMm.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                txtMm.setText("");
            }

            @Override
            public void focusLost(FocusEvent arg0) {                
            }
			});
		txtMm.setToolTipText("");
		txtMm.setText("MM");
		txtMm.setFont(new Font("Arial", Font.BOLD, 12));
		txtMm.setColumns(10);
		txtMm.setBounds(79, 110, 55, 24);
		panel.add(txtMm);
		
		btnAjouterPre = new JButton("AJOUTER PÈRE");
		btnAjouterPre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAjouterPre.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAjouterPre.setBackground(Color.GRAY);
			}
		});
		btnAjouterPre.setForeground(Color.BLACK);
		btnAjouterPre.setBorderPainted(false);
		btnAjouterPre.setBackground(Color.GRAY);
		btnAjouterPre.setBounds(12, 183, 219, 25);
		panel.add(btnAjouterPre);
		
		btnAjouterMre = new JButton("AJOUTER MÈRE");
		btnAjouterMre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAjouterMre.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAjouterMre.setBackground(Color.GRAY);
			}
		});
		btnAjouterMre.setForeground(Color.BLACK);
		btnAjouterMre.setBorderPainted(false);
		btnAjouterMre.setBackground(Color.GRAY);
		btnAjouterMre.setBounds(12, 220, 219, 25);
		panel.add(btnAjouterMre);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(prenomMembreFamille.toArray()));
		comboBox_1.setBackground(Color.GRAY);
		comboBox_1.setBounds(382, 12, 353, 24);
		panel.add(comboBox_1);
	}

	//fonctions
	
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
		if(isValidDate(dateN)) {
			membreFamille[i] = new Homme(txtPrenom.getText(),txtNom.getText());
			membreFamille[i].SetDateNaissance(dateN);
			prenomMembreFamille.add(txtPrenom.getText());
			repaint();
			i++;
		}
	}
	
	public void creeFemme() {
		dateN = (txtYy.getText() + "-" + txtMm.getText() + "-" + txtDd.getText()); 		
		if(isValidDate(dateN)) {
			membreFamille[i] = new Femme(txtPrenom.getText(),txtNom.getText());
			membreFamille[i].SetDateNaissance(dateN);
			prenomMembreFamille.add(txtPrenom.getText());
			repaint();
			i++;
		}
	}
}
