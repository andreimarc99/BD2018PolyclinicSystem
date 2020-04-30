package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegisterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField userNameTextField;
	private JTextField emailTextField;
	private JTextField ibanTextField;
	private JTextField addressTextField;
	private JLabel telephoneNumberLabel;
	private JTextField telephoneNumberTextField;
	private JLabel employmentDateLabel;
	private JTextField employmentDateTextField;
	private JLabel cnpLabel;
	private JTextField cnpTextField;
	private JButton registerButton;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton btnBack;
	private JLabel salaryLabel;
	private JTextField salaryTextField;
	private JLabel noOfHoursLabel;
	private JTextField noOfHoursTextField;
	private JLabel lblContractNumber;
	private JTextField contractNumberTxtFld;

	/**
	 * Launch the application.
	 */
	public static void newWindowRegister() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow frame = new RegisterWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public RegisterWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 13, 0, 19, 13, 0, 19, 13, 0, 19, 13, 0, 19, 13, 0, 19, 13, 0, 19, 0, 0,
				0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel firstNameLabel = new JLabel("First Name");
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.WEST;
		gbc_firstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameLabel.gridx = 0;
		gbc_firstNameLabel.gridy = 0;
		contentPane.add(firstNameLabel, gbc_firstNameLabel);

		telephoneNumberLabel = new JLabel("Telephone Number");
		GridBagConstraints gbc_telephoneNumberLabel = new GridBagConstraints();
		gbc_telephoneNumberLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_telephoneNumberLabel.insets = new Insets(0, 0, 5, 0);
		gbc_telephoneNumberLabel.gridx = 11;
		gbc_telephoneNumberLabel.gridy = 0;
		contentPane.add(telephoneNumberLabel, gbc_telephoneNumberLabel);

		firstNameTextField = new JTextField();
		firstNameTextField.setText("");
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.anchor = GridBagConstraints.WEST;
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameTextField.gridx = 0;
		gbc_firstNameTextField.gridy = 1;
		contentPane.add(firstNameTextField, gbc_firstNameTextField);
		firstNameTextField.setColumns(15);

		telephoneNumberTextField = new JTextField();
		telephoneNumberTextField.setText("");
		GridBagConstraints gbc_telephoneNumberTextField = new GridBagConstraints();
		gbc_telephoneNumberTextField.anchor = GridBagConstraints.WEST;
		gbc_telephoneNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbc_telephoneNumberTextField.gridx = 11;
		gbc_telephoneNumberTextField.gridy = 1;
		contentPane.add(telephoneNumberTextField, gbc_telephoneNumberTextField);
		telephoneNumberTextField.setColumns(15);

		JLabel lastNameLabel = new JLabel("Last Name");
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.WEST;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridx = 0;
		gbc_lastNameLabel.gridy = 3;
		contentPane.add(lastNameLabel, gbc_lastNameLabel);

		lastNameTextField = new JTextField();
		lastNameTextField.setText("");
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.anchor = GridBagConstraints.WEST;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameTextField.gridx = 0;
		gbc_lastNameTextField.gridy = 4;
		contentPane.add(lastNameTextField, gbc_lastNameTextField);
		lastNameTextField.setColumns(15);

		JLabel usernameLabel = new JLabel("Username");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.WEST;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 0;
		gbc_usernameLabel.gridy = 6;
		contentPane.add(usernameLabel, gbc_usernameLabel);

		employmentDateLabel = new JLabel("Employment Date");
		GridBagConstraints gbc_employmentDateLabel = new GridBagConstraints();
		gbc_employmentDateLabel.anchor = GridBagConstraints.WEST;
		gbc_employmentDateLabel.insets = new Insets(0, 0, 5, 0);
		gbc_employmentDateLabel.gridx = 11;
		gbc_employmentDateLabel.gridy = 6;
		contentPane.add(employmentDateLabel, gbc_employmentDateLabel);

		userNameTextField = new JTextField();
		userNameTextField.setText("");
		GridBagConstraints gbc_userNameTextField = new GridBagConstraints();
		gbc_userNameTextField.anchor = GridBagConstraints.WEST;
		gbc_userNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userNameTextField.gridx = 0;
		gbc_userNameTextField.gridy = 7;
		contentPane.add(userNameTextField, gbc_userNameTextField);
		userNameTextField.setColumns(15);

		employmentDateTextField = new JTextField();
		employmentDateTextField.setText("");
		GridBagConstraints gbc_employmentDateTextField = new GridBagConstraints();
		gbc_employmentDateTextField.anchor = GridBagConstraints.WEST;
		gbc_employmentDateTextField.insets = new Insets(0, 0, 5, 0);
		gbc_employmentDateTextField.gridx = 11;
		gbc_employmentDateTextField.gridy = 7;
		contentPane.add(employmentDateTextField, gbc_employmentDateTextField);
		employmentDateTextField.setColumns(15);

		JLabel emailLabel = new JLabel("E-mail");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.WEST;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 9;
		contentPane.add(emailLabel, gbc_emailLabel);

		cnpLabel = new JLabel("CNP");
		GridBagConstraints gbc_cnpLabel = new GridBagConstraints();
		gbc_cnpLabel.anchor = GridBagConstraints.WEST;
		gbc_cnpLabel.insets = new Insets(0, 0, 5, 0);
		gbc_cnpLabel.gridx = 11;
		gbc_cnpLabel.gridy = 9;
		contentPane.add(cnpLabel, gbc_cnpLabel);

		emailTextField = new JTextField();
		emailTextField.setText("");
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.anchor = GridBagConstraints.WEST;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.gridx = 0;
		gbc_emailTextField.gridy = 10;
		contentPane.add(emailTextField, gbc_emailTextField);
		emailTextField.setColumns(15);

		cnpTextField = new JTextField();
		cnpTextField.setText("");
		GridBagConstraints gbc_cnpTextField = new GridBagConstraints();
		gbc_cnpTextField.anchor = GridBagConstraints.WEST;
		gbc_cnpTextField.insets = new Insets(0, 0, 5, 0);
		gbc_cnpTextField.gridx = 11;
		gbc_cnpTextField.gridy = 10;
		contentPane.add(cnpTextField, gbc_cnpTextField);
		cnpTextField.setColumns(15);

		JLabel ibanLabel = new JLabel("IBAN");
		GridBagConstraints gbc_ibanLabel = new GridBagConstraints();
		gbc_ibanLabel.anchor = GridBagConstraints.WEST;
		gbc_ibanLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ibanLabel.gridx = 0;
		gbc_ibanLabel.gridy = 12;
		contentPane.add(ibanLabel, gbc_ibanLabel);

		noOfHoursLabel = new JLabel("Number of hours");
		GridBagConstraints gbc_noOfHoursLabel = new GridBagConstraints();
		gbc_noOfHoursLabel.anchor = GridBagConstraints.WEST;
		gbc_noOfHoursLabel.insets = new Insets(0, 0, 5, 0);
		gbc_noOfHoursLabel.gridx = 11;
		gbc_noOfHoursLabel.gridy = 12;
		contentPane.add(noOfHoursLabel, gbc_noOfHoursLabel);

		ibanTextField = new JTextField();
		ibanTextField.setText("");
		GridBagConstraints gbc_ibanTextField = new GridBagConstraints();
		gbc_ibanTextField.anchor = GridBagConstraints.WEST;
		gbc_ibanTextField.insets = new Insets(0, 0, 5, 5);
		gbc_ibanTextField.gridx = 0;
		gbc_ibanTextField.gridy = 13;
		contentPane.add(ibanTextField, gbc_ibanTextField);
		ibanTextField.setColumns(15);

		noOfHoursTextField = new JTextField();
		GridBagConstraints gbc_noOfHoursTextField = new GridBagConstraints();
		gbc_noOfHoursTextField.anchor = GridBagConstraints.WEST;
		gbc_noOfHoursTextField.insets = new Insets(0, 0, 5, 0);
		gbc_noOfHoursTextField.gridx = 11;
		gbc_noOfHoursTextField.gridy = 13;
		contentPane.add(noOfHoursTextField, gbc_noOfHoursTextField);
		noOfHoursTextField.setColumns(15);

		JLabel addressLabel = new JLabel("Address");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.WEST;
		gbc_addressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 15;
		contentPane.add(addressLabel, gbc_addressLabel);

		passwordLabel = new JLabel("Password");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 0);
		gbc_passwordLabel.gridx = 11;
		gbc_passwordLabel.gridy = 3;
		contentPane.add(passwordLabel, gbc_passwordLabel);

		salaryLabel = new JLabel("Salary");
		GridBagConstraints gbc_salaryLabel = new GridBagConstraints();
		gbc_salaryLabel.anchor = GridBagConstraints.WEST;
		gbc_salaryLabel.insets = new Insets(0, 0, 5, 0);
		gbc_salaryLabel.gridx = 11;
		gbc_salaryLabel.gridy = 15;
		contentPane.add(salaryLabel, gbc_salaryLabel);

		addressTextField = new JTextField();
		addressTextField.setText("");
		GridBagConstraints gbc_addressTextField = new GridBagConstraints();
		gbc_addressTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addressTextField.anchor = GridBagConstraints.WEST;
		gbc_addressTextField.gridx = 0;
		gbc_addressTextField.gridy = 16;
		contentPane.add(addressTextField, gbc_addressTextField);
		addressTextField.setColumns(15);

		passwordTextField = new JTextField();
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.anchor = GridBagConstraints.WEST;
		gbc_passwordTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordTextField.gridx = 11;
		gbc_passwordTextField.gridy = 4;
		contentPane.add(passwordTextField, gbc_passwordTextField);
		passwordTextField.setColumns(15);

		salaryTextField = new JTextField();
		GridBagConstraints gbc_salaryTextField = new GridBagConstraints();
		gbc_salaryTextField.anchor = GridBagConstraints.WEST;
		gbc_salaryTextField.insets = new Insets(0, 0, 5, 0);
		gbc_salaryTextField.gridx = 11;
		gbc_salaryTextField.gridy = 16;
		contentPane.add(salaryTextField, gbc_salaryTextField);
		salaryTextField.setColumns(15);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyLog.loginNewScreen();
				close();
			}
		});

		lblContractNumber = new JLabel("Contract number");
		GridBagConstraints gbc_lblContractNumber = new GridBagConstraints();
		gbc_lblContractNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblContractNumber.gridx = 0;
		gbc_lblContractNumber.gridy = 18;
		contentPane.add(lblContractNumber, gbc_lblContractNumber);

		contractNumberTxtFld = new JTextField();
		GridBagConstraints gbc_contractNumberTxtFld = new GridBagConstraints();
		gbc_contractNumberTxtFld.insets = new Insets(0, 0, 5, 5);
		gbc_contractNumberTxtFld.gridx = 0;
		gbc_contractNumberTxtFld.gridy = 19;
		contentPane.add(contractNumberTxtFld, gbc_contractNumberTxtFld);
		contractNumberTxtFld.setColumns(15);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 21;
		contentPane.add(btnBack, gbc_btnBack);

		JComboBox jobComboBox = new JComboBox();
		GridBagConstraints gbc_jobComboBox = new GridBagConstraints();
		gbc_jobComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_jobComboBox.gridx = 6;
		gbc_jobComboBox.gridy = 21;
		jobComboBox.addItem("Inspector resurse umane");
		jobComboBox.addItem("Expert financiar-contabil");
		jobComboBox.addItem("Receptioner");
		jobComboBox.addItem("Asistent Medical");
		jobComboBox.addItem("Medic");
		jobComboBox.addItem("Administrator");
		jobComboBox.addItem("Super-administrator");
		contentPane.add(jobComboBox, gbc_jobComboBox);

		registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean okCnp = false;
				boolean okEmplDate = false;
				boolean okIban = false;
				boolean okSalary = false;
				boolean okNoOfHours = false;
				setVisible(false);
				if (firstNameTextField.getText().trim().isEmpty() || lastNameTextField.getText().trim().isEmpty()
						|| addressTextField.getText().trim().isEmpty() || ibanTextField.getText().trim().isEmpty()
						|| telephoneNumberTextField.getText().trim().isEmpty()
						|| employmentDateTextField.getText().trim().isEmpty() || cnpTextField.getText().trim().isEmpty()
						|| userNameTextField.getText().trim().isEmpty()
						|| employmentDateTextField.getText().trim().isEmpty()
						|| noOfHoursTextField.getText().trim().isEmpty() || salaryTextField.getText().trim().isEmpty()
						|| jobComboBox.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
					setVisible(true);
				} else {
					User user = new User();
					user.setFirstName(firstNameTextField.getText().trim());
					user.setLastName(lastNameTextField.getText().trim());
					user.setUsername(userNameTextField.getText().trim());
					user.setAddress(addressTextField.getText().trim());
					user.setJob(jobComboBox.getSelectedItem().toString());
					boolean okContractNo = false;
					try {
						user.setContractNumber(Integer.parseInt(contractNumberTxtFld.getText().trim()));
						okContractNo = true;
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Salary should be an integer!");
						okContractNo = false;
					}
					try {
						user.setSalary(Integer.parseInt(salaryTextField.getText().trim()));
						okSalary = true;
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Salary should be an integer!");
						okSalary = false;
					}
					try {
						user.setNoOfHours(Integer.parseInt(noOfHoursTextField.getText().trim()));
						okNoOfHours = true;
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Number of hours should be an integer!");
						okNoOfHours = false;
					}
					if (cnpTextField.getText().trim().length() != 13) {
						JOptionPane.showMessageDialog(null, "CNP must be 13 characters long!");
						okCnp = false;
					} else {
						user.setCNP(cnpTextField.getText().trim());
						okCnp = true;
					}
					user.setEmail(emailTextField.getText().trim());
					if (employmentDateTextField.getText().trim().length() != 10
							|| employmentDateTextField.getText().trim().charAt(4) != '-'
							|| employmentDateTextField.getText().trim().charAt(7) != '-') {
						JOptionPane.showMessageDialog(null, "Incorrect date format. Correct format is 'YYYY-MM-DD");
						okEmplDate = false;
					} else {
						DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
						Date date = new Date();
						try {
							date = (Date) format.parse(employmentDateTextField.getText().trim());
							java.sql.Date sqlDate = new java.sql.Date(date.getTime());
							user.setEmploymentDate(sqlDate);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							user.setEmploymentDate(null);
						}
						okEmplDate = true;
					}
					if (ibanTextField.getText().trim().length() == 24) {
						user.setIban(ibanTextField.getText().trim());
						okIban = true;
					} else {
						okIban = false;
						JOptionPane.showMessageDialog(null, "IBAN must be 24 characters long!");
					}
					boolean okTelephone = false;;
					if (telephoneNumberTextField.getText().trim().length() != 10) {
						JOptionPane.showMessageDialog(null, "Telephone number must be 10 characters long!");
						okTelephone  = false;
					} else {
						user.setTelephoneNumber(telephoneNumberTextField.getText().trim());
						okTelephone = true;
					}
					user.setPassword(passwordTextField.getText().trim());
					UserService userService = new UserService();

					if (okCnp == false || okEmplDate == false || okIban == false || okSalary == false
							|| okNoOfHours == false || okContractNo == false || okTelephone == false) {
						JOptionPane.showMessageDialog(null, "Try again");
						setVisible(true);
					} else {
						if (jobComboBox.getSelectedItem().toString().equals("Asistent medical")) {
							user.setMedic(false);
							user.setMedicalAssistant(true);
							MedicalAssistantAdditionalInformationRegistration medicalAssistantAdditionalInformationRegistration = new MedicalAssistantAdditionalInformationRegistration(
									user);
							medicalAssistantAdditionalInformationRegistration.setVisible(true);
							close();
						} else if (jobComboBox.getSelectedItem().toString().equals("Medic")) {
							user.setMedicalAssistant(false);
							user.setMedic(true);
							MedicAdditionalInformationRegistration medicAdditionalInformationRegistration = new MedicAdditionalInformationRegistration(
									user);
							medicAdditionalInformationRegistration.setVisible(true);
							close();
						} else {
							user.setMedic(false);
							user.setMedicData(null);
							user.setMedicalAssistant(false);
							user.setMedicalAssistantData(null);
							userService.save(user);
							JOptionPane.showMessageDialog(null, "Registered successfully. Please login to continue");
							MyLog.loginNewScreen();
						}
					}
				}
			}
		});

		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.gridx = 11;
		gbc_registerButton.gridy = 21;
		contentPane.add(registerButton, gbc_registerButton);

	}

	public String getUserNameTextField() {
		return userNameTextField.getText().trim();
	}

}
