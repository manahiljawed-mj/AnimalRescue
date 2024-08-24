package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.MedicalRecord;
import com.animalRescue.AnimalRescue.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping("/create")
    public MedicalRecord create(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.create(medicalRecord);
    }

    @GetMapping("/read/{id}")
    public MedicalRecord read(@PathVariable Long id) {
        return medicalRecordService.read(id);
    }

    @PutMapping("/update")
    public MedicalRecord update(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.update(medicalRecord);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        medicalRecordService.delete(id);
    }

    @GetMapping("/getall")
    public Set<MedicalRecord> getall() {
        return medicalRecordService.getall();
    }
}
