package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.graalvm.compiler.lir.LIRInstruction.Use;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MedicalAssistantAdditionalInformationRegistration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MedicalAssistantAdditionalInformationRegistration frame = new MedicalAssistantAdditionalInformationRegistration();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MedicalAssistantAdditionalInformationRegistration(User user) {
		Database database = new Database();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel welcomeLabel = new JLabel("As a medical assistant, you're required to complete some ");
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 0;
		gbc_welcomeLabel.gridy = 1;
		contentPane.add(welcomeLabel, gbc_welcomeLabel);

		JLabel welcomeLabel2 = new JLabel("additional information for the database:");
		GridBagConstraints gbc_welcomeLabel2 = new GridBagConstraints();
		gbc_welcomeLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel2.gridx = 0;
		gbc_welcomeLabel2.gridy = 2;
		contentPane.add(welcomeLabel2, gbc_welcomeLabel2);

		JLabel domainLabel = new JLabel("Your domain:");
		GridBagConstraints gbc_domainLabel = new GridBagConstraints();
		gbc_domainLabel.insets = new Insets(0, 0, 5, 5);
		gbc_domainLabel.gridx = 0;
		gbc_domainLabel.gridy = 4;
		contentPane.add(domainLabel, gbc_domainLabel);

		JComboBox domainComboBox = new JComboBox();
		domainComboBox.addItem("Generalist");
		domainComboBox.addItem("Laborator");
		domainComboBox.addItem("Radiologie");
		GridBagConstraints gbc_domainComboBox = new GridBagConstraints();
		gbc_domainComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_domainComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_domainComboBox.gridx = 1;
		gbc_domainComboBox.gridy = 4;
		contentPane.add(domainComboBox, gbc_domainComboBox);

		JLabel degreeLabel = new JLabel("Your degree:");
		GridBagConstraints gbc_degreeLabel = new GridBagConstraints();
		gbc_degreeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_degreeLabel.gridx = 0;
		gbc_degreeLabel.gridy = 5;
		contentPane.add(degreeLabel, gbc_degreeLabel);

		JComboBox degreeComboBox = new JComboBox();
		degreeComboBox.addItem("Principal");
		degreeComboBox.addItem("Secundar");
		GridBagConstraints gbc_degreeComboBox = new GridBagConstraints();
		gbc_degreeComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_degreeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_degreeComboBox.gridx = 1;
		gbc_degreeComboBox.gridy = 5;
		contentPane.add(degreeComboBox, gbc_degreeComboBox);
		
		UserService userService = new UserService();
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.getMedicalAssistantData().setDegree(degreeComboBox.getSelectedItem().toString());
				user.getMedicalAssistantData().setDomain(domainComboBox.getSelectedItem().toString());
				userService.save(user);
				userService.saveMedicalAssistant(user.getFirstName(), user.getLastName(), degreeComboBox.getSelectedItem().toString(), domainComboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Registered successfully. Please login to continue");
				setVisible(false);
				MyLog.loginNewScreen();
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.gridx = 1;
		gbc_saveButton.gridy = 7;
		contentPane.add(saveButton, gbc_saveButton);

	}

}
