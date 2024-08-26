package AnimalRescueFrontend;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPetOwner extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtCat;
    private JTextField txtDog;
    private JTextField txtContactNumber;
    private JTextField txtEmailAddress;
    private JTextField txtStreetAddress;
    private JComboBox<String> cboApplicantSelection;
    private JRadioButton rdbtnSingleApplicantRecord;
    private JRadioButton rdbtnAll;
    private JPanel formPanel;
    private JPanel tablePanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTable table;
    private JScrollPane tableScrollPane;
    private JButton btnBack1;

    public DisplayPetOwner(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        // Title Label
        JLabel lblTitle = new JLabel("Display Pet Owner Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(254, 55, 350, 40);
        add(lblTitle);

        // Initialize btnBack1
        btnBack1 = new JButton("Back");
        btnBack1.setFont(new Font("Dialog", Font.BOLD, 16));
        btnBack1.setBounds(637, 520, 150, 30);
        btnBack1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Applicant"); // Correctly reference cardPanel
            }
        });
        add(btnBack1);

        // Radio Buttons for selecting view
        rdbtnSingleApplicantRecord = new JRadioButton("Single Pet Owner Record");
        rdbtnSingleApplicantRecord.setForeground(SystemColor.controlLtHighlight);
        rdbtnSingleApplicantRecord.setBackground(new Color(0, 128, 128));
        rdbtnSingleApplicantRecord.setBounds(215, 110, 220, 23);
        rdbtnSingleApplicantRecord.setSelected(true); // Default selection
        rdbtnSingleApplicantRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSingleApplicantRecord();
            }
        });
        add(rdbtnSingleApplicantRecord);

        rdbtnAll = new JRadioButton("All");
        rdbtnAll.setForeground(SystemColor.controlLtHighlight);
        rdbtnAll.setBackground(new Color(0, 128, 128));
        rdbtnAll.setBounds(440, 110, 149, 23);
        rdbtnAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllRecords();
            }
        });
        add(rdbtnAll);

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnSingleApplicantRecord);
        group.add(rdbtnAll);

        // Form Panel for Single Pet Owner Record
        formPanel = new JPanel();
        formPanel.setForeground(SystemColor.desktop);
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(0, 128, 128));
        formPanel.setBounds(20, 150, 760, 400);
        add(formPanel);

        // Labels and Text Fields for Single Pet Owner Record
        createFormComponents();

        // Table Panel for All Records
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(SystemColor.desktop);
        tablePanel.setBounds(7, 170, 780, 80);// Adjusted height to accommodate more rows
        tablePanel.setVisible(false); // Initially hidden

        // Initialize and add the table to the panel
        initializeTable();
        add(tablePanel);

        showSingleApplicantRecord(); // Default view
    }

    private void createFormComponents() {
        // Create and add dropdown for selecting an Applicant
        JLabel lblSelectApplicant = new JLabel("Select Pet Owner:");
        lblSelectApplicant.setFont(new Font("Dialog", Font.BOLD, 16));
        lblSelectApplicant.setForeground(SystemColor.controlLtHighlight);
        lblSelectApplicant.setBounds(139, 68, 175, 30);
        formPanel.add(lblSelectApplicant);

        // Sample data for JComboBox
        String[] applicantNames = {"Alice", "Bob", "Charlie"}; // Example pet owner names
        cboApplicantSelection = new JComboBox<>(applicantNames);
        cboApplicantSelection.setBounds(318, 69, 300, 30);
        formPanel.add(cboApplicantSelection);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblName.setForeground(SystemColor.controlLtHighlight);
        lblName.setBounds(139, 110, 100, 30);
        formPanel.add(lblName);

        txtName = new JTextField();
        txtName.setEnabled(false);
        txtName.setEditable(false);
        txtName.setBounds(318, 110, 300, 30);
        formPanel.add(txtName);

        JLabel lblCat = new JLabel("Cat:");
        lblCat.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCat.setForeground(SystemColor.controlLtHighlight);
        lblCat.setBounds(139, 150, 100, 30);
        formPanel.add(lblCat);

        txtCat = new JTextField();
        txtCat.setEnabled(false);
        txtCat.setEditable(false);
        txtCat.setBounds(318, 150, 300, 30);
        formPanel.add(txtCat);

        JLabel lblDog = new JLabel("Dog:");
        lblDog.setFont(new Font("Dialog", Font.BOLD, 16));
        lblDog.setForeground(SystemColor.controlLtHighlight);
        lblDog.setBounds(139, 190, 100, 30);
        formPanel.add(lblDog);

        txtDog = new JTextField();
        txtDog.setEnabled(false);
        txtDog.setEditable(false);
        txtDog.setBounds(318, 190, 300, 30);
        formPanel.add(txtDog);

        JLabel lblContactNumber = new JLabel("Contact Number:");
        lblContactNumber.setFont(new Font("Dialog", Font.BOLD, 16));
        lblContactNumber.setForeground(SystemColor.controlLtHighlight);
        lblContactNumber.setBounds(139, 230, 150, 30);
        formPanel.add(lblContactNumber);

        txtContactNumber = new JTextField();
        txtContactNumber.setEnabled(false);
        txtContactNumber.setEditable(false);
        txtContactNumber.setBounds(318, 230, 300, 30);
        formPanel.add(txtContactNumber);

        JLabel lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmailAddress.setForeground(SystemColor.controlLtHighlight);
        lblEmailAddress.setBounds(139, 270, 150, 30);
        formPanel.add(lblEmailAddress);

        txtEmailAddress = new JTextField();
        txtEmailAddress.setEnabled(false);
        txtEmailAddress.setEditable(false);
        txtEmailAddress.setBounds(318, 270, 300, 30);
        formPanel.add(txtEmailAddress);

        JLabel lblStreetAddress = new JLabel("Street Address:");
        lblStreetAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStreetAddress.setForeground(SystemColor.controlLtHighlight);
        lblStreetAddress.setBounds(139, 310, 150, 30);
        formPanel.add(lblStreetAddress);

        txtStreetAddress = new JTextField();
        txtStreetAddress.setEnabled(false);
        txtStreetAddress.setEditable(false);
        txtStreetAddress.setBounds(318, 310, 300, 30);
        formPanel.add(txtStreetAddress);
    }

    private void initializeTable() {
        // Sample data for the table
        String[] columnNames = {"Pet Owner ID", "Name", "Cat", "Dog", "Contact Number", "Email Address", "Street Address"};
        Object[][] data = {
            {"PO1", "Alice", "Persian", "Beagle", "123-456-7890", "alice@example.com", "123 Elm St"},
            {"PO2", "Bob", "Siamese", "Bulldog", "234-567-8901", "bob@example.com", "456 Oak St"},
            {"PO3", "Charlie", "Maine Coon", "Labrador", "345-678-9012", "charlie@example.com", "789 Pine St"}
        };

        // Create a table with custom cell renderer
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        // Customizing table appearance
        table.setFont(new Font("Dialog", Font.PLAIN, 14));
        table.setRowHeight(30);

        // Center align table cell values
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Set column widths
        TableColumn column = null;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0: // Pet Owner ID
                    column.setPreferredWidth(100);
                    break;
                case 1: // Name
                    column.setPreferredWidth(150);
                    break;
                case 2: // Cat
                    column.setPreferredWidth(150);
                    break;
                case 3: // Dog
                    column.setPreferredWidth(150);
                    break;
                case 4: // Contact Number
                    column.setPreferredWidth(150);
                    break;
                case 5: // Email Address
                    column.setPreferredWidth(200);
                    break;
                case 6: // Street Address
                    column.setPreferredWidth(200);
                    break;
            }
        }

        // Use JScrollPane for table with dynamic height
        tableScrollPane = new JScrollPane(table);
        tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tableScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
    }

    private void showSingleApplicantRecord() {
        formPanel.setVisible(true);
        tablePanel.setVisible(false);
    }

    private void showAllRecords() {
        formPanel.setVisible(false);
        tablePanel.setVisible(true);

        // Calculate the height needed for the table based on its content
        int rowCount = table.getRowCount();
        int rowHeight = table.getRowHeight();
        int headerHeight = table.getTableHeader().getPreferredSize().height;
        int tableHeight = rowCount * rowHeight + headerHeight;

        // Set a minimum height for the panel and add some padding
        int panelHeight = Math.max(400, tableHeight + 50); // 400 is the minimum height, 50 is extra padding

        // Update the preferred size of the tableScrollPane and tablePanel
        tableScrollPane.setPreferredSize(new Dimension(800, tableHeight));
        tablePanel.setPreferredSize(new Dimension(800, panelHeight));

        // Ensure the layout manager updates the panel size
        tablePanel.revalidate();
        tablePanel.repaint();
    }
}
