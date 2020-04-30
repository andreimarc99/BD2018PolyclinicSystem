package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AppointmentManagement extends JFrame {

	private JPanel contentPane;
	private JTextField appointTxtFld;
	private JTextField medServTxtFld;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AppointmentManagement frame = new AppointmentManagement();
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
	public AppointmentManagement(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 23, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MedicView medicView = new MedicView(user);
				setVisible(false);
				medicView.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		
		appointTxtFld = new JTextField();
		appointTxtFld.setBounds(328, 73, 124, 19);
		contentPane.add(appointTxtFld);
		appointTxtFld.setColumns(10);
		
		UserService userService = new UserService();
		
		JLabel lblEnterAppointmentService = new JLabel("Enter appointment service you wish to delete:");
		lblEnterAppointmentService.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAppointmentService.setBounds(340, 27, 280, 13);
		contentPane.add(lblEnterAppointmentService);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (appointTxtFld.getText().trim().isEmpty() || medServTxtFld.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Complete all the fields");
				} else {
					try {
						int apId = Integer.parseInt(appointTxtFld.getText().trim());
						int medId = Integer.parseInt(medServTxtFld.getText().trim());
						userService.deleteMedicalService(medId, apId);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Enter an integer!");
					}
				}
			}
		});
		btnDelete.setBounds(535, 100, 85, 21);
		contentPane.add(btnDelete);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 131, 622, 379);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		JButton btnViewMyAppointments = new JButton("View my appointments");
		btnViewMyAppointments.setBounds(328, 102, 185, 21);
		btnViewMyAppointments.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(null);
				List<String> services = userService.retrieveMedicalServicesForDoctor(user);
				for (String s : services) {
					textArea.append(s + "\n");
				}
			}
		});
		contentPane.add(btnViewMyAppointments);
		
		JLabel lblAppointmentId = new JLabel("Appointment ID");
		lblAppointmentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAppointmentId.setBounds(345, 50, 107, 13);
		contentPane.add(lblAppointmentId);
		
		medServTxtFld = new JTextField();
		medServTxtFld.setBounds(496, 73, 124, 19);
		contentPane.add(medServTxtFld);
		medServTxtFld.setColumns(10);
		
		JLabel lblMedicalServiceId = new JLabel("Medical service ID");
		lblMedicalServiceId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMedicalServiceId.setBounds(496, 50, 124, 13);
		contentPane.add(lblMedicalServiceId);
		
		JButton btnCreateAMedical = new JButton("Create a medical report for this appointment");
		btnCreateAMedical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int apId = Integer.parseInt(appointTxtFld.getText().trim());
					userService.addMedicalReport(apId);
					MedicalReport medicalReport = new MedicalReport(user, apId);
					setVisible(false);
					medicalReport.setVisible(true);
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(null, "ID should be an integer!");
				}
			}
		});
		btnCreateAMedical.setBounds(10, 102, 292, 21);
		contentPane.add(btnCreateAMedical);
		
		JButton btnViewMedicalReport = new JButton("View medical report for this appointment");
		btnViewMedicalReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int apId = Integer.parseInt(appointTxtFld.getText().trim());
					ViewMedicalReportByID viewMedicalReportByID = new ViewMedicalReportByID(user, apId);
					setVisible(false);
					viewMedicalReportByID.setVisible(true);
				} catch (NumberFormatException e4) {
					JOptionPane.showMessageDialog(null, "ID should be an integer!");
				}
			}
		});
		btnViewMedicalReport.setBounds(10, 72, 292, 21);
		contentPane.add(btnViewMedicalReport);
	}

}
