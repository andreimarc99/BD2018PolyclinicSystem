package Default;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.jdesktop.swingx.auth.UserNameStore;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MedicalAssistantView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MedicalAssistantView frame = new MedicalAssistantView();
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
	public MedicalAssistantView(User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow.userNewScreen(user.getUsername());
				close();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		contentPane.add(btnBack, gbc_btnBack);
		
		UserService userService = new UserService();
		MedicalAssistantData assistantData = userService.retrieveMedicalAssistantData(user);
		
		JLabel lblDegree = new JLabel("Degree:");
		GridBagConstraints gbc_lblDegree = new GridBagConstraints();
		gbc_lblDegree.insets = new Insets(0, 0, 5, 5);
		gbc_lblDegree.gridx = 3;
		gbc_lblDegree.gridy = 2;
		contentPane.add(lblDegree, gbc_lblDegree);
		
		JLabel degreeTextLabel = new JLabel("");
		degreeTextLabel.setText(assistantData.getDegree());
		GridBagConstraints gbc_degreeTextLabel = new GridBagConstraints();
		gbc_degreeTextLabel.insets = new Insets(0, 0, 5, 5);
		gbc_degreeTextLabel.gridx = 5;
		gbc_degreeTextLabel.gridy = 2;
		contentPane.add(degreeTextLabel, gbc_degreeTextLabel);
		
		JLabel lblDomain = new JLabel("Domain:");
		GridBagConstraints gbc_lblDomain = new GridBagConstraints();
		gbc_lblDomain.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomain.gridx = 3;
		gbc_lblDomain.gridy = 4;
		contentPane.add(lblDomain, gbc_lblDomain);
		
		JLabel domainTextLabel = new JLabel("");
		domainTextLabel.setText(assistantData.getDomain());
		GridBagConstraints gbc_domainTextLabel = new GridBagConstraints();
		gbc_domainTextLabel.insets = new Insets(0, 0, 5, 5);
		gbc_domainTextLabel.gridx = 5;
		gbc_domainTextLabel.gridy = 4;
		contentPane.add(domainTextLabel, gbc_domainTextLabel);
		
		JTextArea timetableTextArea = new JTextArea();
		GridBagConstraints gbc_timetableTextArea = new GridBagConstraints();
		gbc_timetableTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_timetableTextArea.fill = GridBagConstraints.BOTH;
		gbc_timetableTextArea.gridx = 7;
		gbc_timetableTextArea.gridy = 5;
		timetableTextArea.setEditable(false);
		timetableTextArea.append("GENERIC TIMETABLE" + "\n");
		List<String> timetable = userService.retrieveGenericTimetable(user);
		for (String s : timetable) {
			timetableTextArea.append(s + "\n");
		}
		contentPane.add(timetableTextArea, gbc_timetableTextArea);
		
		JButton btnDetailsAboutPatients = new JButton("Details about patients & appointments");
		btnDetailsAboutPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetailsForMedicalAssistant detailsForMedicalAssistant = new DetailsForMedicalAssistant(user);
				detailsForMedicalAssistant.setVisible(true);
				close();
			}
		});
		GridBagConstraints gbc_btnDetailsAboutPatients = new GridBagConstraints();
		gbc_btnDetailsAboutPatients.anchor = GridBagConstraints.EAST;
		gbc_btnDetailsAboutPatients.gridx = 7;
		gbc_btnDetailsAboutPatients.gridy = 6;
		contentPane.add(btnDetailsAboutPatients, gbc_btnDetailsAboutPatients);
	}

}
