package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.OwnerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRecordRepository extends JpaRepository<OwnerRecord, Long> {
}
