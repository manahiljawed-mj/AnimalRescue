package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.MedicalRecord;
import com.animalRescue.AnimalRescue.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicalRecordService {
    private final MedicalRecordRepository repository;

    @Autowired
    public MedicalRecordService(MedicalRecordRepository repository) {
        this.repository = repository;
    }


    public MedicalRecord create(MedicalRecord medicalRecord) {
        return repository.save(medicalRecord);
    }


    public MedicalRecord read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public MedicalRecord update(MedicalRecord medicalRecord) {
        return repository.save(medicalRecord);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<MedicalRecord> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
