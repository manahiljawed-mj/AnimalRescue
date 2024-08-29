package com.animalRescue.AnimalRescue;

import com.animalRescue.AnimalRescue.domain.Dog;
import com.animalRescue.AnimalRescue.repository.DogRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AnimalRescueApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalRescueApplication.class, args);
	}
}
