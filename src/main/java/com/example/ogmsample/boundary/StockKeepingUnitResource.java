package com.example.ogmsample.boundary;

import com.example.ogmsample.control.DesignRepository;
import com.example.ogmsample.control.StockKeepingUnitRepository;
import com.example.ogmsample.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class StockKeepingUnitResource {

    @Autowired
    private DesignRepository designRepository;

    @Autowired
    private StockKeepingUnitRepository stockKeepingUnitRepository;

    @Transactional
    @PostMapping(value = "/designs/{designId}/stock-keeping-units")
    public StockKeepingUnit createProduct(@PathVariable UUID designId, @RequestBody StockKeepingUnit stockKeepingUnit) {
        Design design = designRepository.findById(designId).orElseThrow(() -> new RuntimeException("Entity not found"));
        System.out.println("same instance: " + (design == stockKeepingUnit.getProduct().getDesign()));
        design.addStockKeepingUnit(stockKeepingUnit);
        return stockKeepingUnitRepository.save(stockKeepingUnit);
    }
}
