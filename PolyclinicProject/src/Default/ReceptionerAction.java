package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ReceptionerAction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReceptionerAction frame = new ReceptionerAction();
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
	public ReceptionerAction(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserService userService = new UserService();
		List<String> timetable = userService.retrieveGenericTimetable(user);
		

		
		JTextArea timetableTextArea = new JTextArea();
		timetableTextArea.setBounds(10, 96, 346, 211);
		timetableTextArea.setEditable(false);
		contentPane.add(timetableTextArea);
		
		JButton viewTimetableButton = new JButton("Show my timetable");
		viewTimetableButton.setBounds(10, 46, 346, 27);
		viewTimetableButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timetableTextArea.setText(null);
				timetableTextArea.append("GENERIC TIMETABLE \n");
				for (String s : timetable) {
					timetableTextArea.append(s + "\n");
				}
			}
		});
		contentPane.add(viewTimetableButton);
		
		JButton makeAppointmentButton = new JButton("Make an appointment");
		makeAppointmentButton.setBounds(366, 46, 205, 261);
		makeAppointmentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InvestigationChooser chooser = new InvestigationChooser(user);
				setVisible(false);
				chooser.getFrame().setVisible(true);
			}
		});
		contentPane.add(makeAppointmentButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 10, 85, 21);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserWindow userWindow = new UserWindow(user.getUsername());
				setVisible(false);
				userWindow.setVisible(true);
			}
		});
		contentPane.add(backButton);
		
		JButton btnGenerateAReceipt = new JButton("Generate a receipt");
		btnGenerateAReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receipt receipt = new Receipt(user);
				setVisible(false);
				receipt.setVisible(true);
			}
		});
		btnGenerateAReceipt.setBounds(366, 317, 205, 21);
		contentPane.add(btnGenerateAReceipt);
	}

}
