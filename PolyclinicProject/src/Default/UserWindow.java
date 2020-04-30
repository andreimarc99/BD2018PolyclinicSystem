package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import net.miginfocom.swing.MigLayout;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JTextField;

public class UserWindow extends JFrame {

	private JPanel contentPane;
	private String username;

	/**
	 * Launch the application.
	 */
	public static void userNewScreen(String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow frame = new UserWindow(username);
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
	public UserWindow(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 786, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		JButton btnBack = new JButton("Back");
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
		welcomeLabel.setText("Welcome, " + username);
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 0;
		contentPane.add(welcomeLabel, gbc_welcomeLabel);

		UserService userService = new UserService();
		List<User> users = userService.findAll();
		User ourUser = new User();
		for (User userSearcher : users) {
			if (userSearcher.getUsername().equals(username)) {
				ourUser = userSearcher;
				break;
			}
		}
		final User user = ourUser;

		JLabel informationLabel = new JLabel("");
		informationLabel.setText(user.getFirstName() + " " + user.getLastName() + "'s information: ");
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 0;
		gbc_infoLabel.gridy = 1;
		contentPane.add(informationLabel, gbc_infoLabel);

		JLabel firstNameConstantLabel = new JLabel("First name: ");
		GridBagConstraints gbc_fNameConstLabel = new GridBagConstraints();
		gbc_fNameConstLabel.anchor = GridBagConstraints.EAST;
		gbc_fNameConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fNameConstLabel.gridx = 0;
		gbc_fNameConstLabel.gridy = 2;
		contentPane.add(firstNameConstantLabel, gbc_fNameConstLabel);

		JLabel firstNameLabel = new JLabel("");
		firstNameLabel.setText(user.getFirstName());
		GridBagConstraints gbc_fNameLabel = new GridBagConstraints();
		gbc_fNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fNameLabel.gridx = 1;
		gbc_fNameLabel.gridy = 2;
		contentPane.add(firstNameLabel, gbc_fNameLabel);

		JLabel lastNameConstantLabel = new JLabel("Last name: ");
		GridBagConstraints gbc_lNameConstLabel = new GridBagConstraints();
		gbc_lNameConstLabel.anchor = GridBagConstraints.EAST;
		gbc_lNameConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lNameConstLabel.gridx = 0;
		gbc_lNameConstLabel.gridy = 3;
		contentPane.add(lastNameConstantLabel, gbc_lNameConstLabel);

		JLabel lastNameLabel = new JLabel("");
		lastNameLabel.setText(user.getLastName());
		GridBagConstraints gbc_lNameLabel = new GridBagConstraints();
		gbc_lNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lNameLabel.gridx = 1;
		gbc_lNameLabel.gridy = 3;
		contentPane.add(lastNameLabel, gbc_lNameLabel);

		JLabel addressConstantLabel = new JLabel("Address: ");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.EAST;
		gbc_addressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 4;
		contentPane.add(addressConstantLabel, gbc_addressLabel);

		JLabel addressLabel = new JLabel("");
		addressLabel.setText(user.getAddress());
		GridBagConstraints gbc_adLabel = new GridBagConstraints();
		gbc_adLabel.insets = new Insets(0, 0, 5, 5);
		gbc_adLabel.gridx = 1;
		gbc_adLabel.gridy = 4;
		contentPane.add(addressLabel, gbc_adLabel);

		JLabel telephoneConstantLabel = new JLabel("Telephone number: ");
		GridBagConstraints gbc_telConstLabel = new GridBagConstraints();
		gbc_telConstLabel.anchor = GridBagConstraints.EAST;
		gbc_telConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telConstLabel.gridx = 0;
		gbc_telConstLabel.gridy = 5;
		contentPane.add(telephoneConstantLabel, gbc_telConstLabel);

		JLabel telephoneLabel = new JLabel("");
		telephoneLabel.setText(user.getTelephoneNumber());
		GridBagConstraints gbc_telLabel = new GridBagConstraints();
		gbc_telLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telLabel.gridx = 1;
		gbc_telLabel.gridy = 5;
		contentPane.add(telephoneLabel, gbc_telLabel);

		JLabel emailConstantLabel = new JLabel("E-mail: ");
		GridBagConstraints gbc_emailConstLabel = new GridBagConstraints();
		gbc_emailConstLabel.anchor = GridBagConstraints.EAST;
		gbc_emailConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailConstLabel.gridx = 0;
		gbc_emailConstLabel.gridy = 6;
		contentPane.add(emailConstantLabel, gbc_emailConstLabel);

		JLabel emailLabel = new JLabel("");
		emailLabel.setText(user.getEmail());
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 1;
		gbc_emailLabel.gridy = 6;
		contentPane.add(emailLabel, gbc_emailLabel);

		JLabel cnpConstantLabel = new JLabel("CNP: ");
		GridBagConstraints gbc_cnpConstLabel = new GridBagConstraints();
		gbc_cnpConstLabel.anchor = GridBagConstraints.EAST;
		gbc_cnpConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cnpConstLabel.gridx = 0;
		gbc_cnpConstLabel.gridy = 7;
		contentPane.add(cnpConstantLabel, gbc_cnpConstLabel);

		JLabel cnpLabel = new JLabel("");
		cnpLabel.setText(user.getCNP());
		GridBagConstraints gbc_cnpLabel = new GridBagConstraints();
		gbc_cnpLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cnpLabel.gridx = 1;
		gbc_cnpLabel.gridy = 7;
		contentPane.add(cnpLabel, gbc_cnpLabel);

		JLabel jobConstLabel = new JLabel("Job:");
		GridBagConstraints gbc_jobConstLbl = new GridBagConstraints();
		gbc_jobConstLbl.anchor = GridBagConstraints.EAST;
		gbc_jobConstLbl.insets = new Insets(0, 0, 5, 5);
		gbc_jobConstLbl.gridx = 0;
		gbc_jobConstLbl.gridy = 8;
		contentPane.add(jobConstLabel, gbc_jobConstLbl);

		JLabel jobLabel = new JLabel("");
		jobLabel.setText(user.getJob());
		GridBagConstraints gbc_jobLabel = new GridBagConstraints();
		gbc_jobLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jobLabel.gridx = 1;
		gbc_jobLabel.gridy = 8;
		contentPane.add(jobLabel, gbc_jobLabel);

		JLabel ibanConstLabel = new JLabel("IBAN: ");
		GridBagConstraints gbc_ibanConstLabel = new GridBagConstraints();
		gbc_ibanConstLabel.anchor = GridBagConstraints.EAST;
		gbc_ibanConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ibanConstLabel.gridx = 0;
		gbc_ibanConstLabel.gridy = 9;
		contentPane.add(ibanConstLabel, gbc_ibanConstLabel);

		JLabel ibanLabel = new JLabel("");
		ibanLabel.setText(user.getIban());
		GridBagConstraints gbc_ibanLabel = new GridBagConstraints();
		gbc_ibanLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ibanLabel.gridx = 1;
		gbc_ibanLabel.gridy = 9;
		contentPane.add(ibanLabel, gbc_ibanLabel);

		JLabel emplDateConstLabel = new JLabel("Employment date: ");
		GridBagConstraints gbc_emplConstLabel = new GridBagConstraints();
		gbc_emplConstLabel.anchor = GridBagConstraints.EAST;
		gbc_emplConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emplConstLabel.gridx = 0;
		gbc_emplConstLabel.gridy = 10;
		contentPane.add(emplDateConstLabel, gbc_emplConstLabel);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = user.getEmploymentDate();
		String reportDate = df.format(today);

		JLabel emplDateLabel = new JLabel("");
		emplDateLabel.setText(reportDate);
		GridBagConstraints gbc_emplLabel = new GridBagConstraints();
		gbc_emplLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emplLabel.gridx = 1;
		gbc_emplLabel.gridy = 10;
		contentPane.add(emplDateLabel, gbc_emplLabel);

		JLabel idConstLabel = new JLabel("ID: ");
		GridBagConstraints gbc_idConstLabel = new GridBagConstraints();
		gbc_idConstLabel.anchor = GridBagConstraints.EAST;
		gbc_idConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_idConstLabel.gridx = 0;
		gbc_idConstLabel.gridy = 11;
		contentPane.add(idConstLabel, gbc_idConstLabel);

		JLabel idLabel = new JLabel("");
		idLabel.setText(user.getStringID());
		GridBagConstraints gbc_idLabel = new GridBagConstraints();
		gbc_idLabel.insets = new Insets(0, 0, 5, 5);
		gbc_idLabel.gridx = 1;
		gbc_idLabel.gridy = 11;
		contentPane.add(idLabel, gbc_idLabel);

		JLabel salaryConstLabel = new JLabel("Salary:");
		GridBagConstraints gbc_salaryConstLabel = new GridBagConstraints();
		gbc_salaryConstLabel.anchor = GridBagConstraints.EAST;
		gbc_salaryConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaryConstLabel.gridx = 0;
		gbc_salaryConstLabel.gridy = 12;
		contentPane.add(salaryConstLabel, gbc_salaryConstLabel);

		JLabel salaryLabel = new JLabel("");
		salaryLabel.setText(String.format("%d", user.getSalary()));
		GridBagConstraints gbc_salaryLabel = new GridBagConstraints();
		gbc_salaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaryLabel.gridx = 1;
		gbc_salaryLabel.gridy = 12;
		contentPane.add(salaryLabel, gbc_salaryLabel);

		JLabel numberOfHoursConstLabel = new JLabel("Number of hours:");
		GridBagConstraints gbc_numberOfHoursConstLabel = new GridBagConstraints();
		gbc_numberOfHoursConstLabel.anchor = GridBagConstraints.EAST;
		gbc_numberOfHoursConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numberOfHoursConstLabel.gridx = 0;
		gbc_numberOfHoursConstLabel.gridy = 13;
		contentPane.add(numberOfHoursConstLabel, gbc_numberOfHoursConstLabel);

		JLabel noOfHoursLabel = new JLabel("");
		noOfHoursLabel.setText(String.format("%d", user.getNoOfHours()));
		GridBagConstraints gbc_noOfHoursLabel = new GridBagConstraints();
		gbc_noOfHoursLabel.insets = new Insets(0, 0, 5, 5);
		gbc_noOfHoursLabel.gridx = 1;
		gbc_noOfHoursLabel.gridy = 13;
		contentPane.add(noOfHoursLabel, gbc_noOfHoursLabel);
		
		JButton additionalIfnoButton = new JButton("More");
		final MedicalAssistantData assistantData = userService.retrieveMedicalAssistantData(user);
		additionalIfnoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getJob().equals("Asistent Medical")) {
					MedicalAssistantView medicalAssistantView = new MedicalAssistantView(user);
					medicalAssistantView.setVisible(true);
					close();
				} else if (user.getJob().equals("Medic")) {
					MedicView medicView = new MedicView(user);
					medicView.setVisible(true);
					close();
				} else if (user.getJob().equals("Receptioner")) {
					ReceptionerAction receptionerAction = new ReceptionerAction(user);
					receptionerAction.setVisible(true);
					close();
				} else if (user.getJob().equals("Inspector resurse umane")) {
					InspectorStuff inspectorStuff = new InspectorStuff(user);
					inspectorStuff.setVisible(true);
					close();
				} else if (user.getJob().equals("Expert financiar-contabil")){
					ExpertFinanciarStuff expertFinanciarStuff = new ExpertFinanciarStuff(user);
					expertFinanciarStuff.setVisible(true);
					close();
				} else {
					JOptionPane.showMessageDialog(null, "No more additional information for your account");
				}
			}
		});
		
		JLabel lblDepartment = new JLabel("Department:");
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.gridx = 0;
		gbc_lblDepartment.gridy = 14;
		contentPane.add(lblDepartment, gbc_lblDepartment);
		
		JLabel departmentTextLabel = new JLabel("");
		departmentTextLabel.setText(user.getDepartment());
		GridBagConstraints gbc_departmentTextLabel = new GridBagConstraints();
		gbc_departmentTextLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departmentTextLabel.gridx = 1;
		gbc_departmentTextLabel.gridy = 14;
		contentPane.add(departmentTextLabel, gbc_departmentTextLabel);
		
		JLabel lblContractNumber = new JLabel("Contract number:");
		GridBagConstraints gbc_lblContractNumber = new GridBagConstraints();
		gbc_lblContractNumber.anchor = GridBagConstraints.EAST;
		gbc_lblContractNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblContractNumber.gridx = 0;
		gbc_lblContractNumber.gridy = 15;
		contentPane.add(lblContractNumber, gbc_lblContractNumber);
		
		JLabel contractTextLabel = new JLabel("");
		contractTextLabel.setText(String.format("%d", user.getContractNumber()));
		GridBagConstraints gbc_contractTextLabel = new GridBagConstraints();
		gbc_contractTextLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contractTextLabel.gridx = 1;
		gbc_contractTextLabel.gridy = 15;
		contentPane.add(contractTextLabel, gbc_contractTextLabel);
		
		GridBagConstraints gbc_additionalIfnoButton = new GridBagConstraints();
		gbc_additionalIfnoButton.gridx = 4;
		gbc_additionalIfnoButton.gridy = 17;
		contentPane.add(additionalIfnoButton, gbc_additionalIfnoButton);
	}
}
