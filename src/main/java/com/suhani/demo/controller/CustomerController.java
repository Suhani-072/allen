package com.suhani.demo.controller;

import com.suhani.demo.dto.request.BoardCustomerRequestDto;
import com.suhani.demo.dto.response.Response;
import com.suhani.demo.services.executor.CustomerExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CustomerController {

    @Autowired
    private CustomerExecutorService executorService;

    @PostMapping(value="onboardCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<?>> onboardCustomer(@RequestBody BoardCustomerRequestDto boardCustomerRequestDto) {
        return ResponseEntity.ok(executorService.onboardCustomer(boardCustomerRequestDto));
    }
}
