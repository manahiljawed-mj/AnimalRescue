package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateSale extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> cboEmployee;
    private JComboBox<String> cboPetOwner;
    private JComboBox<String> cboCat;
    private JComboBox<String> cboDog;
    private JRadioButton rdbtnCat;
    private JRadioButton rdbtnDog;
    private JLabel lblSaleDate;
    private JTextField txtPrice;
    private ButtonGroup petTypeGroup;

    public CreateSale(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        // Title Label
        JLabel lblTitle = new JLabel("Create New Sale Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(235, 88, 427, 40);
        add(lblTitle);

        // Employee Dropdown
        JLabel lblEmployee = new JLabel("Employee:");
        lblEmployee.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmployee.setForeground(SystemColor.controlLtHighlight);
        lblEmployee.setBounds(150, 155, 135, 30);
        add(lblEmployee);

        String[] employees = {"Employee 1", "Employee 2", "Employee 3"}; // Example data
        cboEmployee = new JComboBox<>(employees);
        cboEmployee.setBounds(318, 155, 300, 30);
        add(cboEmployee);

        // Pet Owner Dropdown
        JLabel lblPetOwner = new JLabel("Pet Owner:");
        lblPetOwner.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPetOwner.setForeground(SystemColor.controlLtHighlight);
        lblPetOwner.setBounds(150, 195, 135, 30);
        add(lblPetOwner);

        String[] petOwners = {"Owner 1", "Owner 2", "Owner 3"}; // Example data
        cboPetOwner = new JComboBox<>(petOwners);
        cboPetOwner.setBounds(318, 195, 300, 30);
        add(cboPetOwner);

        // Radio Buttons for Cat or Dog
        rdbtnCat = new JRadioButton("Cat");
        rdbtnCat.setForeground(SystemColor.controlLtHighlight);
        rdbtnCat.setBackground(new Color(0, 128, 128));
        rdbtnCat.setBounds(150, 235, 100, 30);
        rdbtnCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleDropdowns(true);
            }
        });
        add(rdbtnCat);

        rdbtnDog = new JRadioButton("Dog");
        rdbtnDog.setForeground(SystemColor.controlLtHighlight);
        rdbtnDog.setBackground(new Color(0, 128, 128));
        rdbtnDog.setBounds(250, 235, 100, 30);
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
        lblCat.setBounds(150, 275, 100, 30);
        add(lblCat);

        String[] cats = {"Tom", "Whiskers", "Fluffy"}; // Example data
        cboCat = new JComboBox<>(cats);
        cboCat.setBounds(318, 275, 300, 30);
        cboCat.setEnabled(false); // Initially disabled
        add(cboCat);

        // Dog Dropdown
        JLabel lblDog = new JLabel("Select Dog:");
        lblDog.setFont(new Font("Dialog", Font.BOLD, 16));
        lblDog.setForeground(SystemColor.controlLtHighlight);
        lblDog.setBounds(150, 315, 135, 30);
        add(lblDog);

        String[] dogs = {"Rex", "Buddy", "Max"}; // Example data
        cboDog = new JComboBox<>(dogs);
        cboDog.setBounds(318, 315, 300, 30);
        cboDog.setEnabled(false); // Initially disabled
        add(cboDog);

        // Sale Date
        JLabel lblSaleDate = new JLabel("Sale Date:");
        lblSaleDate.setFont(new Font("Dialog", Font.BOLD, 16));
        lblSaleDate.setForeground(SystemColor.controlLtHighlight);
        lblSaleDate.setBounds(150, 355, 150, 30);
        add(lblSaleDate);

        this.lblSaleDate = new JLabel(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        this.lblSaleDate.setFont(new Font("Dialog", Font.PLAIN, 16));
        this.lblSaleDate.setForeground(SystemColor.controlLtHighlight);
        this.lblSaleDate.setBounds(318, 355, 300, 30);
        add(this.lblSaleDate);

        // Price Field
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPrice.setForeground(SystemColor.controlLtHighlight);
        lblPrice.setBounds(150, 395, 100, 30);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(318, 395, 300, 30);
        add(txtPrice);

        // Buttons
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
        btnAdd.setBounds(150, 450, 150, 40);
        add(btnAdd);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
        btnBack.setBounds(468, 450, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Sale"); // Change "Sale" to the actual name of the main panel
            }
        });
        add(btnBack);

        // Default state: Cat radio button selected
        rdbtnCat.setSelected(true);
        toggleDropdowns(true); // Enable the Cat dropdown by default
    }

    private void toggleDropdowns(boolean showCat) {
        cboCat.setEnabled(showCat);
        cboDog.setEnabled(!showCat);
    }
}
