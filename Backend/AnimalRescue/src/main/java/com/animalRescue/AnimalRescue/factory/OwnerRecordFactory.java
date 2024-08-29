package com.animalRescue.AnimalRescue.factory;

import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.OwnerRecord;
import com.animalRescue.AnimalRescue.domain.PetOwner;
import com.animalRescue.AnimalRescue.util.Helper;

import java.time.LocalDate;

public class OwnerRecordFactory {

    public static OwnerRecord buildOwnerRecord(Long id, Dog dog, Cat cat, PetOwner petOwner, LocalDate takenDate, LocalDate returnDate) {
        if (Helper.isNullorZero(id) || dog == null && cat == null || petOwner == null || takenDate == null) {
            return null;
        }

        return new OwnerRecord.Builder()
                .setId(id)
                .setDog(dog)
                .setCat(cat)
                .setPetOwner(petOwner)
                .setTakenDate(takenDate)
                .setReturnDate(returnDate)
                .build();
    }

    public static OwnerRecord buildOwnerRecord(Dog dog, Cat cat, PetOwner petOwner, LocalDate takenDate, LocalDate returnDate) {
        if (dog == null && cat == null || petOwner == null || takenDate == null) {
            return null;
        }

        Long id = Helper.generateOwnerRecordId(); // Assuming Helper has a method to generate an ID

        return new OwnerRecord.Builder()
                .setId(id)
                .setDog(dog)
                .setCat(cat)
                .setPetOwner(petOwner)
                .setTakenDate(takenDate)
                .setReturnDate(returnDate)
                .build();
    }
}
