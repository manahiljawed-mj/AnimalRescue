package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateDog extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtBreed;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtSize;
    private JTextField txtCageNumber;

    public CreateDog(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblTitle = new JLabel("Create New Dog Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(305, 86, 350, 40);
        add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblName.setForeground(SystemColor.controlLtHighlight);
        lblName.setBounds(150, 155, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(318, 155, 300, 30);
        add(txtName);

        JLabel lblBreed = new JLabel("Breed:");
        lblBreed.setFont(new Font("Dialog", Font.BOLD, 16));
        lblBreed.setForeground(SystemColor.controlLtHighlight);
        lblBreed.setBounds(150, 195, 100, 30);
        add(lblBreed);

        txtBreed = new JTextField();
        txtBreed.setBounds(318, 195, 300, 30);
        add(txtBreed);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Dialog", Font.BOLD, 16));
        lblAge.setForeground(SystemColor.controlLtHighlight);
        lblAge.setBounds(150, 235, 100, 30);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(318, 237, 300, 30);
        add(txtAge);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
        lblGender.setForeground(SystemColor.controlLtHighlight);
        lblGender.setBounds(150, 279, 100, 30);
        add(lblGender);

        txtGender = new JTextField();
        txtGender.setBounds(318, 279, 300, 30);
        add(txtGender);

        JLabel lblSize = new JLabel("Size:");
        lblSize.setFont(new Font("Dialog", Font.BOLD, 16));
        lblSize.setForeground(SystemColor.controlLtHighlight);
        lblSize.setBounds(150, 321, 100, 30);
        add(lblSize);

        txtSize = new JTextField();
        txtSize.setBounds(318, 321, 300, 30);
        add(txtSize);

        JLabel lblCageNumber = new JLabel("Cage Number:");
        lblCageNumber.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCageNumber.setForeground(SystemColor.controlLtHighlight);
        lblCageNumber.setBounds(150, 361, 173, 30);
        add(lblCageNumber);

        txtCageNumber = new JTextField();
        txtCageNumber.setBounds(318, 363, 300, 30);
        add(txtCageNumber);

        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
        btnAdd.setBounds(150, 500, 150, 40);
        add(btnAdd);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
        btnBack.setBounds(472, 500, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Dog"); // Change "MainMenu" to the actual name of the main panel
            }
        });
        add(btnBack);
    }
}
