package com.animalRescue.AnimalRescue.service;


import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DogService {



    private final DogRepository repository;

    @Autowired
    public DogService(DogRepository repository) {
        this.repository = repository;
    }


    public Dog create(Dog dog) {
        return repository.save(dog);
    }


    public Dog read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Dog update(Dog dog) {
        return repository.save(dog);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<Dog> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
