package com.example.zoomanagementapi.model;

import jakarta.persistence.*;

@Entity
public class Zookeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zookeeperId;
    private String name;
    private int experienceYears;

    public Long getZookeeperId() { return zookeeperId; }
    public void setZookeeperId(Long zookeeperId) { this.zookeeperId = zookeeperId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
}