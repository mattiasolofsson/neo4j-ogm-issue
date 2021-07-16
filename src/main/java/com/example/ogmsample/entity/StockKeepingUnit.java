package com.example.ogmsample.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class StockKeepingUnit extends Entity {

    @Relationship(value = "HAS_STOCK_KEEPING_UNIT", direction = Relationship.INCOMING)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
