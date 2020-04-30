package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JPasswordField;

public class AdminIntermediateWindow extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private final String adminPassword = "admin";

	/**
	 * Launch the application.
	 */
//	public static void adminIntermediateNewWindow() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminIntermediateWindow frame = new AdminIntermediateWindow();
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
	public AdminIntermediateWindow(String username) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyLog myLog = new MyLog();
				myLog.loginNewScreen();
				close();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		contentPane.add(btnBack, gbc_btnBack);
		
		JLabel enterPassLabel = new JLabel("Enter admin password");
		GridBagConstraints gbc_enterPassLabel = new GridBagConstraints();
		gbc_enterPassLabel.anchor = GridBagConstraints.WEST;
		gbc_enterPassLabel.insets = new Insets(0, 0, 5, 0);
		gbc_enterPassLabel.gridx = 1;
		gbc_enterPassLabel.gridy = 1;
		contentPane.add(enterPassLabel, gbc_enterPassLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		passwordField.setColumns(15);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getText().trim().equals(adminPassword)) {
					JOptionPane.showMessageDialog(null, "Successfully connected");
					setVisible(false);
					AdminWindow adminWindow = new AdminWindow(username);
					adminWindow.setVisible(true);
				} else { 
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
				}
			}
		});
		GridBagConstraints gbc_btnVerify = new GridBagConstraints();
		gbc_btnVerify.anchor = GridBagConstraints.EAST;
		gbc_btnVerify.gridx = 1;
		gbc_btnVerify.gridy = 4;
		contentPane.add(btnVerify, gbc_btnVerify);
	}

}
