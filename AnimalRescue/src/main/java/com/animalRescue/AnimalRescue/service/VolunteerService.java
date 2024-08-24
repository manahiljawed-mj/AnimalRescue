package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Volunteer;
import com.animalRescue.AnimalRescue.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VolunteerService {
    private final VolunteerRepository repository;

    @Autowired
    public VolunteerService(VolunteerRepository repository) {
        this.repository = repository;
    }


    public Volunteer create(Volunteer volunteer) {
        return repository.save(volunteer);
    }


    public Volunteer read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Volunteer update(Volunteer volunteer) {
        return repository.save(volunteer);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<Volunteer> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
