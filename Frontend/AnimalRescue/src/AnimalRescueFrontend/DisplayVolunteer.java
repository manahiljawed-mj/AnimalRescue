package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayVolunteer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> cmbVolunteerId;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtContactNo;
    private JTextField txtEmailAddress;
    private JTextField txtStreetAddress;
    private JTextField txtAvailability;

    public DisplayVolunteer(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblTitle = new JLabel("Display Volunteer Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(239, 53, 350, 40);
        add(lblTitle);

        JLabel lblVolunteerId = new JLabel("Select Volunteer ID:");
        lblVolunteerId.setFont(new Font("Dialog", Font.BOLD, 16));
        lblVolunteerId.setForeground(SystemColor.controlLtHighlight);
        lblVolunteerId.setBounds(150, 115, 150, 30);
        add(lblVolunteerId);

        // ComboBox to select Volunteer ID
        cmbVolunteerId = new JComboBox<>();
        cmbVolunteerId.setBounds(318, 115, 300, 30);
        // Add items to cmbVolunteerId here
        cmbVolunteerId.addItem("V001"); // Example item
        cmbVolunteerId.addItem("V002"); // Example item
        // You would typically populate this with real IDs from your data source
        add(cmbVolunteerId);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblFirstName.setForeground(SystemColor.controlLtHighlight);
        lblFirstName.setBounds(150, 155, 100, 30);
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setEnabled(false);
        txtFirstName.setEditable(false);
        txtFirstName.setBounds(318, 155, 300, 30);
        add(txtFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblLastName.setForeground(SystemColor.controlLtHighlight);
        lblLastName.setBounds(150, 195, 100, 30);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setEnabled(false);
        txtLastName.setEditable(false);
        txtLastName.setBounds(318, 195, 300, 30);
        add(txtLastName);

        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblContactNo.setForeground(SystemColor.controlLtHighlight);
        lblContactNo.setBounds(150, 235, 100, 30);
        add(lblContactNo);

        txtContactNo = new JTextField();
        txtContactNo.setEnabled(false);
        txtContactNo.setEditable(false);
        txtContactNo.setBounds(318, 237, 300, 30);
        add(txtContactNo);

        JLabel lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmailAddress.setForeground(SystemColor.controlLtHighlight);
        lblEmailAddress.setBounds(150, 279, 130, 30);
        add(lblEmailAddress);

        txtEmailAddress = new JTextField();
        txtEmailAddress.setEditable(false);
        txtEmailAddress.setEnabled(false);
        txtEmailAddress.setBounds(318, 279, 300, 30);
        add(txtEmailAddress);

        JLabel lblStreetAddress = new JLabel("Street Address:");
        lblStreetAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStreetAddress.setForeground(SystemColor.controlLtHighlight);
        lblStreetAddress.setBounds(150, 321, 130, 30);
        add(lblStreetAddress);

        txtStreetAddress = new JTextField();
        txtStreetAddress.setEnabled(false);
        txtStreetAddress.setEditable(false);
        txtStreetAddress.setBounds(318, 321, 300, 30);
        add(txtStreetAddress);

        JLabel lblAvailability = new JLabel("Availability:");
        lblAvailability.setFont(new Font("Dialog", Font.BOLD, 16));
        lblAvailability.setForeground(SystemColor.controlLtHighlight);
        lblAvailability.setBounds(150, 361, 130, 30);
        add(lblAvailability);

        txtAvailability = new JTextField();
        txtAvailability.setEnabled(false);
        txtAvailability.setEditable(false);
        txtAvailability.setBounds(318, 363, 300, 30);
        add(txtAvailability);

        JButton btnDisplay = new JButton("Display");
        btnDisplay.setFont(new Font("Dialog", Font.BOLD, 16));
        btnDisplay.setBounds(150, 500, 150, 40);
        add(btnDisplay);

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
