package com.suhani.demo.repository.repo;

import com.suhani.demo.repository.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Order, Integer> {
}
