package com.example.zoomanagementapi.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;
    private String name;
    private String species;
    private int age;

    @ManyToOne
    @JoinColumn(name = "zoo_id")
    @JsonIgnore // Предотвращает бесконечный цикл в JSON
    private Zoo zoo;

    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Zoo getZoo() { return zoo; }
    public void setZoo(Zoo zoo) { this.zoo = zoo; }
}