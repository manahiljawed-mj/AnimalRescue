package AnimalRescueFrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import AnimalRescueFrontend.CatClass;
import AnimalRescueFrontend.DogClass;
import AnimalRescueFrontend.PetOwnerClass;
public class CreatePetOwner extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtContactNo;
    private JTextField txtEmailAddress;
    private JTextField txtStreetAddress;
    private JRadioButton rdbtnCat;
    private JRadioButton rdbtnDog;
    private JComboBox<String> cboCat;
    private JComboBox<String> cboDog;
    private JTextField txtCurrentDate;
    private JTextField txtReturnDate;
    String petName;
    String petsize;
    String petAge;
    String petGender;
    String petBreed;
    String petCageNo;
    String petFinalId;

    public CreatePetOwner(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(null);
        setBackground(new Color(0, 128, 128));

        JLabel lblTitle = new JLabel("Create New PetOwner Record");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        lblTitle.setForeground(SystemColor.controlLtHighlight);
        lblTitle.setBounds(222, 81, 396, 40);
        add(lblTitle);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblFirstName.setForeground(SystemColor.controlLtHighlight);
        lblFirstName.setBounds(150, 155, 119, 30);
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(318, 155, 300, 30);
        add(txtFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblLastName.setForeground(SystemColor.controlLtHighlight);
        lblLastName.setBounds(150, 195, 100, 30);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(318, 195, 300, 30);
        add(txtLastName);

        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblContactNo.setForeground(SystemColor.controlLtHighlight);
        lblContactNo.setBounds(150, 235, 119, 30);
        add(lblContactNo);

        txtContactNo = new JTextField();
        txtContactNo.setBounds(318, 237, 300, 30);
        add(txtContactNo);

        JLabel lblEmailAddress = new JLabel("Email Address:");
        lblEmailAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblEmailAddress.setForeground(SystemColor.controlLtHighlight);
        lblEmailAddress.setBounds(150, 279, 136, 30);
        add(lblEmailAddress);

        txtEmailAddress = new JTextField();
        txtEmailAddress.setBounds(318, 279, 300, 30);
        add(txtEmailAddress);

        JLabel lblStreetAddress = new JLabel("Street Address:");
        lblStreetAddress.setFont(new Font("Dialog", Font.BOLD, 16));
        lblStreetAddress.setForeground(SystemColor.controlLtHighlight);
        lblStreetAddress.setBounds(150, 321, 136, 30);
        add(lblStreetAddress);

        txtStreetAddress = new JTextField();
        txtStreetAddress.setBounds(318, 321, 300, 30);
        add(txtStreetAddress);

        JLabel lblCurrentDate = new JLabel("Current Date:");
        lblCurrentDate.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCurrentDate.setForeground(SystemColor.controlLtHighlight);
        lblCurrentDate.setBounds(150, 363, 119, 30);
        add(lblCurrentDate);

        txtCurrentDate = new JTextField();
        txtCurrentDate.setBounds(318, 363, 300, 30);
        txtCurrentDate.setText(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        txtCurrentDate.setEditable(false);
        add(txtCurrentDate);

        JLabel lblReturnDate = new JLabel("Return Date:");
        lblReturnDate.setFont(new Font("Dialog", Font.BOLD, 16));
        lblReturnDate.setForeground(SystemColor.controlLtHighlight);
        lblReturnDate.setBounds(150, 405, 119, 30);
        add(lblReturnDate);

        txtReturnDate = new JTextField();
        txtReturnDate.setBounds(318, 405, 300, 30);
        add(txtReturnDate);

        // Radio Buttons for Cat and Dog
        rdbtnCat = new JRadioButton("Cat");
        rdbtnCat.setFont(new Font("Dialog", Font.BOLD, 16));
        rdbtnCat.setForeground(SystemColor.controlLtHighlight);
        rdbtnCat.setBackground(new Color(0, 128, 128));
        rdbtnCat.setBounds(150, 445, 100, 30);
        rdbtnCat.setSelected(true); // Default selection
        rdbtnCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                togglePetSelection(true);
            }
        });
        add(rdbtnCat);

        rdbtnDog = new JRadioButton("Dog");
        rdbtnDog.setFont(new Font("Dialog", Font.BOLD, 16));
        rdbtnDog.setForeground(SystemColor.controlLtHighlight);
        rdbtnDog.setBackground(new Color(0, 128, 128));
        rdbtnDog.setBounds(250, 445, 100, 30);
        rdbtnDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                togglePetSelection(false);
            }
        });
        add(rdbtnDog);

        ButtonGroup petGroup = new ButtonGroup();
        petGroup.add(rdbtnCat);
        petGroup.add(rdbtnDog);

        // Dropdown for Cat
        cboCat = new JComboBox<>();
        cboCat.setBounds(318, 485, 300, 30);
        cboCat.setEnabled(true);
        add(cboCat);

        // Dropdown for Dog
        cboDog = new JComboBox<>();
        cboDog.setBounds(318, 525, 300, 30);
        cboDog.setEnabled(false);
        add(cboDog);

        // Buttons
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
        btnAdd.setBounds(150, 580, 150, 40);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Gather pet owner details
                    String firstName = txtFirstName.getText();
                    String lastName = txtLastName.getText();
                    String contactNo = txtContactNo.getText();
                    String emailAddress = txtEmailAddress.getText();
                    String streetAddress = txtStreetAddress.getText();
                    
                    // Gather pet details based on the selected pet type
                    String selectedPetId = "";
                    String selectedPetType = rdbtnCat.isSelected() ? "cat" : "dog";
                    if (selectedPetType.equals("cat")) {
                        selectedPetId = (String) cboCat.getSelectedItem();
                    } else {
                        selectedPetId = (String) cboDog.getSelectedItem();
                    }
                    String petId = selectedPetId.split(" - ")[0];  // Extract just the ID
                    
                    // Gather return date
                    String returnDate = txtReturnDate.getText();

                    // Construct JSON payload for pet owner creation
                    String petOwnerJson = String.format(
                        "{\"firstName\":\"%s\",\"lastName\":\"%s\",\"contactNo\":\"%s\",\"emailAddress\":\"%s\",\"streetAddress\":\"%s\",\"id\":\"%s\",\"petType\":\"%s\",\"takenDate\":\"%s\",\"returnDate\":\"%s\"}",
                        firstName, lastName, contactNo, emailAddress, streetAddress, petId, selectedPetType, txtCurrentDate.getText(), returnDate
                    );

                    // Send request to create pet owner and get response
                    String responseJson = sendRequest1("http://localhost:8080/animalRescue/petOwner/create", petOwnerJson);
                    if (responseJson != null) {
                        // Parse the response JSON
                        JSONObject responseObject = new JSONObject(responseJson);
                        String createdPetId = String.valueOf(responseObject.optInt("id"));
                        System.out.println(createdPetId);
                        String petOwnerFirstName=responseObject.optString("firstName");
                        System.out.println(petOwnerFirstName);
                        String petOwnerLasttName=responseObject.optString("lastName");
                        String petOwnerContactNo=responseObject.optString("contactNo");
                        String petOwnerEmailAddress=responseObject.optString("emailAddress");
                        String petOwnerStreetAddress=responseObject.optString("streetAddress");
                      
                  
                       
                        if (selectedPetType.equals("cat")) {
                        	
                        	 System.out.println(petFinalId+""+petName+""+petBreed+""+petCageNo+""+petGender+""+petsize+""+petAge);
                        	 CatClass cat=new CatClass(petFinalId, petName, petBreed,petCageNo, petGender, petsize, petAge);
                               System.out.print("Cat Breed"+cat.getBreed());
                            PetOwnerClass pet=new PetOwnerClass(createdPetId,petOwnerFirstName , petOwnerLasttName, petOwnerContactNo, petOwnerEmailAddress, petOwnerStreetAddress);
                                System.out.println("pet owner"+pet.getEmailAddress());
                                               
                                OwnerRecordClass or=new OwnerRecordClass(null,cat,pet,txtCurrentDate.getText(),txtReturnDate.getText());
                                // Send request to create owner record
                                System.out.println("Object"+or.getCat().getId());
                                System.out.println("Object"+or.getPetOwner().getContactNo());
                                System.out.println("Object"+or.getTakenDate());
                                System.out.println("Or Object"+or);
                                
                                String url = "http://localhost:8080/animalRescue/ownerRecord/create";
                                System.out.println("Object: " + or);
                                sendRequest(url, or);

                                // Show success message
                                JOptionPane.showMessageDialog(null, "Pet Owner record created successfully!");
//                                sendRequest("http://localhost:8080/animalRescue/ownerRecord/create", or);
//
//                                JOptionPane.showMessageDialog(null, "Pet Owner record created successfully!");
                            
                        } else {
                        	
                        	
                        	System.out.println(petFinalId+""+petName+""+petBreed+""+petCageNo+""+petGender+""+petsize+""+petAge);
                       	 DogClass dog=new DogClass(petFinalId, petName, petBreed,petCageNo, petGender, petsize, petAge);
                              System.out.print("Cat Breed"+dog.getBreed());
                           PetOwnerClass pet=new PetOwnerClass(createdPetId,petOwnerFirstName , petOwnerLasttName, petOwnerContactNo, petOwnerEmailAddress, petOwnerStreetAddress);
                               System.out.println("pet owner"+pet.getEmailAddress());
                                              
                               OwnerRecordClass or=new OwnerRecordClass(dog,null,pet,txtCurrentDate.getText(),txtReturnDate.getText());
                               
                               System.out.println("Object: " + or);
                               String url = "http://localhost:8080/animalRescue/ownerRecord/create";
                               sendRequest(url, or);

                               // Show success message
                               JOptionPane.showMessageDialog(null, "Pet Owner record created successfully!");
                               // Send request to create owner record
                               System.out.println("Object"+or.getCat());
                               System.out.println("Object"+or.getPetOwner());
                               System.out.println("Object"+or.toString());
//                               sendRequest("http://localhost:8080/animalRescue/ownerRecord/create", or);
//
//                               JOptionPane.showMessageDialog(null, "Pet Owner record created successfully!");
                          
                        }
                       
                        
                      
                        // Optionally clear form fields or update UI
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to create Pet Owner record.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while creating the Pet Owner record.");
                }
            }
        });
        add(btnAdd);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Dialog", Font.BOLD, 16));
        btnCancel.setBounds(350, 580, 150, 40);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PreviousPanelName"); // Change to appropriate panel name
            }
        });
        add(btnCancel);

        togglePetSelection(true); // Initialize dropdowns based on default selection
    }

    private void togglePetSelection(boolean isCat) {
        cboCat.setEnabled(isCat);
        cboDog.setEnabled(!isCat);
        if (isCat) {
            fetchCatData();
        } else {
            fetchDogData();
        }
    }

    private void fetchCatData() {
        try {
            URL url = new URL("http://localhost:8080/animalRescue/cat/getall"); // Endpoint to get cat IDs
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
                cboCat.removeAllItems(); // Clear previous items
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("catId");
                    String name = jsonObject.optString("name", "N/A");
                    petName=jsonObject.optString("name", "N/A");
                    String breed = jsonObject.optString("breed", "N/A");
                    petBreed=jsonObject.optString("breed", "N/A");
                    petCageNo=jsonObject.optString("cageNumber", "N/A");
                    petGender=jsonObject.optString("gender", "N/A");
                    petsize=jsonObject.optString("size", "N/A");
                    petAge=jsonObject.optString("age", "N/A");
                    petFinalId=String.valueOf(jsonObject.opt("catId"));
                    cboCat.addItem(String.format("%d - %s %s", id, name, breed));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: Unable to fetch cat IDs.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void fetchDogData() {
        try {
            URL url = new URL("http://localhost:8080/animalRescue/dog/getall"); // Endpoint to get dog IDs
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
                cboDog.removeAllItems(); // Clear previous items
                for (int i = 0; i < jsonArray.length(); i++) {
                  
                   
           
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("dogId");
                    String name = jsonObject.optString("name", "N/A");
                    petName=jsonObject.optString("name", "N/A");
                    String breed = jsonObject.optString("breed", "N/A");
                    petBreed=jsonObject.optString("breed", "N/A");
                    petCageNo=jsonObject.optString("cageNumber", "N/A");
                    petGender=jsonObject.optString("gender", "N/A");
                    petsize=jsonObject.optString("size", "N/A");
                    petAge=jsonObject.optString("age", "N/A");
                    petFinalId=String.valueOf(jsonObject.opt("dogId"));
                    cboDog.addItem(String.format("%d - %s %s", id, name, breed));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: Unable to fetch dog IDs.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

  
    private String sendRequest(String url, OwnerRecordClass ownerRecord) throws Exception {
        URL url1 = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonObject = new JSONObject();
        JSONObject petOwnerJson = new JSONObject();
        petOwnerJson.put("id", ownerRecord.getPetOwner().getId());
        petOwnerJson.put("firstName", ownerRecord.getPetOwner().getFirstName());
        petOwnerJson.put("lastName", ownerRecord.getPetOwner().getLastName());
        petOwnerJson.put("contactNo", ownerRecord.getPetOwner().getContactNo());
        petOwnerJson.put("emailAddress", ownerRecord.getPetOwner().getEmailAddress());
        petOwnerJson.put("streetAddress", ownerRecord.getPetOwner().getStreetAddress());

        JSONObject catJson = null;
        if (ownerRecord.getCat() != null) {
            catJson = new JSONObject();
            catJson.put("catId", ownerRecord.getCat().getId());
            catJson.put("name", ownerRecord.getCat().getName());
            catJson.put("breed", ownerRecord.getCat().getBreed());
            catJson.put("cageNumber", ownerRecord.getCat().getCageNumber());
            catJson.put("gender", ownerRecord.getCat().getGender());
            catJson.put("size", ownerRecord.getCat().getSize());
            catJson.put("age", ownerRecord.getCat().getAge());
        }

        JSONObject dogJson = null;
        if (ownerRecord.getDog() != null) {
            dogJson = new JSONObject();
            dogJson.put("dogId", ownerRecord.getDog().getId());
            dogJson.put("name", ownerRecord.getDog().getName());
            dogJson.put("breed", ownerRecord.getDog().getBreed());
            dogJson.put("cageNumber", ownerRecord.getDog().getCageNumber());
            dogJson.put("gender", ownerRecord.getDog().getGender());
            dogJson.put("size", ownerRecord.getDog().getSize());
            dogJson.put("age", ownerRecord.getDog().getAge());
        }

        jsonObject.put("petOwner", petOwnerJson);
        jsonObject.put("cat", catJson != null ? catJson : JSONObject.NULL);
        jsonObject.put("dog", dogJson != null ? dogJson : JSONObject.NULL);
        jsonObject.put("takenDate", ownerRecord.getTakenDate());
        jsonObject.put("returnDate", ownerRecord.getReturnDate());

        String jsonString = jsonObject.toString();

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
    
    private String sendRequest1(String urlString, String petOwnerJson) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(petOwnerJson == null ? "GET" : "POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        if (petOwnerJson != null) {
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = petOwnerJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
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