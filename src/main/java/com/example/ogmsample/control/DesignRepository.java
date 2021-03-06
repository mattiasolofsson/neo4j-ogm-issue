package com.example.ogmsample.control;

import com.example.ogmsample.entity.Design;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DesignRepository extends Neo4jRepository<Design, UUID> {
}
