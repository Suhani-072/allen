package com.suhani.demo.controller;

import com.suhani.demo.dto.request.AddDealRequestDto;
import com.suhani.demo.dto.request.PlaceOrderRequestDto;
import com.suhani.demo.dto.response.Response;
import com.suhani.demo.services.executor.OrdersDealExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class OrdersDealController {

    @Autowired
    private OrdersDealExecutorService executorService;


    @PostMapping(value = "placeOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<?>> placeOrder(@RequestBody PlaceOrderRequestDto requestDto) throws Exception {
        return ResponseEntity.ok(executorService.placeOrder(requestDto));
    }

    @PostMapping(value = "addDeal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<?>> addDeal(@RequestBody AddDealRequestDto requestDto) throws Exception {
        return ResponseEntity.ok(executorService.addDeal(requestDto));
    }
}
