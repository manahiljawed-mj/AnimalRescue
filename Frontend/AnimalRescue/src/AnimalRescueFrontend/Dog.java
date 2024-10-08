package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dog extends JPanel {

    private static final long serialVersionUID = 1L;

    public Dog(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblDogManagement = new JLabel("Animal Rescue Application");
        lblDogManagement.setFont(new Font("Dialog", Font.BOLD, 30));
        lblDogManagement.setForeground(SystemColor.controlLtHighlight);
        lblDogManagement.setBounds(167, 73, 460, 80);
        add(lblDogManagement);

        JButton btnCreateDog = new JButton("Add New Dog Record");
        btnCreateDog.setBounds(274, 198, 228, 46);
        btnCreateDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateDog panel
            	  cardPanel.add(new CreateDog(cardLayout,cardPanel), "CreateDog");
                cardLayout.show(cardPanel, "CreateDog");
            }
        });
        add(btnCreateDog);

        JButton btnUpdateDog = new JButton("Update Dog Record");
        btnUpdateDog.setBounds(274, 256, 228, 46);
        btnUpdateDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateDog panel
                cardPanel.add(new UpdateDog(cardLayout,cardPanel), "UpdateDog");

                cardLayout.show(cardPanel, "UpdateDog");
            }
        });
        add(btnUpdateDog);

        JButton btnDeleteDog = new JButton("Delete Dog Record");
        btnDeleteDog.setBounds(274, 316, 228, 46);
        btnDeleteDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateDog panel
                cardPanel.add(new DeleteDog(cardLayout,cardPanel), "DeleteDog");

                cardLayout.show(cardPanel, "DeleteDog");
            }
        });
        add(btnDeleteDog);

        JButton btnManageDog = new JButton("View Dog Record");
        btnManageDog.setBounds(274, 376, 228, 46);
        btnManageDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the CreateDog panel
                cardPanel.add(new DisplayDog(cardLayout,cardPanel), "DisplayDog");
                cardLayout.show(cardPanel, "DisplayDog");
            }
        });
        add(btnManageDog);

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
