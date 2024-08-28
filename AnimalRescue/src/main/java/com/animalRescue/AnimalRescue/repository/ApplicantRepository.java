package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.Applicant;
import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Optional<Object> findByCatId(Cat catId);
    Optional<Object> findByDogId(Dog DogId);
    List<Applicant> findByStatus(String status);
}
