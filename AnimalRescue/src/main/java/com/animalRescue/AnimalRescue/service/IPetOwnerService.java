package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.PetOwner;

import java.util.Set;

public interface IPetOwnerService extends IService<PetOwner,Long> {
    Set<PetOwner> getall();
}
