package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/create")
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.create(applicant);
    }

    @PostMapping("/readCatId")
    public Applicant readApplicantCatId(@RequestBody Cat cat) {
        return applicantService.readCatId(cat);
    }

    @PostMapping("/readDogId")
    public Applicant readApplicantDogId(@RequestBody Dog dog) {
        return applicantService.readDogId(dog);
    }
    @GetMapping("/readStatus/{status}")
    public Set<Applicant> readApplicantStatus(@PathVariable String status) {
        return applicantService.readStatus(status);
    }

    @GetMapping("/read/{id}")
    public Applicant readApplicant(@PathVariable Long id) {
        return applicantService.read(id);
    }

    @PutMapping("/update")
    public Applicant updateApplicant(@RequestBody Applicant applicant) {
        return applicantService.update(applicant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteApplicant(@PathVariable Long id) {
        applicantService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Applicant> getAllApplicants() {
        return applicantService.getall();
    }
}
