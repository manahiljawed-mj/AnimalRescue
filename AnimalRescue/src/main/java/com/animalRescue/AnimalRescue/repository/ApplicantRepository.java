package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
