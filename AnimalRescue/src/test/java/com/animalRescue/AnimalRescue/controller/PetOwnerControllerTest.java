package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.service.PetOwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(PetOwnerController.class)
public class PetOwnerControllerTest {

    @InjectMocks
    private PetOwnerController petOwnerController;

    @Mock
    private PetOwnerService petOwnerService;

    private MockMvc mockMvc;

    private PetOwner petOwner;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(petOwnerController).build();
        petOwner = new PetOwner.Builder()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setContactNo("1234567890")
                .setEmailAddress("john.doe@example.com")
                .setStreetAddress("123 Elm Street")
                .build();
    }

    @Test
    void testCreate() throws Exception {
        when(petOwnerService.create(any(PetOwner.class))).thenReturn(petOwner);
        mockMvc.perform(post("/petOwners")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"contactNo\":\"1234567890\",\"emailAddress\":\"john.doe@example.com\",\"streetAddress\":\"123 Elm Street\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(petOwner.getId()));
    }

    @Test
    void testRead() throws Exception {
        when(petOwnerService.read(1L)).thenReturn(petOwner);
        mockMvc.perform(get("/petOwners/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(petOwner.getFirstName()));
    }

    @Test
    void testUpdate() throws Exception {
        when(petOwnerService.update(any(PetOwner.class))).thenReturn(petOwner);
        mockMvc.perform(put("/petOwners")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"contactNo\":\"1234567890\",\"emailAddress\":\"john.doe@example.com\",\"streetAddress\":\"123 Elm Street\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(petOwner.getFirstName()));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(petOwnerService).delete(1L);
        mockMvc.perform(delete("/petOwners/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAll() throws Exception {
        when(petOwnerService.getall()).thenReturn((Set<PetOwner>) List.of(petOwner));
        mockMvc.perform(get("/petOwners"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value(petOwner.getFirstName()));
    }
}
