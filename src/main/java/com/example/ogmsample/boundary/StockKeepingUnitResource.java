package com.example.ogmsample.boundary;

import com.example.ogmsample.control.DesignRepository;
import com.example.ogmsample.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class StockKeepingUnitResource {

    @Autowired
    private DesignRepository designRepository;

    @Transactional
    @PostMapping(value = "/designs/{designId}/stock-keeping-units")
    public DesignResult createProduct(@PathVariable UUID designId, @RequestBody StockKeepingUnit stockKeepingUnit) {
        Design design = designRepository.findById(designId).orElseThrow(() -> new RuntimeException("Entity not found"));
        System.out.println("same instance: " + (design == stockKeepingUnit.getProduct().getDesign()));
        return new DesignResult(stockKeepingUnit.getProduct().getDesign(), design);
    }
}
