package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.repository.PetOwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetOwnerServiceTest {

    @InjectMocks
    private PetOwnerService petOwnerService;

    @Mock
    private PetOwnerRepository petOwnerRepository;

    private PetOwner petOwner;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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
    void testCreate() {
        when(petOwnerRepository.save(petOwner)).thenReturn(petOwner);
        PetOwner created = petOwnerService.create(petOwner);
        assertNotNull(created);
        assertEquals(petOwner.getId(), created.getId());
        verify(petOwnerRepository, times(1)).save(petOwner);
    }

    @Test
    void testRead() {
        when(petOwnerRepository.findById(1L)).thenReturn(Optional.of(petOwner));
        Optional<PetOwner> found = Optional.ofNullable(petOwnerService.read(1L));
        assertTrue(found.isPresent());
        assertEquals(petOwner.getId(), found.get().getId());
    }

    @Test
    void testUpdate() {
        when(petOwnerRepository.save(petOwner)).thenReturn(petOwner);
        PetOwner updated = petOwnerService.update(petOwner);
        assertNotNull(updated);
        assertEquals(petOwner.getId(), updated.getId());
        verify(petOwnerRepository, times(1)).save(petOwner);
    }

    @Test
    void testDelete() {
        doNothing().when(petOwnerRepository).deleteById(1L);
        petOwnerService.delete(1L);
        verify(petOwnerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAll() {
        List<PetOwner> owners = new ArrayList<>();
        owners.add(petOwner);
        when(petOwnerRepository.findAll()).thenReturn(owners);
        List<PetOwner> allOwners = (List<PetOwner>) petOwnerService.getall();
        assertFalse(allOwners.isEmpty());
        assertEquals(1, allOwners.size());
        assertEquals(petOwner.getId(), allOwners.get(0).getId());
    }
}
