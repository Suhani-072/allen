package com.suhani.demo.services.executor;

import com.suhani.demo.dto.request.AddProductRequestDto;
import com.suhani.demo.dto.request.InwardStockRequestDto;
import com.suhani.demo.dto.request.OnboardSellerRequestDto;
import com.suhani.demo.dto.response.Response;
import com.suhani.demo.services.ProductService;
import com.suhani.demo.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerProductExecutorService {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;

    public Response<?> onboardSeller(OnboardSellerRequestDto requestDto) {
        sellerService.onboardSeller(requestDto);
        return new Response<>();
    }

    public Response<?> addProduct(AddProductRequestDto requestDto) {
        productService.addProduct(requestDto, sellerService.validateAndGetSellerById(requestDto.getSellerId()));
        return new Response<>();
    }

    public Response<?> inwardStock(InwardStockRequestDto requestDto) {
        productService.inwardStock(requestDto);
        return new Response<>();
    }
}
