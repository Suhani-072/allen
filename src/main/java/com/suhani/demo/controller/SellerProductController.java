package com.suhani.demo.controller;

import com.suhani.demo.dto.request.AddProductRequestDto;
import com.suhani.demo.dto.request.InwardStockRequestDto;
import com.suhani.demo.dto.request.OnboardSellerRequestDto;
import com.suhani.demo.dto.response.Response;
import com.suhani.demo.services.executor.SellerProductExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class SellerProductController {

    @Autowired
    private SellerProductExecutorService executorService;

    @PostMapping(value = "onBoardSeller", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<?>> onboardSeller(@RequestBody OnboardSellerRequestDto requestDto) {
        return ResponseEntity.ok(executorService.onboardSeller(requestDto));
    }

    @PostMapping(value = "product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<?>> addProduct(@RequestBody AddProductRequestDto requestDto) {
        return ResponseEntity.ok(executorService.addProduct(requestDto));
    }

    @PatchMapping(value = "product/inward", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<?>> inwardStock(@RequestBody InwardStockRequestDto requestDto) {
        return ResponseEntity.ok(executorService.inwardStock(requestDto));
    }
}
