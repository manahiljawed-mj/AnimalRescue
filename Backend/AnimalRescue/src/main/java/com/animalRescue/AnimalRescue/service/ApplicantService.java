package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicantService implements IApplicantService {
    private final ApplicantRepository repository;

    @Autowired
    public ApplicantService(ApplicantRepository repository) {
        this.repository = repository;
    }


    public Applicant create(Applicant applicant) {
        return repository.save(applicant);
    }

    public Set<Applicant> readStatus(String status) {
        return repository.findByStatus(status).stream().collect(Collectors.toSet());
    }

    public Applicant readCatId(Cat cat) {
        return (Applicant) repository.findByCatId(cat).orElse(null);
    }

    public Applicant readDogId(Dog dog) {
        return (Applicant) repository.findByDogId(dog).orElse(null);
    }


    public Applicant read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Applicant update(Applicant applicant) {
        return repository.save(applicant);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<Applicant> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
