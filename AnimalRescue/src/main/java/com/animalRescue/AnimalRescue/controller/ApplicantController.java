package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Applicant;
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
