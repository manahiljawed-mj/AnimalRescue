package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.factory.DogFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.factory.CatFactory;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/animalRescue/cat";

    private static Cat whiskers;

    @BeforeEach
    public void setUp() {

        whiskers = CatFactory.buildCat("Whiskers", "Small", 3, "Female", "Pitbull", 201,new HashSet<>());
    }

    @Test
    @Order(1)
    void testCreateCat() {
        String url = BASE_URL + "/create";
        ResponseEntity<Cat> response = restTemplate.postForEntity(url, whiskers, Cat.class);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        Cat createdCat = response.getBody();
        assertEquals(whiskers.getName(), createdCat.getName());
        System.out.println("Created Cat: " + createdCat);
    }

    @Test
    @Order(2)
    void testReadCat() {
        String url = BASE_URL + "/read/" + whiskers.getCatId();
        ResponseEntity<Cat> response = restTemplate.getForEntity(url, Cat.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Cat readCat = response.getBody();
        assertEquals(whiskers.getCatId(), readCat.getCatId());
        System.out.println("Read Cat: " + readCat);
    }

    @Test
    @Order(3)
    void testUpdateCat() {
        String url = BASE_URL + "/update";
        Cat updatedCat = new Cat.Builder()
                .copy(whiskers)
                .setSize("Large")
                .build();
        ResponseEntity<Cat> response = restTemplate.postForEntity(url, updatedCat, Cat.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Cat updated = response.getBody();
        assertEquals(updatedCat.getSize(), updated.getSize());
        System.out.println("Updated Cat: " + updated);
    }

    @Test
    @Order(4)
    void testDeleteCat() {
        String url = BASE_URL + "/delete/" + whiskers.getCatId();
        restTemplate.delete(url);
        String deleteUrl = BASE_URL + "/read/" + whiskers.getCatId();
        ResponseEntity<Cat> response = restTemplate.getForEntity(deleteUrl, Cat.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        System.out.println("Deleted Cat (verified by read attempt)");
    }

    @Test
    @Order(5)
    void testGetAllCats() {
        String url = BASE_URL + "/getall";
        ResponseEntity<Set> response = restTemplate.getForEntity(url, Set.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        System.out.println("All Cats: " + response.getBody());
    }
}
