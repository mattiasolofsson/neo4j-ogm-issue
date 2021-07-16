package com.example.ogmsample.control;

import com.example.ogmsample.entity.StockKeepingUnit;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockKeepingUnitRepository extends Neo4jRepository<StockKeepingUnit, UUID> {
}
