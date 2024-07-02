package com.suhani.demo.repository.service;

import com.suhani.demo.repository.model.Order;
import com.suhani.demo.repository.repo.OrdersRepository;
import com.suhani.demo.repository.repo.readonly.OrdersReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersRepositoryService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrdersReadRepository ordersReadRepository;

    public Order save(Order orders) {
        return ordersRepository.save(orders);
    }
}
