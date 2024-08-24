package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Volunteer;
import com.animalRescue.AnimalRescue.repository.VolunteerRepository;
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

public class VolunteerServiceTest {

    @InjectMocks
    private VolunteerService volunteerService;

    @Mock
    private VolunteerRepository volunteerRepository;

    private Volunteer volunteer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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
    void testCreate() {
        when(volunteerRepository.save(volunteer)).thenReturn(volunteer);
        Volunteer created = volunteerService.create(volunteer);
        assertNotNull(created);
        assertEquals(volunteer.getId(), created.getId());
        verify(volunteerRepository, times(1)).save(volunteer);
    }

    @Test
    void testRead() {
        when(volunteerRepository.findById(1L)).thenReturn(Optional.of(volunteer));
        Optional<Volunteer> found = Optional.ofNullable(volunteerService.read(1L));
        assertTrue(found.isPresent());
        assertEquals(volunteer.getId(), found.get().getId());
    }

    @Test
    void testUpdate() {
        when(volunteerRepository.save(volunteer)).thenReturn(volunteer);
        Volunteer updated = volunteerService.update(volunteer);
        assertNotNull(updated);
        assertEquals(volunteer.getId(), updated.getId());
        verify(volunteerRepository, times(1)).save(volunteer);
    }

    @Test
    void testDelete() {
        doNothing().when(volunteerRepository).deleteById(1L);
        volunteerService.delete(1L);
        verify(volunteerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAll() {
        List<Volunteer> volunteers = new ArrayList<>();
        volunteers.add(volunteer);
        when(volunteerRepository.findAll()).thenReturn(volunteers);
        List<Volunteer> allVolunteers = (List<Volunteer>) volunteerService.getall();
        assertFalse(allVolunteers.isEmpty());
        assertEquals(1, allVolunteers.size());
        assertEquals(volunteer.getId(), allVolunteers.get(0).getId());
    }
}
