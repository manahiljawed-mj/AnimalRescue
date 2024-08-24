package com.animalRescue.AnimalRescue.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.factory.DogFactory;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DogControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/animalRescue/dog";

    private static Dog roxy;

    @BeforeEach
    public void setUp() {
        roxy = DogFactory.buildDog("Roxy", "Medium", 8, "Female", "Pitbull", 107, new HashSet<>());
    }


    @Test
    void testCreateDog() {
        String url = BASE_URL + "/create";
        ResponseEntity<Dog> response = restTemplate.postForEntity(url, roxy, Dog.class);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        Dog createdDog = response.getBody();
        assertEquals(roxy.getName(), createdDog.getName());
        System.out.println("Created Dog: " + createdDog);
    }

    @Test
    void testReadDog() {
        String url = BASE_URL + "/read/" + roxy.getDogId();
        ResponseEntity<Dog> response = restTemplate.getForEntity(url, Dog.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Dog readDog = response.getBody();
        assertEquals(roxy.getDogId(), readDog.getDogId());
        System.out.println("Read Dog: " + readDog);
    }


    @Test
    void testUpdateDog() {
        String url = BASE_URL + "/update";
        Dog updatedDog = new Dog.Builder()
                .copy(roxy)
                .setName("Snowy")
                .build();
        ResponseEntity<Dog> response = restTemplate.postForEntity(url, updatedDog, Dog.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Dog updated = response.getBody();
        assertEquals(updatedDog.getName(), updated.getName());
        System.out.println("Updated Dog: " + updated);
    }

    @Test
    void testDeleteDog() {
        String url = BASE_URL + "/delete/" + roxy.getDogId();
        restTemplate.delete(url);
        String deleteUrl = BASE_URL + "/read/" + roxy.getDogId();
        ResponseEntity<Dog> response = restTemplate.getForEntity(deleteUrl, Dog.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        System.out.println("Deleted Dog (verified by read attempt)");
    }


  /* @Test
    void testGetAllDogs() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Set<Dog>> response = restTemplate.exchange(url, HttpMethod.GET, entity, Set.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        System.out.println("Show All Dogs: " + response.getBody());
    }*/
}