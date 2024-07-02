package com.suhani.demo.repository.service;


import com.suhani.demo.repository.model.Products;
import com.suhani.demo.repository.repo.ProductsRepository;
import com.suhani.demo.repository.repo.readonly.ProductsReadRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class ProductsRepositoryService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductsReadRepository productsReadRepository;

    public Optional<Products> findProductsById(Integer id){ return  productsReadRepository.findById(id); }

    public Optional<Products> findProductsByName(String name){ return  productsReadRepository.findByName(name); }

    public Products validateAndGetProductById(Integer id){
        return findProductsById(id).orElse(null);
    }

    public Products validateAndGetProductByName(String name){
        return findProductsByName(name)
                .orElse(null);
    }

    public Products save(Products product) {
        return productsRepository.save(product);
    }
}
