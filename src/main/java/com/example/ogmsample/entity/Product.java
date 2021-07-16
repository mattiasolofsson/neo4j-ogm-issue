package com.example.ogmsample.entity;

import com.example.ogmsample.control.ProductResolver;
import com.fasterxml.jackson.annotation.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = ProductResolver.class)
public class Product extends Entity {

    @Relationship(value = "HAS_PRODUCT", direction = Relationship.INCOMING)
    private Design design;

    @Relationship(value = "HAS_STOCK_KEEPING_UNIT")
    private List<StockKeepingUnit> stockKeepingUnit;

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }

    public List<StockKeepingUnit> getStockKeepingUnit() {
        return stockKeepingUnit;
    }

    public void setStockKeepingUnit(List<StockKeepingUnit> stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
    }
}
