package com.suhani.demo.services;

import com.suhani.demo.dto.request.AddProductRequestDto;
import com.suhani.demo.dto.request.InwardStockRequestDto;
import com.suhani.demo.mapper.MapperUtil;
import com.suhani.demo.repository.model.Products;
import com.suhani.demo.repository.model.Seller;
import com.suhani.demo.repository.service.ProductsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    @Autowired
    private ProductsRepositoryService productsRepoService;

    @Autowired
    private MapperUtil mapper;

    public Products validateAndGetProductById(Integer id){
        return productsRepoService.validateAndGetProductById(id);
    }

    public Products save(Products product) {
        return productsRepoService.save(product);
    }

    public void addProduct(AddProductRequestDto requestDto, Seller seller) {
        if(seller==null){
            //log some error
            return;
        }
        save(mapper.toProduct(requestDto, seller));
    }

    public void inwardStock(InwardStockRequestDto requestDto) {
        Products products = productsRepoService.validateAndGetProductById(requestDto.getProductId());
        if(products==null){

        }else{
            int totalStock = products.getTotalStock();
            int remainingStock = products.getRemainingStock();
            products.setTotalStock(totalStock+requestDto.getStockQuantity());
            products.setRemainingStock(remainingStock+requestDto.getStockQuantity());
            productsRepoService.save(products);
        }
    }
}
