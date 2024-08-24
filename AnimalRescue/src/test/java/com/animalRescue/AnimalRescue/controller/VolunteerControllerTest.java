package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Volunteer;
import com.animalRescue.AnimalRescue.service.VolunteerService;
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
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(VolunteerController.class)
public class VolunteerControllerTest {

    @InjectMocks
    private VolunteerController volunteerController;

    @Mock
    private VolunteerService volunteerService;

    private MockMvc mockMvc;

    private Volunteer volunteer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(volunteerController).build();
        volunteer = new Volunteer.Builder()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setContactNo("1234567890")
                .setEmailAddress("john.doe@example.com")
                .setStreetAddress("123 Elm Street")
                .setAvailability("Weekends")
                .build();
    }

    @Test
    void testCreate() throws Exception {
        when(volunteerService.create(any(Volunteer.class))).thenReturn(volunteer);
        mockMvc.perform(post("/volunteers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"contactNo\":\"1234567890\",\"emailAddress\":\"john.doe@example.com\",\"streetAddress\":\"123 Elm Street\",\"availability\":\"Weekends\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(volunteer.getId()));
    }

    @Test
    void testRead() throws Exception {
        when(volunteerService.read(1L)).thenReturn(volunteer);
        mockMvc.perform(get("/volunteers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(volunteer.getFirstName()));
    }

    @Test
    void testUpdate() throws Exception {
        when(volunteerService.update(any(Volunteer.class))).thenReturn(volunteer);
        mockMvc.perform(put("/volunteers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"contactNo\":\"1234567890\",\"emailAddress\":\"john.doe@example.com\",\"streetAddress\":\"123 Elm Street\",\"availability\":\"Weekends\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(volunteer.getId()));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(volunteerService).delete(1L);
        mockMvc.perform(delete("/volunteers/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAll() throws Exception {
        when(volunteerService.getall()).thenReturn((Set<Volunteer>) List.of(volunteer));
        mockMvc.perform(get("/volunteers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value(volunteer.getFirstName()));
    }
}
