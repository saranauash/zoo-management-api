package com.example.zoomanagementapi.service;

import com.example.zoomanagementapi.model.Animal;
import com.example.zoomanagementapi.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() { return animalRepository.findAll(); }
    public Animal getAnimalById(Long id) { return animalRepository.findById(id).orElse(null); }
    public Animal addAnimal(Animal animal) { return animalRepository.save(animal); }

    // ИСПРАВЛЕННЫЙ МЕТОД ОБНОВЛЕНИЯ
    public Animal updateAnimal(Long id, Animal animalDetails) {
        return animalRepository.findById(id).map(animal -> {
            animal.setName(animalDetails.getName());
            animal.setSpecies(animalDetails.getSpecies());
            animal.setAge(animalDetails.getAge());
            animal.setImageUrl(animalDetails.getImageUrl());
            animal.setDescription(animalDetails.getDescription());

            // ОБЯЗАТЕЛЬНО: добавляем обновление диеты
            animal.setDiet(animalDetails.getDiet());

            return animalRepository.save(animal);
        }).orElseThrow(() -> new RuntimeException("Animal not found with id " + id));
    }

    public void deleteAnimal(Long id) { animalRepository.deleteById(id); }
}