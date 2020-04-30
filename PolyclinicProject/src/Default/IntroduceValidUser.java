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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;

public class IntroduceValidUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IntroduceValidUser frame = new IntroduceValidUser();
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
	public IntroduceValidUser(User admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 326, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblEnterTheUsers = new JLabel("Enter the user's username:");
		GridBagConstraints gbc_lblEnterTheUsers = new GridBagConstraints();
		gbc_lblEnterTheUsers.anchor = GridBagConstraints.WEST;
		gbc_lblEnterTheUsers.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnterTheUsers.gridx = 2;
		gbc_lblEnterTheUsers.gridy = 2;
		contentPane.add(lblEnterTheUsers, gbc_lblEnterTheUsers);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(15);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok = false;
				UserService userService = new UserService();
				List<User> users = userService.findAll();
				User ourUser = new User();
				for (User userSearcher : users) {
					if (userSearcher.getUsername().equals(textField.getText().trim())) {
						ourUser = userSearcher;
						ok = true;
						break;
					}
				}
				if (ok == false) {
					ourUser = null;
				}
				final User user = ourUser;
				if (textField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
				} else if (user == null) {
					JOptionPane.showMessageDialog(null, "Incorrect data. Try again");
				} else if ((userService.getUserType(user.getUsername()).equalsIgnoreCase("Administrator") 
						&& userService.getUserType(admin.getUsername()).equalsIgnoreCase("Administrator")) 
						|| (userService.getUserType(user.getUsername()).equalsIgnoreCase("Super-administrator") 
						&& userService.getUserType(admin.getUsername()).equalsIgnoreCase("Administrator"))) {
					JOptionPane.showMessageDialog(null, "You do not have the authority to do that!");
				} else {
					InfoChanger infoChanger = new InfoChanger(admin, user);
					infoChanger.setVisible(true);
					close();
				}
			}
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.anchor = GridBagConstraints.EAST;
		gbc_btnGo.gridx = 2;
		gbc_btnGo.gridy = 4;
		contentPane.add(btnGo, gbc_btnGo);

	}

}
