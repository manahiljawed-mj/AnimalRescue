package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Volunteer;
import com.animalRescue.AnimalRescue.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @PostMapping("/create")
    public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerService.create(volunteer);
    }

    @GetMapping("/read/{id}")
    public Volunteer readVolunteer(@PathVariable Long id) {
        return volunteerService.read(id);
    }

    @PutMapping("/update")
    public Volunteer updateVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerService.update(volunteer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVolunteer(@PathVariable Long id) {
        volunteerService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Volunteer> getAllVolunteers() {
        return volunteerService.getAll();
    }
}
