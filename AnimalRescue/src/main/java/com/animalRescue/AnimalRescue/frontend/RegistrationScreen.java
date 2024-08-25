package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

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
		btnNewButton.setBounds(130, 10, 140, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volunteer Registration");
		btnNewButton_1.setBounds(130, 41, 140, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("User Registration");
		btnNewButton_2.setBounds(130, 72, 140, 21);
		contentPane.add(btnNewButton_2);
	}

}
