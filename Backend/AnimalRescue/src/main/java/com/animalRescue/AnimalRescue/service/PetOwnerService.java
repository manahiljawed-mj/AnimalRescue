package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PetOwnerService implements IPetOwnerService {
    private final PetOwnerRepository repository;

    @Autowired
    public PetOwnerService(PetOwnerRepository repository) {
        this.repository = repository;
    }


    public PetOwner create(PetOwner petOwner) {
        return repository.save(petOwner);
    }


    public PetOwner read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public PetOwner update(PetOwner petOwner) {
        return repository.save(petOwner);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<PetOwner> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
