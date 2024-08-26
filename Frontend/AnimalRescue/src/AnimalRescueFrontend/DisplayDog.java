package AnimalRescueFrontend;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayDog extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtBreed;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtSize;
    private JTextField txtCageNumber;
    private JComboBox<String> cboDogSelection; // Declare JComboBox
    private JRadioButton rdbtnSingleDogRecord;
    private JRadioButton rdbtnAll;
    private JPanel formPanel;
    private JPanel tablePanel;
    private CardLayout cardLayout;
    private JPanel cardPanel; // Ensure this is declared
    private JTable table;
    private JScrollPane tableScrollPane;
    private JButton btnBack1; // Declare btnBack1 as a member variable

    public DisplayDog(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel; // Initialize the instance variable
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        // Title Label
        JLabel lblTitle = new JLabel("Display New Dog Record");
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
                cardLayout.show(cardPanel, "Dog"); // Correctly reference cardPanel
            }
        });// Initially hidden
        add(btnBack1);
        // Radio Buttons for selecting view
        rdbtnSingleDogRecord = new JRadioButton("Single Dog Record");
        rdbtnSingleDogRecord.setForeground(SystemColor.controlLtHighlight);
        rdbtnSingleDogRecord.setBackground(new Color(0, 128, 128));
        rdbtnSingleDogRecord.setBounds(215, 110, 189, 23);
        rdbtnSingleDogRecord.setSelected(true); // Default selection
        rdbtnSingleDogRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSingleDogRecord();
            }
        });
        add(rdbtnSingleDogRecord);

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
        group.add(rdbtnSingleDogRecord);
        group.add(rdbtnAll);

        // Form Panel for Single Dog Record
        formPanel = new JPanel();
        formPanel.setForeground(SystemColor.desktop);
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(0, 128, 128));
        formPanel.setBounds(20, 150, 760, 400); // Adjusted for padding
        add(formPanel);

        // Labels and Text Fields for Single Dog Record
        createFormComponents();

        // Table Panel for All Records
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(SystemColor.desktop);
        tablePanel.setBounds(7, 170, 780, 80); // Adjust initial size for testing
        tablePanel.setVisible(false); // Initially hidden

        // Initialize and add the table to the panel
        initializeTable();
        add(tablePanel);

        

        showSingleDogRecord(); // Default view
    }

    private void createFormComponents() {
        // Create and add dropdown for selecting a Dog
        JLabel lblSelectDog = new JLabel("Select Dog:");
        lblSelectDog.setFont(new Font("Dialog", Font.BOLD, 16));
        lblSelectDog.setForeground(SystemColor.controlLtHighlight);
        lblSelectDog.setBounds(139, 20, 120, 30);
        formPanel.add(lblSelectDog);

        // Sample data for JComboBox
        String[] DogNames = {"Tom", "Whiskers", "Fluffy"}; // Example Dog names
        cboDogSelection = new JComboBox<>(DogNames);
        cboDogSelection.setBounds(318, 20, 300, 30);
        formPanel.add(cboDogSelection);

        // Create and add form components
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblName.setForeground(SystemColor.controlLtHighlight);
        lblName.setBounds(139, 70, 100, 30);
        formPanel.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(318, 70, 300, 30);
        formPanel.add(txtName);

        JLabel lblBreed = new JLabel("Breed:");
        lblBreed.setFont(new Font("Dialog", Font.BOLD, 16));
        lblBreed.setForeground(SystemColor.controlLtHighlight);
        lblBreed.setBounds(139, 120, 100, 30);
        formPanel.add(lblBreed);

        txtBreed = new JTextField();
        txtBreed.setBounds(318, 120, 300, 30);
        formPanel.add(txtBreed);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Dialog", Font.BOLD, 16));
        lblAge.setForeground(SystemColor.controlLtHighlight);
        lblAge.setBounds(139, 170, 100, 30);
        formPanel.add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(318, 170, 300, 30);
        formPanel.add(txtAge);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
        lblGender.setForeground(SystemColor.controlLtHighlight);
        lblGender.setBounds(139, 220, 100, 30);
        formPanel.add(lblGender);

        txtGender = new JTextField();
        txtGender.setBounds(318, 220, 300, 30);
        formPanel.add(txtGender);

        JLabel lblSize = new JLabel("Size:");
        lblSize.setFont(new Font("Dialog", Font.BOLD, 16));
        lblSize.setForeground(SystemColor.controlLtHighlight);
        lblSize.setBounds(139, 270, 100, 30);
        formPanel.add(lblSize);

        txtSize = new JTextField();
        txtSize.setBounds(318, 270, 300, 30);
        formPanel.add(txtSize);

        JLabel lblCageNumber = new JLabel("Cage Number:");
        lblCageNumber.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCageNumber.setForeground(SystemColor.controlLtHighlight);
        lblCageNumber.setBounds(139, 320, 150, 30);
        formPanel.add(lblCageNumber);

        txtCageNumber = new JTextField();
        txtCageNumber.setBounds(318, 320, 300, 30);
        formPanel.add(txtCageNumber);

//        JButton btnUpdate = new JButton("Update");
//        btnUpdate.setFont(new Font("Dialog", Font.BOLD, 16));
//        btnUpdate.setBounds(150, 370, 150, 40);
//        formPanel.add(btnUpdate);
       

//        JButton btnBack = new JButton("Back");
//        btnBack.setFont(new Font("Dialog", Font.BOLD, 16));
//        btnBack.setBounds(472, 370, 150, 40);
//        btnBack.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(cardPanel, "MainMenu"); // Correctly reference cardPanel
//            }
//        });
//        formPanel.add(btnBack);
    }

    private void initializeTable() {
        // Sample data for the table
        String[] columnNames = {"Name", "Breed", "Age", "Gender", "Size", "Cage Number"};
        Object[][] data = {
            {"Tom", "Siamese", "2", "Male", "Medium", "A1"},
            {"Whiskers", "Maine Coon", "3", "Female", "Large", "B2"}
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
                case 0: // Name
                case 1: // Breed
                    column.setPreferredWidth(100);
                    break;
                case 2: // Age
                    column.setPreferredWidth(50);
                    break;
                case 3: // Gender
                    column.setPreferredWidth(70);
                    break;
                case 4: // Size
                    column.setPreferredWidth(70);
                    break;
                case 5: // Cage Number
                    column.setPreferredWidth(100);
                    break;
            }
        }

        // Use JScrollPane for table with dynamic height
        tableScrollPane = new JScrollPane(table);
        tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tableScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
    }

    private void showSingleDogRecord() {

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
