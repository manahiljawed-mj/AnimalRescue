package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.OwnerRecord;
import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.service.OwnerRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(OwnerRecordController.class)
public class OwnerRecordControllerTest {

    @InjectMocks
    private OwnerRecordController ownerRecordController;

    @Mock
    private OwnerRecordService ownerRecordService;

    private MockMvc mockMvc;

    private OwnerRecord ownerRecord;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerRecordController).build();
        ownerRecord = new OwnerRecord.Builder()
                .setId(1L)
                .setDog(new Dog()) // Assume Dog and Cat instances are available
                .setCat(new Cat())
                .setPetOwner(new PetOwner())
                .setTakenDate(LocalDate.now())
                .setReturnDate(LocalDate.now().plusMonths(6))
                .build();
    }

    @Test
    void testCreate() throws Exception {
        when(ownerRecordService.create(any(OwnerRecord.class))).thenReturn(ownerRecord);
        mockMvc.perform(post("/ownerRecords")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dog\":{\"id\":1},\"cat\":{\"id\":1},\"petOwner\":{\"id\":1},\"takenDate\":\"2024-08-24\",\"returnDate\":\"2024-02-24\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ownerRecord.getId()));
    }

    @Test
    void testRead() throws Exception {
        when(ownerRecordService.read(1L)).thenReturn(ownerRecord);
        mockMvc.perform(get("/ownerRecords/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dog.id").value(ownerRecord.getDog()))
                .andExpect(jsonPath("$.cat.id").value(ownerRecord.getCat()))
                .andExpect(jsonPath("$.petOwner.id").value(ownerRecord.getPetOwner().getId()));
    }

    @Test
    void testUpdate() throws Exception {
        when(ownerRecordService.update(any(OwnerRecord.class))).thenReturn(ownerRecord);
        mockMvc.perform(put("/ownerRecords")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"dog\":{\"id\":1},\"cat\":{\"id\":1},\"petOwner\":{\"id\":1},\"takenDate\":\"2024-08-24\",\"returnDate\":\"2024-02-24\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ownerRecord.getId()));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(ownerRecordService).delete(1L);
        mockMvc.perform(delete("/ownerRecords/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAll() throws Exception {
        when(ownerRecordService.getall()).thenReturn((Set<OwnerRecord>) List.of(ownerRecord));
        mockMvc.perform(get("/ownerRecords"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(ownerRecord.getId()));
    }
}
