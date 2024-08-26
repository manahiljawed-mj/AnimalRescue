package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDog extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtBreed;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtSize;
    private JTextField txtCageNumber;
    private JComboBox<String> cboOptions;

    public UpdateDog(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblTitle = new JLabel("Update New Dog Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(254, 55, 350, 40);
        add(lblTitle);
        
        String[] options = {"Select Dog", "Option 1", "Option 2"}; // Example options
        cboOptions = new JComboBox<>(options);
        cboOptions.setBounds(318, 153, 300, 30);
        add(cboOptions);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblName.setForeground(SystemColor.controlLtHighlight);
        lblName.setBounds(139, 195, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(318, 195, 300, 30);
        add(txtName);

        JLabel lblBreed = new JLabel("Breed:");
        lblBreed.setFont(new Font("Dialog", Font.BOLD, 16));
        lblBreed.setForeground(SystemColor.controlLtHighlight);
        lblBreed.setBounds(139, 237, 100, 30);
        add(lblBreed);

        txtBreed = new JTextField();
        txtBreed.setBounds(318, 237, 300, 30);
        add(txtBreed);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Dialog", Font.BOLD, 16));
        lblAge.setForeground(SystemColor.controlLtHighlight);
        lblAge.setBounds(139, 279, 100, 30);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(318, 279, 300, 30);
        add(txtAge);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
        lblGender.setForeground(SystemColor.controlLtHighlight);
        lblGender.setBounds(139, 321, 100, 30);
        add(lblGender);

        txtGender = new JTextField();
        txtGender.setBounds(318, 321, 300, 30);
        add(txtGender);

        JLabel lblSize = new JLabel("Size:");
        lblSize.setFont(new Font("Dialog", Font.BOLD, 16));
        lblSize.setForeground(SystemColor.controlLtHighlight);
        lblSize.setBounds(139, 361, 100, 30);
        add(lblSize);

        txtSize = new JTextField();
        txtSize.setBounds(318, 363, 300, 30);
        add(txtSize);

        JLabel lblCageNumber = new JLabel("Cage Number:");
        lblCageNumber.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCageNumber.setForeground(SystemColor.controlLtHighlight);
        lblCageNumber.setBounds(139, 403, 173, 30);
        add(lblCageNumber);

        txtCageNumber = new JTextField();
        txtCageNumber.setBounds(318, 405, 300, 30);
        add(txtCageNumber);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Dialog", Font.BOLD, 16));
        btnUpdate.setBounds(150, 500, 150, 40);
        add(btnUpdate);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
        btnBack.setBounds(472, 500, 150, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Dog"); // Change "MainMenu" to the actual name of the main panel
            }
        });
        add(btnBack);
        
        JLabel lblDogId = new JLabel("Select Dog:");
        lblDogId.setForeground(SystemColor.controlLtHighlight);
        lblDogId.setFont(new Font("Dialog", Font.BOLD, 16));
        lblDogId.setBounds(139, 152, 114, 30);
        add(lblDogId);
    }
}
