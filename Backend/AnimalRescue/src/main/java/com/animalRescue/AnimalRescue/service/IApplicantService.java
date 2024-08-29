package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Dog;

import java.util.Set;

public interface IApplicantService extends IService<Applicant,Long> {
    Set<Applicant> getall();
}
