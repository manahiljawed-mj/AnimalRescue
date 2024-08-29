package com.animalRescue.AnimalRescue.factory;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.util.Helper;

import java.time.LocalDate;

public class ApplicantFactory {

    public static Applicant buildApplicant(Long id, PetOwner petOwner, LocalDate applicationDate, Dog dogId, Cat catId, String status) {
        if (Helper.isNullorZero(id) || petOwner == null || applicationDate == null || Helper.isNullorEmpty(status)) {
            return null;
        }

        return new Applicant.Builder()
                .setId(id)
                .setPetOwner(petOwner)
                .setApplicationDate(applicationDate)
                .setDogId(dogId)
                .setCatId(catId)
                .setStatus(status)
                .build();
    }

    public static Applicant buildApplicant(PetOwner petOwner, LocalDate applicationDate, Dog dogId, Cat catId, String status) {
        if (petOwner == null || applicationDate == null || Helper.isNullorEmpty(status)) {
            return null;
        }

        Long id = Helper.generateApplicantId();

        return new Applicant.Builder()
                .setId(id)
                .setPetOwner(petOwner)
                .setApplicationDate(applicationDate)
                .setDogId(dogId)
                .setCatId(catId)
                .setStatus(status)
                .build();
    }
}
