package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

public class IntroduceUserToViewInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IntroduceUserToViewInfo frame = new IntroduceUserToViewInfo();
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
	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	public IntroduceUserToViewInfo(User admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblIntroduceAValid = new JLabel("Introduce a valid username:");
		GridBagConstraints gbc_lblIntroduceAValid = new GridBagConstraints();
		gbc_lblIntroduceAValid.insets = new Insets(0, 0, 5, 0);
		gbc_lblIntroduceAValid.anchor = GridBagConstraints.WEST;
		gbc_lblIntroduceAValid.gridx = 1;
		gbc_lblIntroduceAValid.gridy = 0;
		contentPane.add(lblIntroduceAValid, gbc_lblIntroduceAValid);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService userService = new UserService();
				List<User> users = userService.findAll();
				User ourUser = new User();
				for (User userSearcher : users) {
					if (userSearcher.getUsername().equals(textField.getText().trim())) {
						ourUser = userSearcher;
						break;
					} else ourUser = null;
				}
				final User user = ourUser;
				
				if (textField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
				} else if (user == null) {
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
				} else {
					UserWindow userWindow = new UserWindow(textField.getText().trim());
					setVisible(false);
					userWindow.setVisible(true);
//					close();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
