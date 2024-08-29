package com.animalRescue.AnimalRescue.service;


import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.repository.CatRepository;
import com.animalRescue.AnimalRescue.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatService implements ICatService{

    private final CatRepository repository;

    @Autowired
    public CatService(CatRepository repository) {
        this.repository = repository;
    }


    public Cat create(Cat cat) {
        return repository.save(cat);
    }


    public Cat read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Cat update(Cat cat) {
        return repository.save(cat);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<Cat> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

}
