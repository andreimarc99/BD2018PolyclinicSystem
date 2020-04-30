package Default;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MyLog extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JButton loginAsUserButton;
	private JButton loginAsAdminButton;
	private JButton registerButton;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void loginNewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLog frame = new MyLog();
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
	public MyLog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		getContentPane().setBackground(Color.lightGray);

		UserService userService = new UserService();
		List<User> users = userService.findAll();

		JLabel usernameLabel = new JLabel("Username");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.WEST;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 2;
		gbc_usernameLabel.gridy = 5;
		contentPane.add(usernameLabel, gbc_usernameLabel);

		usernameTextField = new JTextField();
		GridBagConstraints gbc_usernameTextField = new GridBagConstraints();
		gbc_usernameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameTextField.anchor = GridBagConstraints.WEST;
		gbc_usernameTextField.gridx = 2;
		gbc_usernameTextField.gridy = 6;
		contentPane.add(usernameTextField, gbc_usernameTextField);
		usernameTextField.setColumns(15);

		JLabel passwordLabel = new JLabel("Password");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.gridx = 2;
		gbc_passwordLabel.gridy = 8;
		contentPane.add(passwordLabel, gbc_passwordLabel);

		loginAsUserButton = new JButton("Login as user");
		loginAsUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameTextField.getText().trim().isEmpty() || pwdPassword.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
				} else {
					boolean ok = false;
					User ourUser = new User();
					for (User user : users) {
						if (user.getUsername().equals(usernameTextField.getText().trim())) {
							ourUser = user;
							ok = true;
							break;
						}
					}
					if (ok == false) {
						JOptionPane.showMessageDialog(null, "Incorrect data... Try again");
					} else if (ourUser.getPassword().equals(pwdPassword.getText().trim())) {
						setVisible(false);
						UserWindow userWindow = new UserWindow(usernameTextField.getText().trim());
						userWindow.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect data... Try again");
					}
				}
			}
		});

		registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RegisterWindow.newWindowRegister(); // registerWindow = new RegisterWindow();
				// registerWindow.newWindowRegister();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 13;
		contentPane.add(registerButton, gbc_btnNewButton);

		pwdPassword = new JPasswordField();
		pwdPassword.setText("");
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.anchor = GridBagConstraints.WEST;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 9;
		pwdPassword.setColumns(15);
		contentPane.add(pwdPassword, gbc_pwdPassword);

		GridBagConstraints gbc_loginAsUserButton = new GridBagConstraints();
		gbc_loginAsUserButton.insets = new Insets(0, 0, 5, 0);
		gbc_loginAsUserButton.anchor = GridBagConstraints.SOUTHEAST;
		gbc_loginAsUserButton.gridx = 3;
		gbc_loginAsUserButton.gridy = 12;
		contentPane.add(loginAsUserButton, gbc_loginAsUserButton);

		loginAsAdminButton = new JButton("Login as admin");
		loginAsAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameTextField.getText().trim().isEmpty() || pwdPassword.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
				} else {
					boolean ok = false;
					User ourUser = new User();
					for (User user : users) {
						if (user.getUsername().equals(usernameTextField.getText().trim())) {
							ourUser = user;
							ok = true;
							break;
						}
					}
					if (ok == false) {
						JOptionPane.showMessageDialog(null, "Incorrect data... Try again");
					} else if (userService.getUserType(ourUser.getUsername()).equalsIgnoreCase("Administrator") 
							|| userService.getUserType(ourUser.getUsername()).equalsIgnoreCase("Super-Administrator")) {
						 if (ourUser.getPassword().equals(pwdPassword.getText().trim())) {
							setVisible(false);
							AdminIntermediateWindow adminIntermediateWindow = new AdminIntermediateWindow(ourUser.getUsername());
							adminIntermediateWindow.setVisible(true);
						 } 
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect data... Try again");
					}
				}
			}
		});
		GridBagConstraints gbc_loginAsAdminButton = new GridBagConstraints();
		gbc_loginAsUserButton.insets = new Insets(0, 0, 5, 0);
		gbc_loginAsAdminButton.anchor = GridBagConstraints.SOUTHEAST;
		gbc_loginAsAdminButton.gridx = 3;
		gbc_loginAsAdminButton.gridy = 13;
		contentPane.add(loginAsAdminButton, gbc_loginAsAdminButton);
	}

}
