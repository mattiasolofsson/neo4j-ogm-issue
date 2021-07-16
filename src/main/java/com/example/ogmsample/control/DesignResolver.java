package com.example.ogmsample.control;

import com.fasterxml.jackson.annotation.ObjectIdResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DesignResolver extends EntityResolver<DesignRepository> {

    @Autowired
    public DesignResolver(DesignRepository repository) {
        super(repository);
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object context) {
        return new DesignResolver(repository);
    }
}
