package com.example.zoomanagementapi.repository;

import com.example.zoomanagementapi.model.Zookeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZookeeperRepository extends JpaRepository<Zookeeper, Long> {
}