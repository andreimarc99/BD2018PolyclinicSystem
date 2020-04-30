package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import jdk.nashorn.internal.scripts.JO;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class DetailsForMedicalAssistant extends JFrame {

	private JPanel contentPane;
	private JTextField appIdTxtFld;
	private JTextField medServTextField;
	private JTextField detailsTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DetailsForMedicalAssistant frame = new DetailsForMedicalAssistant();
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
	public DetailsForMedicalAssistant(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 108, 762, 321);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		UserService userService = new UserService();
		
		JButton btnViewAllRegistered = new JButton("View all registered patients");
		btnViewAllRegistered.setBounds(166, 48, 300, 39);
		btnViewAllRegistered.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(null);
				for (String s : userService.retrieveAllPatients()) {
					textArea.append(s + "\n");
				}
			}
		});
		contentPane.add(btnViewAllRegistered);
		
		JButton btnViewAllAppointments = new JButton("View all registered appointments");
		btnViewAllAppointments.setBounds(476, 48, 300, 39);
		btnViewAllAppointments.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(null);
				for (String s : userService.retrieveAllAppointments()) {
					textArea.append(s + "\n");
				}
			}
		});
		contentPane.add(btnViewAllAppointments);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(28, 48, 84, 39);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MedicalAssistantView assistantView = new MedicalAssistantView(user);
				setVisible(false);
				assistantView.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		
		appIdTxtFld = new JTextField();
		appIdTxtFld.setBounds(156, 439, 195, 19);
		contentPane.add(appIdTxtFld);
		appIdTxtFld.setColumns(10);
		
		JLabel lblEnterAppointmentId = new JLabel("Enter appointment ID:");
		lblEnterAppointmentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAppointmentId.setBounds(0, 442, 146, 13);
		contentPane.add(lblEnterAppointmentId);
		
		JLabel lblMedicalServiceId = new JLabel("Medical service ID:");
		lblMedicalServiceId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMedicalServiceId.setBounds(466, 442, 119, 13);
		contentPane.add(lblMedicalServiceId);
		
		medServTextField = new JTextField();
		medServTextField.setColumns(10);
		medServTextField.setBounds(595, 439, 195, 19);
		contentPane.add(medServTextField);

		JCheckBox chckbxResult = new JCheckBox("Result");
		chckbxResult.setBounds(365, 438, 95, 21);
		contentPane.add(chckbxResult);
		
		JButton btnCompleteMedicalReport = new JButton("Complete medical report for this appointment");
		btnCompleteMedicalReport.setBounds(492, 487, 300, 19);
		btnCompleteMedicalReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (medServTextField.getText().isEmpty() || lblEnterAppointmentId.getText().isEmpty()
						|| detailsTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Complete the 2 necessary fields");
				} else {
					try {
						int apId = Integer.parseInt(appIdTxtFld.getText().trim());
						int servId = Integer.parseInt(medServTextField.getText().trim());
						String details = detailsTextField.getText().trim();
						userService.updateReportAssistant(apId, servId, details);
						if (chckbxResult.isSelected()) {
							userService.addResult(apId, true);
						} else {
							userService.addResult(apId, false);
						}
						JOptionPane.showMessageDialog(null, "Successfully updated");
					} catch (NumberFormatException e5) {
						JOptionPane.showMessageDialog(null, "IDs should be integers!");
					}
				}
			}
		});
		contentPane.add(btnCompleteMedicalReport);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetails.setBounds(54, 480, 92, 13);
		contentPane.add(lblDetails);
		
		detailsTextField = new JTextField();
		detailsTextField.setBounds(156, 468, 195, 38);
		contentPane.add(detailsTextField);
		detailsTextField.setColumns(10);
	}
}
