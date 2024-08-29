package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

}
