package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimalRescue {

	private JFrame frmAnimalRescueApplication;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalRescue window = new AnimalRescue();
					window.frmAnimalRescueApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AnimalRescue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAnimalRescueApplication = new JFrame();
		frmAnimalRescueApplication.setTitle("Animal Rescue Application");
		frmAnimalRescueApplication.setBounds(100, 100, 450, 300);
		frmAnimalRescueApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAnimalRescueApplication.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(171, 37, 85, 21);
		frmAnimalRescueApplication.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(171, 82, 85, 21);
		frmAnimalRescueApplication.getContentPane().add(btnNewButton_1);
	}
}
