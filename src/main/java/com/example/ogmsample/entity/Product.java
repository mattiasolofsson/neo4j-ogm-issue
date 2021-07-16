package com.example.ogmsample.entity;

import com.example.ogmsample.control.ProductResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = ProductResolver.class)
public class Product extends Entity {

    @Relationship(value = "HAS_PRODUCT", direction = Relationship.INCOMING)
    private Design design;

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }
}
