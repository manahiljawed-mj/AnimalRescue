package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;

import java.util.Set;

public interface ICatService extends IService<Cat,Long> {
    Set<Cat> getall();
}
