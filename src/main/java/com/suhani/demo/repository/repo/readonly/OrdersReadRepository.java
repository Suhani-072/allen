package com.suhani.demo.repository.repo.readonly;

import com.suhani.demo.repository.model.Order;
import com.suhani.demo.utils.ReadOnlyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadOnlyRepository
public interface OrdersReadRepository extends JpaRepository<Order, Integer> {
}
