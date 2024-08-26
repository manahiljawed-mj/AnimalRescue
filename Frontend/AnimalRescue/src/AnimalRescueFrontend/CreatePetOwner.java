package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePetOwner extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtBreed;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtSize;
    private JRadioButton rdbtnCat;
    private JRadioButton rdbtnDog;
    private JComboBox<String> cboCat;
    private JComboBox<String> cboDog;

    public CreatePetOwner(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblTitle = new JLabel("Create New PetOwner Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(222, 81, 396, 40);
        add(lblTitle);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblFirstName.setForeground(SystemColor.controlLtHighlight);
        lblFirstName.setBounds(150, 155, 119, 30);
        add(lblFirstName);

        txtName = new JTextField();
        txtName.setBounds(318, 155, 300, 30);
        add(txtName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblLastName.setForeground(SystemColor.controlLtHighlight);
        lblLastName.setBounds(150, 195, 100, 30);
        add(lblLastName);

        txtBreed = new JTextField();
        txtBreed.setBounds(318, 195, 300, 30);
        add(txtBreed);

        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblContactNo.setForeground(SystemColor.controlLtHighlight);
        lblContactNo.setBounds(150, 235, 119, 30);
        add(lblContactNo);

        txtAge = new JTextField();
        txtAge.setBounds(318, 237, 300, 30);
        add(txtAge);

        JLabel lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmailAddress.setForeground(SystemColor.controlLtHighlight);
        lblEmailAddress.setBounds(150, 279, 136, 30);
        add(lblEmailAddress);

        txtGender = new JTextField();
        txtGender.setBounds(318, 279, 300, 30);
        add(txtGender);

        JLabel lblStreetAddress = new JLabel("Street Address");
        lblStreetAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStreetAddress.setForeground(SystemColor.controlLtHighlight);
        lblStreetAddress.setBounds(150, 321, 136, 30);
        add(lblStreetAddress);

        txtSize = new JTextField();
        txtSize.setBounds(318, 321, 300, 30);
        add(txtSize);

        // Radio Buttons for Cat and Dog
        rdbtnCat = new JRadioButton("Cat");
        rdbtnCat.setFont(new Font("Dialog", Font.BOLD, 16));
        rdbtnCat.setForeground(SystemColor.controlLtHighlight);
        rdbtnCat.setBackground(new Color(0, 128, 128));
        rdbtnCat.setBounds(150, 361, 100, 30);
        rdbtnCat.setSelected(true); // Default selection
        rdbtnCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                togglePetSelection(true);
            }
        });
        add(rdbtnCat);

        rdbtnDog = new JRadioButton("Dog");
        rdbtnDog.setFont(new Font("Dialog", Font.BOLD, 16));
        rdbtnDog.setForeground(SystemColor.controlLtHighlight);
        rdbtnDog.setBackground(new Color(0, 128, 128));
        rdbtnDog.setBounds(250, 361, 100, 30);
        rdbtnDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                togglePetSelection(false);
            }
        });
        add(rdbtnDog);

        ButtonGroup petGroup = new ButtonGroup();
        petGroup.add(rdbtnCat);
        petGroup.add(rdbtnDog);

        // Dropdown for Cat
        cboCat = new JComboBox<>(new String[]{"Select Cat", "Persian", "Siamese", "Maine Coon"});
        cboCat.setBounds(318, 403, 300, 30);
        cboCat.setEnabled(true);
        add(cboCat);

        // Dropdown for Dog
        cboDog = new JComboBox<>(new String[]{"Select Dog", "Beagle", "Bulldog", "Labrador"});
        cboDog.setBounds(318, 445, 300, 30);
        cboDog.setEnabled(false);
        add(cboDog);

        // Buttons
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
        btnAdd.setBounds(150, 500, 150, 40);
        add(btnAdd);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
        btnBack.setBounds(472, 500, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PetOwner");
            }
        });
        add(btnBack);

        // Set default state
        togglePetSelection(true);
    }

    private void togglePetSelection(boolean isCatSelected) {
        cboCat.setEnabled(isCatSelected);
        cboDog.setEnabled(!isCatSelected);
    }
}
