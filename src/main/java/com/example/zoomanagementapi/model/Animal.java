package com.example.zoomanagementapi.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;
    private int age;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String diet;


    @ManyToOne
    @JoinColumn(name = "zoo_id")
    private Zoo zoo;

    @ManyToOne
    @JoinColumn(name = "zookeeper_id")
    private Zookeeper zookeeper;

    public Animal() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public String getDiet() { return diet; }
    public void setDiet(String diet) { this.diet = diet; }

    public Zoo getZoo() { return zoo; }
    public void setZoo(Zoo zoo) { this.zoo = zoo; }
    public Zookeeper getZookeeper() { return zookeeper; }
    public void setZookeeper(Zookeeper zookeeper) { this.zookeeper = zookeeper; }
}