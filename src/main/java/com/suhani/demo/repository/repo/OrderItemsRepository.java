package com.suhani.demo.repository.repo;

import com.suhani.demo.repository.model.OrderItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {
}
