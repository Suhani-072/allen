package com.suhani.demo.repository.service;


import com.suhani.demo.repository.model.Deal;
import com.suhani.demo.repository.model.Products;
import com.suhani.demo.repository.repo.DealsConfigRepository;
import com.suhani.demo.repository.repo.readonly.DealsConfigReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class DealsConfigRepositoryService {

    @Autowired
    private DealsConfigRepository dealsConfigRepository;
    @Autowired
    private DealsConfigReadRepository dealsConfigReadRepository;

    public Optional<Deal> findByAvailableDealByProduct(Integer productId) {
        return dealsConfigReadRepository.findByProduct_idAndDealStartTimeLessThanEqualAndDealEndTimeGreaterThanEqualAndSaleQuantityRemainingGreaterThan(productId, LocalDateTime.now(), 0);
    }

    public Deal save(Deal dealsConfig) {
        return dealsConfigRepository.save(dealsConfig);
    }

    public Deal findByAvailableDealByProduct(Products product) {
        return findByAvailableDealByProduct(product.getId()).orElse(null);
    }
}
