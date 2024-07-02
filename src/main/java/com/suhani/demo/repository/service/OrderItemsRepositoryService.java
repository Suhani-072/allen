package com.suhani.demo.repository.service;

import com.suhani.demo.repository.model.OrderItems;
import com.suhani.demo.repository.repo.OrderItemsRepository;
import com.suhani.demo.repository.repo.readonly.OrderItemsReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemsRepositoryService {
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private OrderItemsReadRepository orderItemsReadRepository;

    public void save(List<OrderItems> list) {
        orderItemsRepository.saveAll(list);
    }
}
