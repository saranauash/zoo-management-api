package com.example.zoomanagementapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zooId;
    private String name;
    private String location;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    private List<Animal> animals;

    public Long getZooId() { return zooId; }
    public void setZooId(Long zooId) { this.zooId = zooId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Animal> getAnimals() { return animals; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }
}