package com.animalRescue.AnimalRescue.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import com.animalRescue.AnimalRescue.domain.Volunteer;
import com.animalRescue.AnimalRescue.factory.VolunteerFactory;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VolunteerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/animalRescue/volunteer";

    private Volunteer volunteer;

    @BeforeEach
    public void setUp() {
        volunteer=VolunteerFactory.buildVolunteer(4L,"Manahil","Jawed","12345","abc@gmail.com","abc street","online");
    }
    @Test
    @Order(1)
    void testCreateVolunteer() {
        String url = BASE_URL + "/create";
        // Log the dog object being sent
        System.out.println("Sending Volunteer object: " + volunteer);
        ResponseEntity<Volunteer> response = restTemplate.postForEntity(url, volunteer, Volunteer.class);
        // Log the response status and body
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Change to HttpStatus.OK if needed
        assertNotNull(response.getBody());
        Volunteer createdVolunteer = response.getBody();
        assertEquals(volunteer.getFirstName(), createdVolunteer.getFirstName());
        System.out.println("Created Volunteer: " + createdVolunteer);
    }

    @Test
    @Order(2)
    void testReadVolunteer() {
        // Ensure the dog is created before reading
        assertNotNull(volunteer.getId(), "Volunteer ID should not be null");
        // Correct URL format
        String url = BASE_URL + "/read/" + volunteer.getId();
        // Log the URL being accessed
        System.out.println("Request URL: " + url);
        ResponseEntity<Volunteer> response = restTemplate.getForEntity(url, Volunteer.class);
        // Log the response status and body
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected status code 200 OK");
        assertNotNull(response.getBody(), "Response body should not be null");
        Volunteer readVolunteer = response.getBody();
        // Log the details of the read dog
        System.out.println("Read Volunteer: " + readVolunteer);
    }

    @Test
    @Order(3)
    void testUpdateVolunteer() {
        String url = BASE_URL + "/update";
        Volunteer updatedVolunteer = new Volunteer.Builder()
                .copy(volunteer)
                .setFirstName("Manahil")
                .setLastName("Jawed")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Volunteer> request = new HttpEntity<>(updatedVolunteer, headers);
        // Using exchange method for PUT request
        ResponseEntity<Volunteer> response = restTemplate.exchange(url, HttpMethod.PUT, request, Volunteer.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Volunteer updated = response.getBody();
        assertEquals(updatedVolunteer.getFirstName(), updated.getFirstName());
        System.out.println("Updated Volunteer: " + updated);
    }


    @Test
    @Order(4)
    void testGetAllVolunteers() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Set> response = restTemplate.exchange(url, HttpMethod.GET, entity, Set.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        System.out.println("Show All Volunteers: " + response.getBody());
    }

    @Test
    @Order(5)
    void testDeleteVolunteer() {
        // DELETE the dog
        String deleteUrl = BASE_URL + "/delete/" + volunteer.getId();
        restTemplate.delete(deleteUrl);
        // Verify the deletion by attempting to read the dog
        String readUrl = BASE_URL + "/read/" + volunteer.getId();
        ResponseEntity<Volunteer> response = restTemplate.getForEntity(readUrl, Volunteer.class);
        // Log the result
        System.out.println("Response Status Code after deletion attempt: " + response.getStatusCode());
        System.out.println("Response Body after deletion attempt: " + response.getBody());

    }


}
