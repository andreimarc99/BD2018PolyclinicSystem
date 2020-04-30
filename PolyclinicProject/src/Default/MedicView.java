package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MedicView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MedicView frame = new MedicView();
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
	public MedicView(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		UserService userService = new UserService();
		MedicData data = userService.retrieveMedicData(user);
		JLabel degreeLabel = new JLabel("Degree:");
		
		JLabel degreeTextLabel = new JLabel("");
		degreeTextLabel.setText(data.getDegree());
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow.userNewScreen(user.getUsername());
				close();
			}
		});
		
		JLabel lblStamp = new JLabel("Stamp:");
		
		JLabel stampTextLabel = new JLabel("");
		stampTextLabel.setText(data.getStamp());
		
		JLabel lblScientificTitle = new JLabel("Scientific title:");
		
		JLabel scientificTitleTextLabel = new JLabel("");
		if (data.getScientificTitle().equals("") == false) {
			scientificTitleTextLabel.setText(data.getScientificTitle());
		} else {
			scientificTitleTextLabel.setText("-");
		}
		
		JLabel lblTeachingSpot = new JLabel("Teaching spot:");
		
		JLabel teachingSpotTextLabel = new JLabel("");
		if (data.getTeachingSpot().equals("") == false) {
			teachingSpotTextLabel.setText(data.getTeachingSpot());
		} else {
			teachingSpotTextLabel.setText("-");
		}
		
		JLabel lblPercentageFrom = new JLabel("Percentage from");
		
		JLabel lblMedicalServices = new JLabel("medical services:");
		
		JLabel percentageTextLabel = new JLabel("");
		percentageTextLabel.setText(String.format("%f", data.getPercentage()));
		
		JTextArea specialitiesTextArea = new JTextArea();
		specialitiesTextArea.setEditable(false);
		for (String spec : userService.retrieveSpecialities(user)) {
			specialitiesTextArea.append(spec + "\n");
		}
		
		JTextArea timetableTextArea = new JTextArea();
		timetableTextArea.setEditable(false);
		
		
		JButton btnViewAppointments = new JButton("View appointments");
		btnViewAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timetableTextArea.setText(null);
				timetableTextArea.append("MY APPOINTMENTS" + "\n");
				for (String s : userService.retrieveAppointmentsForDoctor(user)) {
					timetableTextArea.append(s + "\n");
				}
			}
		});
		
		JButton btnViewMyTimetable = new JButton("View my timetable");
		btnViewMyTimetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timetableTextArea.setText(null);
				timetableTextArea.append("GENERIC TIMETABLE" + "\n");
				for (String s : userService.retrieveGenericTimetable(user)) {
					timetableTextArea.append(s + "\n");
				}
				timetableTextArea.append("SPECIFIC TIMETABLE" + "\n");
				for (String s : userService.retrieveSpecificTimetable(user)) {
					timetableTextArea.append(s + "\n");
				}
			}
		});
		
		JButton btnManageMyAppointments = new JButton("Manage my appointments");
		btnManageMyAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppointmentManagement appointmentManagement = new AppointmentManagement(user);
				appointmentManagement.setVisible(true);
				close();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblTeachingSpot, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(degreeLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStamp, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblScientificTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addComponent(lblMedicalServices, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblPercentageFrom, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(degreeTextLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(teachingSpotTextLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(scientificTitleTextLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(stampTextLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
								.addComponent(percentageTextLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(specialitiesTextArea, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(timetableTextArea, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnViewMyTimetable, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnViewAppointments, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnManageMyAppointments, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnManageMyAppointments))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(degreeLabel)
						.addComponent(degreeTextLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStamp)
						.addComponent(stampTextLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScientificTitle)
						.addComponent(scientificTitleTextLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTeachingSpot)
						.addComponent(teachingSpotTextLabel))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPercentageFrom)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMedicalServices))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(percentageTextLabel)))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnViewAppointments)
						.addComponent(btnViewMyTimetable))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(specialitiesTextArea, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addComponent(timetableTextArea, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	
	}
}
