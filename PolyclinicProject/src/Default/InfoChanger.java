package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import jdk.nashorn.internal.scripts.JO;

//import net.miginfocom.layout.Grid;

//import net.miginfocom.layout.Grid;

import java.awt.GridBagLayout;
import java.awt.Insets;

public class InfoChanger extends JFrame {

	private JPanel contentPane;
	private String username;

	/**
	 * Launch the application.
	 */
//	public static void infoChangerNewScreen() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InfoChanger frame = new InfoChanger();
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
	public InfoChanger(User admin, User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		JButton btnBack = new JButton("Back to login");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyLog.loginNewScreen();
				close();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		contentPane.add(btnBack, gbc_btnBack);

		JLabel welcomeLabel = new JLabel("");
		welcomeLabel.setText(user.getUsername() + "'s information");
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 0;
		contentPane.add(welcomeLabel, gbc_welcomeLabel);

		JLabel newFirstNameLabel = new JLabel("Introduce new first name:");
		GridBagConstraints gbc_fNameLbl = new GridBagConstraints();
		gbc_fNameLbl.insets = new Insets(0, 0, 5, 5);
		gbc_fNameLbl.gridx = 0;
		gbc_fNameLbl.gridy = 1;
		contentPane.add(newFirstNameLabel, gbc_fNameLbl);

		JTextField fNameTextField = new JTextField();
		GridBagConstraints gbc_fNameTxtFld = new GridBagConstraints();
		gbc_fNameTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_fNameTxtFld.gridx = 1;
		gbc_fNameTxtFld.gridy = 1;
		fNameTextField.setColumns(15);
		contentPane.add(fNameTextField, gbc_fNameTxtFld);

		JButton fNameButton = new JButton("Change");
		fNameButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (fNameTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No first name introduced. Try again");
				} else {
					user.setFirstName(fNameTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "First name changed.");
				}
			}
		});
		GridBagConstraints gbc_fNameBtn = new GridBagConstraints();
		gbc_fNameBtn.insets = new Insets(0, 0, 5, 0);
		gbc_fNameBtn.gridx = 2;
		gbc_fNameBtn.gridy = 1;
		contentPane.add(fNameButton, gbc_fNameBtn);

		JLabel newLastNameLabel = new JLabel("Introduce new last name:");
		GridBagConstraints gbc_lNameLabel = new GridBagConstraints();
		gbc_lNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lNameLabel.gridx = 0;
		gbc_lNameLabel.gridy = 2;
		contentPane.add(newLastNameLabel, gbc_lNameLabel);

		JTextField lNameTextField = new JTextField();
		GridBagConstraints gbc_lNameTxtFld = new GridBagConstraints();
		gbc_lNameTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_lNameTxtFld.gridx = 1;
		gbc_lNameTxtFld.gridy = 2;
		lNameTextField.setColumns(15);
		contentPane.add(lNameTextField, gbc_lNameTxtFld);

		JButton lNameButton = new JButton("Change");
		lNameButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (lNameTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No last name introduced. Try again");
				} else {
					user.setLastName(lNameTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "Last name changed.");
				}
			}
		});
		GridBagConstraints gbc_lNameBtn = new GridBagConstraints();
		gbc_lNameBtn.insets = new Insets(0, 0, 5, 0);
		gbc_lNameBtn.gridx = 2;
		gbc_lNameBtn.gridy = 2;
		contentPane.add(lNameButton, gbc_lNameBtn);

		JLabel newPasswordLabel = new JLabel("Introduce new password: ");
		GridBagConstraints gbc_passLbl = new GridBagConstraints();
		gbc_passLbl.insets = new Insets(0, 0, 5, 5);
		gbc_passLbl.gridx = 0;
		gbc_passLbl.gridy = 3;
		contentPane.add(newPasswordLabel, gbc_passLbl);

		JTextField newPassTextField = new JTextField();
		GridBagConstraints gbc_passTextFld = new GridBagConstraints();
		gbc_passTextFld.insets = new Insets(0, 0, 5, 5);
		gbc_passTextFld.gridx = 1;
		gbc_passTextFld.gridy = 3;
		newPassTextField.setColumns(15);
		contentPane.add(newPassTextField, gbc_passTextFld);

		JButton passButton = new JButton("Change");
		passButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (newPassTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No password introduced. Try again");
				} else {
					user.setPassword(newPassTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "Password changed.");
				}
			}
		});
		GridBagConstraints gbc_passBtn = new GridBagConstraints();
		gbc_passBtn.insets = new Insets(0, 0, 5, 0);
		gbc_passBtn.gridx = 2;
		gbc_passBtn.gridy = 3;
		contentPane.add(passButton, gbc_passBtn);

		JLabel salaryLabel = new JLabel("Introduce new salary:");
		GridBagConstraints gbc_salaryLabel = new GridBagConstraints();
		gbc_salaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaryLabel.gridx = 0;
		gbc_salaryLabel.gridy = 4;
		contentPane.add(salaryLabel, gbc_salaryLabel);

		JTextField salaryTextField = new JTextField();
		GridBagConstraints gbc_salaryTextField = new GridBagConstraints();
		gbc_salaryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_salaryTextField.gridx = 1;
		gbc_salaryTextField.gridy = 4;
		salaryTextField.setColumns(15);
		contentPane.add(salaryTextField, gbc_salaryTextField);

		JButton salaryButton = new JButton("Change");
		salaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (salaryTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No salary introduced. Try again");
				} else {
					try {
						user.setSalary(Integer.parseInt(salaryTextField.getText().trim()));
						JOptionPane.showMessageDialog(null, "Salary changed.");
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Salary should be an integer!");
					}
				}
			}
		});
		GridBagConstraints gbc_salaryButton = new GridBagConstraints();
		gbc_salaryButton.anchor = GridBagConstraints.WEST;
		gbc_salaryButton.insets = new Insets(0, 0, 5, 0);
		gbc_salaryButton.gridx = 2;
		gbc_salaryButton.gridy = 4;
		contentPane.add(salaryButton, gbc_salaryButton);

		JLabel hoursLabel = new JLabel("Introduce new amount of hours:");
		GridBagConstraints gbc_hoursLabel = new GridBagConstraints();
		gbc_hoursLabel.insets = new Insets(0, 0, 5, 5);
		gbc_hoursLabel.gridx = 0;
		gbc_hoursLabel.gridy = 5;
		contentPane.add(hoursLabel, gbc_hoursLabel);

		JTextField hoursTextField = new JTextField();
		GridBagConstraints gbc_hoursTxtFld = new GridBagConstraints();
		gbc_hoursTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_hoursTxtFld.gridx = 1;
		gbc_hoursTxtFld.gridy = 5;
		hoursTextField.setColumns(15);
		contentPane.add(hoursTextField, gbc_hoursTxtFld);

		JButton hoursButton = new JButton("Change");
		hoursButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hoursTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No amount of hours introduced. Try again");
				} else {
					try {
						user.setNoOfHours(Integer.parseInt(hoursTextField.getText().trim()));
						JOptionPane.showMessageDialog(null, "Number of hours changed.");
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Number of hours should be an integer!");
					}
				}
			}
		});
		GridBagConstraints gbc_hoursButton = new GridBagConstraints();
		gbc_hoursButton.insets = new Insets(0, 0, 5, 0);
		gbc_hoursButton.gridx = 2;
		gbc_hoursButton.gridy = 5;
		contentPane.add(hoursButton, gbc_hoursButton);

		JLabel newEmailLabel = new JLabel("Introduce new e-mail:");
		GridBagConstraints gbc_emailLbl = new GridBagConstraints();
		gbc_emailLbl.insets = new Insets(0, 0, 5, 5);
		gbc_emailLbl.gridx = 0;
		gbc_emailLbl.gridy = 6;
		contentPane.add(newEmailLabel, gbc_emailLbl);

		JTextField newEmailTextField = new JTextField();
		GridBagConstraints gbc_emailTxtFld = new GridBagConstraints();
		gbc_emailTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_emailTxtFld.gridx = 1;
		gbc_emailTxtFld.gridy = 6;
		newEmailTextField.setColumns(15);
		contentPane.add(newEmailTextField, gbc_emailTxtFld);

		JButton emailButton = new JButton("Change");
		emailButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (newEmailTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No e-mail introduced. Try again");
				} else {
					user.setEmail(newEmailTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "E-mail changed.");
				}
			}
		});
		GridBagConstraints gbc_emailBtn = new GridBagConstraints();
		gbc_emailBtn.insets = new Insets(0, 0, 5, 0);
		gbc_emailBtn.gridx = 2;
		gbc_emailBtn.gridy = 6;
		contentPane.add(emailButton, gbc_emailBtn);

		JLabel newAddressLabel = new JLabel("Introduce new address");
		GridBagConstraints gbc_addressLbl = new GridBagConstraints();
		gbc_addressLbl.insets = new Insets(0, 0, 5, 5);
		gbc_addressLbl.gridx = 0;
		gbc_addressLbl.gridy = 7;
		contentPane.add(newAddressLabel, gbc_addressLbl);

		JTextField newAddressTextField = new JTextField();
		GridBagConstraints gbc_addressTxtFld = new GridBagConstraints();
		gbc_addressTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_addressTxtFld.gridx = 1;
		gbc_addressTxtFld.gridy = 7;
		newAddressTextField.setColumns(15);
		contentPane.add(newAddressTextField, gbc_addressTxtFld);

		JButton newAddressButton = new JButton("Change");
		newAddressButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (newAddressTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No address introduced. Try again");
				} else {
					user.setAddress(newAddressTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "Address changed.");
				}
			}
		});
		GridBagConstraints gbc_addressBtn = new GridBagConstraints();
		gbc_addressBtn.insets = new Insets(0, 0, 5, 0);
		gbc_addressBtn.gridx = 2;
		gbc_addressBtn.gridy = 7;
		contentPane.add(newAddressButton, gbc_addressBtn);

		JLabel newTelephoneLabel = new JLabel("Introduce new telephone number:");
		GridBagConstraints gbc_telLabel = new GridBagConstraints();
		gbc_telLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telLabel.gridx = 0;
		gbc_telLabel.gridy = 8;
		contentPane.add(newTelephoneLabel, gbc_telLabel);
		gbc_telLabel.gridx = 1;
		gbc_telLabel.gridy = 6;

		JTextField newTelephoneTextField = new JTextField();
		GridBagConstraints gbc_telTxtFld = new GridBagConstraints();
		gbc_telTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_telTxtFld.gridx = 1;
		gbc_telTxtFld.gridy = 8;
		newTelephoneTextField.setColumns(15);
		contentPane.add(newTelephoneTextField, gbc_telTxtFld);

		JButton newTelephoneButton = new JButton("Change");
		newTelephoneButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (newTelephoneTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No telephone number introduced. Try again");
				} else if (newTelephoneTextField.getText().trim().length() != 10) {
					JOptionPane.showMessageDialog(null, "Telephone number should be 10 characters long!");
				} else {
					user.setTelephoneNumber(newTelephoneTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "Telephone number changed.");
				}
			}
		});

		GridBagConstraints gbc_telBtn = new GridBagConstraints();
		gbc_telBtn.insets = new Insets(0, 0, 5, 0);
		gbc_telBtn.gridx = 2;
		gbc_telBtn.gridy = 8;
		contentPane.add(newTelephoneButton, gbc_telBtn);

		JLabel cnpLabel = new JLabel("Introduce new CNP:");
		GridBagConstraints gbc_cnpLbl = new GridBagConstraints();
		gbc_cnpLbl.insets = new Insets(0, 0, 5, 5);
		gbc_cnpLbl.gridx = 0;
		gbc_cnpLbl.gridy = 9;
		contentPane.add(cnpLabel, gbc_cnpLbl);

		JTextField cnpTextField = new JTextField();
		GridBagConstraints gbc_cnpTxtFld = new GridBagConstraints();
		gbc_cnpTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_cnpTxtFld.gridx = 1;
		gbc_cnpTxtFld.gridy = 9;
		cnpTextField.setColumns(15);
		contentPane.add(cnpTextField, gbc_cnpTxtFld);

		JButton cnpButton = new JButton("Change");
		cnpButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (cnpTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No CNP introduced. Try again");
				} else if (cnpTextField.getText().trim().length() != 13) {
					JOptionPane.showMessageDialog(null, "CNP should be 13 characters long!");
				} else {
					user.setCNP(cnpTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "CNP changed.");
				}
			}
		});
		GridBagConstraints gbc_cnpBtn = new GridBagConstraints();
		gbc_cnpBtn.insets = new Insets(0, 0, 5, 0);
		gbc_cnpBtn.gridx = 2;
		gbc_cnpBtn.gridy = 9;
		contentPane.add(cnpButton, gbc_cnpBtn);

		JLabel positionLabel = new JLabel("Introduce new position:");
		GridBagConstraints gbc_positionLbl = new GridBagConstraints();
		gbc_positionLbl.insets = new Insets(0, 0, 5, 5);
		gbc_positionLbl.gridx = 0;
		gbc_positionLbl.gridy = 10;
		contentPane.add(positionLabel, gbc_positionLbl);

		JComboBox jobComboBox = new JComboBox();
		jobComboBox.addItem("Inspector resurse umane");
		jobComboBox.addItem("Expert financiar - contabil");
		jobComboBox.addItem("Receptioner");
		jobComboBox.addItem("Asistent medical");
		jobComboBox.addItem("Medic");
		GridBagConstraints gbc_positionBox = new GridBagConstraints();
		gbc_positionBox.insets = new Insets(0, 0, 5, 5);
		gbc_positionBox.gridx = 1;
		gbc_positionBox.gridy = 10;
		contentPane.add(jobComboBox, gbc_positionBox);

//
//		JTextField positionTextField = new JTextField();
//		GridBagConstraints gbc_positionTxtFld = new GridBagConstraints();
//		gbc_positionTxtFld.gridx = 1;
//		gbc_positionTxtFld.gridy = 8;
//		positionTextField.setColumns(15);
//		contentPane.add(positionTextField, gbc_positionTxtFld);
//
		JButton posButton = new JButton("Change");
		posButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (jobComboBox.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "No job introduced. Try again");
				} else {
					user.setJob(jobComboBox.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Job changed.");
				}
			}
		});
		GridBagConstraints gbc_posBtn = new GridBagConstraints();
		gbc_posBtn.insets = new Insets(0, 0, 5, 0);
		gbc_posBtn.gridx = 2;
		gbc_posBtn.gridy = 10;
		contentPane.add(posButton, gbc_posBtn);

		JLabel newIbanLabel = new JLabel("Introduce new IBAN");
		GridBagConstraints gbc_ibanLbl = new GridBagConstraints();
		gbc_ibanLbl.insets = new Insets(0, 0, 5, 5);
		gbc_ibanLbl.gridx = 0;
		gbc_ibanLbl.gridy = 11;
		contentPane.add(newIbanLabel, gbc_ibanLbl);

		JTextField newIbanTextField = new JTextField();
		GridBagConstraints gbc_ibanTxtFld = new GridBagConstraints();
		gbc_ibanTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_ibanTxtFld.gridx = 1;
		gbc_ibanTxtFld.gridy = 11;
		newIbanTextField.setColumns(15);
		contentPane.add(newIbanTextField, gbc_ibanTxtFld);

		JButton newIbanButton = new JButton("Change");
		newIbanButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (newIbanTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No IBAN introduced. Try again");
				} else {
					user.setIban(newIbanTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "IBAN changed.");
				}
			}
		});
		GridBagConstraints gbc_ibanBtn = new GridBagConstraints();
		gbc_ibanBtn.insets = new Insets(0, 0, 5, 0);
		gbc_ibanBtn.gridx = 2;
		gbc_ibanBtn.gridy = 11;
		contentPane.add(newIbanButton, gbc_ibanBtn);

		JLabel newEmplDateLabel = new JLabel("Introduce new employment date:");
		GridBagConstraints gbc_newEmplDateLbl = new GridBagConstraints();
		gbc_newEmplDateLbl.insets = new Insets(0, 0, 5, 5);
		gbc_newEmplDateLbl.gridx = 0;
		gbc_newEmplDateLbl.gridy = 12;
		contentPane.add(newEmplDateLabel, gbc_newEmplDateLbl);

		JTextField newEmplDateTextField = new JTextField();
		GridBagConstraints gbc_newEmplDateTxtFld = new GridBagConstraints();
		gbc_newEmplDateTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_newEmplDateTxtFld.gridx = 1;
		gbc_newEmplDateTxtFld.gridy = 12;
		newEmplDateTextField.setColumns(15);
		contentPane.add(newEmplDateTextField, gbc_newEmplDateTxtFld);

		JButton newEmplDateButton = new JButton("Change");
		newEmplDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (newEmplDateTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "No employment date introduced. Try again");
				} else if (newEmplDateTextField.getText().trim().length() != 10
						|| newEmplDateTextField.getText().trim().charAt(4) != '-'
						|| newEmplDateTextField.getText().trim().charAt(7) != '-') {
					JOptionPane.showMessageDialog(null, "Incorrect date format. Correct format is 'YYYY-MM-DD'");
				} else {
					// UserService.get(username).setEmploymentDate(newEmplDateTextField.getText().trim());
					JOptionPane.showMessageDialog(null, "Employment date changed.");
				}
			}
		});
		GridBagConstraints gbc_emplDateBtn = new GridBagConstraints();
		gbc_emplDateBtn.insets = new Insets(0, 0, 5, 0);
		gbc_emplDateBtn.gridx = 2;
		gbc_emplDateBtn.gridy = 12;
		contentPane.add(newEmplDateButton, gbc_emplDateBtn);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService userService = new UserService();
				userService.updateUser(user);
				JOptionPane.showMessageDialog(null, "Information updated");
				AdminWindow adminWindow = new AdminWindow(admin.getUsername());
				adminWindow.setVisible(true);
				close();
			}
		});
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.gridx = 2;
		gbc_btnDone.gridy = 13;
		contentPane.add(btnDone, gbc_btnDone);
	}
}
