package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
