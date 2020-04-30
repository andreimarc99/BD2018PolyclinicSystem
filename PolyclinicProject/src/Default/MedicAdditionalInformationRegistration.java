package Default;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class MedicAdditionalInformationRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField stampTextField;
	private JTextField percentageTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MedicAdditionalInformationRegistration frame = new MedicAdditionalInformationRegistration();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public MedicAdditionalInformationRegistration(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 857, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(33, 78, 477, 448);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JCheckBox chckbxAnalizeLaborator = new JCheckBox("Analize de laborator");
		GridBagConstraints gbc_chckbxAnalizeLaborator = new GridBagConstraints();
		gbc_chckbxAnalizeLaborator.anchor = GridBagConstraints.WEST;
		gbc_chckbxAnalizeLaborator.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAnalizeLaborator.gridx = 0;
		gbc_chckbxAnalizeLaborator.gridy = 0;
		panel.add(chckbxAnalizeLaborator, gbc_chckbxAnalizeLaborator);

		JCheckBox chckbxOrl = new JCheckBox("O.R.L.");
		GridBagConstraints gbc_chckbxOrl = new GridBagConstraints();
		gbc_chckbxOrl.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxOrl.anchor = GridBagConstraints.WEST;
		gbc_chckbxOrl.gridx = 1;
		gbc_chckbxOrl.gridy = 0;
		panel.add(chckbxOrl, gbc_chckbxOrl);

		JCheckBox chckbxAlergologieSiImunologie = new JCheckBox("Alergologie si imunologie clinica");
		GridBagConstraints gbc_chckbxAlergologieSiImunologie = new GridBagConstraints();
		gbc_chckbxAlergologieSiImunologie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAlergologieSiImunologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxAlergologieSiImunologie.gridx = 0;
		gbc_chckbxAlergologieSiImunologie.gridy = 1;
		panel.add(chckbxAlergologieSiImunologie, gbc_chckbxAlergologieSiImunologie);

		JCheckBox chckbxObstetricaGinecologie = new JCheckBox("Obstetrica \u2013 Ginecologie");
		GridBagConstraints gbc_chckbxObstetricaGinecologie = new GridBagConstraints();
		gbc_chckbxObstetricaGinecologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxObstetricaGinecologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxObstetricaGinecologie.gridx = 1;
		gbc_chckbxObstetricaGinecologie.gridy = 1;
		panel.add(chckbxObstetricaGinecologie, gbc_chckbxObstetricaGinecologie);

		JCheckBox chckbxAnestezieTerapie = new JCheckBox("Anestezie - terapie intensiva");
		GridBagConstraints gbc_chckbxAnestezieTerapie = new GridBagConstraints();
		gbc_chckbxAnestezieTerapie.anchor = GridBagConstraints.WEST;
		gbc_chckbxAnestezieTerapie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAnestezieTerapie.gridx = 0;
		gbc_chckbxAnestezieTerapie.gridy = 2;
		panel.add(chckbxAnestezieTerapie, gbc_chckbxAnestezieTerapie);

		JCheckBox chckbxOftalmologie = new JCheckBox("Oftalmologie");
		GridBagConstraints gbc_chckbxOftalmologie = new GridBagConstraints();
		gbc_chckbxOftalmologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxOftalmologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxOftalmologie.gridx = 1;
		gbc_chckbxOftalmologie.gridy = 2;
		panel.add(chckbxOftalmologie, gbc_chckbxOftalmologie);

		JCheckBox chckbxCardiologie = new JCheckBox("Cardiologie");
		GridBagConstraints gbc_chckbxCardiologie = new GridBagConstraints();
		gbc_chckbxCardiologie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCardiologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxCardiologie.gridx = 0;
		gbc_chckbxCardiologie.gridy = 3;
		panel.add(chckbxCardiologie, gbc_chckbxCardiologie);

		JCheckBox chckbxOrtopedieTraumatologie = new JCheckBox("Ortopedie - Traumatologie");
		GridBagConstraints gbc_chckbxOrtopedieTraumatologie = new GridBagConstraints();
		gbc_chckbxOrtopedieTraumatologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxOrtopedieTraumatologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxOrtopedieTraumatologie.gridx = 1;
		gbc_chckbxOrtopedieTraumatologie.gridy = 3;
		panel.add(chckbxOrtopedieTraumatologie, gbc_chckbxOrtopedieTraumatologie);

		JCheckBox chckbxChirurgieGenerala = new JCheckBox("Chirurgie generala");
		GridBagConstraints gbc_chckbxChirurgieGenerala = new GridBagConstraints();
		gbc_chckbxChirurgieGenerala.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxChirurgieGenerala.anchor = GridBagConstraints.WEST;
		gbc_chckbxChirurgieGenerala.gridx = 0;
		gbc_chckbxChirurgieGenerala.gridy = 4;
		panel.add(chckbxChirurgieGenerala, gbc_chckbxChirurgieGenerala);

		JCheckBox chckbxOsteodensitometrie = new JCheckBox("Osteodensitometrie");
		GridBagConstraints gbc_chckbxOsteodensitometrie = new GridBagConstraints();
		gbc_chckbxOsteodensitometrie.anchor = GridBagConstraints.WEST;
		gbc_chckbxOsteodensitometrie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxOsteodensitometrie.gridx = 1;
		gbc_chckbxOsteodensitometrie.gridy = 4;
		panel.add(chckbxOsteodensitometrie, gbc_chckbxOsteodensitometrie);

		JCheckBox chckbxDermatologieVenerologie = new JCheckBox("Dermatologie \u2013 venerologie");
		GridBagConstraints gbc_chckbxDermatologieVenerologie = new GridBagConstraints();
		gbc_chckbxDermatologieVenerologie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDermatologieVenerologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxDermatologieVenerologie.gridx = 0;
		gbc_chckbxDermatologieVenerologie.gridy = 5;
		panel.add(chckbxDermatologieVenerologie, gbc_chckbxDermatologieVenerologie);

		JCheckBox chckbxPediatrieNeonatologie = new JCheckBox("Pediatrie - Neonatologie");
		GridBagConstraints gbc_chckbxPediatrieNeonatologie = new GridBagConstraints();
		gbc_chckbxPediatrieNeonatologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxPediatrieNeonatologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPediatrieNeonatologie.gridx = 1;
		gbc_chckbxPediatrieNeonatologie.gridy = 5;
		panel.add(chckbxPediatrieNeonatologie, gbc_chckbxPediatrieNeonatologie);

		JCheckBox chckbxDermatologieBoliDe = new JCheckBox("Dermatologie, boli de nutritie si metabolism");
		GridBagConstraints gbc_chckbxDermatologieBoliDe = new GridBagConstraints();
		gbc_chckbxDermatologieBoliDe.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDermatologieBoliDe.anchor = GridBagConstraints.WEST;
		gbc_chckbxDermatologieBoliDe.gridx = 0;
		gbc_chckbxDermatologieBoliDe.gridy = 6;
		panel.add(chckbxDermatologieBoliDe, gbc_chckbxDermatologieBoliDe);

		JCheckBox chckbxPneumologie = new JCheckBox("Pneumologie");
		GridBagConstraints gbc_chckbxPneumologie = new GridBagConstraints();
		gbc_chckbxPneumologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxPneumologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPneumologie.gridx = 1;
		gbc_chckbxPneumologie.gridy = 6;
		panel.add(chckbxPneumologie, gbc_chckbxPneumologie);

		JCheckBox chckbxEndocrinologie = new JCheckBox("Endocrinologie");
		GridBagConstraints gbc_chckbxEndocrinologie = new GridBagConstraints();
		gbc_chckbxEndocrinologie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEndocrinologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxEndocrinologie.gridx = 0;
		gbc_chckbxEndocrinologie.gridy = 7;
		panel.add(chckbxEndocrinologie, gbc_chckbxEndocrinologie);

		JCheckBox chckbxPsihologie = new JCheckBox("Psihologie");
		GridBagConstraints gbc_chckbxPsihologie = new GridBagConstraints();
		gbc_chckbxPsihologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxPsihologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPsihologie.gridx = 1;
		gbc_chckbxPsihologie.gridy = 7;
		panel.add(chckbxPsihologie, gbc_chckbxPsihologie);

		JCheckBox chckbxExplorariFunctionale = new JCheckBox("Explorari functionale");
		GridBagConstraints gbc_chckbxExplorariFunctionale = new GridBagConstraints();
		gbc_chckbxExplorariFunctionale.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxExplorariFunctionale.anchor = GridBagConstraints.WEST;
		gbc_chckbxExplorariFunctionale.gridx = 0;
		gbc_chckbxExplorariFunctionale.gridy = 8;
		panel.add(chckbxExplorariFunctionale, gbc_chckbxExplorariFunctionale);

		JCheckBox chckbxPsihiatrie = new JCheckBox("Psihiatrie");
		GridBagConstraints gbc_chckbxPsihiatrie = new GridBagConstraints();
		gbc_chckbxPsihiatrie.anchor = GridBagConstraints.WEST;
		gbc_chckbxPsihiatrie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPsihiatrie.gridx = 1;
		gbc_chckbxPsihiatrie.gridy = 8;
		panel.add(chckbxPsihiatrie, gbc_chckbxPsihiatrie);

		JCheckBox chckbxGastroenterologie = new JCheckBox("Gastroenterologie");
		GridBagConstraints gbc_chckbxGastroenterologie = new GridBagConstraints();
		gbc_chckbxGastroenterologie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGastroenterologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxGastroenterologie.gridx = 0;
		gbc_chckbxGastroenterologie.gridy = 9;
		panel.add(chckbxGastroenterologie, gbc_chckbxGastroenterologie);

		JCheckBox chckbxRadiologieImagistica = new JCheckBox("Radiologie - Imagistica Medicala");
		GridBagConstraints gbc_chckbxRadiologieImagistica = new GridBagConstraints();
		gbc_chckbxRadiologieImagistica.anchor = GridBagConstraints.WEST;
		gbc_chckbxRadiologieImagistica.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxRadiologieImagistica.gridx = 1;
		gbc_chckbxRadiologieImagistica.gridy = 9;
		panel.add(chckbxRadiologieImagistica, gbc_chckbxRadiologieImagistica);

		JCheckBox chckbxMedicinaGenerala = new JCheckBox("Medicina generala");
		GridBagConstraints gbc_chckbxMedicinaGenerala = new GridBagConstraints();
		gbc_chckbxMedicinaGenerala.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMedicinaGenerala.anchor = GridBagConstraints.WEST;
		gbc_chckbxMedicinaGenerala.gridx = 0;
		gbc_chckbxMedicinaGenerala.gridy = 10;
		panel.add(chckbxMedicinaGenerala, gbc_chckbxMedicinaGenerala);

		JCheckBox chckbxReumatologie = new JCheckBox("Reumatologie");
		GridBagConstraints gbc_chckbxReumatologie = new GridBagConstraints();
		gbc_chckbxReumatologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxReumatologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxReumatologie.gridx = 1;
		gbc_chckbxReumatologie.gridy = 10;
		panel.add(chckbxReumatologie, gbc_chckbxReumatologie);

		JCheckBox chckbxMedicinaInterna = new JCheckBox("Medicina interna");
		GridBagConstraints gbc_chckbxMedicinaInterna = new GridBagConstraints();
		gbc_chckbxMedicinaInterna.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMedicinaInterna.anchor = GridBagConstraints.WEST;
		gbc_chckbxMedicinaInterna.gridx = 0;
		gbc_chckbxMedicinaInterna.gridy = 11;
		panel.add(chckbxMedicinaInterna, gbc_chckbxMedicinaInterna);

		JCheckBox chckbxStomatologie = new JCheckBox("Stomatologie");
		GridBagConstraints gbc_chckbxStomatologie = new GridBagConstraints();
		gbc_chckbxStomatologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxStomatologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxStomatologie.gridx = 1;
		gbc_chckbxStomatologie.gridy = 11;
		panel.add(chckbxStomatologie, gbc_chckbxStomatologie);

		JCheckBox chckbxNeurologie = new JCheckBox("Neurologie");
		GridBagConstraints gbc_chckbxNeurologie = new GridBagConstraints();
		gbc_chckbxNeurologie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNeurologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxNeurologie.gridx = 0;
		gbc_chckbxNeurologie.gridy = 12;
		panel.add(chckbxNeurologie, gbc_chckbxNeurologie);

		JCheckBox chckbxUrologie = new JCheckBox("Urologie");
		GridBagConstraints gbc_chckbxUrologie = new GridBagConstraints();
		gbc_chckbxUrologie.anchor = GridBagConstraints.WEST;
		gbc_chckbxUrologie.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxUrologie.gridx = 1;
		gbc_chckbxUrologie.gridy = 12;
		panel.add(chckbxUrologie, gbc_chckbxUrologie);

		JCheckBox chckbxNeurologiePediatrica = new JCheckBox("Neurologie pediatrica");
		GridBagConstraints gbc_chckbxNeurologiePediatrica = new GridBagConstraints();
		gbc_chckbxNeurologiePediatrica.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNeurologiePediatrica.anchor = GridBagConstraints.WEST;
		gbc_chckbxNeurologiePediatrica.gridx = 0;
		gbc_chckbxNeurologiePediatrica.gridy = 13;
		panel.add(chckbxNeurologiePediatrica, gbc_chckbxNeurologiePediatrica);

		JCheckBox chckbxAlteServicii = new JCheckBox("Alte servicii");
		GridBagConstraints gbc_chckbxAlteServicii = new GridBagConstraints();
		gbc_chckbxAlteServicii.anchor = GridBagConstraints.WEST;
		gbc_chckbxAlteServicii.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxAlteServicii.gridx = 1;
		gbc_chckbxAlteServicii.gridy = 13;
		panel.add(chckbxAlteServicii, gbc_chckbxAlteServicii);

		JLabel lblChooseFromThe = new JLabel("Choose from the specialities below:");
		lblChooseFromThe.setBounds(34, 43, 181, 13);
		contentPane.add(lblChooseFromThe);

		JLabel lblChooseYourDegree = new JLabel("Choose your degree:");
		lblChooseYourDegree.setBounds(574, 43, 146, 13);
		contentPane.add(lblChooseYourDegree);

		JComboBox degreeComboBox = new JComboBox();
		degreeComboBox.setBounds(574, 78, 146, 21);
		degreeComboBox.addItem("Primar");
		degreeComboBox.addItem("Specialist");
		contentPane.add(degreeComboBox);

		JLabel stampLabel = new JLabel("Enter your stamp:");
		stampLabel.setBounds(574, 127, 163, 13);
		contentPane.add(stampLabel);

		stampTextField = new JTextField();
		stampTextField.setBounds(574, 150, 146, 19);
		contentPane.add(stampTextField);
		stampTextField.setColumns(10);

		JLabel scientificTitleLabel = new JLabel("Choose your scientific title:");
		scientificTitleLabel.setBounds(574, 196, 198, 13);
		contentPane.add(scientificTitleLabel);

		JComboBox scientificTitleComboBox = new JComboBox();
		scientificTitleComboBox.setBounds(574, 233, 146, 21);
		scientificTitleComboBox.addItem("");
		scientificTitleComboBox.addItem("Doctorand");
		scientificTitleComboBox.addItem("Doctor in stiinte medicale");
		contentPane.add(scientificTitleComboBox);

		JLabel lblChooseYourTeaching = new JLabel("Choose your teaching spot:");
		lblChooseYourTeaching.setBounds(574, 285, 186, 13);
		contentPane.add(lblChooseYourTeaching);

		JComboBox teachingSpotComboBox = new JComboBox();
		teachingSpotComboBox.setBounds(574, 328, 146, 21);
		teachingSpotComboBox.addItem("");
		teachingSpotComboBox.addItem("Preparator");
		teachingSpotComboBox.addItem("Asistent");
		teachingSpotComboBox.addItem("Sef de lucrari");
		teachingSpotComboBox.addItem("Conferentiar");
		teachingSpotComboBox.addItem("Profesor");
		contentPane.add(teachingSpotComboBox);

		JLabel percentageLabel = new JLabel("Enter the percentage from the");
		percentageLabel.setBounds(574, 383, 243, 21);
		contentPane.add(percentageLabel);

		percentageTextField = new JTextField();
		percentageTextField.setBounds(574, 426, 146, 19);
		contentPane.add(percentageTextField);
		percentageTextField.setColumns(10);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService userService = new UserService();
				boolean ok = false;
				for (Component component : panel.getComponents()) {
					if (component instanceof JCheckBox) {
						JCheckBox c = (JCheckBox) component;
						if (c.isSelected()) {
							ok = true;
						}
					}
				}
				if (degreeComboBox.getSelectedIndex() == -1 || stampTextField.getText().trim().isEmpty()
						|| percentageTextField.getText().trim().isEmpty() || ok == false) {
					JOptionPane.showMessageDialog(null, "Try again");
					setVisible(true);
				} else {
					userService.save(user);
					userService.saveDoctor(user.getFirstName(), user.getLastName(),
							degreeComboBox.getSelectedItem().toString(),
							scientificTitleComboBox.getSelectedItem().toString(),
							teachingSpotComboBox.getSelectedItem().toString(),
							Float.parseFloat(percentageTextField.getText().trim()),
							stampTextField.getText().trim());
					for (Component component : panel.getComponents()) {
						if (component instanceof JCheckBox) {
							JCheckBox c = (JCheckBox) component;
							if (c.isSelected()) {
								userService.addSpeciality(user.getFirstName(), user.getLastName(), c.getText().trim());
							}
						}
					}
					JOptionPane.showMessageDialog(null, "Successfully registered. Login to continue");
					MyLog.loginNewScreen();
					close();
				}
			}
		});
		btnDone.setBounds(732, 505, 85, 21);
		contentPane.add(btnDone);

		JLabel lblMedicalServices = new JLabel("medical services:");
		lblMedicalServices.setBounds(574, 403, 133, 13);
		contentPane.add(lblMedicalServices);

//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, UserService.get(username).getMedicData().getSpeciality()[0]);
//			}
//		});
//		btnNewButton.setBounds(635, 505, 85, 21);
//		contentPane.add(btnNewButton);
	}
}
