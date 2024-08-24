package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.OwnerRecord;
import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.repository.OwnerRecordRepository;
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

public class OwnerRecordServiceTest {

    @InjectMocks
    private OwnerRecordService ownerRecordService;

    @Mock
    private OwnerRecordRepository ownerRecordRepository;

    private OwnerRecord ownerRecord;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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
    void testCreate() {
        when(ownerRecordRepository.save(ownerRecord)).thenReturn(ownerRecord);
        OwnerRecord created = ownerRecordService.create(ownerRecord);
        assertNotNull(created);
        assertEquals(ownerRecord.getId(), created.getId());
        verify(ownerRecordRepository, times(1)).save(ownerRecord);
    }

    @Test
    void testRead() {
        when(ownerRecordRepository.findById(1L)).thenReturn(Optional.of(ownerRecord));
        Optional<OwnerRecord> found = Optional.ofNullable(ownerRecordService.read(1L));
        assertTrue(found.isPresent());
        assertEquals(ownerRecord.getId(), found.get().getId());
    }

    @Test
    void testUpdate() {
        when(ownerRecordRepository.save(ownerRecord)).thenReturn(ownerRecord);
        OwnerRecord updated = ownerRecordService.update(ownerRecord);
        assertNotNull(updated);
        assertEquals(ownerRecord.getId(), updated.getId());
        verify(ownerRecordRepository, times(1)).save(ownerRecord);
    }

    @Test
    void testDelete() {
        doNothing().when(ownerRecordRepository).deleteById(1L);
        ownerRecordService.delete(1L);
        verify(ownerRecordRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAll() {
        List<OwnerRecord> records = new ArrayList<>();
        records.add(ownerRecord);
        when(ownerRecordRepository.findAll()).thenReturn(records);
        List<OwnerRecord> allRecords = (List<OwnerRecord>) ownerRecordService.getall();
        assertFalse(allRecords.isEmpty());
        assertEquals(1, allRecords.size());
        assertEquals(ownerRecord.getId(), allRecords.get(0).getId());
    }
}
