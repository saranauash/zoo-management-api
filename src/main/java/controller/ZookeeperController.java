package com.example.zoomanagementapi.controller;

import com.example.zoomanagementapi.model.Zookeeper;
import com.example.zoomanagementapi.service.ZookeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zookeepers")
public class ZookeeperController {

    private final ZookeeperService zookeeperService;

    @Autowired
    public ZookeeperController(ZookeeperService zookeeperService) {
        this.zookeeperService = zookeeperService;
    }

    @GetMapping
    public List<Zookeeper> getAllZookeepers() {
        return zookeeperService.getAllZookeepers();
    }

    @PostMapping
    public Zookeeper addZookeeper(@RequestBody Zookeeper zookeeper) {
        return zookeeperService.addZookeeper(zookeeper);
    }

    @PutMapping("/{id}")
    public Zookeeper updateZookeeper(@PathVariable Long id, @RequestBody Zookeeper zookeeper) {
        return zookeeperService.updateZookeeper(id, zookeeper);
    }

    @DeleteMapping("/{id}")
    public void deleteZookeeper(@PathVariable Long id) {
        zookeeperService.deleteZookeeper(id);
    }
}