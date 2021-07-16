package com.example.ogmsample.boundary;

import com.example.ogmsample.entity.Design;

public class DesignResult {

    private Design designFromResolver;
    private Design designFromLookup;

    public DesignResult() {
    }

    public DesignResult(Design designFromResolver, Design designFromLookup) {
        this.designFromResolver = designFromResolver;
        this.designFromLookup = designFromLookup;
    }

    public Design getDesignFromResolver() {
        return designFromResolver;
    }

    public Design getDesignFromLookup() {
        return designFromLookup;
    }
}
