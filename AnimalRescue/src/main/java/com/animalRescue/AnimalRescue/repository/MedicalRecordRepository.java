package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
