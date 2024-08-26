package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeleteApplicant extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtBreed;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtSize;
    private JTextField txtCageNumber;
    private JTextField txtStatus;
    private JComboBox<String> cboPetOwner;
    private JComboBox<String> cboCat;
    private JComboBox<String> cboDog;
    private JRadioButton rdbtnCat;
    private JRadioButton rdbtnDog;
    private JLabel lblApplicationDate;
    private ButtonGroup petTypeGroup;
    private JComboBox<String> cboApplicantID;

    public DeleteApplicant(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        // Title Label
        JLabel lblTitle = new JLabel("Delete New Applicant Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(209, 84, 427, 40);
        add(lblTitle);

        // Applicant ID Dropdown
        JLabel lblApplicantID = new JLabel("Applicant ID:");
        lblApplicantID.setFont(new Font("Dialog", Font.BOLD, 16));
        lblApplicantID.setForeground(SystemColor.controlLtHighlight);
        lblApplicantID.setBounds(150, 140, 150, 30);
        add(lblApplicantID);

        String[] applicantIDs = {"Select Applicant Id", "ID 1", "ID 2", "ID 3"}; // Example data
        cboApplicantID = new JComboBox<>(applicantIDs);
        cboApplicantID.setBounds(318, 140, 300, 30);
        cboApplicantID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Optionally, display a message or show the applicant details
                // but do not enable any fields
                String selectedID = (String) cboApplicantID.getSelectedItem();
                if (selectedID != null && !selectedID.equals("Select Applicant Id")) {
                    // Optionally show details or a message that the record will be deleted
                }
            }
        });
        add(cboApplicantID);

        // Pet Owner Dropdown
        JLabel lblPetOwner = new JLabel("Pet Owner:");
        lblPetOwner.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPetOwner.setForeground(SystemColor.controlLtHighlight);
        lblPetOwner.setBounds(150, 184, 150, 30);
        add(lblPetOwner);

        String[] petOwners = {"Owner 1", "Owner 2", "Owner 3"}; // Example data
        cboPetOwner = new JComboBox<>(petOwners);
        cboPetOwner.setBounds(318, 185, 300, 30);
        cboPetOwner.setEnabled(false); // Initially disabled
        add(cboPetOwner);

        // Radio Buttons for Cat or Dog
        rdbtnCat = new JRadioButton("Cat");
        rdbtnCat.setFont(new Font("Tahoma", Font.BOLD, 10));
        rdbtnCat.setForeground(new Color(0, 0, 0));
        rdbtnCat.setBackground(new Color(0, 128, 128));
        rdbtnCat.setBounds(148, 223, 100, 30);
        rdbtnCat.setEnabled(false); // Initially disabled
        rdbtnCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleDropdowns(true);
            }
        });
        add(rdbtnCat);

        rdbtnDog = new JRadioButton("Dog");
        rdbtnDog.setForeground(SystemColor.controlLtHighlight);
        rdbtnDog.setBackground(new Color(0, 128, 128));
        rdbtnDog.setBounds(252, 223, 100, 30);
        rdbtnDog.setEnabled(false); // Initially disabled
        rdbtnDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleDropdowns(false);
            }
        });
        add(rdbtnDog);

        // Group the radio buttons
        petTypeGroup = new ButtonGroup();
        petTypeGroup.add(rdbtnCat);
        petTypeGroup.add(rdbtnDog);

        // Cat Dropdown
        JLabel lblCat = new JLabel("Select Cat:");
        lblCat.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCat.setForeground(SystemColor.controlLtHighlight);
        lblCat.setBounds(150, 265, 100, 30);
        add(lblCat);

        String[] cats = {"Tom", "Whiskers", "Fluffy"}; // Example data
        cboCat = new JComboBox<>(cats);
        cboCat.setBounds(318, 265, 300, 30);
        cboCat.setEnabled(false); // Initially disabled
        add(cboCat);

        // Dog Dropdown
        JLabel lblDog = new JLabel("Select Dog:");
        lblDog.setFont(new Font("Dialog", Font.BOLD, 16));
        lblDog.setForeground(SystemColor.controlLtHighlight);
        lblDog.setBounds(153, 307, 133, 30);
        add(lblDog);

        String[] dogs = {"Rex", "Buddy", "Max"}; // Example data
        cboDog = new JComboBox<>(dogs);
        cboDog.setBounds(318, 307, 300, 30);
        cboDog.setEnabled(false); // Initially disabled
        add(cboDog);

        // Application Date
        JLabel lblApplicationDate = new JLabel("Application Date:");
        lblApplicationDate.setFont(new Font("Dialog", Font.BOLD, 16));
        lblApplicationDate.setForeground(SystemColor.controlLtHighlight);
        lblApplicationDate.setBounds(150, 339, 150, 30);
        add(lblApplicationDate);

        this.lblApplicationDate = new JLabel(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        this.lblApplicationDate.setFont(new Font("Dialog", Font.PLAIN, 16));
        this.lblApplicationDate.setForeground(SystemColor.controlLtHighlight);
        this.lblApplicationDate.setBounds(318, 339, 300, 30);
        add(this.lblApplicationDate);

        // Status Field
        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStatus.setForeground(SystemColor.controlLtHighlight);
        lblStatus.setBounds(150, 379, 100, 30);
        add(lblStatus);

        txtStatus = new JTextField();
        txtStatus.setBounds(318, 381, 300, 30);
        txtStatus.setEnabled(false); // Initially disabled
        add(txtStatus);

        // Buttons
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Dialog", Font.BOLD, 16));
        btnDelete.setBounds(150, 442, 150, 40);
        add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
        btnBack.setBounds(468, 442, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Applicant"); // Change "Applicant" to the actual name of the main panel
            }
        });
        add(btnBack);

        // Default state: Cat radio button selected
        rdbtnCat.setSelected(true);
        toggleDropdowns(true); // Enable the Cat dropdown by default

        // Initially disable all fields
        setFieldsEnabled(false);
    }

    private void toggleDropdowns(boolean showCat) {
        cboCat.setEnabled(showCat);
        cboDog.setEnabled(!showCat);
    }

    private void setFieldsEnabled(boolean enabled) {
        cboPetOwner.setEnabled(enabled);
        rdbtnCat.setEnabled(enabled);
        rdbtnDog.setEnabled(enabled);
        cboCat.setEnabled(enabled && rdbtnCat.isSelected());
        cboDog.setEnabled(enabled && rdbtnDog.isSelected());
        txtStatus.setEnabled(enabled);
    }
}
