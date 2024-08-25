package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.OwnerRecord;

import java.util.Set;

public interface IOwnerRecordService extends IService<OwnerRecord,Long> {
    Set<OwnerRecord> getall();
}
