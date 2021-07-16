package com.example.ogmsample.entity;

import com.example.ogmsample.control.DesignResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.*;

@NodeEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = DesignResolver.class)
public class Design extends Entity {

    @Relationship(value = "HAS_PRODUCT")
    private List<Product> products = new ArrayList<>();

    @Relationship(value = "HAS_STOCK_KEEPING_UNIT")
    private List<StockKeepingUnit> stockKeepingUnits = new ArrayList<>();

    public Design() {
    }

    public Design(UUID designId) {
        super(designId);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<StockKeepingUnit> getStockKeepingUnits() {
        return stockKeepingUnits;
    }

    public void setStockKeepingUnits(List<StockKeepingUnit> stockKeepingUnits) {
        this.stockKeepingUnits = stockKeepingUnits;
    }

    public void addStockKeepingUnit(StockKeepingUnit stockKeepingUnit) {
        stockKeepingUnits.add(stockKeepingUnit);
        stockKeepingUnit.setDesign(this);
    }
}
