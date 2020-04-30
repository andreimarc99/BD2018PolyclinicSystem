package Default;

import java.awt.Component;
import java.awt.EventQueue;
//import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import org.graalvm.compiler.lir.LIRInstruction.Use;

//import net.proteanit.sql.DbUtils;

public class InvestigationChooser {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField investigationTxtFld;
	private JTextField docFirstNameTxtFld;
	private JTextField docLastNameTxtFld;
	private JTextField patFirstNameTxtFld;
	private JTextField patLastNameTxtFld;
	private JTextField dateTimeTxtFld;
	private JTextField patCnpTxtFld;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InvestigationChooser window = new InvestigationChooser();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public InvestigationChooser(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 601);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 877, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		UserService userService = new UserService();
		List<User> users = userService.findAll();

		JLabel lblEnterInvestigationName = new JLabel("Enter investigation name:");
		lblEnterInvestigationName.setHorizontalAlignment(SwingConstants.CENTER);

		investigationTxtFld = new JTextField();
		investigationTxtFld.setHorizontalAlignment(SwingConstants.CENTER);
		investigationTxtFld.setColumns(20);

		JLabel abilityField = new JLabel("");
		
		List<String> investigations = new ArrayList<String>();
		JButton addButton = new JButton("Add investigation");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				investigations.add(investigationTxtFld.getText().trim());
			}
		});

		JButton doneButton = new JButton("Done");
		
		doneButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				boolean okDate = false;
				boolean okDoc = false;
				java.sql.Timestamp sqlDate = null;
				try {
					date = (Date) format.parse(dateTimeTxtFld.getText().trim());
					sqlDate = new java.sql.Timestamp(date.getTime());
					okDate = true;
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					okDate = false;
				}
				
				User ourUser = new User();
				for (User userSearcher : users) {
					if (userSearcher.getFirstName().equals(docFirstNameTxtFld.getText().trim())
							&& userSearcher.getLastName().equals(docLastNameTxtFld.getText().trim())) {
						ourUser = userSearcher;
						okDoc = true;
						break;
					}
				}
				final User doctor = ourUser;

				if (okDoc == true) {
					if (dateTimeTxtFld.getText().isEmpty() || patLastNameTxtFld.getText().isEmpty()
							|| patFirstNameTxtFld.getText().isEmpty() || docFirstNameTxtFld.getText().isEmpty()
							|| docLastNameTxtFld.getText().isEmpty() || patCnpTxtFld.getText().trim().isEmpty() 
							|| patCnpTxtFld.getText().trim().length() != 13) {
						JOptionPane.showMessageDialog(null, "All fields must be completed to continue");
					} else if (okDate == false) {
						JOptionPane.showMessageDialog(null, "Incorrect date format. Try again");
					} else {
						userService.addAppointment(doctor, patFirstNameTxtFld.getText().trim(), patLastNameTxtFld.getText().trim(),
								patCnpTxtFld.getText().trim(), sqlDate);

						for (String s : investigations) {
							userService.addAppointmentServices(doctor, patFirstNameTxtFld.getText().trim(), 
									patLastNameTxtFld.getText().trim(), s);
						}
						JOptionPane.showMessageDialog(null, "Successfully created appointment");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Inexistent doctor. Try again");
				}
			}
		});
			
		JLabel lblPrice = new JLabel("Price");

		JLabel lblDuration = new JLabel("Duration");

		JLabel lblAbility = new JLabel("Ability");

		JLabel lblSpeciality = new JLabel("Speciality");

		JLabel durationField = new JLabel("");

		JLabel specialityField = new JLabel("");

		JLabel priceField = new JLabel("");

		JButton verifyButton = new JButton("Verify");
		verifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService userService = new UserService();
				InvestigationData investigationData = new InvestigationData();
				investigationData = userService.searchInvestigation(investigationTxtFld.getText().trim());
				if (investigationData.getPrice() != 0.0) {
					priceField.setText(String.format("%f", investigationData.getPrice()));
					durationField.setText(String.format("%d", investigationData.getDuration()));
					abilityField.setText(investigationData.getAbility());
					specialityField.setText(investigationData.getSpecialityName());
					abilityField.setText(investigationData.getAbility());
				} else {
					JOptionPane.showMessageDialog(null, "Invalid investigation. Try again");
				}
			}
		});
		
		JLabel lblDoctorsFirstName = new JLabel("Doctor's first name:");
		
		docFirstNameTxtFld = new JTextField();
		docFirstNameTxtFld.setColumns(10);
		
		JLabel lblDoctorsLastName = new JLabel("Doctor's last name:");
		
		docLastNameTxtFld = new JTextField();
		docLastNameTxtFld.setColumns(10);
		
		JLabel lblPatientsFirstName = new JLabel("Patient's first name:");
		
		patFirstNameTxtFld = new JTextField();
		patFirstNameTxtFld.setColumns(10);
		
		JLabel lblPatientsLastName = new JLabel("Patient's last name:");
		
		patLastNameTxtFld = new JTextField();
		patLastNameTxtFld.setColumns(10);
		
		JLabel lblDateTime = new JLabel("Date & time:");
		
		dateTimeTxtFld = new JTextField();
		dateTimeTxtFld.setColumns(10);
		
		JLabel lblPatientsCnp = new JLabel("Patient's CNP:");
		
		patCnpTxtFld = new JTextField();
		patCnpTxtFld.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				UserWindow userWindow = new UserWindow(user.getUsername());
//				getFrame().setVisible(false);
//				userWindow.setVisible(true);
				ReceptionerAction receptionerAction = new ReceptionerAction(user);
				getFrame().setVisible(false);
				receptionerAction.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDateTime, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblDoctorsFirstName, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(docLastNameTxtFld, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
													.addComponent(docFirstNameTxtFld, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
													.addComponent(dateTimeTxtFld, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblDoctorsLastName, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(12)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAbility, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSpeciality, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(investigationTxtFld, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
														.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
															.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(priceField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblPrice))
															.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
															.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(verifyButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
																.addComponent(addButton))))
													.addGap(48))
												.addComponent(specialityField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(durationField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(abilityField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
												.addComponent(lblDuration, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(85)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(patFirstNameTxtFld, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
												.addComponent(patLastNameTxtFld)
												.addComponent(patCnpTxtFld)
												.addComponent(lblPatientsLastName, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
												.addComponent(lblPatientsFirstName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblPatientsCnp, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEnterInvestigationName, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
							.addGap(49))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(802, Short.MAX_VALUE)
					.addComponent(doneButton)
					.addGap(56))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(lblPrice)
							.addGap(6)
							.addComponent(priceField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBack)
								.addComponent(lblEnterInvestigationName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(investigationTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(verifyButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addButton)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDuration, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(durationField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(lblAbility)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(abilityField, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSpeciality)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(specialityField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDoctorsFirstName)
						.addComponent(lblPatientsFirstName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(patFirstNameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(docFirstNameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPatientsLastName)
						.addComponent(lblDoctorsLastName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(patLastNameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(docLastNameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateTime)
						.addComponent(lblPatientsCnp))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateTimeTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(patCnpTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(doneButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
