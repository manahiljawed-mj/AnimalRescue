package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.MedicalRecord;
import com.animalRescue.AnimalRescue.repository.MedicalRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MedicalRecordServiceTest {

    @InjectMocks
    private MedicalRecordService medicalRecordService;

    @Mock
    private MedicalRecordRepository medicalRecordRepository;

    private MedicalRecord medicalRecord;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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
    void testCreate() {
        when(medicalRecordRepository.save(medicalRecord)).thenReturn(medicalRecord);
        MedicalRecord created = medicalRecordService.create(medicalRecord);
        assertNotNull(created);
        assertEquals(medicalRecord.getId(), created.getId());
        verify(medicalRecordRepository, times(1)).save(medicalRecord);
    }

    @Test
    void testRead() {
        when(medicalRecordRepository.findById(1L)).thenReturn(Optional.of(medicalRecord));
        Optional<MedicalRecord> found = Optional.ofNullable(medicalRecordService.read(1L));
        assertTrue(found.isPresent());
        assertEquals(medicalRecord.getId(), found.get().getId());
    }

    @Test
    void testUpdate() {
        when(medicalRecordRepository.save(medicalRecord)).thenReturn(medicalRecord);
        MedicalRecord updated = medicalRecordService.update(medicalRecord);
        assertNotNull(updated);
        assertEquals(medicalRecord.getId(), updated.getId());
        verify(medicalRecordRepository, times(1)).save(medicalRecord);
    }

    @Test
    void testDelete() {
        doNothing().when(medicalRecordRepository).deleteById(1L);
        medicalRecordService.delete(1L);
        verify(medicalRecordRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAll() {
        List<MedicalRecord> records = new ArrayList<>();
        records.add(medicalRecord);
        when(medicalRecordRepository.findAll()).thenReturn(records);
        List<MedicalRecord> allRecords = (List<MedicalRecord>) medicalRecordService.getall();
        assertFalse(allRecords.isEmpty());
        assertEquals(1, allRecords.size());
        assertEquals(medicalRecord.getId(), allRecords.get(0).getId());
    }
}
