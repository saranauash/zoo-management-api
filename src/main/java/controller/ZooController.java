package com.example.zoomanagementapi.controller;

import com.example.zoomanagementapi.model.Zoo;
import com.example.zoomanagementapi.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zoos")
public class ZooController {

    private final ZooService zooService;

    @Autowired
    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping
    public List<Zoo> getAllZoos() {
        return zooService.getAllZoos();
    }

    @PostMapping
    public Zoo addZoo(@RequestBody Zoo zoo) {
        return zooService.addZoo(zoo);
    }

    @PutMapping("/{id}")
    public Zoo updateZoo(@PathVariable Long id, @RequestBody Zoo zoo) {
        return zooService.updateZoo(id, zoo);
    }

    @DeleteMapping("/{id}")
    public void deleteZoo(@PathVariable Long id) {
        zooService.deleteZoo(id);
    }
}