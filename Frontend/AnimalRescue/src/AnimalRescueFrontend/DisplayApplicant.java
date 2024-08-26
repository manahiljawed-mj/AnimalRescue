package AnimalRescueFrontend;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayApplicant extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtBreed;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtSize;
    private JComboBox<String> cboApplicantSelection; // Updated JComboBox
    private JRadioButton rdbtnSingleApplicantRecord;
    private JRadioButton rdbtnAll;
    private JPanel formPanel;
    private JPanel tablePanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTable table;
    private JScrollPane tableScrollPane;
    private JButton btnBack1;

    public DisplayApplicant(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        // Title Label
        JLabel lblTitle = new JLabel("Display Applicant Record");
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
        rdbtnSingleApplicantRecord = new JRadioButton("Single Applicant Record");
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

        // Form Panel for Single Applicant Record
        formPanel = new JPanel();
        formPanel.setForeground(SystemColor.desktop);
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(0, 128, 128));
        formPanel.setBounds(20, 150, 760, 400);
        add(formPanel);

        // Labels and Text Fields for Single Applicant Record
        createFormComponents();

        // Table Panel for All Records
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(SystemColor.desktop);
        tablePanel.setBounds(7, 170, 780, 80);
        tablePanel.setVisible(false); // Initially hidden

        // Initialize and add the table to the panel
        initializeTable();
        add(tablePanel);

        showSingleApplicantRecord(); // Default view
    }

    private void createFormComponents() {
        // Create and add dropdown for selecting an Applicant
        JLabel lblSelectApplicant = new JLabel("Select Applicant:");
        lblSelectApplicant.setFont(new Font("Dialog", Font.BOLD, 16));
        lblSelectApplicant.setForeground(SystemColor.controlLtHighlight);
        lblSelectApplicant.setBounds(139, 20, 150, 30);
        formPanel.add(lblSelectApplicant);

        // Sample data for JComboBox
        String[] applicantNames = {"Alice", "Bob", "Charlie"}; // Example applicant names
        cboApplicantSelection = new JComboBox<>(applicantNames);
        cboApplicantSelection.setBounds(318, 20, 300, 30);
        formPanel.add(cboApplicantSelection);

        // Create and add form components
        JLabel lblPetOwner = new JLabel("PetOwner:");
        lblPetOwner.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPetOwner.setForeground(SystemColor.controlLtHighlight);
        lblPetOwner.setBounds(139, 70, 100, 30);
        formPanel.add(lblPetOwner);

        txtName = new JTextField();
        txtName.setEnabled(false);
        txtName.setEditable(false);
        txtName.setBounds(318, 70, 300, 30);
        formPanel.add(txtName);

        JLabel lblCat = new JLabel("Cat:");
        lblCat.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCat.setForeground(SystemColor.controlLtHighlight);
        lblCat.setBounds(139, 120, 100, 30);
        formPanel.add(lblCat);

        txtBreed = new JTextField();
        txtBreed.setEnabled(false);
        txtBreed.setEditable(false);
        txtBreed.setBounds(318, 120, 300, 30);
        formPanel.add(txtBreed);

        JLabel lblDog = new JLabel("Dog:");
        lblDog.setFont(new Font("Dialog", Font.BOLD, 16));
        lblDog.setForeground(SystemColor.controlLtHighlight);
        lblDog.setBounds(139, 170, 100, 30);
        formPanel.add(lblDog);

        txtAge = new JTextField();
        txtAge.setEnabled(false);
        txtAge.setEditable(false);
        txtAge.setBounds(318, 170, 300, 30);
        formPanel.add(txtAge);

        JLabel lblGender = new JLabel("");
        lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
        lblGender.setForeground(SystemColor.controlLtHighlight);
        lblGender.setBounds(139, 220, 100, 30);
        formPanel.add(lblGender);

        txtGender = new JTextField();
        txtGender.setEnabled(false);
        txtGender.setEditable(false);
        txtGender.setBounds(318, 220, 300, 30);
        formPanel.add(txtGender);

        JLabel lblApplicationDate = new JLabel("Application Date");
        lblApplicationDate.setFont(new Font("Dialog", Font.BOLD, 16));
        lblApplicationDate.setForeground(SystemColor.controlLtHighlight);
        lblApplicationDate.setBounds(139, 270, 150, 30);
        formPanel.add(lblApplicationDate);

        txtSize = new JTextField();
        txtSize.setEnabled(false);
        txtSize.setEditable(false);
        txtSize.setBounds(318, 270, 300, 30);
        formPanel.add(txtSize);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStatus.setForeground(SystemColor.controlLtHighlight);
        lblStatus.setBounds(139, 220, 100, 30);
        formPanel.add(lblStatus);
    }

    private void initializeTable() {
        // Sample data for the table
        String[] columnNames = {"Applicant ID", "Pet Owner","Cat","Dog","Application Date", "Application Status"};
        Object[][] data = {
            {"1", "1-Siamese", "2-Kitty", "null","2000-12-12","Pending"},
            {"1", "1-Siamese", "2-Kitty", "null","2000-12-12","Pending"},
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
                case 0: // Applicant ID
                    column.setPreferredWidth(150);
                    break;
                case 1: // Pet Owner Id
                	column.setPreferredWidth(150);
                case 2: // Cat Id
                    column.setPreferredWidth(150);
                    break;
                case 3: // Dog Id
                    column.setPreferredWidth(150);
                    break;
                case 4: // Application Date
                    column.setPreferredWidth(150);
                    break;
                case 5: // Application status
                    column.setPreferredWidth(150);
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
