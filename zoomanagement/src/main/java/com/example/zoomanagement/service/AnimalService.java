package com.example.zoomanagement.service;

import com.example.zoomanagement.entity.Animal;
import com.example.zoomanagement.exceptions.ResourceNotFoundException;
import com.example.zoomanagement.repository.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        logger.info("Saving new animal: {}", animal.getName());
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        logger.info("Fetching all animals");
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        logger.info("Fetching animal with ID {}", id);
        return animalRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Animal with ID {} not found", id);
                    return new ResourceNotFoundException("Animal with ID " + id + " not found");
                });
    }

}
