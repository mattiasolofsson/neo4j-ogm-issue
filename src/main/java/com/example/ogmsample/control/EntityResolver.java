package com.example.ogmsample.control;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public abstract class EntityResolver<T extends Neo4jRepository<?, UUID>> extends SimpleObjectIdResolver {

    protected T repository;

    public EntityResolver(T repository) {
        this.repository = repository;
    }

    @Override
    public Object resolveId(ObjectIdGenerator.IdKey idKey) {
        Object resolved = super.resolveId(idKey);
        if (resolved == null) {
            resolved = repository.findById((UUID) idKey.key).get();
            bindItem(idKey, resolved);
        }
        return resolved;
    }

    @Override
    public boolean canUseFor(ObjectIdResolver objectIdResolver) {
        return getClass().equals(objectIdResolver.getClass());
    }
}