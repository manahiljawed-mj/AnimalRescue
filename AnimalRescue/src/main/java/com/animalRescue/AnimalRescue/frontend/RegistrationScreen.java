package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationScreen frame = new RegistrationScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationScreen() {
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Employee Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EmployeeRegistration eregister = new EmployeeRegistration();
				eregister.setVisible(true);
			}
		});
		btnNewButton.setBounds(130, 10, 140, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volunteer Registration");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VolunteerRegistration vregister = new VolunteerRegistration();
				vregister.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(130, 41, 140, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("User Registration");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserRegistration uregister = new UserRegistration();
				uregister.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(130, 72, 140, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Login Screen");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen lscreen6 = new LoginScreen();
				lscreen6.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(75, 149, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalRescue mainscreen2 = new AnimalRescue();
				mainscreen2.main(null);
			}
		});
		btnNewButton_4.setBounds(258, 149, 85, 21);
		contentPane.add(btnNewButton_4);
	}

}
