package com.example.zoomanagementapi.service;

import com.example.zoomanagementapi.model.Zoo;
import com.example.zoomanagementapi.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    private final ZooRepository zooRepository;

    @Autowired
    public ZooService(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public List<Zoo> getAllZoos() {
        return zooRepository.findAll();
    }

    public Zoo addZoo(Zoo zoo) {
        return zooRepository.save(zoo);
    }

    public Zoo updateZoo(Long id, Zoo zoo) {
        zoo.setZooId(id);
        return zooRepository.save(zoo);
    }

    public void deleteZoo(Long id) {
        zooRepository.deleteById(id);
    }
}