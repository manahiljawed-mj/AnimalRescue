package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Dog;

import java.util.Set;

public interface IDogService extends IService<Dog, Long>{
    Set<Dog> getall();
}
