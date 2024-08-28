package AnimalRescueFrontend;

import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateSale extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> cboEmployee;
    private JComboBox<String> cboPetOwner;
    private JComboBox<String> cboCat;
    private JComboBox<String> cboDog;
    private JComboBox<String> cboApplicantID;
    private JLabel lblSaleDate;
    private JTextField textField;
    private JTextField txtPrice;
    private ButtonGroup petTypeGroup;
    
    String applicantId;
    String applicationDate;
    String applicationStatus;
    String petOwnerId;
    String petOwnerfirstName;
    String petOwnerlastName;
    String petOwnercontactNo;
    String petOwneremailAddress;
    String petOwnerstreetAddress;
    
    String petName;
    String petsize;
    String petAge;
    String petGender;
    String petBreed;
    String petCageNo;
    String petFinalId;
    String petType;
    
    String EmployeeFirstName;
    String EmployeeLastName;
    String EmployeeContactNumber;
    String EmployeeEmailAddress;
    String EmployeeId;
    
   
    
    String date;
    String selectedPet;
    
    

    public CreateSale(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        // Title Label
        JLabel lblTitle = new JLabel("Create New Sale Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(223, 49, 427, 40);
        add(lblTitle);

        // Employee Dropdown
        JLabel lblEmployee = new JLabel("Employee:");
        lblEmployee.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmployee.setForeground(SystemColor.controlLtHighlight);
        lblEmployee.setBounds(150, 155, 135, 30);
        add(lblEmployee);

        
        String[] applicantIDs = {"Select Applicant Id","ID 1", "ID 2", "ID 3"}; // Example data
        cboApplicantID = new JComboBox<>(applicantIDs);
        cboApplicantID.setBounds(318, 115, 300, 30);
        cboApplicantID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    String selectedItem = (String) cboApplicantID.getSelectedItem();
                    if (selectedItem != null) {
                        String id = selectedItem.split(" - ")[0]; // Extract ID from the selected item
                        fetchApplicantDetails(id);
                    }
                }
            
        });
        add(cboApplicantID);
        
        String[] employees = {"Employee 1", "Employee 2", "Employee 3"}; // Example data
        cboEmployee = new JComboBox<>(employees);
        cboEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    String selectedItem = (String) cboEmployee.getSelectedItem();
                    if (selectedItem != null) {
                        String id = selectedItem.split(" - ")[0]; // Extract ID from the selected item
                        fetchEmployeeById(id);
                    }
                }
            
        });
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
        cboPetOwner.setEnabled(false);
        cboPetOwner.setBounds(318, 195, 300, 30);
        add(cboPetOwner);

        // Group the radio buttons
        petTypeGroup = new ButtonGroup();

        // Cat Dropdown
        JLabel lblCat = new JLabel("Cat:");
        lblCat.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCat.setForeground(SystemColor.controlLtHighlight);
        lblCat.setBounds(150, 272, 100, 30);
        add(lblCat);

        String[] cats = {"Tom", "Whiskers", "Fluffy"}; // Example data
        cboCat = new JComboBox<>(cats);
        cboCat.setBounds(318, 275, 300, 30);
        cboCat.setEnabled(false); // Initially disabled
        add(cboCat);

        // Dog Dropdown
        JLabel lblDog = new JLabel("Dog");
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
        date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
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
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(petType.equals("cat"))
                {
                	 CatClass cat = new CatClass(petFinalId, petName, petBreed, petCageNo, petGender, petsize, petAge);
                	 Employee emp=new Employee(EmployeeId,EmployeeFirstName,EmployeeLastName,EmployeeContactNumber,EmployeeEmailAddress);
                     PetOwnerClass pet=new PetOwnerClass(ownerId,ownerFirstName , ownerLastName, ownerContactName, ownerEmail, ownerStreet);
                     ApplicantClass or=new ApplicantClass(pet,date,null,cat,"Approved");
                     
                     Sale sale=new Sale("1",or,date,emp,txtPrice.getText());
                     String url1 = "http://localhost:8080/animalRescue/sale/create";
                     System.out.println("Object: " + sale);
                     sendRequest(url1, or);
                     
                }
        });
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
        
        JLabel lblApplicantId = new JLabel("Applicant Id:");
        lblApplicantId.setForeground(SystemColor.controlLtHighlight);
        lblApplicantId.setFont(new Font("Dialog", Font.BOLD, 16));
        lblApplicantId.setBounds(150, 115, 135, 30);
        add(lblApplicantId);
        
        JLabel lblReturnDate = new JLabel("Return Date:");
        lblReturnDate.setForeground(SystemColor.controlLtHighlight);
        lblReturnDate.setFont(new Font("Dialog", Font.BOLD, 16));
        lblReturnDate.setBounds(150, 235, 135, 30);
        add(lblReturnDate);
        
        textField = new JTextField();
        textField.setBounds(318, 235, 300, 30);
        add(textField);
        fetchApplicantData();
        fetchEmployeeData();
        toggleDropdowns(true); // Enable the Cat dropdown by default
        
    }

    private void toggleDropdowns(boolean showCat) {
        cboCat.setEnabled(showCat);
        cboDog.setEnabled(!showCat);
    }
    
//    private void fetchApplicantData() {
//        try {
//            URL url = new URL("http://localhost:8080/animalRescue/applicant/readStatus/Approved"); // Endpoint to get applicant data
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Accept", "application/json");
//
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                StringBuilder response = new StringBuilder();
//                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
//                    String line;
//                    while ((line = in.readLine()) != null) {
//                        response.append(line);
//                    }
//                }
//
//                JSONObject jsonObject = new JSONObject(response.toString());
//
//                // Clear previous items
//                cboApplicantID.removeAllItems(); 
//
//                // Extract Applicant Data
//                applicantId = jsonObject.optString("id", "No ID");
//                applicationDate = jsonObject.optString("applicationDate", "No Date");
//                applicationStatus = jsonObject.optString("status", "No Status");
//
//                // Extract Pet Owner Data
//                JSONObject petOwner = jsonObject.optJSONObject("petOwner");
//                if (petOwner != null) {
//                    petOwnerId = petOwner.optString("id", "No ID");
//                    petOwnerfirstName = petOwner.optString("firstName", "No First Name");
//                    petOwnerlastName = petOwner.optString("lastName", "No Last Name");
//                    petOwnercontactNo = petOwner.optString("contactNo", "No Contact No");
//                    petOwneremailAddress = petOwner.optString("emailAddress", "No Email");
//                    petOwnerstreetAddress = petOwner.optString("streetAddress", "No Street Address");
//                }
//
//                // Extract Pet Data (Cat or Dog)
//                JSONObject catId = jsonObject.optJSONObject("catId");
//                JSONObject dogId = jsonObject.optJSONObject("dogId");
//
//                if (catId != null) {
//                    petName = catId.optString("name", "No Name");
//                    petsize = catId.optString("size", "No Size");
//                    petAge = catId.optString("age", "No Age");
//                    petGender = catId.optString("gender", "No Gender");
//                    petBreed = catId.optString("breed", "No Breed");
//                    petCageNo = catId.optString("cageNumber", "No Cage Number");
//                    petFinalId = catId.optString("catId", "No Cat ID");
//                    selectedPet = "cat";
//                } else if (dogId != null) {
//                    petName = dogId.optString("name", "No Name");
//                    petsize = dogId.optString("size", "No Size");
//                    petAge = dogId.optString("age", "No Age");
//                    petGender = dogId.optString("gender", "No Gender");
//                    petBreed = dogId.optString("breed", "No Breed");
//                    petCageNo = dogId.optString("cageNumber", "No Cage Number");
//                    petFinalId = dogId.optString("dogId", "No Dog ID");
//                    selectedPet = "dog";
//                }
//
//                // Update the Applicant ID dropdown
//                cboApplicantID.addItem(String.format("%s - %s - %s", applicantId, applicationDate, applicationStatus));
//            } else {
//                JOptionPane.showMessageDialog(null, "Error: Unable to fetch applicant data.");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
//        }
//    }
//    
private void fetchApplicantData() {
    try {
        URL url = new URL("http://localhost:8080/animalRescue/applicant/readStatus/Approved"); // Endpoint to get applicant data
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONArray jsonArray = new JSONArray(response.toString());
            cboApplicantID.removeAllItems(); // Clear previous items
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extract Applicant Data
                applicantId = jsonObject.optString("id", "No ID");
                applicationDate = jsonObject.optString("applicationDate", "No Date");
                applicationStatus = jsonObject.optString("status", "No Status");

                // Extract Pet Owner Data
                JSONObject petOwner = jsonObject.optJSONObject("petOwner");
                if (petOwner != null) {
                    petOwnerId = petOwner.optString("id", "No ID");
                    petOwnerfirstName = petOwner.optString("firstName", "No First Name");
                    petOwnerlastName = petOwner.optString("lastName", "No Last Name");
                    petOwnercontactNo = petOwner.optString("contactNo", "No Contact No");
                    petOwneremailAddress = petOwner.optString("emailAddress", "No Email");
                    petOwnerstreetAddress = petOwner.optString("streetAddress", "No Street Address");
                }

                // Extract Pet Data (Cat or Dog)
                JSONObject catId = jsonObject.optJSONObject("catId");
                JSONObject dogId = jsonObject.optJSONObject("dogId");

                if (catId != null) {
                	petType="cat";
                    petName = catId.optString("name", "No Name");
                    petsize = catId.optString("size", "No Size");
                    petAge = catId.optString("age", "No Age");
                    petGender = catId.optString("gender", "No Gender");
                    petBreed = catId.optString("breed", "No Breed");
                    petCageNo = catId.optString("cageNumber", "No Cage Number");
                    petFinalId = catId.optString("catId", "No Cat ID");
                    selectedPet="cat";
                } else if (dogId != null) {
                	petType="dog";
                    petName = dogId.optString("name", "No Name");
                    petsize = dogId.optString("size", "No Size");
                    petAge = dogId.optString("age", "No Age");
                    petGender = dogId.optString("gender", "No Gender");
                    petBreed = dogId.optString("breed", "No Breed");
                    petCageNo = dogId.optString("cageNumber", "No Cage Number");
                    petFinalId = dogId.optString("dogId", "No Dog ID");
                    selectedPet="dog";
                }

                // Update the Applicant ID dropdown
                cboApplicantID.addItem(String.format("%s - %s - %s", applicantId, applicationDate,applicationStatus));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error: Unable to fetch applicant data.");
        }
    } 
    
    catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
    
    
}

private void fetchApplicantDetails(String id) {
    try {
        URL url = new URL("http://localhost:8080/animalRescue/applicant/read/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONObject jsonObject = new JSONObject(response.toString()); // Parse as JSONObject
            
//            // Clear previous items
//            cboApplicantID.removeAllItems();
            cboCat.removeAllItems();
            cboDog.removeAllItems();
            cboPetOwner.removeAllItems();

            // Extract Applicant Data
            applicantId = jsonObject.optString("id", "No ID");
            applicationDate = jsonObject.optString("applicationDate", "No Date");
            applicationStatus = jsonObject.optString("status", "No Status");

            // Extract Pet Owner Data
            JSONObject petOwner = jsonObject.optJSONObject("petOwner");
            if (petOwner != null) {
                petOwnerId = petOwner.optString("id", "No ID");
                petOwnerfirstName = petOwner.optString("firstName", "No First Name");
                petOwnerlastName = petOwner.optString("lastName", "No Last Name");
                petOwnercontactNo = petOwner.optString("contactNo", "No Contact No");
                petOwneremailAddress = petOwner.optString("emailAddress", "No Email");
                petOwnerstreetAddress = petOwner.optString("streetAddress", "No Street Address");
                System.out.print(String.format("%s - %s - %s", petOwnerId, petOwnerfirstName, petOwnerlastName));
                cboPetOwner.addItem(String.format("%s - %s - %s", petOwnerId, petOwnerfirstName, petOwnerlastName));
            }

            // Extract Pet Data (Cat or Dog)
            JSONObject catId = jsonObject.optJSONObject("catId");
            JSONObject dogId = jsonObject.optJSONObject("dogId");

            if (catId != null) {
            	petType="cat";
                petName = catId.optString("name", "No Name");
                petsize = catId.optString("size", "No Size");
                petAge = catId.optString("age", "No Age");
                petGender = catId.optString("gender", "No Gender");
                petBreed = catId.optString("breed", "No Breed");
                petCageNo = catId.optString("cageNumber", "No Cage Number");
                petFinalId = catId.optString("catId", "No Cat ID");
                selectedPet="cat";
                cboCat.addItem(String.format("%s - %s - %s", petFinalId, petName, petsize));
            } else if (dogId != null) {
            	petType="dog";
                petName = dogId.optString("name", "No Name");
                petsize = dogId.optString("size", "No Size");
                petAge = dogId.optString("age", "No Age");
                petGender = dogId.optString("gender", "No Gender");
                petBreed = dogId.optString("breed", "No Breed");
                petCageNo = dogId.optString("cageNumber", "No Cage Number");
                petFinalId = dogId.optString("dogId", "No Dog ID");
                selectedPet="dog";
                cboDog.addItem(String.format("%s - %s - %s", petFinalId, petName, petsize));
            }

            // Update the Applicant ID dropdown
            cboApplicantID.addItem(String.format("%s - %s - %s", applicantId, applicationDate, applicationStatus));
        } else {
            JOptionPane.showMessageDialog(null, "Error: Unable to fetch applicant details.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}

private void fetchEmployeeById(String id) {
    try {
        URL url = new URL("http://localhost:8080/animalRescue/employee/read/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONObject jsonObject = new JSONObject(response.toString());

            
            int id1 = jsonObject.getInt("id");
            EmployeeId=String.valueOf(id1);
            EmployeeFirstName = jsonObject.optString("firstName", "N/A");
            EmployeeLastName = jsonObject.optString("lastName", "N/A");
            EmployeeEmailAddress= jsonObject.optString("emailAddress", "N/A");
            EmployeeContactNumber=jsonObject.optString("contactNumber", "N/A");
            cboCat.addItem(String.format("%s - %s %s", EmployeeId, EmployeeFirstName, EmployeeLastName));

        } else {
            JOptionPane.showMessageDialog(null, "Error: Unable to fetch cat details.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
private void fetchEmployeeData() {
    try {
        URL url = new URL("http://localhost:8080/animalRescue/employee/getall"); // Endpoint to get cat IDs
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONArray jsonArray = new JSONArray(response.toString());
            cboEmployee.removeAllItems(); // Clear previous items
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                EmployeeId=String.valueOf(id);
                EmployeeFirstName = jsonObject.optString("firstName", "N/A");
                EmployeeLastName = jsonObject.optString("lastName", "N/A");
                EmployeeEmailAddress= jsonObject.optString("emailAddress", "N/A");
                EmployeeContactNumber=jsonObject.optString("contactNumber", "N/A");
                cboEmployee.addItem(String.format("%s - %s %s", EmployeeId, EmployeeFirstName, EmployeeLastName));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Unable to fetch employee IDs.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
private String sendRequest(String url, Sale or) throws Exception {
    URL url1 = new URL(url);
    HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/json; utf-8");
    conn.setRequestProperty("Accept", "application/json");
    conn.setDoOutput(true);

    JSONObject jsonObject = new JSONObject();
    JSONObject petOwnerJson = new JSONObject();
    petOwnerJson.put("id", or.getPetOwner().getId());
    petOwnerJson.put("firstName", or.getPetOwner().getFirstName());
    petOwnerJson.put("lastName", or.getPetOwner().getLastName());
    petOwnerJson.put("contactNo", or.getPetOwner().getContactNo());
    petOwnerJson.put("emailAddress", or.getPetOwner().getEmailAddress());
    petOwnerJson.put("streetAddress", or.getPetOwner().getStreetAddress());

    JSONObject catJson = null;
    if (or.getCat() != null) {
        catJson = new JSONObject();
        catJson.put("catId", or.getCat().getId());
        catJson.put("name", or.getCat().getName());
        catJson.put("breed", or.getCat().getBreed());
        catJson.put("cageNumber", or.getCat().getCageNumber());
        catJson.put("gender", or.getCat().getGender());
        catJson.put("size", or.getCat().getSize());
        catJson.put("age", or.getCat().getAge());
    }

    JSONObject dogJson = null;
    if (or.getDog() != null) {
        dogJson = new JSONObject();
        dogJson.put("dogId", or.getDog().getId());
        dogJson.put("name", or.getDog().getName());
        dogJson.put("breed", or.getDog().getBreed());
        dogJson.put("cageNumber", or.getDog().getCageNumber());
        dogJson.put("gender", or.getDog().getGender());
        dogJson.put("size", or.getDog().getSize());
        dogJson.put("age", or.getDog().getAge());
    }
    
    JSONObject applicantJson = null;
    if (or.getDog() != null) {
    	applicantJson = new JSONObject();
    	applicantJson.put("dog", or.);
    	applicantJson.put("name", or.applicantJson().getName());
    	applicantJson.put("breed", or.applicantJson().getBreed());
    	applicantJson.put("cageNumber", or.applicantJson().getCageNumber());
    	applicantJson.put("gender", or.applicantJson().getGender());
    	applicantJson.put("size", or.applicantJson().getSize());
    	applicantJson.put("age", or.applicantJson().getAge());
    }
    
    

    jsonObject.put("petOwner", petOwnerJson);
    jsonObject.put("applicationDate", or.getapplicationDate());
    jsonObject.put("dogId", dogJson != null ? dogJson : JSONObject.NULL);
    jsonObject.put("catId", catJson != null ? catJson : JSONObject.NULL);
    jsonObject.put("status", or.getReturnDate());

    String jsonString = jsonObject.toString();

    System.out.println("request"+jsonString);
    try (OutputStream os = conn.getOutputStream()) {
        byte[] input = jsonString.getBytes("utf-8");
        os.write(input, 0, input.length);
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        return response.toString();
    }
}
}
