package com.animalRescue.AnimalRescue.controller;

import com.animalRescue.AnimalRescue.domain.Cat;
import com.animalRescue.AnimalRescue.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @PostMapping("/create")
    public Cat createCat(@RequestBody Cat cat) {
        return catService.create(cat);
    }

    @GetMapping("/read/{id}")
    public Cat readCat(@PathVariable Long id) {
        return catService.read(id);
    }

    @PutMapping("/update")
    public Cat updateCat(@RequestBody Cat cat) {
        return catService.update(cat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCat(@PathVariable Long id) {
        catService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Cat> getAllCats() {
        return catService.getall();
    }
}
