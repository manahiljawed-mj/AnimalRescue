package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Employee Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EmployeeLogin elogin = new EmployeeLogin();
				elogin.setVisible(true);
			}
		});
		btnNewButton.setBounds(141, 10, 137, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volunteer Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VolunteerLogin vlogin = new VolunteerLogin();
				vlogin.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(141, 41, 137, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("User Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserLogin ulogin = new UserLogin();
				ulogin.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(141, 72, 137, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Go to Registration Screen");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegistrationScreen regscreen2 = new RegistrationScreen();
				regscreen2.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(50, 154, 160, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalRescue mainscreen1 = new AnimalRescue();
				mainscreen1.main(null);
			}
		});
		btnNewButton_4.setBounds(244, 154, 144, 21);
		contentPane.add(btnNewButton_4);
	}
}
