package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicalReport extends JFrame {

	private JPanel contentPane;
	private JTextField diagnosticTextField;
	private JTextField symptomsTxtFld;
	private JTextField recomTxtFld;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MedicalReport frame = new MedicalReport();
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
	public MedicalReport(User user, int appointmentId) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentManagement appointmentManagement = new AppointmentManagement(user);
				setVisible(false);
				appointmentManagement.setVisible(true);
			}
		});
		btnBack.setBounds(10, 10, 85, 21);
		contentPane.add(btnBack);
		
		JLabel lblDiagnostic = new JLabel("Diagnostic");
		lblDiagnostic.setBounds(94, 55, 121, 13);
		contentPane.add(lblDiagnostic);
		
		diagnosticTextField = new JTextField();
		diagnosticTextField.setBounds(94, 78, 312, 45);
		contentPane.add(diagnosticTextField);
		diagnosticTextField.setColumns(10);
		
		JLabel lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setBounds(94, 133, 121, 13);
		contentPane.add(lblSymptoms);
		
		symptomsTxtFld = new JTextField();
		symptomsTxtFld.setColumns(10);
		symptomsTxtFld.setBounds(94, 156, 312, 45);
		contentPane.add(symptomsTxtFld);
		
		JLabel lblRecommendations = new JLabel("Recommendations");
		lblRecommendations.setBounds(94, 211, 121, 13);
		contentPane.add(lblRecommendations);
		
		recomTxtFld = new JTextField();
		recomTxtFld.setColumns(10);
		recomTxtFld.setBounds(94, 234, 312, 45);
		contentPane.add(recomTxtFld);
		
		UserService userService = new UserService();
		
		JButton btnSaveReport = new JButton("Save report");
		btnSaveReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (diagnosticTextField.getText().isEmpty() || symptomsTxtFld.getText().isEmpty() || recomTxtFld.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields must be completed");
				} else {
					userService.updateMedicalReport(appointmentId, symptomsTxtFld.getText().trim(), 
							diagnosticTextField.getText().trim(), recomTxtFld.getText().trim());
					JOptionPane.showMessageDialog(null, "Successfully saved.");
				}
			}
		});
		btnSaveReport.setBounds(447, 326, 129, 21);
		contentPane.add(btnSaveReport);
	}
}
