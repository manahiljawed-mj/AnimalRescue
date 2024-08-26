package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateVolunteer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtContactNo;
    private JTextField txtEmailAddress;
    private JTextField txtStreetAddress;
    private JTextField txtAvailability;

    public CreateVolunteer(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblTitle = new JLabel("Create New Volunteer Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(248, 82, 350, 40);
        add(lblTitle);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblFirstName.setForeground(SystemColor.controlLtHighlight);
        lblFirstName.setBounds(150, 155, 100, 30);
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(318, 155, 300, 30);
        add(txtFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblLastName.setForeground(SystemColor.controlLtHighlight);
        lblLastName.setBounds(150, 195, 100, 30);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(318, 195, 300, 30);
        add(txtLastName);

        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblContactNo.setForeground(SystemColor.controlLtHighlight);
        lblContactNo.setBounds(150, 235, 100, 30);
        add(lblContactNo);

        txtContactNo = new JTextField();
        txtContactNo.setBounds(318, 237, 300, 30);
        add(txtContactNo);

        JLabel lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmailAddress.setForeground(SystemColor.controlLtHighlight);
        lblEmailAddress.setBounds(150, 279, 130, 30);
        add(lblEmailAddress);

        txtEmailAddress = new JTextField();
        txtEmailAddress.setBounds(318, 279, 300, 30);
        add(txtEmailAddress);

        JLabel lblStreetAddress = new JLabel("Street Address:");
        lblStreetAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStreetAddress.setForeground(SystemColor.controlLtHighlight);
        lblStreetAddress.setBounds(150, 321, 130, 30);
        add(lblStreetAddress);

        txtStreetAddress = new JTextField();
        txtStreetAddress.setBounds(318, 321, 300, 30);
        add(txtStreetAddress);

        JLabel lblAvailability = new JLabel("Availability:");
        lblAvailability.setFont(new Font("Dialog", Font.BOLD, 16));
        lblAvailability.setForeground(SystemColor.controlLtHighlight);
        lblAvailability.setBounds(150, 361, 130, 30);
        add(lblAvailability);

        txtAvailability = new JTextField();
        txtAvailability.setBounds(318, 363, 300, 30);
        add(txtAvailability);

        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
        btnAdd.setBounds(150, 500, 150, 40);
        add(btnAdd);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
        btnBack.setBounds(472, 500, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Volunteer");
            }
        });
        add(btnBack);
    }
}
