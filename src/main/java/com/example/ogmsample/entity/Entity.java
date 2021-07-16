package com.example.ogmsample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.typeconversion.UuidStringConverter;

import java.util.Objects;
import java.util.UUID;

@NodeEntity
public abstract class Entity {

    @JsonIgnore
    private Long id;

    @Id
    @Convert(UuidStringConverter.class)
    private UUID uuid;

    @Property
    private String name;

    public Entity() {
    }

    public Entity(UUID uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("id")
    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(uuid, entity.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    public void generateId() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
    }
}
