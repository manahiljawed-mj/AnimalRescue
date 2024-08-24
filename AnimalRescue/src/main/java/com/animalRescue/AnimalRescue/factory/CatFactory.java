package com.animalRescue.AnimalRescue.factory;

import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.MedicalRecord;
import com.animalRescue.AnimalRescue.util.Helper;

import java.util.HashSet;
import java.util.Set;

public class CatFactory {
    public static Cat buildCat(long catId, String name, String size, int age, String gender, String breed, int cageNumber, Set<MedicalRecord> medicalRecords) {
        if (Helper.isNullorZero(catId) || Helper.isNullorEmpty(name) || Helper.isNullorEmpty(size) || Helper.isLessThanOrEqualToZero(age) || Helper.isNullorEmpty(gender) || Helper.isNullorEmpty(breed) || Helper.isLessThanOrEqualToZero(cageNumber) || medicalRecords == null || medicalRecords.isEmpty()) {
            return null;
        }

        Cat cat = new Cat.Builder()
                .setCatId(catId)
                .setName(name)
                .setSize(size)
                .setAge(age)
                .setGender(gender)
                .setBreed(breed)
                .setCageNumber(cageNumber)
                .build();

        Set<MedicalRecord> updatedMedicalRecords = new HashSet<>();
        for (MedicalRecord record : medicalRecords) {
            MedicalRecord updatedRecord = new MedicalRecord.Builder()
                    .copy(record)
                    .setCat(cat)
                    .build();
            updatedMedicalRecords.add(updatedRecord);
        }

        return cat;
    }

    public static Cat buildCat(String name, String size, int age, String gender, String breed, int cageNumber, Set<MedicalRecord> medicalRecords) {
        if (Helper.isNullorEmpty(name) || Helper.isNullorEmpty(size) || Helper.isLessThanOrEqualToZero(age) || Helper.isNullorEmpty(gender) || Helper.isNullorEmpty(breed) || Helper.isLessThanOrEqualToZero(cageNumber) || medicalRecords == null || medicalRecords.isEmpty()) {
            return null;
        }

        long catId = Helper.generateCatId();

        Cat cat = new Cat.Builder()
                .setCatId(catId)
                .setName(name)
                .setSize(size)
                .setAge(age)
                .setGender(gender)
                .setBreed(breed)
                .setCageNumber(cageNumber)
                .build();

        Set<MedicalRecord> updatedMedicalRecords = new HashSet<>();
        for (MedicalRecord record : medicalRecords) {
            MedicalRecord updatedRecord = new MedicalRecord.Builder()
                    .copy(record)
                    .setCat(cat)
                    .build();
            updatedMedicalRecords.add(updatedRecord);
        }

        return cat;
    }
}
