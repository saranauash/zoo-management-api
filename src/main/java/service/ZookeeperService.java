package com.example.zoomanagementapi.service;

import com.example.zoomanagementapi.model.Zookeeper;
import com.example.zoomanagementapi.repository.ZookeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZookeeperService {

    private final ZookeeperRepository zookeeperRepository;

    @Autowired
    public ZookeeperService(ZookeeperRepository zookeeperRepository) {
        this.zookeeperRepository = zookeeperRepository;
    }

    public List<Zookeeper> getAllZookeepers() {
        return zookeeperRepository.findAll();
    }

    public Zookeeper addZookeeper(Zookeeper zookeeper) {
        return zookeeperRepository.save(zookeeper);
    }

    public Zookeeper updateZookeeper(Long id, Zookeeper zookeeper) {
        zookeeper.setZookeeperId(id);
        return zookeeperRepository.save(zookeeper);
    }

    public void deleteZookeeper(Long id) {
        zookeeperRepository.deleteById(id);
    }
}