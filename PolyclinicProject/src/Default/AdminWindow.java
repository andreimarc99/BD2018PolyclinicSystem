package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class AdminWindow extends JFrame {

	private JPanel contentPane;
	private String username;

	/**
	 * Launch the application.
	 */
//	public static void newWindowAdmin() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminWindow frame = new AdminWindow();
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
	public AdminWindow(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 773, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		UserService userService = new UserService();
		List<User> users = userService.findAll();
		User ourUser = new User();
		for (User userSearcher : users) {
			if (userSearcher.getUsername().equals(username)) {
				ourUser = userSearcher;
				break;
			}
		}
		final User admin = ourUser;
		
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
		
		JLabel informationLabel = new JLabel("");
		informationLabel.setText(admin.getFirstName() + " " + admin.getLastName() + "'s information: " );
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 0;
		gbc_infoLabel.gridy = 1;
		contentPane.add(informationLabel, gbc_infoLabel);
		
		JLabel firstNameConstantLabel = new JLabel("First name: ");
		GridBagConstraints gbc_fNameConstLabel = new GridBagConstraints();
		gbc_fNameConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fNameConstLabel.gridx = 0;
		gbc_fNameConstLabel.gridy = 2;
		contentPane.add(firstNameConstantLabel, gbc_fNameConstLabel);
		
		JLabel firstNameLabel = new JLabel("");
		firstNameLabel.setText(admin.getFirstName());
		GridBagConstraints gbc_fNameLabel = new GridBagConstraints();
		gbc_fNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fNameLabel.gridx = 1;
		gbc_fNameLabel.gridy = 2;
		contentPane.add(firstNameLabel, gbc_fNameLabel);
		
		JLabel lastNameConstantLabel = new JLabel("Last name: ");
		GridBagConstraints gbc_lNameConstLabel = new GridBagConstraints();
		gbc_lNameConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lNameConstLabel.gridx = 0;
		gbc_lNameConstLabel.gridy = 3;
		contentPane.add(lastNameConstantLabel, gbc_lNameConstLabel);
		
		JLabel lastNameLabel = new JLabel("");
		lastNameLabel.setText(admin.getLastName());
		GridBagConstraints gbc_lNameLabel = new GridBagConstraints();
		gbc_lNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lNameLabel.gridx = 1;
		gbc_lNameLabel.gridy = 3;
		contentPane.add(lastNameLabel, gbc_lNameLabel);
		
		JLabel addressConstantLabel = new JLabel("Address: ");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 4;
		contentPane.add(addressConstantLabel, gbc_addressLabel);
		
		JLabel addressLabel = new JLabel("");
		addressLabel.setText(admin.getAddress());
		GridBagConstraints gbc_adLabel = new GridBagConstraints();
		gbc_adLabel.insets = new Insets(0, 0, 5, 5);
		gbc_adLabel.gridx = 1;
		gbc_adLabel.gridy = 4;
		contentPane.add(addressLabel, gbc_adLabel);
		
		JLabel telephoneConstantLabel = new JLabel("Telephone number: ");
		GridBagConstraints gbc_telConstLabel = new GridBagConstraints();
		gbc_telConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telConstLabel.gridx = 0;
		gbc_telConstLabel.gridy = 5;
		contentPane.add(telephoneConstantLabel, gbc_telConstLabel);
		
		JLabel telephoneLabel = new JLabel("");
		telephoneLabel.setText(admin.getTelephoneNumber());
		GridBagConstraints gbc_telLabel = new GridBagConstraints();
		gbc_telLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telLabel.gridx = 1;
		gbc_telLabel.gridy = 5;
		contentPane.add(telephoneLabel, gbc_telLabel);
		
		JLabel emailConstantLabel = new JLabel("E-mail: ");
		GridBagConstraints gbc_emailConstLabel = new GridBagConstraints();
		gbc_emailConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailConstLabel.gridx = 0;
		gbc_emailConstLabel.gridy = 6;
		contentPane.add(emailConstantLabel, gbc_emailConstLabel);
		
		JLabel emailLabel  = new JLabel("");
		emailLabel.setText(admin.getEmail());
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 1;
		gbc_emailLabel.gridy = 6;
		contentPane.add(emailLabel, gbc_emailLabel);
		
		JLabel cnpConstantLabel = new JLabel("CNP: ");
		GridBagConstraints gbc_cnpConstLabel = new GridBagConstraints();
		gbc_cnpConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cnpConstLabel.gridx = 0;
		gbc_cnpConstLabel.gridy = 7;
		contentPane.add(cnpConstantLabel, gbc_cnpConstLabel);
		
		JLabel cnpLabel = new JLabel("");
		cnpLabel.setText(admin.getCNP());
		GridBagConstraints gbc_cnpLabel = new GridBagConstraints();
		gbc_cnpLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cnpLabel.gridx = 1;
		gbc_cnpLabel.gridy = 7;
		contentPane.add(cnpLabel, gbc_cnpLabel);
		
		JLabel jobConstLabel = new JLabel("Job: ");
		GridBagConstraints gbc_jobConstLabel = new GridBagConstraints();
		gbc_jobConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jobConstLabel.gridx = 0;
		gbc_jobConstLabel.gridy = 8;
		contentPane.add(jobConstLabel, gbc_jobConstLabel);
		
		JLabel jobLabel = new JLabel("");
		jobLabel.setText(admin.getJob());
		GridBagConstraints gbc_jobLabel = new GridBagConstraints();
		gbc_jobLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jobLabel.gridx = 1;
		gbc_jobLabel.gridy = 8;
		contentPane.add(jobLabel, gbc_jobLabel);
		
		JLabel ibanConstLabel = new JLabel("IBAN: ");
		GridBagConstraints gbc_ibanConstLabel = new GridBagConstraints();
		gbc_ibanConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ibanConstLabel.gridx = 0;
		gbc_ibanConstLabel.gridy = 9;
		contentPane.add(ibanConstLabel, gbc_ibanConstLabel);
		
		JLabel ibanLabel = new JLabel("");
		ibanLabel.setText(admin.getIban());
		GridBagConstraints gbc_ibanLabel = new GridBagConstraints();
		gbc_ibanLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ibanLabel.gridx = 1;
		gbc_ibanLabel.gridy = 9;
		contentPane.add(ibanLabel, gbc_ibanLabel);
		
		JLabel emplDateConstLabel = new JLabel("Employment date: ");
		GridBagConstraints gbc_emplConstLabel = new GridBagConstraints();
		gbc_emplConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emplConstLabel.gridx = 0;
		gbc_emplConstLabel.gridy = 10;
		contentPane.add(emplDateConstLabel, gbc_emplConstLabel);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = admin.getEmploymentDate();
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
		gbc_idConstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_idConstLabel.gridx = 0;
		gbc_idConstLabel.gridy = 11;
		contentPane.add(idConstLabel, gbc_idConstLabel);
		
		JButton changeMyInfoButton = new JButton("Change my information");
		changeMyInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoChanger infoChanger = new InfoChanger(admin, admin);
				infoChanger.setVisible(true);
				close();
			}
		});
		
		JLabel idLabel = new JLabel("");
		idLabel.setText(admin.getStringID());
		GridBagConstraints gbc_idLabel = new GridBagConstraints();
		gbc_idLabel.insets = new Insets(0, 0, 5, 5);
		gbc_idLabel.gridx = 1;
		gbc_idLabel.gridy = 11;
		contentPane.add(idLabel, gbc_idLabel);
		
		JLabel salaryLabel = new JLabel("Salary:");
		GridBagConstraints gbc_salaryLabel = new GridBagConstraints();
		gbc_salaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaryLabel.gridx = 0;
		gbc_salaryLabel.gridy = 12;
		contentPane.add(salaryLabel, gbc_salaryLabel);
		
		JLabel salaryTextLabel = new JLabel("");
		salaryTextLabel.setText(String.format("%d", admin.getSalary()));
		GridBagConstraints gbc_salaryTextLabel = new GridBagConstraints();
		gbc_salaryTextLabel.gridx = 1;
		gbc_salaryTextLabel.gridy = 12;
		contentPane.add(salaryTextLabel, gbc_salaryTextLabel);
		
		JLabel noOfHoursLabel = new JLabel("Number of hours:");
		GridBagConstraints gbc_noOfHoursLabel = new GridBagConstraints();
		gbc_noOfHoursLabel.insets = new Insets(0, 0, 5, 5);
		gbc_noOfHoursLabel.gridx = 0;
		gbc_noOfHoursLabel.gridy = 13;
		contentPane.add(noOfHoursLabel, gbc_noOfHoursLabel);
		
		JLabel hoursTextLabel = new JLabel("");
		hoursTextLabel.setText(String.format("%d", admin.getNoOfHours()));
		GridBagConstraints gbc_hourTxtLbl = new GridBagConstraints();
		gbc_hourTxtLbl.gridx = 1;
		gbc_hourTxtLbl.gridy = 13;
		contentPane.add(hoursTextLabel, gbc_hourTxtLbl);
		
		GridBagConstraints gbc_changeMyInfoBtn = new GridBagConstraints();
		gbc_changeMyInfoBtn.insets = new Insets(0, 0, 0, 5);
		gbc_changeMyInfoBtn.gridx = 0;
		gbc_changeMyInfoBtn.gridy = 15;
		contentPane.add(changeMyInfoButton, gbc_changeMyInfoBtn);
		
		JButton changeUserButton = new JButton("Change another user's information");
		changeUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroduceValidUser introduceValidUser = new IntroduceValidUser(admin);
				introduceValidUser.setVisible(true);
				close();
			}
		});
		GridBagConstraints gbc_changeUserInfo = new GridBagConstraints();
		gbc_changeUserInfo.insets = new Insets(0, 0, 0, 5);
		gbc_changeUserInfo.gridy = 15;
		gbc_changeUserInfo.gridx = 1;
		gbc_changeMyInfoBtn.gridy = 12;
		contentPane.add(changeUserButton, gbc_changeUserInfo);
		
		JButton viewUserButton = new JButton("View another user's information");
		viewUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroduceUserToViewInfo introduceUserToViewInfo = new IntroduceUserToViewInfo(admin);
				introduceUserToViewInfo.setVisible(true);
				close();
			}
		});
		GridBagConstraints gbc_viewUserInfo = new GridBagConstraints();
		gbc_viewUserInfo.gridx = 2;
		gbc_viewUserInfo.gridy = 15;
		contentPane.add(viewUserButton, gbc_viewUserInfo);
	}

}
