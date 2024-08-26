package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee extends JPanel {

    private static final long serialVersionUID = 1L;

    public Employee(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblEmployeeManagement = new JLabel("Animal Rescue Application");
        lblEmployeeManagement.setFont(new Font("Dialog", Font.BOLD, 30));
        lblEmployeeManagement.setForeground(SystemColor.controlLtHighlight);
        lblEmployeeManagement.setBounds(167, 73, 460, 80);
        add(lblEmployeeManagement);

        JButton btnCreateEmployee = new JButton("Add New Employee Record");
        btnCreateEmployee.setBounds(274, 198, 228, 46);
        add(btnCreateEmployee);

        JButton btnUpdateEmployee = new JButton("Update Employee Record");
        btnUpdateEmployee.setBounds(274, 256, 228, 46);
        add(btnUpdateEmployee);

        JButton btnDeleteEmployee = new JButton("Delete Employee Record");
        btnDeleteEmployee.setBounds(274, 316, 228, 46);
        add(btnDeleteEmployee);

        JButton btnManageEmployee = new JButton("View Employee Record");
        btnManageEmployee.setBounds(274, 376, 228, 46);
        add(btnManageEmployee);

        JButton btnBack = new JButton("Back ");
        btnBack.setBounds(637, 500, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainMenu");
            }
        });
        add(btnBack);
    }
}
