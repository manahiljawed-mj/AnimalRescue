package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.domain.Sale;

import java.util.Set;

public interface ISaleService extends IService<Sale,Long> {
    Set<Sale> getall();
}
