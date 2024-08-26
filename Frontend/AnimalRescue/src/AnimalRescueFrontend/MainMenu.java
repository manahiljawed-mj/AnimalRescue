package AnimalRescueFrontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainMenu frame = new MainMenu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 823, 608);
        setTitle("Animal Rescue Application");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add different screens/panels to the card panel
        cardPanel.add(createMainMenuPanel(), "MainMenu");
        cardPanel.add(new Cat(cardLayout, cardPanel), "Cat");
        cardPanel.add(new Dog(cardLayout, cardPanel), "Dog");
        cardPanel.add(new Volunteer(cardLayout, cardPanel), "Volunteer");
        cardPanel.add(new Employee(cardLayout, cardPanel), "Employee");
        cardPanel.add(new Sale(cardLayout, cardPanel), "Sale");
        cardPanel.add(new Applicant(cardLayout, cardPanel), "Applicant");
        cardPanel.add(new MedicalRecord(cardLayout, cardPanel), "MedicalRecord");
        cardPanel.add(new PetOwner(cardLayout, cardPanel), "PetOwner");
        cardPanel.add(new CreateCat(cardLayout,cardPanel), "CreateCat");
        cardPanel.add(new UpdateCat(cardLayout,cardPanel), "UpdateCat");
        cardPanel.add(new DeleteCat(cardLayout,cardPanel), "DeleteCat");
        cardPanel.add(new DisplayCat(cardLayout,cardPanel), "DisplayCat");
        cardPanel.add(new CreateDog(cardLayout,cardPanel), "CreateDog");
        cardPanel.add(new UpdateDog(cardLayout,cardPanel), "UpdateDog");
        cardPanel.add(new DeleteDog(cardLayout,cardPanel), "DeleteDog");
        cardPanel.add(new DisplayDog(cardLayout,cardPanel), "DisplayDog");
        cardPanel.add(new CreateApplicant(cardLayout,cardPanel), "CreateApplicant");
        cardPanel.add(new UpdateApplicant(cardLayout,cardPanel), "UpdateApplicant");
        cardPanel.add(new DeleteApplicant(cardLayout,cardPanel), "DeleteApplicant");
        cardPanel.add(new DisplayApplicant(cardLayout,cardPanel), "DisplayApplicant");
        cardPanel.add(new CreatePetOwner(cardLayout,cardPanel), "CreatePetOwner");
        cardPanel.add(new UpdatePetOwner(cardLayout,cardPanel), "UpdatePetOwner");
        cardPanel.add(new DeletePetOwner(cardLayout,cardPanel), "DeletePetOwner");
        cardPanel.add(new DisplayPetOwner(cardLayout,cardPanel), "DisplayPetOwner");
        cardPanel.add(new CreateMedicalRecord(cardLayout,cardPanel), "CreateMedicalRecord");
        cardPanel.add(new UpdateMedicalRecord(cardLayout,cardPanel), "UpdateMedicalRecord");
        cardPanel.add(new DeleteMedicalRecord(cardLayout,cardPanel), "DeleteMedicalRecord");
        cardPanel.add(new DisplayMedicalRecord(cardLayout,cardPanel), "DisplayMedicalRecord");
        cardPanel.add(new DisplayVolunteer(cardLayout,cardPanel), "DisplayVolunteer");
        cardPanel.add(new CreateVolunteer(cardLayout,cardPanel), "CreateVolunteer");
        cardPanel.add(new UpdateVolunteer(cardLayout,cardPanel), "UpdateVolunteer");
        cardPanel.add(new DeleteVolunteer(cardLayout,cardPanel), "DeleteVolunteer");
        cardPanel.add(new DisplaySale(cardLayout,cardPanel), "DisplaySale");
        cardPanel.add(new CreateSale(cardLayout,cardPanel), "CreateSale");
        cardPanel.add(new UpdateSale(cardLayout,cardPanel), "UpdateSale");
        cardPanel.add(new DeleteSale(cardLayout,cardPanel), "DeleteSale");
        
        // Add other panels similarly

        contentPane.add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createMainMenuPanel() {
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(new Color(0, 128, 128));
        mainMenuPanel.setLayout(null);

        JLabel lblAnimalRescueApplication = new JLabel("Animal Rescue Application");
        lblAnimalRescueApplication.setFont(new Font("Dialog", Font.BOLD, 30));
        lblAnimalRescueApplication.setForeground(SystemColor.controlLtHighlight);
        lblAnimalRescueApplication.setBounds(186, 37, 460, 80);
        mainMenuPanel.add(lblAnimalRescueApplication);

        JButton btnEmployee = new JButton("Manage Employees");
        btnEmployee.setBounds(22, 505, 181, 46);
        btnEmployee.addActionListener(e -> cardLayout.show(cardPanel, "Employee"));
        mainMenuPanel.add(btnEmployee);

        JButton btnVolunteer = new JButton("Volunteer");
        btnVolunteer.setBounds(274, 392, 228, 46);
        btnVolunteer.addActionListener(e -> cardLayout.show(cardPanel, "Volunteer"));
        mainMenuPanel.add(btnVolunteer);

        JButton btnPetOwner = new JButton("Pet Owner");
        btnPetOwner.setBounds(274, 280, 228, 46);
        btnPetOwner.addActionListener(e -> cardLayout.show(cardPanel, "PetOwner"));
        mainMenuPanel.add(btnPetOwner);
        
        
        JButton btnApplicant = new JButton("Applicant");
        btnApplicant.setBounds(274, 224, 228, 46);
        btnApplicant.addActionListener(e -> cardLayout.show(cardPanel, "Applicant"));
        mainMenuPanel.add(btnApplicant);
        
        JButton btnCat = new JButton("Cat");
        btnCat.setBounds(274, 116, 228, 46);
        btnCat.addActionListener(e -> cardLayout.show(cardPanel, "Cat"));
        mainMenuPanel.add(btnCat);

        JButton btnDog = new JButton("Dog");
        btnDog.setBounds(274, 168, 228, 46);
        btnDog.addActionListener(e -> cardLayout.show(cardPanel, "Dog"));
        mainMenuPanel.add(btnDog);

        JButton btnSale = new JButton("Sales");
        btnSale.setBounds(274, 447, 228, 46);
        btnSale.addActionListener(e -> cardLayout.show(cardPanel, "Sale"));
        mainMenuPanel.add(btnSale);

        JButton btnSignOff = new JButton("Sign Off");
        btnSignOff.setBounds(666, 505, 122, 46);
        mainMenuPanel.add(btnSignOff);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(536, 505, 122, 46);
        mainMenuPanel.add(btnBack);
        
        JButton btnMedicalRecord = new JButton("Medical Record");
        btnMedicalRecord.setBounds(274, 336, 228, 46);
        btnMedicalRecord.addActionListener(e -> cardLayout.show(cardPanel, "MedicalRecord"));
        mainMenuPanel.add(btnMedicalRecord);
        
       

        return mainMenuPanel;
    }
}
