package com.animalRescue.AnimalRescue.service;

import com.animalRescue.AnimalRescue.domain.Sale;
import com.animalRescue.AnimalRescue.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SaleService {
    private final SaleRepository repository;

    @Autowired
    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }


    public Sale create(Sale sale) {
        return repository.save(sale);
    }


    public Sale read(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Sale update(Sale sale) {
        return repository.save(sale);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Set<Sale> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
