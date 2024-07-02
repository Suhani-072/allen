package com.suhani.demo.services;

import com.suhani.demo.dto.request.BoardCustomerRequestDto;
import com.suhani.demo.mapper.MapperUtil;
import com.suhani.demo.repository.service.CustomerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepositoryService customerRepoService;

    @Autowired
    private MapperUtil customerMapper;

    public void onboardCustomer(BoardCustomerRequestDto requestDto) {
        customerRepoService.save(customerMapper.toCustomer(requestDto));
    }
}
