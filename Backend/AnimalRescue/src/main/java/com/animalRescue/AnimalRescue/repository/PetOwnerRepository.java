package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
}
