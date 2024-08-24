package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Employee;
import com.animalRescue.AnimalRescue.domain.MedicalRecord;
import com.animalRescue.AnimalRescue.service.MedicalRecordService;
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

@WebMvcTest(MedicalRecordController.class)
public class MedicalRecordControllerTest {

    @InjectMocks
    private MedicalRecordController medicalRecordController;

    @Mock
    private MedicalRecordService medicalRecordService;

    private MockMvc mockMvc;

    private MedicalRecord medicalRecord;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(medicalRecordController).build();
        medicalRecord = new MedicalRecord.Builder()
                .setId(1L)
                .setDog(new Dog()) // Assume Dog and Cat instances are available
                .setCat(new Cat())
                .setVaccinationDate(LocalDate.now())
                .setMedication("Med1")
                .setBehaviour("Good")
                .setNextCheckup(LocalDate.now().plusMonths(6))
                .setDescription("Annual checkup")
                .build();
    }

    @Test
    void testCreate() throws Exception {
        when(medicalRecordService.create(any(MedicalRecord.class))).thenReturn(medicalRecord);
        mockMvc.perform(post("/medicalRecords")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dog\":{\"id\":1},\"cat\":{\"id\":1},\"vaccinationDate\":\"2024-08-24\",\"medication\":\"Med1\",\"behaviour\":\"Good\",\"nextCheckup\":\"2024-08-24\",\"description\":\"Annual checkup\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(medicalRecord.getId()));
    }

    @Test
    void testRead() throws Exception {
        when(medicalRecordService.read(1L)).thenReturn(medicalRecord);
        mockMvc.perform(get("/medicalRecords/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dog.id").value(medicalRecord.getDog()))
                .andExpect(jsonPath("$.cat.id").value(medicalRecord.getCat()));
    }

    @Test
    void testUpdate() throws Exception {
        when(medicalRecordService.update(any(MedicalRecord.class))).thenReturn(medicalRecord);
        mockMvc.perform(put("/medicalRecords")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"dog\":{\"id\":1},\"cat\":{\"id\":1},\"vaccinationDate\":\"2024-08-24\",\"medication\":\"Med1\",\"behaviour\":\"Good\",\"nextCheckup\":\"2024-08-24\",\"description\":\"Annual checkup\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(medicalRecord.getId()));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(medicalRecordService).delete(1L);
        mockMvc.perform(delete("/medicalRecords/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAll() throws Exception {
        when(medicalRecordService.getall()).thenReturn((Set<MedicalRecord>) List.of(medicalRecord));
        mockMvc.perform(get("/medicalRecords"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(medicalRecord.getId()));
    }
}
