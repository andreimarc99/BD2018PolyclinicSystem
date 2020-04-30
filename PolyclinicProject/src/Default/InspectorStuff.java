package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import jdk.nashorn.internal.scripts.JS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class InspectorStuff extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTxtFld;
	private JTextField lastNameTxtFld;
	private JTextField jobTxtFld;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InspectorStuff frame = new InspectorStuff();
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
	public InspectorStuff(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 773, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Search after the employee's name:");
		lblNewLabel.setBounds(10, 58, 213, 13);
		contentPane.add(lblNewLabel);

		firstNameTxtFld = new JTextField();
		firstNameTxtFld.setBounds(10, 104, 158, 19);
		contentPane.add(firstNameTxtFld);
		firstNameTxtFld.setColumns(10);

		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(10, 81, 96, 13);
		contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(10, 133, 96, 13);
		contentPane.add(lblLastName);

		lastNameTxtFld = new JTextField();
		lastNameTxtFld.setBounds(10, 156, 158, 19);
		contentPane.add(lastNameTxtFld);
		lastNameTxtFld.setColumns(10);

		JTextArea textArea = new JTextArea(10, 10);
		textArea.setBounds(10, 13, 250, 20);
		contentPane.add(textArea);
		
		JScrollPane jScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(10, 200, 700, 320);
		contentPane.add(jScrollPane);
		
		UserService userService = new UserService();
		List<User> users = userService.findAll();

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(178, 155, 85, 21);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (firstNameTxtFld.getText().trim().isEmpty() || lastNameTxtFld.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please complete all the fields");
				} else {
					boolean ok = false;
					User ourUser = new User();
					for (User u : users) {
						if (u.getFirstName().equalsIgnoreCase(firstNameTxtFld.getText().trim())
								&& u.getLastName().equalsIgnoreCase(lastNameTxtFld.getText().trim())) {
							ourUser = u;
							ok = true;
							break;
						}
					}
					if (ok == true) {
						textArea.setText(null);
						textArea.append(ourUser.getFirstName() + " " + ourUser.getLastName() + ": \n");
						textArea.append("\nGENERIC TIMETABLE\n");
						for (String s : userService.retrieveGenericTimetable(ourUser)) {
							textArea.append(s + "\n");
						}
						textArea.append("\nSPECIFIC TIMETABLE \n");
						if (ourUser.getJob().equals("Medic") && ourUser.getJob().equals("Medic")
								&& ourUser.getJob().equals("Medic")) {
							try {
								List<String> specTimetable = userService.retrieveSpecificTimetable(ourUser);
								for (String s : specTimetable) {
										textArea.append(s + "\n");
								}
							} catch (NullPointerException e1) {
								textArea.append("The employee does not have a specific timetable. \n");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect name. Try again");
					}
				}
			}
		});
		contentPane.add(btnSearch);

		JLabel lblSearchAfterThe = new JLabel("Search after the employee's job:");
		lblSearchAfterThe.setBounds(406, 58, 213, 13);
		contentPane.add(lblSearchAfterThe);

		jobTxtFld = new JTextField();
		jobTxtFld.setBounds(406, 85, 158, 19);
		contentPane.add(jobTxtFld);
		jobTxtFld.setColumns(10);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				if (jobTxtFld.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please complete the job field.");
				} else if (jobTxtFld.getText().trim().equalsIgnoreCase("Medic") || jobTxtFld.getText().trim().equalsIgnoreCase("Asistent medical")
						|| jobTxtFld.getText().trim().equalsIgnoreCase("Inspector resurse umane") || jobTxtFld.getText().trim().equalsIgnoreCase("Receptioner")
						|| jobTxtFld.getText().trim().equalsIgnoreCase("Expert financiar-contabil")) {
					for (String s : userService.retrieveGenericTimetableByJob(jobTxtFld.getText().trim())) {
						textArea.append(s + "\n");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not a valid job. Try again");
				}
			}
		});
		btnSearch_1.setBounds(574, 84, 85, 21);
		contentPane.add(btnSearch_1);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 10, 85, 21);
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserWindow userWindow = new UserWindow(user.getUsername());
				setVisible(false);
				userWindow.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		
		JLabel lblViewAMedical = new JLabel("View a medical unit's program by ID:");
		lblViewAMedical.setBounds(406, 133, 253, 13);
		contentPane.add(lblViewAMedical);
		
		textField = new JTextField();
		textField.setBounds(406, 156, 158, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch_2 = new JButton("Search");
		btnSearch_2.setBounds(574, 155, 85, 21);
		btnSearch_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(null);
				int id = 0;
				try {
					id = Integer.parseInt(textField.getText().trim());
				} catch (NumberFormatException e4) {
					JOptionPane.showMessageDialog(null, "ID should be an integer!");
				}
				if (textField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please complete the medical unit field.");
				} else {
					try {
						for (String s : userService.retrieveMedicalUnitProgram(id)) {
							textArea.append(s + "\n");
						}
					} catch (NullPointerException e3) {
					}
					try {
						String prev = null;
						for (String s : userService.retrieveMedicalUnitVacations(id)) {
							if (s.equals(prev))
								;
							else textArea.append(s + "\n");
							prev = s;
						}
					}  catch (NullPointerException e3) {
						JOptionPane.showMessageDialog(null, "Not a valid ID.");
					}
				}
			}
		});
		contentPane.add(btnSearch_2);
	}
}
