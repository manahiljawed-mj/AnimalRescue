package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.Volunteer;

import java.util.Set;

public interface IVolunteerService extends IService<Volunteer,Long> {
    Set<Volunteer> getall();
}
