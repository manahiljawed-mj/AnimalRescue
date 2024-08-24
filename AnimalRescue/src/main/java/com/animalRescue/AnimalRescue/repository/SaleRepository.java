package com.animalRescue.AnimalRescue.repository;

import com.animalRescue.AnimalRescue.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
