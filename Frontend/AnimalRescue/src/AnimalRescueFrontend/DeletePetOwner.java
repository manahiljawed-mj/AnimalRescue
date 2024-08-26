package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePetOwner extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> cboPetOwnerId;
    private JTextField txtName;
    private JTextField txtBreed;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtSize;
    private JRadioButton rdbtnCat;
    private JRadioButton rdbtnDog;
    private JComboBox<String> cboCat;
    private JComboBox<String> cboDog;

    public DeletePetOwner(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblTitle = new JLabel("Delete PetOwner Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(222, 81, 396, 40);
        add(lblTitle);

        // Dropdown for Pet Owner ID
        JLabel lblPetOwnerId = new JLabel("Pet Owner ID:");
        lblPetOwnerId.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPetOwnerId.setForeground(SystemColor.controlLtHighlight);
        lblPetOwnerId.setBounds(150, 135, 119, 30);
        add(lblPetOwnerId);

        cboPetOwnerId = new JComboBox<>(new String[]{"Select ID", "PO1", "PO2", "PO3"});
        cboPetOwnerId.setBounds(318, 135, 300, 30);
        add(cboPetOwnerId);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblFirstName.setForeground(SystemColor.controlLtHighlight);
        lblFirstName.setBounds(150, 175, 119, 30);
        add(lblFirstName);

        txtName = new JTextField();
        txtName.setEnabled(false);
        txtName.setEditable(false);
        txtName.setBounds(318, 175, 300, 30);
        add(txtName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblLastName.setForeground(SystemColor.controlLtHighlight);
        lblLastName.setBounds(150, 215, 100, 30);
        add(lblLastName);

        txtBreed = new JTextField();
        txtBreed.setEnabled(false);
        txtBreed.setEditable(false);
        txtBreed.setBounds(318, 215, 300, 30);
        add(txtBreed);

        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblContactNo.setForeground(SystemColor.controlLtHighlight);
        lblContactNo.setBounds(150, 255, 119, 30);
        add(lblContactNo);

        txtAge = new JTextField();
        txtAge.setEnabled(false);
        txtAge.setEditable(false);
        txtAge.setBounds(318, 255, 300, 30);
        add(txtAge);

        JLabel lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmailAddress.setForeground(SystemColor.controlLtHighlight);
        lblEmailAddress.setBounds(150, 295, 136, 30);
        add(lblEmailAddress);

        txtGender = new JTextField();
        txtGender.setEnabled(false);
        txtGender.setEditable(false);
        txtGender.setBounds(318, 295, 300, 30);
        add(txtGender);

        JLabel lblStreetAddress = new JLabel("Street Address");
        lblStreetAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStreetAddress.setForeground(SystemColor.controlLtHighlight);
        lblStreetAddress.setBounds(150, 335, 136, 30);
        add(lblStreetAddress);

        txtSize = new JTextField();
        txtSize.setEnabled(false);
        txtSize.setEditable(false);
        txtSize.setBounds(318, 335, 300, 30);
        add(txtSize);

        // Radio Buttons for Cat and Dog
        rdbtnCat = new JRadioButton("Cat");
        rdbtnCat.setEnabled(false);
        rdbtnCat.setFont(new Font("Dialog", Font.BOLD, 16));
        rdbtnCat.setForeground(SystemColor.controlLtHighlight);
        rdbtnCat.setBackground(new Color(0, 128, 128));
        rdbtnCat.setBounds(150, 375, 100, 30);
        rdbtnCat.setSelected(true); // Default selection
        rdbtnCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                togglePetSelection(true);
            }
        });
        add(rdbtnCat);

        rdbtnDog = new JRadioButton("Dog");
        rdbtnDog.setEnabled(false);
        rdbtnDog.setFont(new Font("Dialog", Font.BOLD, 16));
        rdbtnDog.setForeground(SystemColor.controlLtHighlight);
        rdbtnDog.setBackground(new Color(0, 128, 128));
        rdbtnDog.setBounds(250, 375, 100, 30);
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
        cboCat.setBounds(318, 408, 300, 30);
        add(cboCat);

        // Dropdown for Dog
        cboDog = new JComboBox<>(new String[]{"Select Dog", "Beagle", "Bulldog", "Labrador"});
        cboDog.setBounds(318, 450, 300, 30);
        cboDog.setEnabled(false);
        add(cboDog);

        // Buttons
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Dialog", Font.BOLD, 16));
        btnDelete.setBounds(150, 500, 150, 40);
        add(btnDelete);

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
        cboCat.setEnabled(false);
        cboDog.setEnabled(!isCatSelected);
    }
}
