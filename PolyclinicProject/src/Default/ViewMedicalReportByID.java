package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import jdk.nashorn.internal.scripts.JO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewMedicalReportByID extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewMedicalReportByID frame = new ViewMedicalReportByID();
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
	public ViewMedicalReportByID(User user, int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 10, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AppointmentManagement appointmentManagement = new AppointmentManagement(user);
				setVisible(false);
				appointmentManagement.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 67, 474, 228);
		contentPane.add(scrollPane);
		
		UserService userService = new UserService();
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
//		for (String s : userService.retrieveMedicalReport(id)) {
//			
//		}
		textArea.append(userService.retrieveMedicalReport(id));
		textArea.append("\n\n");
		for (String s : userService.retrieveServicesByReport(id)) {
			textArea.append(s + "\n");
		}
		scrollPane.setViewportView(textArea);
		
		JButton btnStamp = new JButton("Stamp");
		btnStamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userService.stamp(id);
				JOptionPane.showMessageDialog(null, "Stamped.");
				textArea.setText(null);
				textArea.append(userService.retrieveMedicalReport(id));
				textArea.append("\n\n");
				for (String s : userService.retrieveServicesByReport(id)) {
					textArea.append(s + "\n");
				}
			}
		});
		btnStamp.setBounds(462, 313, 85, 21);
		contentPane.add(btnStamp);
	}

}
