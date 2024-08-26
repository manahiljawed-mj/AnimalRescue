package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cat extends JPanel {

    private static final long serialVersionUID = 1L;

    public Cat(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblCatManagement = new JLabel("Animal Rescue Application");
        lblCatManagement.setFont(new Font("Dialog", Font.BOLD, 30));
        lblCatManagement.setForeground(SystemColor.controlLtHighlight);
        lblCatManagement.setBounds(167, 73, 460, 80);
        add(lblCatManagement);

        JButton btnCreateCat = new JButton("Add New Cat Record");
        btnCreateCat.setBounds(274, 198, 228, 46);
        btnCreateCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateCat panel
                cardLayout.show(cardPanel, "CreateCat");
            }
        });
        add(btnCreateCat);

        JButton btnUpdateCat = new JButton("Update Cat Record");
        btnUpdateCat.setBounds(274, 256, 228, 46);
        btnUpdateCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateCat panel
                cardLayout.show(cardPanel, "UpdateCat");
            }
        });
        add(btnUpdateCat);

        JButton btnDeleteCat = new JButton("Delete Cat Record");
        btnDeleteCat.setBounds(274, 316, 228, 46);
        btnDeleteCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateCat panel
                cardLayout.show(cardPanel, "DeleteCat");
            }
        });
        add(btnDeleteCat);

        JButton btnManageCat = new JButton("View Cat Record");
        btnManageCat.setBounds(274, 376, 228, 46);
        btnManageCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateCat panel
                cardLayout.show(cardPanel, "DisplayCat");
            }
        });
        add(btnManageCat);

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
