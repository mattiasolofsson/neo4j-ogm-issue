package com.example.ogmsample.control;

import com.fasterxml.jackson.annotation.ObjectIdResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProductResolver extends EntityResolver<ProductRepository> {

    @Autowired
    public ProductResolver(ProductRepository repository) {
        super(repository);
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object context) {
        return new ProductResolver(repository);
    }
}
