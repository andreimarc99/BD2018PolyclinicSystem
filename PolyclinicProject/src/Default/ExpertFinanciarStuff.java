package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ExpertFinanciarStuff extends JFrame {

	private JPanel contentPane;
	private JTextField idTxtFld;
	private JTextField fNameTxtFld;
	private JTextField lNameTxtFld;
	private JTextField monthTxtFld;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ExpertFinanciarStuff frame = new ExpertFinanciarStuff();
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
	public ExpertFinanciarStuff(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 540);
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
				UserWindow userWindow = new UserWindow(user.getUsername());
				setVisible(false);
				userWindow.setVisible(true);
			}
		});
		contentPane.add(btnBack);

		UserService userService = new UserService();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 94, 469, 320);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton btnViewMyTimetable = new JButton("View my timetable");
		btnViewMyTimetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				textArea.append("GENERIC TIMETABLE" + "\n");
				for (String s : userService.retrieveGenericTimetable(user)) {
					textArea.append(s + "\n");
				}
			}
		});
		btnViewMyTimetable.setBounds(10, 94, 206, 188);
		contentPane.add(btnViewMyTimetable);

		JButton btnCheckMedicalUnit = new JButton("Check medical unit program");
		btnCheckMedicalUnit.setBounds(10, 393, 206, 21);
		btnCheckMedicalUnit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(null);
				int id = 0;
				if (idTxtFld.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please complete the medical unit field.");
				} else {
					try {
						id = Integer.parseInt(idTxtFld.getText().trim());
					} catch (NumberFormatException e4) {
						JOptionPane.showMessageDialog(null, "ID should be an integer!");
					}
					try {
						for (String s : userService.retrieveMedicalUnitProgram(id)) {
							textArea.append(s + "\n");
						}
					} catch (NullPointerException e3) {
						JOptionPane.showMessageDialog(null, "Not a valid ID.");
					}
				}
			}
		});
		contentPane.add(btnCheckMedicalUnit);

		idTxtFld = new JTextField();
		idTxtFld.setBounds(10, 349, 206, 19);
		contentPane.add(idTxtFld);
		idTxtFld.setColumns(10);

		JLabel lblEnterId = new JLabel("Enter ID:");
		lblEnterId.setBounds(10, 330, 206, 13);
		contentPane.add(lblEnterId);

		JButton btnSalaries = new JButton("Salaries");
		btnSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userService.calculateSalary();
				JOptionPane.showMessageDialog(null, "Salaries calculated.");
			}
		});
		btnSalaries.setBounds(233, 393, 85, 21);
		contentPane.add(btnSalaries);

		fNameTxtFld = new JTextField();
		fNameTxtFld.setBounds(380, 473, 135, 19);
		contentPane.add(fNameTxtFld);
		fNameTxtFld.setColumns(10);

		lNameTxtFld = new JTextField();
		lNameTxtFld.setBounds(525, 473, 135, 19);
		contentPane.add(lNameTxtFld);
		lNameTxtFld.setColumns(10);

		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(380, 452, 92, 13);
		contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(525, 450, 100, 13);
		contentPane.add(lblLastName);

		JButton btnViewSalaries = new JButton("View");
		btnViewSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fNameTxtFld.getText().isEmpty() || lNameTxtFld.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill in both the first name and the last name");
				} else {
					textArea.setText(null);
					if (userService.viewSalaryByName(fNameTxtFld.getText().trim(), lNameTxtFld.getText().trim()) != null) {
						textArea.append(userService.viewSalaryByName(fNameTxtFld.getText().trim(), lNameTxtFld.getText().trim()));
					} else {
						JOptionPane.showMessageDialog(null, "Wrong name");
					}
				}
			}
		});
		btnViewSalaries.setBounds(670, 472, 127, 21);
		contentPane.add(btnViewSalaries);

		JLabel lblProfitForA = new JLabel("Profit for a month:");
		lblProfitForA.setBounds(10, 452, 151, 13);
		contentPane.add(lblProfitForA);

		monthTxtFld = new JTextField();
		monthTxtFld.setBounds(10, 473, 135, 19);
		contentPane.add(monthTxtFld);
		monthTxtFld.setColumns(10);

		JButton btnCheck = new JButton("Calculate");
		btnCheck.setBounds(158, 472, 109, 21);
		btnCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (monthTxtFld.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insert date");
				} else {
					DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
					Date date = new Date();
					try {
						date = (Date) format.parse(monthTxtFld.getText().trim());
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						String profit = userService.calculateProfit(sqlDate);
						textArea.setText(null);
						textArea.append(profit);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Incorrect format");
						;
						user.setEmploymentDate(null);
					}
				}
			}
		});
		contentPane.add(btnCheck);
	}
}
