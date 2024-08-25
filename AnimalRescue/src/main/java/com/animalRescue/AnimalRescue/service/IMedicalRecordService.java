package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.MedicalRecord;

import java.util.Set;

public interface IMedicalRecordService extends IService<MedicalRecord,Long> {
    Set<MedicalRecord> getall();
}
