package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
