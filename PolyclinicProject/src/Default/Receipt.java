package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Receipt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Receipt frame = new Receipt();
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
	public Receipt(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 384, 335);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		UserService userService = new UserService();
		for (String s : userService.retrieveAllAppointments()) {
			textArea.append(s + "\n");
		}
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(442, 72, 182, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(539, 107, 85, 21);
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					int id = Integer.parseInt(textField.getText().trim());
					userService.generateReceipt(id);
					JOptionPane.showMessageDialog(null, "Receipt generated");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Enter an integer!");
				}
			}
		});
		contentPane.add(btnEnter);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 10, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ReceptionerAction receptionerAction = new ReceptionerAction(user);
				setVisible(false);
				receptionerAction.setVisible(true);
			}
		});
		contentPane.add(btnBack);
	}

}
