package com.suhani.demo.services.executor;

import com.suhani.demo.dto.request.BoardCustomerRequestDto;
import com.suhani.demo.dto.response.Response;
import com.suhani.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerExecutorService {

    @Autowired
    private CustomerService service;

    public Response<?> onboardCustomer(BoardCustomerRequestDto requestDto) {
        service.onboardCustomer(requestDto);
        return new Response<>();
    }
}
